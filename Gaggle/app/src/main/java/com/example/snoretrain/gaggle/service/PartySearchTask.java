package com.example.snoretrain.gaggle.service;

import android.os.AsyncTask;

import com.example.snoretrain.gaggle.listener.IPartyCallbackListener;
import com.example.snoretrain.gaggle.model.PartyListModel;
import com.example.snoretrain.gaggle.utility.PartyParser;
import com.example.snoretrain.gaggle.utility.UrlFormatUtility;

import java.io.IOException;

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

       HttpRequestManager httpRequestManager = new HttpRequestManager();
       String response = "";

       try {
           response = httpRequestManager.getParty(UrlFormatUtility.formatPartySearchString());
       } catch (IOException exception) {
           String exceptionString = exception.getMessage();
       }

       if (response == null){
           PartyListModel nplm = new PartyListModel();
           return nplm;
       }


       return PartyParser.parsePartyFromJson(response);
    }

    @Override
    protected void onPostExecute(PartyListModel partyListModel) {
        super.onPostExecute(partyListModel);

        partyCallbackListener.onSearchCallback(partyListModel);
    }
}
