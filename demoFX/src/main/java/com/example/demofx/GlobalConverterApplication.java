package com.example.demofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GlobalConverterApplication extends Application {                                                                       // Class to start the application
    @Override
    public void start(Stage stage) throws IOException {                                                                             // Method to start the application
        FXMLLoader fxmlLoader = new FXMLLoader(GlobalConverterApplication.class.getResource("hello-view.fxml"));             // Load the FXML file
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);                                                              // Create the scene with the FXML file
        stage.setTitle("Global Converter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {                                                                                     // Main method to launch the application
        launch();
    }
}