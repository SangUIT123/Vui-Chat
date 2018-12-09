package com.example.appfirebasedemofcm.appfirebasedemofcm;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.appfirebasedemofcm.appfirebasedemofcm.Models.Friends;
import com.example.appfirebasedemofcm.appfirebasedemofcm.Models.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class LayoutFragment extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private DatabaseReference mUserDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        mUserDatabase = FirebaseDatabase.getInstance().getReference();
        writeNewUser( "url","TramYeu");
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

            ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this,getSupportFragmentManager());

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
    private void writeNewUser( String url, String name) {
        Friends friend = new Friends(url ,name );
        Map<String, Object> friendValues = friend.toMap();
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/Friends/",friendValues );
        mUserDatabase.updateChildren(childUpdates);
    }
}
