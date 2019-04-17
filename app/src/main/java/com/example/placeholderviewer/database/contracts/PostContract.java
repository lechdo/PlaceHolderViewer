package com.example.placeholderviewer.database.contracts;

public class PostContract {

    public static final String TABLE_NAME = "posts";

    public static final String COL_ID = "id";
    public static final String COL_AUTHOR_ID = "author";
    public static final String COL_TITLE = "title";
    public static final String COL_BODY = "body";

    public static final String[] ALL_SELECT = new String[]{
            COL_ID,
            COL_AUTHOR_ID,
            COL_TITLE,
            COL_BODY
    };

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COL_AUTHOR_ID + " LONG," +
                    COL_TITLE + " TEXT," +
                    COL_BODY + " TEXT" +
                    ");";

    public static final String DROP_TABLE = "DROP TABLE " + TABLE_NAME;
}
