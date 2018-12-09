package com.example.appfirebasedemofcm.appfirebasedemofcm;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.appfirebasedemofcm.appfirebasedemofcm.Models.Message;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FragmentChat extends Fragment {
    private EditText metText;
    private Button mbtSent;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.chat_fragment,container,false);
        // 1. get a reference to recyclerView
        mbtSent = (Button) rootView.findViewById(R.id.button_chatbox_send);
        metText = (EditText)rootView.findViewById(R.id.edittext_chatbox);

        mbtSent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = metText.getText().toString();
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat mdformat = new SimpleDateFormat("HH:mm:ss");
                String strDate = "Current Time : " + mdformat.format(calendar.getTime());
                if (content.length() > 0) {
                    metText.setText("");
                    Message newMessage = new Message(content, "thien",strDate);
                    FirebaseDatabase.getInstance().getReference().child("message/").push().setValue(newMessage);
                }

//                if(!TextUtils.isEmpty(content))
//                {
//                    // Add a new sent message to the list.
//                    ChatAppMsgDTO msgDto = new ChatAppMsgDTO(ChatAppMsgDTO.MSG_TYPE_SENT, content);
//                    msgDtoList.add(msgDto);
//
//                    int newMsgPosition = msgDtoList.size() - 1;
//
//                    // Notify recycler view insert one new data.
//                    ListMessageAdapter messageAdapter = new ListMessageAdapter();
//
//
//                    // Scroll RecyclerView to the last message.
//                    msgRecyclerView.scrollToPosition(newMsgPosition);
//
//                    // Empty the input edit text box.
//
//                }
            }
        });
        return rootView;
    }


}
