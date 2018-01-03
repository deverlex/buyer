package vn.needy.buyer.screen.wallet.historyIncome;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.List;

import vn.needy.buyer.screen.BaseRecyclerViewAdapter;
import vn.needy.buyer.screen.wallet.WalletActivity;
import vn.needy.buyer.screen.wallet.WalletRecyclerViewAdapter;
import vn.needy.buyer.screen.wallet.WalletViewModel;

/**
 * Created by minh_dai on 02/01/2018.
 */

public class WalletHistoryIncomeViewModel extends BaseObservable implements WalletHistoryIncomeContract.ViewModel,
        BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object>{

    private Context mContext;
    private WalletRecyclerViewAdapter mAdapter;
    private boolean mVisibilityRecyclerView;
    private  BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object>
            mItemClickListener;
    private WalletHistoryIncomeContract.Presenter mPresenter;

    public WalletHistoryIncomeViewModel(Context mContext, WalletRecyclerViewAdapter adapter) {
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
    public void setPresenter(WalletHistoryIncomeContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public WalletRecyclerViewAdapter getAdapter() {
        return mAdapter;
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

    @Bindable
    public boolean isVisibilityRecyclerView() {
        return mVisibilityRecyclerView;
    }
}
