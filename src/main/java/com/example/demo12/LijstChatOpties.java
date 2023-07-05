package com.example.demo12;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


 class LijstChatOpties {

    public  void showOptions() {
        ListView<String> listView = new ListView<>(FXCollections.observableArrayList(
                "films", "boeken"
        ));

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                openNewWindow(newValue);
                listView.getSelectionModel().clearSelection();
            }
        });

        VBox vbox = new VBox(listView);
        Scene scene = new Scene(vbox, 200, 200);
        Stage stage = new Stage();
        stage.setTitle("Options");
        stage.setScene(scene);
        stage.show();
    }

    private  void openNewWindow(String option) {

        if (option.equals("boeken")) {
            Stage chatStage = new Stage();
            ChatBoeken promptsEnAntwoordenabstract = new ChatBoeken();
            ChatBoek chatBoeken = new ChatBoek(chatStage, promptsEnAntwoordenabstract);
            chatBoeken.displayChatWindow();
        }

        if (option.equals("films")) {
            Stage chatStage = new Stage();
            ChatFilms promptsEnAntwoordenabstract = new ChatFilms();
            ChatFilm chatFilms = new ChatFilm(chatStage, promptsEnAntwoordenabstract);
            chatFilms.displayChatWindow();
        }
    }
}
