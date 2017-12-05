package androidthai.in.th.barcodepi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import androidthai.in.th.barcodepi.utility.MyManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Create SQLite Database (First Time)
        MyManager myManager = new MyManager(MainActivity.this);

//        Test Add Value
        String[] strings = new String[]{
                "13",
                "testName",
                "testBar",
                "testPrice",
                "testDetail",
                "testPath",
                "testItem"};
        myManager.addNewValueToSQLite(strings);

    }   // Main Method


}   // Main Class
