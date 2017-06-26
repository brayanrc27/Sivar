package com.lb.s.frags;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lb.s.R;
import com.lb.s.adap.adapterChat;
import com.lb.s.db.dbHelper;
import com.lb.s.message;


/**
 * Created by HP on 20/6/2017.
 */

public class chatFragment extends Fragment implements adapterChat.OnItemClickListener {
    private static String TAG = "-------->fragMen";
    
    private View v;
    private RecyclerView list;
    private LinearLayoutManager lManager;
    private adapterChat adapt;
    private dbHelper base;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup con,
                            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.chat_fragment, con, false);

        FloatingActionButton fab = v.findViewById(R.id.fab);

        list = (RecyclerView) v.findViewById(R.id.chats);
        list.setHasFixedSize(true);

        lManager = new LinearLayoutManager(getActivity());
        list.setLayoutManager(lManager);

        adapt = new adapterChat(getActivity(), this);
        list.setAdapter(adapt);

        base = new dbHelper(getActivity());
        Cursor c = base.getAllChats();

        while (c.moveToNext()) { adapt.swapCursor(c); }
        return v;
    }

    @Override
    public void onClick(adapterChat.ViewHolder holder, String chat) {
        Log.d(TAG, "onClick: " + chat);
        Intent i = new Intent(getActivity(),message.class);
        i.putExtra("chat",chat);
        startActivity(i);
    }
}