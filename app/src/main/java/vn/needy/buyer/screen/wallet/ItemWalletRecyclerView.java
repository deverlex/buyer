package vn.needy.buyer.screen.wallet;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;

import vn.needy.buyer.screen.BaseRecyclerViewAdapter;

/**
 * Created by minh_dai on 02/01/2018.
 */

public class ItemWalletRecyclerView extends BaseObservable {
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> mItemClickListener;
    private WalletActivity.Product mProduct;

    public ItemWalletRecyclerView(WalletActivity.Product mProduct , BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
        this.mProduct = mProduct;
    }

    public void onProductCLick(){

    }

    @Bindable
    public WalletActivity.Product getProduct() {
        return mProduct;
    }
}
