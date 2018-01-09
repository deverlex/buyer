package vn.needy.buyer.screen.wallet.historyIncome;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.List;

import vn.needy.buyer.domain.OrderWallet;
import vn.needy.buyer.screen.BaseRecyclerViewAdapter;
import vn.needy.buyer.screen.wallet.WalletRecyclerViewAdapter;

/**
 * Created by minh_dai on 02/01/2018.
 */

public class WalletIncomeHistoryViewModel extends BaseObservable implements WalletIncomeHistoryContract.ViewModel,
        BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object>{

    private Context mContext;
    private WalletRecyclerViewAdapter mAdapter;
    private boolean mVisibilityRecyclerView;
    private  BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object>
            mItemClickListener;
    private WalletIncomeHistoryContract.Presenter mPresenter;

    public WalletIncomeHistoryViewModel(Context mContext, WalletRecyclerViewAdapter adapter) {
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
    public void setPresenter(WalletIncomeHistoryContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public WalletRecyclerViewAdapter getAdapter() {
        return mAdapter;
    }

    @Override
    public void onItemRecyclerViewClick(Object item) {

    }

    @Override
    public void getOrderWalletList(List<OrderWallet> orderWallets) {
        mAdapter.updateData(orderWallets);
        mVisibilityRecyclerView = orderWallets.size() == 0 ? false : true;
    }

    @Override
    public void onViewAboutReceiveCoinClick() {

    }

    @Bindable
    public boolean isVisibilityRecyclerView() {
        return mVisibilityRecyclerView;
    }
}
