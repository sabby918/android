package com.example.jarrm5.gymapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    private String mWorkoutName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        //return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    //Clicking add workout button in the action bar
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.action_add_workout:

                //Creating the dialog box for entering the workout name
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                final EditText input = new EditText(this);

                builder.setTitle("Enter the workout name").setView(input).setView(input);

                builder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //mWorkoutName = input.getText().toString();
                        Workout workout = new Workout(input.getText().toString());
                        long workout_key = myDb.createWorkout(workout);
                    }
                });
                builder.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}




////////////////////////////////////////edits by sarah/////////////////////////////////////////////////////////
