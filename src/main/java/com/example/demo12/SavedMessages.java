package com.example.demo12;

import java.util.ArrayList;

 class SavedMessages {
    ArrayList<String> chatMessages = new ArrayList<>();
    SavedMessages(){

    }
    public void putMessageInLijst(String message){
        chatMessages.add(message);
    }
}
