package com.example.demo12;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

class EventHandlerKlikOpTab implements EventHandler<ActionEvent> {
    private Chat chat;

    EventHandlerKlikOpTab(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        chat.displayChatWindow();
    }
}

public class Tab extends Button {
     Tab(Chat chat) {
        setPrefWidth(120); // Set the preferred width for the button
        setPrefHeight(40); // Set the preferred height for the button
        setText("Tab"); // Set the text for the button

        // Apply CSS styling to achieve the black button design
        setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5), null)));
        setTextFill(Color.WHITE); // Set text color to white

        // Register the event handler for the button
        setOnAction(new EventHandlerKlikOpTab(chat));
    }

     Tab() {

    }
}
