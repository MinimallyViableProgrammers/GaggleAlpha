package com.example.snoretrain.gaggle.adapter;

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
    private TextView partyDescription;

    public PartyViewHolder(final View partyView) { super(partyView); }

    public final void bind(final PartyModel party) {

        partyImage = (ImageView)itemView.findViewById(R.id.partyImage);
        partyDescription = (TextView)itemView.findViewById(R.id.partyDescription);

        Glide.with(itemView.getContext())
                .load(party.getPartyImageUrls().get(0))
                .into(partyImage);
    }

    public final void unbind() {

    }
}
