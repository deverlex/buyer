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

public class BottomSheetAddToCartDialog extends BottomSheetDialogFragment {

    public static BottomSheetAddToCartDialog newInstance() {
        Bundle args = new Bundle();
        BottomSheetAddToCartDialog fragment = new BottomSheetAddToCartDialog();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_bottom_sheet_add_to_cart, container,
                false);

        // get the views and attach the listener

        return view;
    }
}
