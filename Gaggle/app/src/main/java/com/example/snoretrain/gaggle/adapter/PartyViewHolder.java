package com.example.snoretrain.gaggle.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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
    private ImageView partyImage;
    private TextView partyName;
    private TextView partyDescription;
    private String party_name;
    private String party_image;
    private String party_description;

    public PartyViewHolder(final View partyView) {
        super(partyView);
        partyView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Context context = v.getContext();
        Intent intent = new Intent(v.getContext(), DisplayPartyActivity.class);
        int position = getAdapterPosition();
        intent.putExtra(EXTRA_NAME, party_name);
        intent.putExtra(EXTRA_IMAGE, party_image);
        intent.putExtra(EXTRA_DESCRIPTION, party_description);
        context.startActivity(intent);

    }


    public final void bind(final PartyModel party) {

        partyImage = (ImageView)itemView.findViewById(R.id.partyImage);
        partyDescription = (TextView)itemView.findViewById(R.id.partyDescription);
        partyName = (TextView)itemView.findViewById(R.id.partyName);

        /*Glide.with(itemView.getContext())
                .load(party.getPartyImageUrls().get(0))
                .into(partyImage);*/
        party_image = party.getID();
        party_name = party.getPartyName();
        party_description = party.getPartyDescription();
        Context context = partyImage.getContext();
        int id = context.getResources().getIdentifier(party.getID(), "drawable", context.getPackageName());
        partyImage.setImageResource(id);
        partyName.setText(party.getPartyName());
        partyDescription.setText(party.getPartyDescription());
    }

    public final void unbind() {

    }
}
