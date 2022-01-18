package com.abim.perpustakaanapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {
    private SharedPreferences prefs;

    public Session(Context ctx) {
        prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public void setUser(int user_id, String name, String username){
        prefs.edit().putInt("user_id", user_id).commit();
        prefs.edit().putString("name", name).commit();
        prefs.edit().putString("username", username).commit();
    }

    public int getUser_Id(){
        return prefs.getInt("user_id", 0);
    }

    public String getName(){
        return prefs.getString("name", "");
    }

    public String getUsername(){
        return prefs.getString("username", "");
    }
}
