package com.example.snoretrain.gaggle.service;

import android.os.AsyncTask;

import java.io.IOException;

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
       PartyListModel partyListModel = new PartyListModel();
       PartyModel party1 = new PartyModel();
       PartyModel party2 = new PartyModel();
       PartyModel party3 = new PartyModel();
       PartyModel party4 = new PartyModel();
       PartyModel party5 = new PartyModel();
       party1.setID("red_cup");
       party1.setPartyDescription("Get Together!");
       party2.setID("red_cup");
       party2.setPartyDescription("Get Together!");
       party3.setID("red_cup");
       party3.setPartyDescription("Get Together!");
       party4.setID("red_cup");
       party4.setPartyDescription("Get Together!");
       party5.setID("red_cup");
       party5.setPartyDescription("Get Together!");
       partyListModel.listResults.set(0, party1);
       partyListModel.listResults.set(1, party1);
       partyListModel.listResults.set(2, party2);
       partyListModel.listResults.set(3, party2);
       partyListModel.listResults.set(4, party3);
       partyListModel.listResults.set(5, party3);
       partyListModel.listResults.set(6, party4);
       partyListModel.listResults.set(7, party5);

       return partyListModel;
    }

    @Override
    protected void onPostExecute(PartyListModel partyListModel) {
        super.onPostExecute(partyListModel);

        partyCallbackListener.onSearchCallback(partyListModel);
    }
}
