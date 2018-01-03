package vn.needy.buyer.screen.productPnDetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.needy.buyer.R;

/**
 * Created by truongpq on 03/01/2018.
 */

public class BottomSheetBuyNow extends BottomSheetDialogFragment {
    public static BottomSheetBuyNow newInstance() {
        
        Bundle args = new Bundle();
        
        BottomSheetBuyNow fragment = new BottomSheetBuyNow();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_buy_now, container,
                false);

        // get the views and attach the listener

        return view;
    }
}
