package com.example.jarrm5.umpirebuddy;

/**
 * Created by jarrm5 on 1/24/2017.
 */
public class AtBat {
    private int mBall;
    private int mStrike;

    public AtBat(){ mBall = 0; mStrike = 0;}

    public int getStrikes() {
        return mStrike;
    }
    public int getBalls() {
        return mBall;
    }

    public void incrementBall(){mBall++;}
    public void incrementStrike(){mStrike++;}
    public boolean isOut() {return mStrike == 3;}
    public boolean isWalk() {return mBall == 4;}

}
