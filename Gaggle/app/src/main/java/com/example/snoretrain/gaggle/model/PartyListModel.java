package com.example.snoretrain.gaggle.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Snore Train on 4/18/2016.
 */
public class PartyListModel {

    @SerializedName("matches")
    public ArrayList<PartyModel> listResults;
    public PartyListModel(){
    };

    public ArrayList<PartyModel> getListResults() { return listResults;}

    public PartyModel getPartyModel(int position){
        return listResults.get(position);
    }

}
