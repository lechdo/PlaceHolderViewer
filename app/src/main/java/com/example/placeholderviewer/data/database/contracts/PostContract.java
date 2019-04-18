package com.example.placeholderviewer.data.database.contracts;

public class PostContract {

    public static final String TABLE_NAME = "posts";

    public static final String COL_ID = "id";
    public static final String COL_USER_ID = "userId";
    public static final String COL_TITLE = "title";
    public static final String COL_BODY = "body";

    public static final String[] ALL_SELECT = new String[]{
            COL_ID,
            COL_USER_ID,
            COL_TITLE,
            COL_BODY
    };

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COL_USER_ID + " LONG," +
                    COL_TITLE + " TEXT," +
                    COL_BODY + " TEXT" +
                    ");";

    public static final String DROP_TABLE = "DROP TABLE " + TABLE_NAME;
}
