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

//Need the implements part to be able to respond to the dialog box
public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

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
    public boolean onOptionsItemSelected(MenuItem item) {

        //Create the user input xml file into a java object; capturing the user input from the dialog box
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.userinput, null);
        EditText userInputText = (EditText)view.findViewById(R.id.workout_name_input);

        //Creating the dialog box for entering the workout name
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter the workout name");
        builder.setPositiveButton("OK",this); //Second parameter pass in which event listener should trigger when the button is clicked
        builder.setNegativeButton("Cancel",this);
        builder.setView(R.layout.userinput);
        builder.show();
        return true;



    }

    @Override
    public void onClick(DialogInterface dialogInterface, int which) {

        EditText result = (EditText) findViewById(R.id.workout_name_input);

        switch (which){
            case DialogInterface.BUTTON_POSITIVE:
                //Get the user input here
                int test = 9;
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                int test2 = 9;
                break;
            default:
        }
    }
}
