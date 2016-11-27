package com.example.chango.sharedpreferences;

import android.preference.PreferenceActivity;
import android.os.Bundle;

public class MisPreferencias extends PreferenceActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
