package com.example.jarrm5.umpirebuddy;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class umpireActivity extends AppCompatActivity {

    private TextView mStrikeTextView;
    private TextView mBallTextView;
    private Button mStrikeButton;
    private Button mBallButton;

    private AtBat ab;

    public void dialog(CharSequence title){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(title);
        alert.setPositiveButton("OK", null);
        alert.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umpire);

        mStrikeTextView = (TextView)findViewById(R.id.strike_text_view);
        mBallTextView = (TextView)findViewById(R.id.ball_text_view);
        mStrikeButton = (Button)findViewById(R.id.strike_button);
        mBallButton = (Button)findViewById(R.id.ball_button);

        ab = new AtBat();

        mStrikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ab.incrementStrike();
                if (ab.isOut()){
                    dialog("Out!");
                    ab = new AtBat();
                }
                mStrikeTextView.setText("Strike: " + ab.getStrikes());
                mBallTextView.setText("Ball: " + ab.getBalls());
            }
        });

        mBallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ab.incrementBall();
                if (ab.isWalk()){
                    dialog("Walk!");
                    ab = new AtBat();
                }
                mStrikeTextView.setText("Strike: " + ab.getStrikes());
                mBallTextView.setText("Ball: " + ab.getBalls());
            }
        });
    }
}
