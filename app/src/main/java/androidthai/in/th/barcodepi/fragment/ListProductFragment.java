package androidthai.in.th.barcodepi.fragment;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;

import androidthai.in.th.barcodepi.MainActivity;
import androidthai.in.th.barcodepi.R;
import androidthai.in.th.barcodepi.utility.MyConstant;
import androidthai.in.th.barcodepi.utility.ReadAllData;

/**
 * Created by masterung on 7/12/2017 AD.
 */

public class ListProductFragment extends Fragment {

    //    Explicit
    private String[] connectedStrings;
    private int indexAnIn = 0;
    private Handler handler;
    private boolean statusSynDataABoolean = true; // true สภาวะที่จะ Update Data



    //    Create Main Method
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Check Internet
        checkInternet();

//        Create Toolbar
        createToolbar();

//        My Loop
        myLoop();

    }   // Main Method

    private void myLoop() {

//        ToDo
        checkInternet();
        changeSubTitle();

//        Check Update
        if (statusSynDataABoolean && (indexAnIn == 0)) {
            Log.d("12DecV1", "Update Working");
            statusSynDataABoolean = false;

            mySynchronize();

        }


//        Delay
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                myLoop();
            }
        }, 10000);
    }

    private void mySynchronize() {

        try {

            String tag = "15DecV1";

            //        Read All Data From  JSON
            MyConstant myConstant = new MyConstant();
            ReadAllData readAllData = new ReadAllData(getActivity());
            readAllData.execute(myConstant.getUrlGetAllProductString());

            String jsonString = readAllData.get();
            Log.d(tag, "JSON ==> " + jsonString);

            JSONArray jsonArray = new JSONArray(jsonString);


            for (int i=0; i<jsonArray.length(); i+=1) {



            }   // For




            //        Delete All SQLite and Update New Date to SQLte

            //        Share Operated to Create ListView

        } catch (Exception e) {
            e.printStackTrace();
        }


    }   // mySyn

    private void checkInternet() {

        MyConstant myConstant = new MyConstant();
        connectedStrings = myConstant.getConnectedStrings();

//        Check Internet
        try {

            ConnectivityManager connectivityManager = (ConnectivityManager)
                    getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            if (networkInfo.isConnected() && networkInfo != null) {

//                Internet OK
                indexAnIn = 0;

            } else {

//                Internet False
                indexAnIn = 1;
                statusSynDataABoolean = true;


            }

        } catch (Exception e) {
            e.printStackTrace();
            indexAnIn = 1;
        }

        Log.d("8DecV1", "index ==> " + indexAnIn);

    }

    private void createToolbar() {

        Toolbar toolbar = getView().findViewById(R.id.toolbarListProduct);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Check Internet");

//        Change SubTitle
        changeSubTitle();

    }

    private void changeSubTitle() {
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle(connectedStrings[indexAnIn]);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_product, container, false);
        return view;
    }
}   // Main Class
