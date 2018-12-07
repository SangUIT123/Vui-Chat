package com.example.appfirebasedemofcm.appfirebasedemofcm;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter{

    private Context mContext;

    public ViewPagerAdapter(Context context, FragmentManager fragmentManager){
        super(fragmentManager);
        mContext =context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new FragmentChat();
        }
        else {
            return  new FragmentUser();
        }

    }

    @Override
    public int getCount() {
        //return 2 Tabs
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0) {
            return "Chat";
        }
        else  {
            return "User";
        }

    }
}
