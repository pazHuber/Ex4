package com.example.paz.ex4;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.List;

public class MenuAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<MenuItem> items;

    public MenuAdapter(Activity activity, List<MenuItem> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int location) {
        return items.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_item_friends, null);

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.friend_icon);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.friend_title);
        RelativeLayout layout = (RelativeLayout) convertView.findViewById(R.id.friend_item);

        MenuItem item = items.get(position);
        imgIcon.setImageResource(item.getIcon());
        txtTitle.setText(item.getTitle());

        layout.setOnClickListener(item.getListener());

        return convertView;
    }

}