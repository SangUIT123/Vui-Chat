package com.example.appfirebasedemofcm.appfirebasedemofcm.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appfirebasedemofcm.appfirebasedemofcm.Models.Friends;
import com.example.appfirebasedemofcm.appfirebasedemofcm.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.MyViewHolder>{
    private List<Friends> lFriends ;




    public FriendAdapter( List<Friends> _lFriends){
        lFriends = _lFriends;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = (View)  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.users_single_layout, parent, false);

        MyViewHolder vh = new MyViewHolder(v);



        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.mUserName.setText(lFriends.get(i).GetFriendName() );
       // holder.mCircleImageView.()

    }

    @Override
    public int getItemCount() {
        return lFriends.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //public CircleImageView mCircleImageView;
        public TextView mUserName;
        //public ImageView mUserIcon;

        public MyViewHolder(@NonNull View v) {
            super(v);
            //mCircleImageView = (CircleImageView) v.findViewById(R.id.user_single_image);
            mUserName = (TextView) v.findViewById(R.id.user_single_name);
            //mUserStatus = (TextView) v.findViewById(R.id.user_single_status);
            //mUserIcon = (ImageView) v.findViewById(R.id.user_single_online_icon);
        }
    }



}
