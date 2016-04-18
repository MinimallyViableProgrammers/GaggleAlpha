package com.example.snoretrain.gaggle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView partyRecycler;

    private LinearLayoutManager layoutManager;

    private ImageView partyImage;

    private TextView partyDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        partyRecycler = (RecyclerView) findViewById(R.id.partyRecycler);

        partyImage = (ImageView) findViewById(R.id.partyImage);

        partyDescription = (TextView) findViewById(R.id.partyDescription);

        layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);

        partyRecycler.setLayoutManager(layoutManager);

        View partyView = LayoutInflater.from(partyRecycler.getContext()).inflate(R.layout.party_view, partyRecycler, false);

        partyImage = (ImageView)partyView.findViewById(R.id.partyImage);

        partyDescription = (TextView)partyView.findViewById(R.id.partyDescription);


    }
}
