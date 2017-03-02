package com.example.jarrm5.gymapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mAddWorkout;

    public class CustomClickListener implements View.OnClickListener {

        private final Dialog dialog;

        CustomClickListener(Dialog dialog) {
            this.dialog = dialog;
        }

        @Override
        public void onClick(View v) {
            String test = v.findViewById(R.id.workout_name_input).toString();
            String editTextValue= mAddWorkout.getText().toString();
        }
    }

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

        switch(item.getItemId()){
            case R.id.action_add_workout:
                //final EditText mAddWorkout = (EditText)R.layout.userinput;

                //Creating the dialog box for entering the workout name
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Enter the workout name");

                //Create the user input xml file into a java object; capturing the user input from the dialog box
                //inflate means "fill"
                View view = LayoutInflater.from(this).inflate(R.layout.userinput,null);
                mAddWorkout = (EditText)view.findViewById(R.id.workout_name_input);

                builder.setView(R.layout.userinput);
                builder.setPositiveButton("OK",null);
                builder.setNegativeButton("Cancel",null);

                AlertDialog alertDialog = builder.create();
                Button saveWorkout = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
                saveWorkout.setOnClickListener(new CustomClickListener(alertDialog));
                alertDialog.show();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
