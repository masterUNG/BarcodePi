package androidthai.in.th.barcodepi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import androidthai.in.th.barcodepi.fragment.ListProductFragment;
import androidthai.in.th.barcodepi.utility.MyManager;

public class MainActivity extends AppCompatActivity {

    private MyManager myManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Create SQLite Database (First Time)
        createSQLite();

//        Test Add Value
//        testAddValue();

//        Add Fragment to Activity
        addFragment(savedInstanceState);


    }   // Main Method

    private void addFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {

            ListProductFragment listProductFragment = new ListProductFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentListProductFragment, listProductFragment).commit();

        }
    }

    private void createSQLite() {
        myManager = new MyManager(MainActivity.this);
    }

    private void testAddValue() {
        String[] strings = new String[]{
                null,
                "testName",
                "testBar",
                "testPrice",
                "testDetail",
                "testPath",
                "testItem"};
        myManager.addNewValueToSQLite(strings);
    }


}   // Main Class
