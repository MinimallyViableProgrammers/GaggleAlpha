package com.example.snoretrain.gaggle.model;

import java.util.ArrayList;

/**
 * Created by Snore Train on 4/18/2016.
 */
public class PartyModel {
    private String party_id;
    private String host_id;
    private String party_name;
    private String city;
    private String state;
    private String image;
    private String description;
    private String start_time;
    private String end_time;
    private String street_address;
    private double lat;
    private double lng;
    private double dist;
    public String getID() {return image;}
    public String getPartyName() { return party_name; }
    public String getPartyDescription() {return description;}
    public String getPartyLocation() {return street_address + " " + city + "," + state;}
    public void setImage(String pid) { image = pid; }
    public void setParty_name(String someName) { party_name = someName; }
    public void setDescription(String pDesc) { description = pDesc; }
    public void setParty_id(String a){party_id = a;}
    public void setCity(String a){city = a;}
    public void setHost_id(String a){host_id = a;}
    public void setState(String a){state = a;}
    public void setStart_time(String a){start_time = a;}
    public void setEnd_time(String a){end_time = a;}
    public void setStreet_address(String a){street_address = a;}



}
