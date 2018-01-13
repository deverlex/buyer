package vn.needy.buyer.screen.wallet.historyTransaction;

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

public class WalletTransactionHistoryViewModel extends BaseObservable implements WalletTransactionHistoryContract.ViewModel,
        BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object>{

    private Context mContext;
    private boolean mVisibilityRecyclerView;
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> mItemClickListener;
    private WalletRecyclerViewAdapter mAdapter;
    private WalletTransactionHistoryContract.Presenter mPresenter;


    public WalletTransactionHistoryViewModel(Context mContext, WalletRecyclerViewAdapter adapter) {
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
    public void setPresenter(WalletTransactionHistoryContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onItemRecyclerViewClick(Object item) {

    }

    @Override
    public void setOrderWalletList(List<OrderWallet> orderWallets) {
        mVisibilityRecyclerView = orderWallets.size() == 0 ? false : true;
        mAdapter.updateData(orderWallets);
    }

    @Override
    public void onViewAboutReceiveCoinClick() {

    }

    public WalletRecyclerViewAdapter getAdapter() {
        return mAdapter;
    }

    @Bindable
    public boolean isVisibilityRecyclerView() {
        return mVisibilityRecyclerView;
    }
}
