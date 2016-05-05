package com.example.snoretrain.gaggle.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import com.example.snoretrain.gaggle.R;
import com.example.snoretrain.gaggle.adapter.PartyAdapter;
import com.example.snoretrain.gaggle.itemdecoration.VerticalItemDecoration;
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

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        partyRecycler = (RecyclerView) findViewById(R.id.partyRecycler);

        layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        IPartyCallbackListener listener = new IPartyCallbackListener() {
            @Override
            public void onSearchCallback(PartyListModel partyListModel) {

                adapter = new PartyAdapter(partyListModel);

                partyRecycler.setLayoutManager(layoutManager);

                partyRecycler.setAdapter(adapter);

                partyRecycler.addItemDecoration(new VerticalItemDecoration(4));
            }
        };


        PartySearchTask partySearchTask = new PartySearchTask(listener);
        partySearchTask.execute("red_cup");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add_new);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
