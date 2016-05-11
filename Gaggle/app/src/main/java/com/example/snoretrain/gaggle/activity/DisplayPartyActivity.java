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
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_party_display);

        ImageView partyImage;
        TextView partyName;
        TextView partyDescription;
        Toolbar toolbar = (Toolbar) findViewById(R.id.partyDisplayToolbar);

        setSupportActionBar(toolbar);

        partyImage = (ImageView) findViewById(R.id.partyImageDisplay);
        partyName = (TextView) findViewById(R.id.partyNameDisplay);
        partyDescription = (TextView) findViewById(R.id.partyDescriptionDisplay);

        Intent intent = getIntent();

        String thisPartyName = intent.getStringExtra(PartyViewHolder.EXTRA_NAME);
        String thisPartyDescription = intent.getStringExtra(PartyViewHolder.EXTRA_DESCRIPTION);
        String thisPartyImage = intent.getStringExtra(PartyViewHolder.EXTRA_IMAGE);

        Context context = partyImage.getContext();

        int id = context.getResources().getIdentifier(thisPartyImage, "drawable", context.getPackageName());

        partyImage.setImageResource(id);
        partyName.setText(thisPartyName);
        partyDescription.setText(thisPartyDescription);
    }
}
