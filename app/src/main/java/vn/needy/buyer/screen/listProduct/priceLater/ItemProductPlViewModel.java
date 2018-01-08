package vn.needy.buyer.screen.listProduct.priceLater;

import android.databinding.BaseObservable;

import vn.needy.buyer.port.wrapper.ProductPlWrapper;
import vn.needy.buyer.screen.BaseRecyclerViewAdapter;

/**
 * Created by truongpq on 03/01/2018.
 */

public class ItemProductPlViewModel extends BaseObservable {

    private ProductPlWrapper mProductPl;
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> mItemClickListener;

    public ItemProductPlViewModel(ProductPlWrapper productPl, BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> itemClickListener) {
        this.mProductPl = productPl;
        this.mItemClickListener = itemClickListener;
    }

    public void onItemClick() {
        if (mItemClickListener != null) {
            mItemClickListener.onItemRecyclerViewClick(mProductPl);
        }
    }
}
