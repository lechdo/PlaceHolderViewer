package com.example.placeholderviewer.database.contracts;

public class CommentContract {

    public static final String TABLE_NAME = "comments";

    public static final String COL_ID = "id";
    public static final String COL_POSET_ID = "post";
    public static final String COL_COMMENTATOR_ID = "commentator";
    public static final String COL_BODY = "body";

    public static final String[] ALL_SELECT = new String[]{
            COL_ID,
            COL_POSET_ID,
            COL_COMMENTATOR_ID,
            COL_BODY
    };

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COL_POSET_ID + " LONG," +
                    COL_COMMENTATOR_ID + " LONG," +
                    COL_BODY + " TEXT" +
                    ");";

    public static final String DROP_TABLE = "DROP TABLE " + TABLE_NAME;
}
