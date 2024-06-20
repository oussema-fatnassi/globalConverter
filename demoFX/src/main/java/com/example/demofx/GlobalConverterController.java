package com.example.demofx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class GlobalConverterController implements Initializable {

    @FXML
    private TextField originalTextField;
    @FXML
    private Label resultLabel;
    @FXML
    private Button convertButton;
    @FXML
    private Button resetButton;
    @FXML
    private Button invertButton;
    @FXML
    private ComboBox<String> originalFormat;
    @FXML
    private ComboBox<String> targetFormat;
    @FXML
    private ComboBox<String> operation;
    @FXML
    private ComboBox<String> cipherType;
    @FXML
    private TextField cipherKey;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        originalFormat.getItems().addAll("Text", "Decimal", "Binary", "Hexadecimal", "Octal");
        targetFormat.getItems().addAll("Text", "Decimal", "Binary", "Hexadecimal", "Octal");
        operation.getItems().addAll("Cipher", "Decipher", "Convert");
        cipherType.getItems().addAll("Caesar", "Vigenere", "Atbash");

        originalFormat.setPromptText("Select original format");
        targetFormat.setPromptText("Select target format");
        operation.setPromptText("Select operation");
        cipherType.setPromptText("Select cipher type");

        convertButton.setOnAction(event -> handleConvert());
        resetButton.setOnAction(event -> handleReset());
        invertButton.setOnAction(event -> handleInvert());
    }

    private void handleConvert() {
        String input = originalTextField.getText();
        String fromFormat = originalFormat.getValue();
        String toFormat = targetFormat.getValue();
        String selectedOperation = operation.getValue();
        String selectedCipherType = cipherType.getValue();
        String key = cipherKey.getText();

        if (input.isEmpty() || fromFormat == null || toFormat == null || selectedOperation == null) {
            resultLabel.setText("Please fill all fields.");
            return;
        }

        ConversionResult conversionResult = convertToAscii(input, fromFormat);
        if (conversionResult.getErrorMessage() != null) {
            resultLabel.setText(conversionResult.getErrorMessage());
            return;
        }

        int[] asciiArray = conversionResult.getAsciiArray();
        String result = switch (selectedOperation) {
            case "Cipher" -> handleCipher(new String(asciiArray, 0, asciiArray.length), selectedCipherType, key);
            case "Decipher" -> handleDecipher(new String(asciiArray, 0, asciiArray.length), selectedCipherType, key);
            case "Convert" -> convertFromAscii(asciiArray, toFormat);
            default -> "";
        };

        resultLabel.setText(result);
    }

    private ConversionResult convertToAscii(String input, String format) {
        switch (format) {
            case "Decimal":
                if (InputVerification.isDecimal(input)) {
                    return new ConversionResult(Decimal.toAscii(InputVerification.formatString(input, 3)), null);
                } else {
                    return new ConversionResult(null, "Invalid decimal string. Enter only 0-9.");
                }
            case "Hexadecimal":
                if (InputVerification.isHexadecimal(input)) {
                    return new ConversionResult(Hexadecimal.toAscii(InputVerification.formatString(input, 2)), null);
                } else {
                    return new ConversionResult(null, "Invalid hexadecimal string. Enter only 0-9 and A-F.");
                }
            case "Binary":
                if (InputVerification.isBinary(input)) {
                    return new ConversionResult(Binary.toAscii(InputVerification.formatString(input, 8)), null);
                } else {
                    return new ConversionResult(null, "Invalid binary string. Enter only 0-1.");
                }
            case "Octal":
                if (InputVerification.isOctal(input)) {
                    return new ConversionResult(Octal.toAscii(InputVerification.formatString(input, 3)), null);
                } else {
                    return new ConversionResult(null, "Invalid octal string. Enter only 0-7.");
                }
            case "Text":
                if (InputVerification.isText(input)) {
                    return new ConversionResult(Text.toAscii(input), null);
                } else {
                    return new ConversionResult(null, "Invalid text string. Enter only printable characters.");
                }
            default:
                return new ConversionResult(null, "Unknown format.");
        }
    }

    private String convertFromAscii(int[] asciiArray, String format) {
        return switch (format) {
            case "Decimal" -> Ascii.toDecimal(asciiArray);
            case "Hexadecimal" -> Ascii.toHexadecimal(asciiArray);
            case "Binary" -> Ascii.toBinary(asciiArray);
            case "Octal" -> Ascii.toOctal(asciiArray);
            case "Text" -> Ascii.toText(asciiArray);
            default -> "";
        };
    }

    private String handleCipher(String input, String cipherType, String key) {
        switch (cipherType) {
            case "Caesar":
                try {
                    int shift = Integer.parseInt(key);
                    return Cipher.CaesarCipher(input, shift);
                } catch (NumberFormatException e) {
                    return "Invalid Caesar cipher key. Must be a number.";
                }
            case "Vigenere":
                if (InputVerification.isAlphabeticText(key)) {
                    return Cipher.VigenereCipher(input, key.toUpperCase());
                } else {
                    return "Invalid Vigenere cipher key. Must be a word.";
                }
            case "Atbash":
                return Cipher.AtbashCipher(input);
            default:
                return "Invalid cipher type.";
        }
    }

    private String handleDecipher(String input, String cipherType, String key) {
        switch (cipherType) {
            case "Caesar":
                try {
                    int shift = Integer.parseInt(key);
                    return Cipher.CaesarDecipher(input, shift);
                } catch (NumberFormatException e) {
                    return "Invalid Caesar decipher key. Must be a number.";
                }
            case "Vigenere":
                if (InputVerification.isText(key)) {
                    return Cipher.VigenereDecipher(input, key.toUpperCase());
                } else {
                    return "Invalid Vigenere decipher key. Must be a word.";
                }
            case "Atbash":
                return Cipher.AtbashDecipher(input);
            default:
                return "Invalid cipher type.";
        }
    }

    private void handleInvert() {
        // Swap the text between the originalTextField and resultLabel
        String originalText = originalTextField.getText();
        String resultText = resultLabel.getText();

        originalTextField.setText(resultText);
        resultLabel.setText(originalText);

        // Swap the selected items in the originalFormat and targetFormat ComboBoxes
        String originalFormatValue = originalFormat.getValue();
        String targetFormatValue = targetFormat.getValue();

        originalFormat.setValue(targetFormatValue);
        targetFormat.setValue(originalFormatValue);
    }

    private void handleReset() {
        originalTextField.clear();
        resultLabel.setText("");
        cipherKey.clear();

        // Clear selection and reset prompt text
        originalFormat.getSelectionModel().clearSelection();
        targetFormat.getSelectionModel().clearSelection();
        operation.getSelectionModel().clearSelection();
        cipherType.getSelectionModel().clearSelection();

        // Ensure prompt text is displayed after reset
        originalFormat.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "Select original format" : item);
            }
        });
        targetFormat.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "Select target format" : item);
            }
        });
        operation.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "Select operation" : item);
            }
        });
        cipherType.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "Select cipher type" : item);
            }
        });
    }
}
