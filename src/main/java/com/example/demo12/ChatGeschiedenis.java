package com.example.demo12;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.ArrayList;

class EventHandlerOpenOudeChat implements EventHandler<ActionEvent> {
    private Chat chat;

    EventHandlerOpenOudeChat(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        chat.displayChatWindow();
    }
}

public class ChatGeschiedenis extends Stage {
    private ArrayList<Chat> chats;
    private Pane rootPane;

    public ChatGeschiedenis(ArrayList<Chat> chats) {
        this.rootPane = new Pane();
        setTitle("Status");
        this.rootPane.setMinSize(200, 200);
        this.chats = chats;
        draw();
        Scene scene = new Scene(rootPane);
        setScene(scene);
    }

    public void draw() {
        if (chats != null) {
            this.rootPane.getChildren().clear();
            TabPane tabPane = new TabPane();
            this.rootPane.getChildren().add(tabPane);
            for (Chat chat : chats) {
                System.out.print("bbbbbb");
                Tab tab = new Tab();
                tab.setText("Chat " + chat.getOnderwerp());
                tab.setContent(chat.getGridPane());
                tabPane.getTabs().add(tab);

                Button openChat = new Button();
                openChat.setText("Open Chat");
                openChat.setOnAction(new EventHandlerOpenOudeChat(chat));
                tab.setContent(new VBox(tab.getContent(), openChat));
            }
        } else {
            System.out.println("Chat is null ZIE CLASS CHATGESCHIEDENIS");
        }
    }

    public ArrayList<Chat> getChats() {
        return chats;
    }
}