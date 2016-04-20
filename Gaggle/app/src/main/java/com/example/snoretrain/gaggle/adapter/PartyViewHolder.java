package com.example.snoretrain.gaggle.adapter;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.example.snoretrain.gaggle.R;
import com.example.snoretrain.gaggle.model.PartyModel;


/**
 * Created by Snore Train on 4/18/2016.
 */
public class PartyViewHolder extends RecyclerView.ViewHolder {

    private ImageView partyImage;
    private TextView partyName;
    private TextView partyDescription;

    public PartyViewHolder(final View partyView) { super(partyView); }

    public final void bind(final PartyModel party) {

        partyImage = (ImageView)itemView.findViewById(R.id.partyImage);
        partyDescription = (TextView)itemView.findViewById(R.id.partyDescription);
        partyName = (TextView)itemView.findViewById(R.id.partyName);

        partyImage.setImageResource(R.drawable.red_cup);
        /*Glide.with(itemView.getContext())
                .load(party.getPartyImageUrls().get(0))
                .into(partyImage);*/
        partyName.setText(party.getPartyName());
        partyDescription.setText(party.getPartyDescription());
    }

    public final void unbind() {

    }
}
