package com.lb.s.obj;

import android.content.ContentValues;

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

    public String getId(){ return this.id; }
    public String getCont(){ return this.conact; }
    public Integer getAnom(){ return this.anonym; }
}
