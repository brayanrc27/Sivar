package com.lb.s.obj;

import android.content.ContentValues;

import com.lb.s.db.chatContract.*;

import java.util.UUID;

public class objMen {
    private String id;
    private String idChat;
    private Integer who;//1 yo 0 el
    private String message;
    private long date;//unix format

    public objMen(String IdChat,Integer Who,String Message,long Date){
        this.id="M-" + UUID.randomUUID().toString();
        this.idChat=IdChat;
        this.who=Who;
        this.message=Message;
        this.date=Date;
    }
    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(mens.ID, id);
        values.put(mens.ID_CHAT, idChat);
        values.put(mens.WHO, who);
        values.put(mens.MESSAGE, message);
        values.put(mens.DATE, date);
        return values;
    }

    public String getId(){ return this.id; }
    public String getIdChat(){ return this.idChat; }
    public Boolean getWho(){ if (this.who==1){ return true; }else{ return false; }}
    public String getMessage(){ return this.message; }
    public long getDate(){ return this.date; }
}
