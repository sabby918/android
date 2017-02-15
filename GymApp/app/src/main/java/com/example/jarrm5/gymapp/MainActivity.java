package com.example.jarrm5.gymapp;

import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    //Clicking add workout button in the action bar
    public boolean onOptionsItemSelected(MenuItem item) {

        //Create the user input xml file into a java object; capturing the user input from the dialog box
        //inflate means "fill"
        View view = LayoutInflater.from(MainActivity.this)
                .inflate(R.layout.userinput, null);
        final EditText mAddWorkout = (EditText)view.findViewById(R.id.workout_name_input);

        //Creating the dialog box for entering the workout name
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter the workout name");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = mAddWorkout.getText().toString();
                boolean brkpt = true;
            }
        }); //Second parameter pass in which event listener should trigger when the button is clicked
        builder.setNegativeButton("Cancel",null);
        builder.setView(R.layout.userinput);
        builder.show();


        return true;



    }
}
