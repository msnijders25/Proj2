package com.example.demo12;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    public static ArrayList<Gebruiker> gebruikers = new ArrayList<>();

    static Gebruiker loggedGebruiker = new Gebruiker();

    @Override
    public void start(Stage primaryStage) {

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(800, 600);
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        button1.setMinSize(50, 40);
        button2.setMinSize(50, 40);

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gridPane.getChildren().clear();
                LoginScreen loginScreen = new LoginScreen(gridPane);
            }
        });

        // Positioning buttons in the grid
        GridPane.setConstraints(button1, 31, 40);
        GridPane.setConstraints(button2, 32, 40);

        gridPane.getChildren().addAll(button1, button2);

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Button Positioning Example");
        primaryStage.show();
    }

    public static void main(String[] args) {

        gebruikers.add(new Gebruiker("1", "1"));
        gebruikers.add(new Gebruiker("Gebruiker", "Wachtwoord"));
        gebruikers.add(new Gebruiker("Gebruiker1", "Wachtwoord1"));
        gebruikers.add(new Gebruiker("Gebruiker2", "Wachtwoord2"));

        launch(args);
    }
}
