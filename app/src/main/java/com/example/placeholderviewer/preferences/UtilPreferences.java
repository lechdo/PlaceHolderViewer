package com.example.placeholderviewer.preferences;

import android.view.Gravity;

public class UtilPreferences {


    public static final boolean DEFAULT_DATABASE_IS_PROVIDED = false;


    public static final String PREFERENCE_DATABASE_IS_PROVIDED = "commentSideView";


    public static void resetCommentSide() {
        GenericPreferenceManager.setPreferenceValue(PREFERENCE_DATABASE_IS_PROVIDED, DEFAULT_DATABASE_IS_PROVIDED);
    }

    public static boolean getNextCommentSide() {
        return GenericPreferenceManager.getPreferenceValue(PREFERENCE_DATABASE_IS_PROVIDED, DEFAULT_DATABASE_IS_PROVIDED);
    }

}
