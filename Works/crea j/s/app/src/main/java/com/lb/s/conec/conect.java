package com.lb.s.conec;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class conect {
    public boolean c(Context c){
        ConnectivityManager cM = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nI = cM.getActiveNetworkInfo();
        return (nI != null && nI.isConnected());
    }
}
