package com.example.snoretrain.gaggle.service;

import android.os.AsyncTask;


import com.example.snoretrain.gaggle.listener.IPartyPostBackListener;
import com.example.snoretrain.gaggle.utility.PartyMashedPotatoes;

import java.io.IOException;

/**
 * Created by student on 5/10/16.
 */
public class PartyPostTask extends AsyncTask<String, String, String> {

    private IPartyPostBackListener partyPostbackListener;


    public PartyPostTask(final IPartyPostBackListener partyCallbackListener) {
        this.partyPostbackListener = partyCallbackListener;
    }

    @Override
    protected String doInBackground(String... params) {
        HttpRequestManager httpRequestManager = new HttpRequestManager();

        try {
            httpRequestManager.newParty(PartyMashedPotatoes.formatPartyMashedPotatoes(params));
        } catch (IOException exception) {
            String exceptionString = exception.getMessage();
        }

        return "";
    }

    @Override
    protected void onPostExecute(String poststuff) {
        super.onPostExecute(poststuff);

        partyPostbackListener.onPostCallBack();
    }
}