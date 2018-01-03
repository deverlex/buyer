package vn.needy.buyer.screen.wallet;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import vn.needy.buyer.R;

/**
 * Created by lion on 16/12/2017.
 */

public class WalletPresenter implements WalletContract.Presenter{

    private List<WalletActivity.Product> mList;
    private WalletContract.ViewModel mViewModel;
    private Context mContext;

    public WalletPresenter(WalletContract.ViewModel mViewModel, Context mContext) {
        this.mViewModel = mViewModel;
        this.mContext = mContext;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void loadWalletList() {

    }
}
