package com.example.snoretrain.gaggle.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.snoretrain.gaggle.R;
import com.example.snoretrain.gaggle.adapter.PartyViewHolder;

/**
 * Created by student on 4/26/16.
 */
public class DisplayPartyActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_party_display);

        ImageView partyImage;
        TextView partyName;
        TextView partyDescription;
        TextView partyAddress;

        partyImage = (ImageView) findViewById(R.id.partyImageDisplay);
        partyName = (TextView) findViewById(R.id.partyNameDisplay);
        partyDescription = (TextView) findViewById(R.id.partyDescriptionDisplay);
        partyAddress = (TextView) findViewById(R.id.partyAddressDisplay);

        Intent intent = getIntent();


        String thisPartyName = intent.getStringExtra(PartyViewHolder.EXTRA_NAME);
        String thisPartyDescription = intent.getStringExtra(PartyViewHolder.EXTRA_DESCRIPTION);
        String thisPartyImage = intent.getStringExtra(PartyViewHolder.EXTRA_IMAGE);
        String thisPartyAddress = intent.getStringExtra(PartyViewHolder.EXTRA_ADDRESS);
        String newPartyImage = thisPartyImage.substring(0, thisPartyImage.length()-1) + "1";

        Context context = partyImage.getContext();

        int id = context.getResources().getIdentifier(newPartyImage, "drawable", context.getPackageName());

        partyImage.setImageResource(id);
        partyName.setText(thisPartyName);
        partyDescription.setText(thisPartyDescription);
        partyAddress.setText(thisPartyAddress);
    }
}
