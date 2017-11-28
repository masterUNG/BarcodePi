package androidthai.in.th.barcodepi.utility;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by masterung on 28/11/2017 AD.
 */

public class MyOpenHelper extends SQLiteOpenHelper{

    //    Explicit
    private Context context;
    public static final String database_name = "pi.db";
    private static final int database_version = 1;
    private static final String database_detail = "CREATE TABLE productTABLE (" +
            "id Integer Primary Key, " +
            "NameProduct Text, " +
            "Barcode Text, " +
            "Price Text, " +
            "Detail Text, " +
            "PathImage Text, " +
            "Item Text);";




    public MyOpenHelper(Context context) {
        super(context, database_name, null, database_version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(database_detail);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}   // Main Class
