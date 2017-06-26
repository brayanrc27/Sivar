package com.lb.s.obj;

import android.content.ContentValues;

import com.lb.s.db.chatContract.*;

public class objMen {
    private String id;
    private String idChat;
    private Integer who;//1 yo 0 el
    private String message;
    private Integer date;//unix format

    public objMen(String Id,String IdChat,Integer Who,String Message,Integer Date){
        this.id=Id;
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
    public Integer getUse(){ return this.who; }
    public String getMen(){ return this.message; }
    public Integer getDat(){ return this.date; }
}
