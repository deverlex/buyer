package vn.needy.buyer.screen.wallet.historyTransaction;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import vn.needy.buyer.R;
import vn.needy.buyer.databinding.FragmentWalletTransactionHistoryBinding;
import vn.needy.buyer.domain.OrderWallet;
import vn.needy.buyer.screen.wallet.WalletRecyclerViewAdapter;

/**
 * Created by lion on 02/01/2018.
 */

public class WalletTransactionHistoryFragment extends Fragment {


    public static WalletTransactionHistoryFragment getInstance() {
        return new WalletTransactionHistoryFragment();
    }

    private WalletTransactionHistoryContract.ViewModel mViewModel;
    private WalletTransactionHistoryContract.Presenter mPresenter;
    private WalletRecyclerViewAdapter mAdapter;
    private List<OrderWallet> mOrderWallets;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mOrderWallets = new ArrayList<>();
        mAdapter = new WalletRecyclerViewAdapter(getActivity() , mOrderWallets);
        mViewModel = new WalletTransactionHistoryViewModel(getActivity() , mAdapter);

        mPresenter = new WalletTransactionHistoryPresenter(getActivity() , mViewModel);

        mViewModel.setPresenter(mPresenter);
        mViewModel.onStart();

        FragmentWalletTransactionHistoryBinding binding = DataBindingUtil.inflate(inflater , R.layout.fragment_wallet_transaction_history
                , container , false);
        binding.setViewModel((WalletTransactionHistoryViewModel) mViewModel);

        return binding.getRoot();
    }
}
