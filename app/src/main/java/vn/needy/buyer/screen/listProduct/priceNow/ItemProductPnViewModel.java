package vn.needy.buyer.screen.listProduct.priceNow;

import android.databinding.BaseObservable;

import vn.needy.buyer.repository.remote.product.context.ProductPnContext;
import vn.needy.buyer.screen.BaseRecyclerViewAdapter;

/**
 * Created by truongpq on 03/01/2018.
 */

public class ItemProductPnViewModel extends BaseObservable{
    private ProductPnContext mProductPn;
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> mItemClickListener;

    public ItemProductPnViewModel(ProductPnContext productPn, BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> itemClickListener) {
        this.mProductPn = productPn;
        this.mItemClickListener = itemClickListener;
    }
    public void onItemClick() {
        if (mItemClickListener != null) {
            mItemClickListener.onItemRecyclerViewClick(mProductPn);
        }
    }

}
