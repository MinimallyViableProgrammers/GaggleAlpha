package com.example.snoretrain.gaggle.service;

import android.os.AsyncTask;

import java.io.IOException;
import java.util.ArrayList;

import com.example.snoretrain.gaggle.listener.IPartyCallbackListener;
import com.example.snoretrain.gaggle.model.PartyListModel;
import com.example.snoretrain.gaggle.model.PartyModel;

/**
 * Created by Snore Train on 4/19/2016.
 */
public class PartySearchTask extends AsyncTask<String,String,PartyListModel> {

    private IPartyCallbackListener partyCallbackListener;


    public PartySearchTask (final IPartyCallbackListener partyCallbackListener) {
        this.partyCallbackListener = partyCallbackListener;
    }

   @Override
    protected PartyListModel doInBackground(String... params) {

            //Where HTTP Requests will be made for this....
       PartyListModel partyListModel;
       partyListModel = new PartyListModel();
       PartyModel party1 = new PartyModel();
       PartyModel party2 = new PartyModel();
       PartyModel party3 = new PartyModel();
       PartyModel party4 = new PartyModel();
       PartyModel party5 = new PartyModel();
       party1.setID("red_cup");
       party1.setPartyDescription("Just a fun time with some friends!");
       party1.setPartyName("Get Together!");
       party2.setID("red_cup");
       party2.setPartyName("Super Rager 2k16");
       party2.setPartyDescription("Let's. Get. Waystead");
       party3.setID("red_cup");
       party3.setPartyName("Keg Stands Only");
       party3.setPartyDescription("Go Hard or die trying :)");
       party4.setID("red_cup");
       party4.setPartyName("Book club meeting");
       party4.setPartyDescription("Open to anyone with a real interest in Twilight");
       party5.setID("red_cup");
       party5.setPartyName("Lord of the Rings Night");
       party5.setPartyDescription("Popcorn. LOTR. Nuff said.");
       partyListModel.listResults = new ArrayList<>();
       partyListModel.listResults.add(0, party1);
       partyListModel.listResults.add(1, party1);
       partyListModel.listResults.add(2, party2);
       partyListModel.listResults.add(3, party2);
       partyListModel.listResults.add(4, party3);
       partyListModel.listResults.add(5, party3);
       partyListModel.listResults.add(6, party4);
       partyListModel.listResults.add(7, party5);

       return partyListModel;
    }

    @Override
    protected void onPostExecute(PartyListModel partyListModel) {
        super.onPostExecute(partyListModel);

        partyCallbackListener.onSearchCallback(partyListModel);
    }
}
