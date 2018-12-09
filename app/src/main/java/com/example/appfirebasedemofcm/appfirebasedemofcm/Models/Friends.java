package com.example.appfirebasedemofcm.appfirebasedemofcm.Models;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Friends {
    public String profileUrl;
    public String FriendName;
    public Map<String, Boolean> stars = new HashMap<>();
    public Friends(){

    }

    public Friends(String _ProfileUrl, String _FriendName)
    {
        profileUrl = _ProfileUrl;
        FriendName = _FriendName;

    }
    public void setFriendName(String _FriendName)
    {
        FriendName = _FriendName;
    }

    public String GetFriendName()
    {
        return FriendName;
    }

    public void setprofileUrl(String _ProfileUrl)
    {
        FriendName = _ProfileUrl;
    }

    public String GetprofileUrl()
    {
        return profileUrl;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("FriendName", FriendName);
        result.put("profileUrl", profileUrl);
        result.put("stars", stars);

        return result;
    }

}
