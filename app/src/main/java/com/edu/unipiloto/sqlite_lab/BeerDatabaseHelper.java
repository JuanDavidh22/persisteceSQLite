package com.edu.unipiloto.sqlite_lab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BeerDatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "beerdb";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "BEERS";
    public static final String COL_ID = "id";
    public static final String COL_BRAND = "BRAND";
    public static final String COL_COLOR = "COLOR";
    public static final String COL_SCORE = "SCORE";
    public static final String COL_COUNTRY = "COUNTRY";
    public static final String COL_PRICE = "PRICE";


    public BeerDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = String.format("CREATE TABLE BEERS(" +
                        "%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT," +
                        "%s TEXT," +
                        "%s INTEGER," +
                        "%s TEXT," +
                        "%s INTEGER);", COL_ID, COL_BRAND,
                COL_COLOR, COL_SCORE, COL_COUNTRY, COL_PRICE);
        db.execSQL(query);
        insertBeer("Poker", "Rubia", 4, "Colombia", 3000);
        insertBeer("Aguila", "Rubia", 4, "Colombia", 3000);
        insertBeer("Club Colombia", "Roja", 4, "Colombia", 3700);
    }

    public boolean insertBeer(String brand, String color, int score, String country, int price) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues beerValues = new ContentValues();
        beerValues.put(COL_BRAND, brand);
        beerValues.put(COL_COLOR, color);
        beerValues.put(COL_SCORE, score);
        beerValues.put(COL_COUNTRY, country);
        beerValues.put(COL_PRICE, price);
        long result = db.insert(TABLE_NAME, null, beerValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void initData() {
        SQLiteDatabase db = this.getWritableDatabase();
        onUpgrade(db, 1, 1);
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);
        return result;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = String.format("SELECT * FROM " + TABLE_NAME + " WHERE %s=" + id + "", COL_ID);
        Cursor result = db.rawQuery(query, null);
        return result;
    }

    public Cursor findDataColor(String color) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = String.format("SELECT * FROM " + TABLE_NAME + " WHERE %s='" + color + "'", COL_COLOR);
        Cursor result = db.rawQuery(query, null);
        return result;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        onCreate(db);
    }
}
