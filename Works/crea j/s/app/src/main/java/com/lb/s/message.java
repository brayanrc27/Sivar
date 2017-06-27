package com.lb.s;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.lb.s.adap.adapterMen;
import com.lb.s.db.dbHelper;
import com.lb.s.obj.objChat;
import com.lb.s.obj.objMen;

import java.util.ArrayList;

public class message extends AppCompatActivity implements View.OnClickListener {
    private static String TAG = "------->Mensaje";

    private dbHelper db;
    private objChat c;
    private objMen m;
    private adapterMen adapM;
    private commons commons;

    private ArrayList<objMen> message;
    private EditText msg;
    private ListView msgList;
    private ImageButton btn;

    private String chatId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);

        commons = new commons();
        db = new dbHelper(this);
        c = new objChat();
        chatId = getIntent().getExtras().getString("chat");
        c.constructValues(db.getChat(chatId));
        Log.d(TAG, "onCreate: " + chatId);
        Log.d(TAG, "onCreate: " + c.getId());

        msg = (EditText) findViewById(R.id.messageEditText);
        msgList = (ListView) findViewById(R.id.msgListView);
        btn = (ImageButton) findViewById(R.id.sendMessageButton);
        btn.setOnClickListener(this);

        // ----Set autoscroll of listview when a new message arrives----//
        msgList.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        msgList.setStackFromBottom(true);

        message = new ArrayList<objMen>();
        adapM = new adapterMen(this, message);
        msgList.setAdapter(adapM);
    }

    public void sendTextMessage(View v) {
        String message = msg.getEditableText().toString();
        if (!message.equalsIgnoreCase("")) {
            final objMen obj = new objMen(chatId,1,message,commons.getTimeDate());
            msg.setText("");
            adapM.add(obj);
            adapM.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sendMessageButton:
                sendTextMessage(v);
        }
    }
}
