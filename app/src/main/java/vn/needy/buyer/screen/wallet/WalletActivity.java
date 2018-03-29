package vn.needy.buyer.screen.wallet;


import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import vn.needy.buyer.R;
import vn.needy.buyer.databinding.ActivityWalletBinding;
import vn.needy.buyer.domain.OrderWallet;
import vn.needy.buyer.screen.BaseActivity;

/**
 * Created by lion on 16/12/2017.
 */

public class WalletActivity extends BaseActivity{

    private WalletContract.ViewModel mViewModel;
    private WalletContract.Presenter mPresenter;
    private WalletSectionsAdapter mWalletSectionAdapter;
    private WalletRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {

        List<OrderWallet> mList = new ArrayList<>();

        mWalletSectionAdapter = new WalletSectionsAdapter(this , getSupportFragmentManager());
        mViewModel = new WalletViewModel(this , mWalletSectionAdapter);
        mPresenter = new WalletPresenter(mViewModel , this);

        mAdapter = new WalletRecyclerViewAdapter(this , mList);

        mViewModel.setPresenter(mPresenter);
        mViewModel.onStart();

        ActivityWalletBinding binding = DataBindingUtil.setContentView(this , R.layout.activity_wallet);
        binding.setViewModel((WalletViewModel) mViewModel);

    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0)
            getSupportFragmentManager().popBackStack();
        else {
            super.onBackPressed();
        }
    }

}
