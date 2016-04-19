package com.example.snoretrain.gaggle.model;

import java.util.ArrayList;

/**
 * Created by Snore Train on 4/18/2016.
 */
public class PartyModel {

    private String id;
    private String partyDescription;
    private ArrayList<String> partyImageUrls;
    public PartyModel() {
        id = " ";
        partyDescription = " ";
    }
    public String getID() {return id;}
    public String getPartyDescription() {return partyDescription;}
    public ArrayList<String> getPartyImageUrls() { return partyImageUrls; }

    public void setID(String pid) { id = pid; }
    public void setPartyDescription(String pDesc) { partyDescription = pDesc; }



}
