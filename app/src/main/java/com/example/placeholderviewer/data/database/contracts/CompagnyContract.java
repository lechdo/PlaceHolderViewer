package com.example.placeholderviewer.data.database.contracts;

public class CompagnyContract {

    public static final String TABLE_NAME = "compagnies";

    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_CATCH_PHRASE = "catchPhrase";
    public static final String COL_BS = "bs";

    public static final String[] ALL_SELECT = new String[]{
            COL_ID,
            COL_NAME,
            COL_CATCH_PHRASE,
            COL_BS
    };

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COL_NAME + " TEXT," +
                    COL_CATCH_PHRASE + " TEXT," +
                    COL_BS + " TEXT" +
                    ");";

    public static final String DROP_TABLE = "DROP TABLE " + TABLE_NAME;
}
