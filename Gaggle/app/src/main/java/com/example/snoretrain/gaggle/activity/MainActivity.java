package com.example.snoretrain.gaggle.activity;


import android.content.Context;
import android.content.Intent;


import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.snoretrain.gaggle.R;
import com.example.snoretrain.gaggle.adapter.PartyAdapter;
import com.example.snoretrain.gaggle.itemdecoration.VerticalItemDecoration;
import com.example.snoretrain.gaggle.listener.IPartyCallbackListener;
import com.example.snoretrain.gaggle.location.GPSTracker;
import com.example.snoretrain.gaggle.model.PartyListModel;
import com.example.snoretrain.gaggle.service.PartySearchTask;




public class MainActivity extends AppCompatActivity {

    private RecyclerView partyRecycler;
    private LinearLayoutManager layoutManager;
    private PartyAdapter adapter;
    double latitude;
    double longitude;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GPSTracker tracker = new GPSTracker(this);
        if (tracker.canGetLocation()){
            latitude = tracker.getLatitude();
            longitude = tracker.getLongitude();
        } else tracker.showSettingsAlert();
        tracker.stopUsingGPS();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ImageButton createButton = (ImageButton) findViewById(R.id.createButton);
        setSupportActionBar(toolbar);

        partyRecycler = (RecyclerView) findViewById(R.id.partyRecycler);


        IPartyCallbackListener listener = new IPartyCallbackListener() {
            @Override
            public void onSearchCallback(PartyListModel partyListModel) {

                layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);

                adapter = new PartyAdapter(partyListModel);

                partyRecycler.setLayoutManager(layoutManager);

                partyRecycler.setAdapter(adapter);

                partyRecycler.addItemDecoration(new VerticalItemDecoration(4));
            }
        };

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(v.getContext(), CreatePartyActivity.class);
                context.startActivity(intent);
            }
        });

        PartySearchTask partySearchTask = new PartySearchTask(listener);
        partySearchTask.execute("--");
    }


}
