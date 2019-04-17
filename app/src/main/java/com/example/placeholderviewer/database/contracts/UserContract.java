package com.example.placeholderviewer.database.contracts;

public class UserContract {

    public static final String TABLE_NAME = "users";

    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_USERNAME = "userName";
    public static final String COL_ADRESS_ID = "adress_id";
    public static final String COL_EMAIL = "email";
    public static final String COL_PHONE = "phone";
    public static final String COL_WEBSITE = "website";
    public static final String COL_COMPAGNY_ID = "compagny_id";

    public static final String[] ALL_SELECT = new String[]{
            COL_ID,
            COL_NAME,
            COL_USERNAME,
            COL_ADRESS_ID,
            COL_EMAIL,
            COL_PHONE,
            COL_WEBSITE,
            COL_COMPAGNY_ID
    };

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COL_NAME + " TEXT," +
                    COL_USERNAME + " TEXT," +
                    COL_ADRESS_ID + " LONG," +
                    COL_EMAIL + " TEXT," +
                    COL_PHONE + " TEXT," +
                    COL_WEBSITE + " TEXT," +
                    COL_COMPAGNY_ID + " LONG" +
                    ");";

    public static final String DROP_TABLE = "DROP TABLE " + TABLE_NAME;

}
