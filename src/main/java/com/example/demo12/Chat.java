package com.example.demo12;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;



public abstract class Chat {

    private PromptsEnAntwoordenabstract promptsEnAntwoordenabstract;
    private Stage chatStage;
    private GridPane gridPane;
    private String onderwerp;
    private int nr;

    Chat(Stage chatStage ,PromptsEnAntwoordenabstract promptsEnAntwoordenabstract) {
        this.promptsEnAntwoordenabstract = promptsEnAntwoordenabstract;
        this.chatStage = chatStage;
        this.gridPane = new GridPane();
        this.nr = 0;
    }

    public Chat() {

    }

    public String getOnderwerp() {
        return onderwerp;
    }

    public int getNr() {
        return nr;
    }

    public void displayChatWindow() {
        chatStage.setTitle("Chat Window");

        StackPane chatAreaStackPane = new StackPane();
        chatAreaStackPane.setPrefSize(770, 550);
        TextArea chatArea = new TextArea();
        chatArea.setPrefSize(770, 550);
        chatArea.setEditable(false);
        chatAreaStackPane.getChildren().add(chatArea);

        VBox messageBox = new VBox();
        messageBox.setAlignment(Pos.CENTER_RIGHT);
        messageBox.setPadding(new Insets(5));

        TextArea messageArea = new TextArea();
        messageArea.setPrefWidth(770);
        messageArea.setPrefHeight(50);
        VBox.setVgrow(messageArea, Priority.ALWAYS);

        Button sendButton = new Button();
        Polygon triangle = new Polygon(0, 0, 0, 20, 10, 10);
        triangle.setFill(Color.GREEN);
        sendButton.setGraphic(triangle);
        sendButton.setPrefSize(30, 30);
        sendButton.setOnAction(event -> {
            String message = messageArea.getText().trim();
            QueryResolutionForm form = new QueryResolutionForm( message) ;
            if (!message.isEmpty()) {
                chatArea.appendText("You: " + message + "\n");
                chatArea.getText();
                Main.loggedGebruiker.savedMessages.putMessageInLijst(message);
                promptsEnAntwoordenabstract.resolve(form);
                if(promptsEnAntwoordenabstract.gimmeResultsI() != null) {
                    chatArea.appendText(promptsEnAntwoordenabstract.gimmeResultsI() + "\n");
                    Main.loggedGebruiker.savedMessages.putMessageInLijst(promptsEnAntwoordenabstract.gimmeResultsI());}
            }
            messageArea.clear();

        });

        messageBox.getChildren().addAll(messageArea, sendButton);

        GridPane.setConstraints(chatAreaStackPane, 0, 0);
        GridPane.setConstraints(messageBox, 0, 1);

        gridPane.getChildren().addAll(chatAreaStackPane, messageBox);

        Scene scene = new Scene(gridPane, 800, 600);
        chatStage.setScene(scene);
        chatStage.show();
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public void setOnderwerp(String onderwerp) {
        this.onderwerp = onderwerp;
    }
}
class ChatFilm extends Chat{

    ChatFilm(Stage chatStage , ChatFilms promptsEnAntwoordenabstract){
        super(chatStage , promptsEnAntwoordenabstract);

    }
}
class ChatBoek extends Chat{
   ChatBoek(Stage chatStage , ChatBoeken promptsEnAntwoordenabstract){
       super(chatStage , promptsEnAntwoordenabstract);
   }
}
