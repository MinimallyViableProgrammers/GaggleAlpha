package com.example.snoretrain.gaggle.utility;

import com.example.snoretrain.gaggle.model.PartyListModel;
import com.google.gson.Gson;

/**
 * Created by student on 4/21/16.
 */
public class PartyParser {
    public static final PartyListModel parsePartyFromJson(final String stringIn){
        PartyListModel partyListModel;
        Gson gson = new Gson();
        partyListModel = gson.fromJson(stringIn, PartyListModel.class);

        return partyListModel;
    }
}
