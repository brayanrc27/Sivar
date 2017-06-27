package com.lb.s.obj;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;

import com.lb.s.db.chatContract.*;

import java.io.Serializable;

public class objChat {
    private String id;
    private String conact;
    private Integer anonym;

    public objChat(){}
    public objChat(String Id,String Contact,Integer Anonym){
        this.id=Id;
        this.conact=Contact;
        this.anonym=Anonym;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(chat.ID, id);
        values.put(chat.CONTACT, conact);
        values.put(chat.ANONYM, anonym);
        return values;
    }
    public objChat constructValues(Cursor c){
        DatabaseUtils.dumpCursor(c);
        c.moveToPosition(0);
        this.id=c.getString(0);
        this.conact=c.getString(1);
        this.anonym=c.getInt(2);
        return this;
    }

    public String getId(){ return this.id; }
    public String getCont(){ return this.conact; }
    public Integer getAnom(){ return this.anonym; }
}
