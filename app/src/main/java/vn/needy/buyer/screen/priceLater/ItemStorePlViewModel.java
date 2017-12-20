package vn.needy.buyer.screen.priceLater;

import android.databinding.BaseObservable;

import vn.needy.buyer.model.Store;
import vn.needy.buyer.screen.BaseRecyclerViewAdapter;

/**
 * Created by truongpq on 20/12/2017.
 */

public class ItemStorePlViewModel extends BaseObservable{
    private Store mStore;
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> mItemClickListener;

    public ItemStorePlViewModel(Store store, BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> mtemClickListener) {
        this.mStore = store;
        this.mItemClickListener = mtemClickListener;
    }

    public void onItemClick() {
        if (mItemClickListener != null) {
            mItemClickListener.onItemRecyclerViewClick(mStore);
        }
    }
}
