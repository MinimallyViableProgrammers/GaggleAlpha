package com.example.snoretrain.gaggle.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.snoretrain.gaggle.R;
import com.example.snoretrain.gaggle.adapter.PartyAdapter;
import com.example.snoretrain.gaggle.listener.IPartyCallbackListener;
import com.example.snoretrain.gaggle.model.PartyListModel;
import com.example.snoretrain.gaggle.service.PartySearchTask;

public class MainActivity extends AppCompatActivity {

    private RecyclerView partyRecycler;
    private LinearLayoutManager layoutManager;
    private PartyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        partyRecycler = (RecyclerView) findViewById(R.id.partyRecycler);

        layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        IPartyCallbackListener listener = new IPartyCallbackListener() {
            @Override
            public void onSearchCallback(PartyListModel partyListModel) {

                adapter = new PartyAdapter(partyListModel.getListResults());

                partyRecycler.setLayoutManager(layoutManager);

                partyRecycler.setAdapter(adapter);
            }
        };

        PartySearchTask partySearchTask = new PartySearchTask(listener);
        partySearchTask.execute("red_cup");
        
    }
}
