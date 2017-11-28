package androidthai.in.th.barcodepi.utility;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by masterung on 28/11/2017 AD.
 */

public class MyManager {

    private Context context;
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public MyManager(Context context) {
        this.context = context;

        myOpenHelper = new MyOpenHelper(context);
        sqLiteDatabase = myOpenHelper.getWritableDatabase();

    }
}   // Main Class
