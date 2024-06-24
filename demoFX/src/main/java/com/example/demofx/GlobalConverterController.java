package com.example.demofx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GlobalConverterController implements Initializable {

    @FXML
    private TextArea originalTextArea;
    @FXML
    private Label resultLabel;
    @FXML
    private Button convertButton;
    @FXML
    private Button resetButton;
    @FXML
    private Button invertButton;
    @FXML
    private Button saveButton;
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
        saveButton.setOnAction(event -> handleSave());
    }

    private void handleConvert() {
        String input = originalTextArea.getText();
        String fromFormat = originalFormat.getValue();
        String toFormat = targetFormat.getValue();
        String selectedOperation = operation.getValue();
        String selectedCipherType = cipherType.getValue();
        String key = cipherKey.getText();

        if (input.isEmpty() || fromFormat == null || toFormat == null || selectedOperation == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "Missing Input", "Please fill all fields.");
            return;
        }

        ConversionResult conversionResult = convertToAscii(input, fromFormat);
        if (conversionResult.getErrorMessage() != null) {
            showAlert(Alert.AlertType.ERROR, "Error", "Conversion Error", conversionResult.getErrorMessage());
            return;
        }

        int[] asciiArray = conversionResult.getAsciiArray();
        String result;
        try {
            result = switch (selectedOperation) {
                case "Cipher" -> handleCipher(new String(asciiArray, 0, asciiArray.length), selectedCipherType, key);
                case "Decipher" -> handleDecipher(new String(asciiArray, 0, asciiArray.length), selectedCipherType, key);
                case "Convert" -> convertFromAscii(asciiArray, toFormat);
                default -> "";
            };
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Cipher/Decipher Error", e.getMessage());
            return;
        }

        resultLabel.setText(result);
    }

    private void showAlert(Alert.AlertType alertType, String title, String headerText, String contentText) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
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

    private String handleCipher(String input, String cipherType, String key) throws Exception {
        switch (cipherType) {
            case "Caesar":
                try {
                    int shift = Integer.parseInt(key);
                    return Cipher.CaesarCipher(input, shift);
                } catch (NumberFormatException e) {
                    throw new Exception("Invalid Caesar cipher key. Must be a number.");
                }
            case "Vigenere":
                if (InputVerification.isAlphabeticText(key)) {
                    return Cipher.VigenereCipher(input, key.toUpperCase());
                } else {
                    throw new Exception("Invalid Vigenere cipher key. Must be a word.");
                }
            case "Atbash":
                return Cipher.AtbashCipher(input);
            default:
                throw new Exception("Invalid cipher type.");
        }
    }

    private String handleDecipher(String input, String cipherType, String key) throws Exception {
        switch (cipherType) {
            case "Caesar":
                try {
                    int shift = Integer.parseInt(key);
                    return Cipher.CaesarDecipher(input, shift);
                } catch (NumberFormatException e) {
                    throw new Exception("Invalid Caesar decipher key. Must be a number.");
                }
            case "Vigenere":
                if (InputVerification.isText(key)) {
                    return Cipher.VigenereDecipher(input, key.toUpperCase());
                } else {
                    throw new Exception("Invalid Vigenere decipher key. Must be a word.");
                }
            case "Atbash":
                return Cipher.AtbashDecipher(input);
            default:
                throw new Exception("Invalid cipher type.");
        }
    }

    private void handleInvert() {
        String originalText = originalTextArea.getText();
        String resultText = resultLabel.getText();

        originalTextArea.setText(resultText);
        resultLabel.setText(originalText);

        String originalFormatValue = originalFormat.getValue();
        String targetFormatValue = targetFormat.getValue();

        originalFormat.setValue(targetFormatValue);
        targetFormat.setValue(originalFormatValue);
    }

    private void handleReset() {
        originalTextArea.clear();
        resultLabel.setText("");
        cipherKey.clear();

        originalFormat.getSelectionModel().clearSelection();
        targetFormat.getSelectionModel().clearSelection();
        operation.getSelectionModel().clearSelection();
        cipherType.getSelectionModel().clearSelection();

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

    private void handleSave() {
        String originalInput = originalTextArea.getText();
        String result = resultLabel.getText();
        String originalFormatValue = originalFormat.getValue();
        String resultFormatValue = targetFormat.getValue();
        String selectedOperation = operation.getValue();
        String selectedCipherType = cipherType.getValue();
        String key = cipherKey.getText();

        if (result.isEmpty() || originalInput.isEmpty() || originalFormatValue == null || resultFormatValue == null || selectedOperation == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "Save Error", "Nothing to save or some fields are missing.");
            return;
        }

        ConversionResult conversionResult = convertToAscii(originalInput, originalFormatValue);
        if (conversionResult.getErrorMessage() != null) {
            showAlert(Alert.AlertType.ERROR, "Error", "Save Error", conversionResult.getErrorMessage());
            return;
        }

        String csvLine = String.join(",", originalInput, result, originalFormatValue, resultFormatValue, selectedOperation, selectedCipherType != null ? selectedCipherType : "", key != null ? key : "");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("conversion_results.csv", true))) {
            writer.write(csvLine);
            writer.newLine();
            showAlert(Alert.AlertType.INFORMATION, "Save Successful", null, "Result saved successfully.");
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Save Error", "Failed to save result.");
            e.printStackTrace();
        }
    }
}
