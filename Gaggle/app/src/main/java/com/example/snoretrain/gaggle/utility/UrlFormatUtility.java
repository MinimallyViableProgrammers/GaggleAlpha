package com.example.snoretrain.gaggle.utility;

/**
 * Created by student on 4/21/16.
 */
public class UrlFormatUtility {
    private static final String PARTY_ROUTE = "http://salty-gorge-55246.herokuapp.com/party/getparties";

    public static String formatPartySearchString(){
        String urlString = PARTY_ROUTE;
        return urlString;
    }

}
