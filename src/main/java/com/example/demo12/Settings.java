package com.example.demo12;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

class Settings {
    private GridPane gridPane;

    Settings(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public void displaySettingsScreen() {
        gridPane.getChildren().clear();
        Button darkModeButton = new Button("Dark Mode");
        Button lightModeButton = new Button("Light Mode");
        Button changeLanguageButton = new Button("Change Language");

        GridPane.setConstraints(darkModeButton, 0, 0);
        GridPane.setConstraints(lightModeButton, 0, 1);
        GridPane.setConstraints(changeLanguageButton, 0, 2);
        gridPane.getChildren().addAll(darkModeButton, lightModeButton, changeLanguageButton);
    }
}

