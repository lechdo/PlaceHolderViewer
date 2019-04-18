package com.example.placeholderviewer.data.database.contracts;

public class CommentContract {

    public static final String TABLE_NAME = "comments";

    public static final String COL_ID = "id";
    public static final String COL_POST_ID = "postId";
    public static final String COL_NAME = "name";
    public static final String COL_BODY = "body";

    public static final String[] ALL_SELECT = new String[]{
            COL_ID,
            COL_POST_ID,
            COL_NAME,
            COL_BODY
    };

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COL_POST_ID + " LONG," +
                    COL_NAME + " TEXT," +
                    COL_BODY + " TEXT" +
                    ");";

    public static final String DROP_TABLE = "DROP TABLE " + TABLE_NAME;
}
