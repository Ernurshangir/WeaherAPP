package com.example.weatherapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class APP extends Application {
    static String filename;
    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(APP.filename+".fxml")));
        Scene scene = new Scene(root);
        stage.setTitle("Weather App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Select numbers which weather website choose");
        System.out.println("1 is http://api.weatherapi.com on XML format: ");
        System.out.println("2 is http://api.openweathermap.org on Json format");
        int n = s.nextInt();
        s.close();
        switch (n) {
            case 1 -> filename = "primary";
            case 2 -> filename = "hello-view";
        }
        launch();
    }
}