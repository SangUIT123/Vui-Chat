package com.example.appfirebasedemofcm.appfirebasedemofcm;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appfirebasedemofcm.appfirebasedemofcm.Adapter.FriendAdapter;
import com.example.appfirebasedemofcm.appfirebasedemofcm.Models.Friends;
import com.example.appfirebasedemofcm.appfirebasedemofcm.Models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FragmentUser extends Fragment {
    private RecyclerView myFriendsList;
    private  DatabaseReference FriendsReference;
    private FirebaseAuth mAuth;

    String online_user_id;
    private View myMainView;

    public FragmentUser(){

    }
    @SuppressLint("WrongViewCast")
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState)
    {
        myMainView = inflater.inflate( R.layout.user_fragment, container, false );

        myFriendsList = (RecyclerView) myMainView.findViewById( R.id.friends_list );
        mAuth=FirebaseAuth.getInstance();
        online_user_id = mAuth.getCurrentUser().getUid();




        return myMainView;
    }

    }