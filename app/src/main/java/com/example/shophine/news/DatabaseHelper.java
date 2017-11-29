package com.example.shophine.news;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by shophine on 11/25/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION =1;
    private static final String DATABASE = "news.db";
    private static final String TABLENAME = "users";
    private static final String CREATE_TABLE = "create table users(id integer primary key not null,"+"email text not null,password text not null )";
    private static final String ID = "id";

    SQLiteDatabase db;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        this.db=db;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS users";
        db.execSQL(query);
        this.onCreate(db);
    }

    public DatabaseHelper(Context context) {
        super(context, DATABASE, null, DATABASE_VERSION);
        this.db = db;
    }

    public void insert(User user){
        db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        String query="select * from users";
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();

        contentValues.put(ID,count);
        contentValues.put("email",user.getEmail());
        contentValues.put("password",user.getPassword());

        db.insert(TABLENAME,null,contentValues);
        db.close();

    }

    public int validate(String email,String pass){
        db=this.getReadableDatabase();

        String query = "select email,password from users";
        Cursor cursor = db.rawQuery(query,null);
        String a,b;
        if(cursor.moveToFirst()){
            do {
                   a=cursor.getString(0);
                   if(a.equals(email)){
                       b=cursor.getString(1);
                       if(b.equals(pass)){
                           return 1;
                       }else{
                           return -1;
                       }
                   }
            }while (cursor.moveToNext());

        }
        return 0;
    }

    public int checkUserExist(String email){
        db=this.getReadableDatabase();

        String query = "select email,password from users";
        Cursor cursor = db.rawQuery(query,null);
        String a,b;
        if(cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);
                if (a.equals(email)) {
                    return 0;
                }
            } while (cursor.moveToNext());
        }

        return 1;
    }
}
