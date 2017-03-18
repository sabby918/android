package com.example.jarrm5.gymapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by James on 3/3/2017.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    //private static final String LOG = "DatabaseHelper";  //Logcat tag
    private static final int DATABASE_VERSION = 1;  // Database Version
    private static final String DATABASE_NAME = "workout"; // Database Name

    // TABLE NAMES
    private static final String TABLE_WORKOUT = "workouts";
    private static final String TABLE_EXERCISE = "exercises";
    private static final String TABLE_SET = "sets";

    // WORKOUTS TABLE - COLUMN NAMES
    private static final String PKEY_WORKOUT_ID = "wktId";
    private static final String WORKOUT_NAME = "wktName";

    // EXERCISES TABLE - COLUMN NAMES
    private static final String PKEY_EXERCISE_ID = "exerId";
    private static final String EXERCISE_NAME = "exerName";
    private static final String FKEY_WORKOUT_ID = "wktId";

    // SETS TABLE - COLUMN NAMES
    private static final String PKEY_SET_ID = "setId";
    private static final String SET_WEIGHT = "weight";
    private static final String SET_REPS = "reps";
    private static final String SET_DATE = "progDate";
    private static final String FKEY_EXERCISE_ID = "exerId";

    //TABLE CREATE STATEMENTS

    //CREATE WORKOUT TABLE
    private static final String CREATE_TABLE_WORKOUT = "CREATE TABLE " + TABLE_WORKOUT + "("
            + PKEY_WORKOUT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + WORKOUT_NAME + " TEXT);";

    private static final String CREATE_TABLE_EXERCISE = "CREATE TABLE " + TABLE_EXERCISE + "("
            + PKEY_EXERCISE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + EXERCISE_NAME + " TEXT,"
            + FKEY_WORKOUT_ID + " INTEGER,"
            + " FOREIGN KEY ("+ FKEY_WORKOUT_ID +") REFERENCES " + TABLE_WORKOUT + "("+PKEY_WORKOUT_ID+"));";

    private static final String CREATE_TABLE_SET = "CREATE TABLE " + TABLE_SET + "("
            + PKEY_SET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + SET_WEIGHT + " INTEGER,"
            + SET_REPS + " INTEGER,"
            + SET_DATE + " DATE,"
            + FKEY_EXERCISE_ID + " INTEGER,"
            + " FOREIGN KEY ("+ FKEY_EXERCISE_ID +") REFERENCES " + TABLE_EXERCISE + "("+PKEY_EXERCISE_ID+"));";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //context.deleteDatabase("workout");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create the tables if the db doesnt exist
        db.execSQL(CREATE_TABLE_WORKOUT);
        db.execSQL(CREATE_TABLE_EXERCISE);
        db.execSQL(CREATE_TABLE_SET);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //onUpgrade, drop older tables
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_WORKOUT);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_EXERCISE);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_SET);
        onCreate(db);
    }

    /*public boolean insertWorkout(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(WORKOUT_NAME,name);
        long result = db.insert(TABLE_WORKOUT,null,contentValues);
        return result == -1 ? false:true;
    }*/

    public long createWorkout(Workout workout){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(WORKOUT_NAME,workout.getWktName());
        return db.insert(TABLE_WORKOUT,null,contentValues);
    }
}
