package vn.needy.buyer.screen.wallet.historyPurchase;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.List;

import vn.needy.buyer.screen.BaseRecyclerViewAdapter;
import vn.needy.buyer.screen.wallet.WalletActivity;
import vn.needy.buyer.screen.wallet.WalletRecyclerViewAdapter;

/**
 * Created by minh_dai on 02/01/2018.
 */

public class WalletHistoryPurchaseViewModel extends BaseObservable implements WalletHistoryPurchaseContract.ViewModel,
        BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object>{

    private Context mContext;
    private boolean mVisibilityRecyclerView;
    private  BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object>
            mItemClickListener;
    private WalletRecyclerViewAdapter mAdapter;
    private WalletHistoryPurchaseContract.Presenter mPresenter;

    public WalletHistoryPurchaseViewModel(Context mContext, WalletRecyclerViewAdapter adapter) {
        this.mContext = mContext;
        mAdapter = adapter;
        mVisibilityRecyclerView = false;
        mAdapter.setItemClickListener(this);
    }

    @Override
    public void onStart() {
        mPresenter.getListProduct();
    }

    @Override
    public void onStop() {

    }

    @Override
    public void setPresenter(WalletHistoryPurchaseContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onItemRecyclerViewClick(Object item) {

    }

    @Override
    public void getProductList(List<WalletActivity.Product> products) {
        mAdapter.updateData(products);
        mVisibilityRecyclerView = products.size() == 0 ? false : true;
    }

    @Override
    public void onPersonalEarnedCoinClick() {

    }

    public WalletRecyclerViewAdapter getAdapter() {
        return mAdapter;
    }

    @Bindable
    public boolean isVisibilityRecyclerView() {
        return mVisibilityRecyclerView;
    }
}
