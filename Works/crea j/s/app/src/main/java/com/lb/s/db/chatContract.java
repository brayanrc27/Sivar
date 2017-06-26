package com.lb.s.db;

import android.net.Uri;
import android.provider.BaseColumns;

import java.util.Date;
import java.util.UUID;

public class chatContract {
    interface chatEntry {
        String TABLE_NAME = "chat";
        String ID = "id";
        String CONTACT = "contact";
        String ANONYM = "anonym";
    }
    interface menEntry {
        String TABLE_NAME = "men";
        String ID = "id";
        String ID_CHAT = "idchat";
        String WHO = "who";
        String MESSAGE = "message";
        String DATE = "date";
    }
    public static class chat implements chatEntry {}
    public static class mens implements menEntry {}
}
