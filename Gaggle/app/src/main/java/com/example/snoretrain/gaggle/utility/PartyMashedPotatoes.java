package com.example.snoretrain.gaggle.utility;



public class PartyMashedPotatoes {

    private static final String PARTY_ROUTE = "http://salty-gorge-55246.herokuapp.com/party/saveparty?";
    private static String[] partyFields = {"party_name", "city", "state", "street_address", "image", "host_id", "start_time", "end_time", "description"};
    public static String formatPartyMashedPotatoes(String[] partyInfo){
        String createPartyUrl = PARTY_ROUTE;
        createPartyUrl += partyFields[0] + "=" + partyInfo[0];
        for (int i = 1; i < partyFields.length; i++){

            createPartyUrl += "&" + partyFields[i] + "=" + partyInfo[i];


        }

        return createPartyUrl;
    }


}
