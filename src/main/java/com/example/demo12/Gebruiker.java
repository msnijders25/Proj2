package com.example.demo12;

import java.util.ArrayList;

class Gebruiker {
    String gebruikersNaam;
    String wachtWoord;

    SavedMessages savedMessages = new SavedMessages();
     int nr;

    ArrayList<Chat> chats = new ArrayList<>();
    Gebruiker(String gebruikersNaam, String wachtWoord){
        ArrayList<Chat> chats = new ArrayList<>();
        this.gebruikersNaam = gebruikersNaam;
        this.wachtWoord = wachtWoord;
        this.chats = chats;
    }

    public  void setNr(int nr) {
        this.nr = nr;
    }

    public  int getNr() {
        return nr;
    }

    public Gebruiker() {

     }



    public ArrayList<Chat> getChats() {
        return chats;
    }


    public String getGebruikersnaam() {
         return gebruikersNaam;
     }

     public String getWachtwoord() {
         return wachtWoord;
     }
 }
