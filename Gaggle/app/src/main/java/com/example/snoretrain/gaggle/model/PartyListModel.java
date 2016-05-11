package com.example.snoretrain.gaggle.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Snore Train on 4/18/2016.
 */
public class PartyListModel extends ArrayList<PartyModel>{

    public PartyModel getPartyModel(int position){
        return this.get(position);
    }

}
