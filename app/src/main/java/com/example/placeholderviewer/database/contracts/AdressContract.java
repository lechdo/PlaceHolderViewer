package com.example.placeholderviewer.database.contracts;

public class AdressContract {

    public static final String TABLE_NAME = "adresses";

    public static final String COL_ID = "id";
    public static final String COL_STREET = "street";
    public static final String COL_SUITE = "suite";
    public static final String COL_CITY = "city";
    public static final String COL_ZIP_CODE = "zipCode";
    public static final String COL_GEO_ID = "geo_id";

    public static final String[] ALL_SELECT = new String[]{
            COL_ID,
            COL_STREET,
            COL_SUITE,
            COL_CITY,
            COL_ZIP_CODE,
            COL_GEO_ID,
    };

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COL_STREET + " TEXT," +
                    COL_SUITE + " TEXT," +
                    COL_CITY + " TEXT," +
                    COL_ZIP_CODE + " TEXT," +
                    COL_GEO_ID + " LONG" +
                    ");";

    public static final String DROP_TABLE = "DROP TABLE " + TABLE_NAME;
}
