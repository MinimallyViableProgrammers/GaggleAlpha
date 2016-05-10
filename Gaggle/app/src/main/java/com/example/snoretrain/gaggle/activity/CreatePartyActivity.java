package com.example.snoretrain.gaggle.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.snoretrain.gaggle.R;
import com.example.snoretrain.gaggle.service.HttpRequestManager;
import com.example.snoretrain.gaggle.utility.PartyMashedPotatoes;
import com.example.snoretrain.gaggle.utility.UrlFormatUtility;

import java.io.IOException;

/**
 * Created by Snore Train on 5/5/2016.
 */
public class CreatePartyActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.create_party_display);


        Toolbar toolbar = (Toolbar) findViewById(R.id.createPartyToolbar);

        setSupportActionBar(toolbar);

        final EditText partyNameSubmit = (EditText) findViewById(R.id.partyNameSubmit);
        final EditText partyDescriptionSubmit = (EditText) findViewById(R.id.partyDescriptionSubmit);
        final EditText partyStartTime = (EditText) findViewById(R.id.partyStartTime);
        final EditText partyEndTime = (EditText) findViewById(R.id.partyEndTime);
        final EditText partyAddress = (EditText) findViewById(R.id.partyAddress);
        final EditText partyState = (EditText) findViewById(R.id.partyState);
        final EditText partyCity = (EditText) findViewById(R.id.partyCity);


        Button submitPartyButton = (Button) findViewById(R.id.submitPartyButton);

        submitPartyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] partyInfoStrings = {partyNameSubmit.getText().toString(), partyCity.getText().toString(),
                        partyState.getText().toString(), partyAddress.getText().toString(),
                        "cake_2", "100", partyStartTime.getText().toString(), partyEndTime.getText().toString(),
                        partyDescriptionSubmit.getText().toString()
                };

                HttpRequestManager httpRequestManager = new HttpRequestManager();

                try {
                    httpRequestManager.newParty(PartyMashedPotatoes.formatPartyMashedPotatoes(partyInfoStrings));
                } catch (IOException exception) {
                    String exceptionString = exception.getMessage();
                }


            }
        });

    }

}
