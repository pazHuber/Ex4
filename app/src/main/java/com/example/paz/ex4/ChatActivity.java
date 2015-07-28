package com.example.paz.ex4;


import android.support.v4.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends FragmentActivity {
    Button sendBtn;
    List<ChatItem> chatItems = new ArrayList<ChatItem>();

    EditText textBox;

    ListView chatList;
    ChatAdapter chatAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        chatList = (ListView) findViewById(R.id.activityChatLV);
        chatAdapter = new ChatAdapter(this, chatItems);
        chatList.setAdapter(chatAdapter);

        this.textBox = (EditText) findViewById(R.id.editText);
        this.sendBtn = (Button) findViewById(R.id.login_btnLogin);
        this.sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String m = textBox.getText().toString();
                if(m.length() > 0) {
                    chatItems.add(new ChatItem((m)));
                    chatAdapter.notifyDataSetChanged();
                }
            }

        });

    }
}
