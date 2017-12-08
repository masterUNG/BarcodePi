package androidthai.in.th.barcodepi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidthai.in.th.barcodepi.R;

/**
 * Created by masterung on 8/12/2017 AD.
 */

public class DetailProductFragment extends Fragment{




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_product, container, false);
        return view;
    }
}   // Main Class
