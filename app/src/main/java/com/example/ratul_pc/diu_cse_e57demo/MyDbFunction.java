package com.example.ratul_pc.diu_cse_e57demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbFunction extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Mydb";
    private static final String TABLE_NAME = "mytab ";

    private static final String TAB_ID = "Id";
    private static final String TAB_NAME = "Name";
    private static final String TAB_PHONE = "Phone";

    MyDbFunction(Context c){
        super(c, DATABASE_NAME, null, 5);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String s = "CREATE TABLE "+TABLE_NAME+" ("+TAB_ID+" INTEGER PRIMARY KEY, "+TAB_NAME+" TEXT, "+TAB_PHONE+" TEXT)";
        db.execSQL(s);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //----------- adding data to database ---------------
    void addingDataToTable(DataTemp dt){

        SQLiteDatabase sql = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(TAB_NAME, dt.getName());
        cv.put(TAB_PHONE,dt.getPhone());

        sql.insert(TABLE_NAME, null, cv);
        sql.close();
    }
    //------------ show data------------
    String[] my_data() {

        SQLiteDatabase sq = this.getReadableDatabase();
        String q = "SELECT * FROM "+TABLE_NAME;
        Cursor c = sq.rawQuery(q, null);

        String[] received_data = new String[c.getCount()];

        c.moveToFirst();
        if(c.moveToFirst()){
            int counter = 0;
            do {
                received_data[counter] = c.getString(c.getColumnIndex(TAB_NAME+""))+"Birthday: "+
                        c.getString(c.getColumnIndex(TAB_PHONE+""));
                counter = counter+1;
            }while (c.moveToNext());
        }
        return received_data;
    }
}
