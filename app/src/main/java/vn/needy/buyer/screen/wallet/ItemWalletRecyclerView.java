package vn.needy.buyer.screen.wallet;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import vn.needy.buyer.screen.BaseRecyclerViewAdapter;

/**
 * Created by minh_dai on 02/01/2018.
 */

public class ItemWalletRecyclerView extends BaseObservable {
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> mItemClickListener;
    private WalletActivity.Cargo mCargo;

    public ItemWalletRecyclerView(WalletActivity.Cargo mCargo, BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
        this.mCargo = mCargo;
    }

    public void onProductCLick(){

    }

    @Bindable
    public WalletActivity.Cargo getCargo() {
        return mCargo;
    }
}
