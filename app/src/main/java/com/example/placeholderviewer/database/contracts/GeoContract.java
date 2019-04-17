package com.example.placeholderviewer.database.contracts;

public class GeoContract {

    public static final String TABLE_NAME = "geos";

    public static final String COL_ID = "id";
    public static final String COL_LAT = "lat";
    public static final String COL_LON = "lon";


    public static final String[] ALL_SELECT = new String[]{
            COL_ID,
            COL_LAT,
            COL_LON
    };

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COL_LAT + " DOUBLE," +
                    COL_LON + " DOUBLE" +
                    ");";

    public static final String DROP_TABLE = "DROP TABLE " + TABLE_NAME;
}
