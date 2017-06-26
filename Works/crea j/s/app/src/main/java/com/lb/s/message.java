package com.lb.s;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.lb.s.adap.adapterMen;
import com.lb.s.obj.objChat;
import com.lb.s.obj.objMen;

import java.util.ArrayList;

public class message extends AppCompatActivity {

    private objChat c;
    private objMen m;
    private adapterMen adapM;

    private ArrayList<objMen> message;
    private EditText msg;
    private ListView msgList;
    private ImageButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);
         String chat = getIntent().getExtras().getString("chat");

        msg = (EditText) findViewById(R.id.messageEditText);
        msgList = (ListView) findViewById(R.id.msgListView);
        btn = (ImageButton) findViewById(R.id.sendMessageButton);
        //btn.setOnClickListener(this);

        // ----Set autoscroll of listview when a new message arrives----//
        msgList.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        msgList.setStackFromBottom(true);

        message = new ArrayList<objMen>();
        //adapM = new adapterMen(this, message);
        //msgList.setAdapter(adapM);
    }

}
