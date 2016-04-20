package com.example.snoretrain.gaggle.model;

import java.util.ArrayList;

/**
 * Created by Snore Train on 4/18/2016.
 */
public class PartyModel {

    private String imageId;
    private String partyDescription;
    private String partyName;
    private ArrayList<String> partyImageUrls;
    public String getID() {return imageId;}
    public String getPartyName() { return partyName; }
    public String getPartyDescription() {return partyDescription;}
    public ArrayList<String> getPartyImageUrls() { return partyImageUrls; }

    public void setID(String pid) { imageId = pid; }
    public void setPartyName(String someName) { partyName = someName; }
    public void setPartyDescription(String pDesc) { partyDescription = pDesc; }



}
