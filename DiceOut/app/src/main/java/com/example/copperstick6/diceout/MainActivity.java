package com.example.copperstick6.diceout;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    public TextView rollResult;
    public int score;
    public Button rollButton;
    public ArrayList<Integer> die;
    public ArrayList<ImageView> images;
    public TextView currentScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //created a short message
        Toast.makeText(getApplicationContext(),"Welcome to DiceOut!", Toast.LENGTH_SHORT).show();
        currentScore = (TextView) findViewById(R.id.totScore);
        score = 1000;
        die = new ArrayList<Integer>();
        images = new ArrayList<ImageView>();
        ImageView die1Image = (ImageView) findViewById(R.id.dice1Image);
        ImageView die2Image = (ImageView) findViewById(R.id.dice2Image);
        ImageView die3Image = (ImageView) findViewById(R.id.dice3Image);
        images = new ArrayList<ImageView>();
        images.add(die1Image);
        images.add(die2Image);
        images.add(die3Image);
        rollButton = (Button)findViewById(R.id.rollButton);
    }
    public void rollDice(View viewer){
        die.clear();
        int die1 = (int)(6*Math.random()) + 1;
        int die2 = (int)(6*Math.random()) + 1;
        int die3 = (int)(6*Math.random()) + 1;
        die.add(die1);
        die.add(die2);
        die.add(die3);
        for(int curDice = 0; curDice < 3; curDice++){
            String imageName = "die_face_" + die.get(curDice) + ".png";
            try{
                InputStream stream = getAssets().open(imageName);
                Drawable curImage = Drawable.createFromStream(stream,null);
                images.get(curDice).setImageDrawable(curImage);
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
