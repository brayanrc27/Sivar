package com.lb.s.db;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.lb.s.db.chatContract.*;
import com.lb.s.obj.objChat;
import com.lb.s.obj.objMen;

/**
 * Created by HP on 25/6/2017.
 */

public class dbHelper extends SQLiteOpenHelper {
    public static String TAG = "------>DB";
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Chat.db";

    public dbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private String ID_CHAT = "REFERENCES " + chat.TABLE_NAME + "(" + chat.ID + ")";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + chat.TABLE_NAME + " ("
                + chat.ID + " TEXT PRIMARY KEY,"
                + chat.CONTACT + " TEXT NOT NULL,"
                + chat.ANONYM + " INTEGER DEFAULT 1,"
                + "UNIQUE (" + chat.ID + "))");

        db.execSQL("CREATE TABLE " + mens.TABLE_NAME + " ("
                + mens.ID + " TEXT PRIMARY KEY,"
                + mens.ID_CHAT + " TEXT NOT NULL "+ ID_CHAT +","
                + mens.WHO + " TEXT NOT NULL,"
                + mens.MESSAGE + " TEXT NOT NULL,"
                + mens.DATE + " INTEGER DEFAULT 1,"
                + "UNIQUE (" + mens.ID + "))");

        objChat o1 = new objChat("C001","A001",1);
        objChat o2 = new objChat("C002","A004",0);
        objChat o3 = new objChat("C003","A005",1);

        db.insert(chat.TABLE_NAME,null,o1.toContentValues());
        db.insert(chat.TABLE_NAME,null,o2.toContentValues());
        db.insert(chat.TABLE_NAME,null,o3.toContentValues());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ mens.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ chat.TABLE_NAME);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                db.setForeignKeyConstraintsEnabled(true);
            } else {
                db.execSQL("PRAGMA foreign_keys=ON");
            }
        }
    }

    public long saveChat(objChat o) {
        SQLiteDatabase s = getWritableDatabase();
        return s.insert(
                chat.TABLE_NAME,
                null,
                o.toContentValues());
    }
    public long saveMen(objMen o) {
        SQLiteDatabase s = getWritableDatabase();
        return s.insert(
                mens.TABLE_NAME,
                null,
                o.toContentValues());
    }

    public Cursor getChat(String id) {
        String var[] = {id};
        return getReadableDatabase().query(
                        chat.TABLE_NAME,null,
                        chat.ID + "=?",
                        var,null,null,null);
    }
    public Cursor getChat_C(String id) {
        return getReadableDatabase().query(
                        chat.TABLE_NAME,null,
                        chat.CONTACT + "=" + id,
                        null,null,null,null);
    }
    public Cursor getAllChats() {
        return getReadableDatabase().query(
                        chat.TABLE_NAME,
                        null,null,null,null,null,null);
    }
    public Cursor getMen_Chat(String id) {
        return getReadableDatabase().query(
                        mens.TABLE_NAME,null,
                        mens.ID_CHAT + "=" + id,
                        null,null,null,null);
    }
}
