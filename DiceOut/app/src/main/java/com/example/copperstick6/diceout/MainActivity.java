package com.example.copperstick6.diceout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public TextView rollResult;
    public int score;
    public Button rollButton;
    public ArrayList<Integer> die = new ArrayList<Integer>();


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
                        .setAction("A ction", null).show();
            }
        });
        score = 0;

        rollResult = (TextView)findViewById(R.id.rollResult);
        rollButton = (Button)findViewById(R.id.rollButton);
        //created a short message
        Toast.makeText(getApplicationContext(),"Welcome to DiceOut!", Toast.LENGTH_SHORT).show();
    }
    public void rollDice(View viewer){
        rollResult.setText("Clicked!");
      /*  int numberGenerated = (int)(6*Math.random()) + 1;
        String randVal = "Number Generated: " + numberGenerated;
        Toast.makeText(getApplicationContext(), randVal, Toast.LENGTH_SHORT).show();*/
        int die1 = (int)(6*Math.random()) + 1;
        int die2 = (int)(6*Math.random()) + 1;
        int die3 = (int)(6*Math.random()) + 1;
        die.add(die1);
        die.add(die2);
        die.add(die3);
        String msg = " I rolled a total of: " + (die1 + die2 + die3) + ". \n You rolled a " + die1 + ", " + die2 + ", " + die3 + ".";
        rollResult.setText(msg);
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
