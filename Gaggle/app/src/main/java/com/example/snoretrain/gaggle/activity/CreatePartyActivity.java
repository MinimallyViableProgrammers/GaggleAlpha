package com.example.snoretrain.gaggle.activity;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.snoretrain.gaggle.R;
import com.example.snoretrain.gaggle.listener.IPartyPostBackListener;
import com.example.snoretrain.gaggle.service.PartyPostTask;

import java.util.ArrayList;

/**
 * Created by Snore Train on 5/5/2016.
 */
public class CreatePartyActivity extends AppCompatActivity{
    String partyImageName;
    String newPartyImageName;
    ListView list;
    ArrayList<String> imageNamesList = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.create_party_display);

        Toolbar toolbar = (Toolbar) findViewById(R.id.createPartyToolbar);
        CheckBox checkBox21 = (CheckBox) findViewById(R.id.checkbox21);

        setSupportActionBar(toolbar);

        list = (ListView)findViewById(R.id.listview);

        final EditText partyNameSubmit = (EditText) findViewById(R.id.partyNameSubmit);
        final EditText partyDescriptionSubmit = (EditText) findViewById(R.id.partyDescriptionSubmit);
        final EditText partyStartTime = (EditText) findViewById(R.id.partyStartTime);
        final EditText partyEndTime = (EditText) findViewById(R.id.partyEndTime);
        final EditText partyAddress = (EditText) findViewById(R.id.partyAddress);
        final EditText partyState = (EditText) findViewById(R.id.partyState);
        final EditText partyCity = (EditText) findViewById(R.id.partyCity);
        imageNamesList.add(0, "cake_");
        imageNamesList.add(1, "dice_");
        imageNamesList.add(2, "dog_");
        imageNamesList.add(3, "game_");
        imageNamesList.add(4, "movie_");
        imageNamesList.add(5, "pizza_");
        imageNamesList.add(6, "redcup_");
        imageNamesList.add(7, "sport_");
        imageNamesList.add(8, "study_");
        imageNamesList.add(9, "wine_");

        list.setAdapter(new ImageListAdapter(this));
        Button submitPartyButton = (Button) findViewById(R.id.submitPartyButton);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Object o = list.getItemAtPosition(position);
                partyImageName = imageNamesList.get(position);

            }
        });

        submitPartyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] partyInfoStrings = {partyNameSubmit.getText().toString(), partyCity.getText().toString(),
                        partyState.getText().toString(), partyAddress.getText().toString(),
                        newPartyImageName, "100", partyStartTime.getText().toString(), partyEndTime.getText().toString(),
                        partyDescriptionSubmit.getText().toString()
                };

                IPartyPostBackListener listener = new IPartyPostBackListener() {
                    @Override
                    public void onPostCallBack() {

                    }

                };

                PartyPostTask partyPostTask = new PartyPostTask(listener);
                partyPostTask.execute(partyInfoStrings);

                Context context = v.getContext();
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                context.startActivity(intent);
            }
        });

    }
    public class ImageListAdapter extends BaseAdapter {
        private Context mContext;

        // Keep all Images in array
        public Integer[] mThumbIds = {
                R.drawable.cake_1, R.drawable.dice_1, R.drawable.dog_1,
                R.drawable.game_1, R.drawable.movie_1, R.drawable.pizza_1,
                R.drawable.redcup_1, R.drawable.sport_1, R.drawable.study_1,
                R.drawable.wine_1
        };

        // Constructor
        public ImageListAdapter(Context c){
            mContext = c;
        }

        @Override
        public int getCount() {
            return mThumbIds.length;
        }

        @Override
        public Object getItem(int position) {
            return mThumbIds[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(mContext);
            imageView.setImageResource(mThumbIds[position]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new ListView.LayoutParams(100, 100));
            return imageView;
        }

    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.checkbox21:
                if (checked){
                    newPartyImageName = partyImageName + "3";
                }
                else{
                    newPartyImageName = partyImageName + "2";
                }
                break;

        }
    }
}
