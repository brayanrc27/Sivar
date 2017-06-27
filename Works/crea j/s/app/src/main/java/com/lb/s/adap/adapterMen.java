package com.lb.s.adap;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lb.s.R;
import com.lb.s.commons;
import com.lb.s.obj.objMen;

import java.util.ArrayList;

public class adapterMen extends BaseAdapter {

    private static commons commons;

    private static LayoutInflater inflater = null;
    ArrayList<objMen> chatMessageList;

    public adapterMen(Activity activity, ArrayList<objMen> list) {
        chatMessageList = list;
        inflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() { return chatMessageList.size(); }

    @Override
    public Object getItem(int position) { return position; }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        objMen message = chatMessageList.get(position);
        View vi = convertView;
        if (convertView == null)
            vi = inflater.inflate(R.layout.message_design, null);

        TextView msg = vi.findViewById(R.id.message_text);
        TextView dt = vi.findViewById(R.id.message_date);
        msg.setText(message.getMessage());
        msg.setText(commons.getTime(message.getDate()));
        ConstraintLayout layout = vi.findViewById(R.id.bubble_layout);
        LinearLayout parent_layout =  vi.findViewById(R.id.message_bubble);

        if (message.getWho()) {
            layout.setBackgroundResource(R.drawable.bubble2);
            parent_layout.setGravity(Gravity.RIGHT);
        }else {
            layout.setBackgroundResource(R.drawable.bubble1);
            parent_layout.setGravity(Gravity.LEFT);
        }
        msg.setTextColor(Color.BLACK);
        return vi;
    }
    public void add(objMen object) { chatMessageList.add(object); }
}
