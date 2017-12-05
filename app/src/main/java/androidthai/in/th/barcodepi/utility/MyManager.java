package androidthai.in.th.barcodepi.utility;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by masterung on 28/11/2017 AD.
 */

public class MyManager {

    private Context context;
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    private MyConstant myConstant;
    private String[] strings;

    public MyManager(Context context) {
        this.context = context;

        myOpenHelper = new MyOpenHelper(context);
        sqLiteDatabase = myOpenHelper.getWritableDatabase();

//        Getter Value to strings
        myConstant = new MyConstant();
        strings = myConstant.getColumnProductStrings();

        for (int i=0; i<strings.length; i+=1) {

            Log.d("5DecV1", "strings[" + i + "] ==> " + strings[i]);

        }


    }   // Constructor


    //    Add New Value to SQLite
    public long addNewValueToSQLite(String[] valueStrings) {

        ContentValues contentValues = new ContentValues();

        for (int i=0; i<strings.length; i+=1) {

            contentValues.put(strings[i], valueStrings[i]);

        }

        return sqLiteDatabase.insert("productTABLE", null, contentValues);
    }




}   // Main Class
