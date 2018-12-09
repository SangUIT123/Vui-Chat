package com.example.appfirebasedemofcm.appfirebasedemofcm;

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
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private View mMainView;
    private DatabaseReference mUserDatabase;
    private List<Friends> lFriends;
    private final String TAG = "";
    private ValueEventListener userListener;
    public FragmentUser() {
        lFriends = new ArrayList<Friends>();

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mMainView = inflater.inflate(R.layout.user_fragment,container,false);

        mUserDatabase = FirebaseDatabase.getInstance().getReference();
        //writeNewUser("thien");
        userListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final String UserName = dataSnapshot.child("UserName").getValue().toString();
                // String profileUrl = dataSnapshot.child("profileUrl").getValue().toString();
                Friends friend1 = new Friends("profileUrl", UserName);

                lFriends.add(friend1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        };
        mUserDatabase.child("Friends").addValueEventListener(userListener);

        mRecyclerView = (RecyclerView) mMainView.findViewById(R.id.friends_list);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
//        Friends friend = new Friends("url", "thien");
//        Friends friend2 = new Friends("url", "hoa");
//        lFriends.add(friend);
//        lFriends.add(friend2);
        mAdapter = new FriendAdapter(lFriends);
        mRecyclerView.setAdapter(mAdapter);
        return mMainView;
    }
//    private void writeNewUser( String name) {
//        User user = new User(name);
//
//        mUserDatabase.child("Friends").setValue(user);
//    }

}
