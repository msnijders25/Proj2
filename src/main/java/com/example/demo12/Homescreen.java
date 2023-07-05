package com.example.demo12;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

class EventHandlerOpenSettings implements EventHandler<ActionEvent> {
    private GridPane gridPane;

    EventHandlerOpenSettings(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        gridPane.getChildren().clear();
        Settings settings = new Settings(gridPane);
        settings.displaySettingsScreen();
    }
}

class EventHandlerLijstMetChats implements EventHandler<ActionEvent> {
    private LijstChatOpties lijst;

    EventHandlerLijstMetChats(LijstChatOpties lijst) {
        this.lijst = lijst;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
lijst.showOptions();
    }
}
class EventHandlerOpenChat implements EventHandler<ActionEvent> {
    private LijstChatOpties lijst;

    EventHandlerOpenChat(LijstChatOpties lijst) {
        this.lijst = lijst;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        lijst.showOptions();

        }
    }


    class EventHandlerOpenOudeChats implements EventHandler<ActionEvent> {
        ChatGeschiedenis chatGeschiedenis;

        EventHandlerOpenOudeChats(ChatGeschiedenis chatGeschiedenis) {
            this.chatGeschiedenis = chatGeschiedenis;
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            chatGeschiedenis.draw();
            chatGeschiedenis.show();
            for(int i = 0; i < chatGeschiedenis.getChats().size(); i++){
            System.out.println(chatGeschiedenis.getChats().get(i).getNr());}
        }
    }
class EventHandlerLogOut implements EventHandler<ActionEvent> {
    Gebruiker gebruiker;
    GridPane gridPane;

    EventHandlerLogOut(Gebruiker gebruiker, GridPane pane) {
        this.gebruiker = gebruiker;
        this.gridPane = pane;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Main.loggedGebruiker = null;
        LoginScreen loginScreen = new LoginScreen(gridPane);
        loginScreen.displayLoginScreen();
    }
}

    public class Homescreen {
    LijstChatOpties lijst = new LijstChatOpties();

        private GridPane gridPane;

        Homescreen(GridPane gridPane) {
            this.gridPane = gridPane;
            displayHomescreen();
        }

        public void displayHomescreen() {
            gridPane.getChildren().clear();
            Button settingsButton = new Button("Settings");
            settingsButton.setOnAction(new EventHandlerOpenSettings(gridPane));

            Button chatButton = new Button("Chat");
            chatButton.setOnAction(new EventHandlerOpenChat(lijst)); // Assign the correct event handler here


                ChatGeschiedenis chatGeschiedenis = new ChatGeschiedenis(Main.loggedGebruiker.getChats());
                Button oudeChats = new Button("ChatGeschiedenis");
                oudeChats.setOnAction(new EventHandlerOpenOudeChats(chatGeschiedenis));
                GridPane.setConstraints(oudeChats, 2, 0);
                gridPane.getChildren().add(oudeChats);


            Button logOutButton = new Button();
            logOutButton.setOnAction(new EventHandlerLogOut(Main.loggedGebruiker, gridPane));
            GridPane.setConstraints(logOutButton, 3,0);
            gridPane.getChildren().add(logOutButton);

            GridPane.setConstraints(settingsButton, 0, 0);
            gridPane.getChildren().add(settingsButton);

            GridPane.setConstraints(chatButton, 1, 0);
            gridPane.getChildren().add(chatButton);

            Button lijstOpties = new Button();
            lijstOpties.setOnAction(new EventHandlerLijstMetChats(lijst));
            GridPane.setConstraints(lijstOpties, 4,0);
            gridPane.getChildren().add(lijstOpties);



    }

    }
