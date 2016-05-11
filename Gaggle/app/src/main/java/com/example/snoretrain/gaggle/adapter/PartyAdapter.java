package com.example.snoretrain.gaggle.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.snoretrain.gaggle.R;
import com.example.snoretrain.gaggle.model.PartyModel;

import java.util.ArrayList;

/**
 * Created by Snore Train on 4/18/2016.
 */
public class PartyAdapter extends RecyclerView.Adapter<PartyViewHolder> {

    private ArrayList<PartyModel> partyCollection;

    public PartyAdapter(ArrayList<PartyModel> partyCollection){
        this.partyCollection = partyCollection;
    }
    @Override
    public PartyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.party_view, parent, false);

        return new PartyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PartyViewHolder holder, int position) {

        PartyModel party = partyCollection.get(position);

        holder.bind(party);
    }

    @Override
    public final void onViewRecycled(final PartyViewHolder holder) {
        super.onViewRecycled(holder);
        holder.unbind();
    }

    @Override
    public int getItemCount() { if (partyCollection == null) return 0;
        return partyCollection.size();}
}
