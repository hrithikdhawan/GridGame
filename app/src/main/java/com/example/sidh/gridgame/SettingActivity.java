package com.example.sidh.gridgame;

import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }
    public static class SettingPreferenceFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener
    {
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_xml);
            Preference arrayLengthPreference=findPreference(getString(R.string.setting_length_key));
            bindPreferenceSummaryToValue(arrayLengthPreference);
        }
        private void bindPreferenceSummaryToValue(Preference preference)
        {
            preference.setOnPreferenceChangeListener(this);
            SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(preference.getContext());
            String preferenceString=sharedPreferences.getString(preference.getKey(),"");
            onPreferenceChange(preference,preferenceString);
        }
        @Override
        public boolean onPreferenceChange(Preference preference, Object o) {
            String value=o.toString();
            preference.setSummary(value);
            return true;
        }
    }
    }

