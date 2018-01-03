package vn.needy.buyer.screen.wallet;

import android.app.Activity;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;

import vn.needy.buyer.screen.BaseRecyclerViewAdapter;

/**
 * Created by lion on 16/12/2017.
 */

public class WalletViewModel extends BaseObservable implements WalletContract.ViewModel {

    private WalletActivity.Product mListProduct;
    private WalletContract.Presenter mPresenter;
    private WalletSectionsAdapter mWalletSectionsAdapter;
    private String mCoin;
    private Context mContext;


    public WalletViewModel(Context mContext, WalletSectionsAdapter walletSectionAdapter) {
        this.mContext = mContext;
        this.mWalletSectionsAdapter = walletSectionAdapter;
        mCoin = "0";
    }

    public WalletViewModel() {
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void setPresenter(WalletContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onBackPressed() {
        ((Activity) mContext).onBackPressed();
    }

    @Override
    public void onPersonalEarnedCoinClick() {

    }

    @Override
    public void getProductList(WalletActivity.Product product) {
        mListProduct = product;
    }

    @Bindable
    public WalletSectionsAdapter getWalletSectionsAdapter() {
        return mWalletSectionsAdapter;
    }

    @Bindable
    public String getCoin() {
        return mCoin;
    }


}
