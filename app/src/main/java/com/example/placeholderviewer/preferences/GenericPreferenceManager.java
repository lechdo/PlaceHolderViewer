package com.example.placeholderviewer.preferences;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.example.placeholderviewer.PlaceHolderViewerApplication;

import java.util.Map;

public class GenericPreferenceManager {
    private static SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(PlaceHolderViewerApplication.getAppContext());

    public static String getPreferenceValue(String key, String defValue) {
        return prefs.getString(key, defValue);
    }

    public static int getPreferenceValue(String key, int defValue) {
        return prefs.getInt(key, defValue);
    }

    public static boolean getPreferenceValue(String key, boolean defValue) {
        return prefs.getBoolean(key, defValue);
    }

    public static void setPreferenceValue(String key, String prefsValue) {
        prefs.edit().putString(key, prefsValue).apply();
    }

    public static void setPreferenceValue(String key, int prefsValue) {
        prefs.edit().putInt(key, prefsValue).apply();
    }

    public static void setPreferenceValue(String key, boolean prefsValue) {
        prefs.edit().putBoolean(key, prefsValue).apply();
    }

    public static boolean containsPreferenceKey(String key) {
        return prefs.contains(key);
    }

    public static void removePreferenceValue(String key) {
        prefs.edit().remove(key).apply();
    }

    public static Map<String, ?> getAllPreferences() {
        return prefs.getAll();
    }

}
