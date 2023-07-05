package com.example.demo12;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
class EventHandlerOpenKlikOpLogin implements EventHandler<ActionEvent> {
    private GridPane gridPane;

    EventHandlerOpenKlikOpLogin(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        gridPane.getChildren().clear();
        LoginScreen loginScreen = new LoginScreen(gridPane);
    }
}
public class LoginScreen {
    private GridPane gridPane;

    LoginScreen(GridPane gridPane) {
        this.gridPane = gridPane;
        displayLoginScreen();
    }

    public void displayLoginScreen() {
        // Clear existing content and add login screen components
        gridPane.getChildren().clear();

        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login");
        Label errorLabel = new Label("");

        EventHandler<ActionEvent> loginHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String username = usernameField.getText();
                String password = passwordField.getText();

                boolean validLogin = false;
                for (Gebruiker gebruiker : Main.gebruikers) {
                    if (gebruiker.getGebruikersnaam().equals(username) && gebruiker.getWachtwoord().equals(password)) {
                        validLogin = true;
                        Main.loggedGebruiker = gebruiker;
                        break;
                    }
                }

                if (validLogin) {
                    // Successful login
                    gridPane.getChildren().clear();
                    Homescreen homeScreen = new Homescreen(gridPane);
                } else {
                    // Invalid login, display error message
                    errorLabel.setText("Invalid username or password");
                }
            }
        };

        loginButton.setOnAction(loginHandler);

        // Add the components to the gridPane using gridPane.add()
        GridPane.setConstraints(usernameLabel, 0, 0);
        GridPane.setConstraints(usernameField, 1, 0);
        GridPane.setConstraints(passwordLabel, 0, 1);
        GridPane.setConstraints(passwordField, 1, 1);
        GridPane.setConstraints(loginButton, 0, 2);
        GridPane.setConstraints(errorLabel, 0, 3, 2, 1);

        gridPane.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, loginButton, errorLabel);
    }
}