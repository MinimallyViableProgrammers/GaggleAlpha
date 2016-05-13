package com.example.snoretrain.gaggle.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



import com.example.snoretrain.gaggle.R;
import com.example.snoretrain.gaggle.activity.DisplayPartyActivity;
import com.example.snoretrain.gaggle.model.PartyListModel;
import com.example.snoretrain.gaggle.model.PartyModel;

import static android.support.v4.app.ActivityCompat.startActivity;


/**
 * Created by Snore Train on 4/18/2016.
 */
public class PartyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public static final String EXTRA_NAME = "com.example.snoretrain.gaggle.adapter.NAME";
    public static final String EXTRA_IMAGE = "com.example.snoretrain.gaggle.adapter.IMAGE";
    public static final String EXTRA_DESCRIPTION = "com.example.snoretrain.gaggle.adapter.DESCRIPTION";
    public static final String EXTRA_ADDRESS = "com.example.snoretrain.gaggle.adapter.ADDRESS";
    public static final String EXTRA_TIME = "com.example.snoretrain.gaggle.adapter.TIME";
    private ImageView partyImage;
    private TextView partyName;
    private TextView partyDescription;
    private String party_name;
    private String party_image;
    private String party_description;
    private String party_location;
    private String start_time;

    public PartyViewHolder(final View partyView) {
        super(partyView);
        partyView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Context context = v.getContext();
        Intent intent = new Intent(v.getContext(), DisplayPartyActivity.class);
        intent.putExtra(EXTRA_NAME, party_name);
        intent.putExtra(EXTRA_IMAGE, party_image);
        intent.putExtra(EXTRA_DESCRIPTION, party_description);
        intent.putExtra(EXTRA_ADDRESS, party_location);
        intent.putExtra(EXTRA_TIME, start_time);
        context.startActivity(intent);

    }


    public final void bind(final PartyModel party) {

        partyImage = (ImageView)itemView.findViewById(R.id.partyImage);
        partyDescription = (TextView)itemView.findViewById(R.id.partyDescription);
        partyName = (TextView)itemView.findViewById(R.id.partyName);

        party_image = party.getID();
        party_name = party.getPartyName();
        party_description = party.getPartyDescription();
        party_location = party.getPartyLocation();
        start_time = party.getStartTime();
        Context context = partyImage.getContext();
        int id = context.getResources().getIdentifier(party.getID(), "drawable", context.getPackageName());
        partyImage.setImageResource(id);
        partyName.setText(party.getPartyName());
        partyDescription.setText(party.getPartyDescription());
    }

    public final void unbind() {

    }
}
