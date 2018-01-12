package vn.needy.buyer.screen.wallet.historyIncome;

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
import vn.needy.buyer.databinding.FragmentWalletIncomeHistoryBinding;
import vn.needy.buyer.domain.OrderWallet;
import vn.needy.buyer.screen.wallet.WalletRecyclerViewAdapter;

/**
 * Created by lion on 02/01/2018.
 */

public class WalletIncomeHistoryFragment extends Fragment {

    public static WalletIncomeHistoryFragment getInstance() {
        return new WalletIncomeHistoryFragment();
    }

    private WalletIncomeHistoryContract.Presenter mPresenter;
    private WalletIncomeHistoryContract.ViewModel mViewModel;
    private WalletRecyclerViewAdapter mAdapter;
    private List<OrderWallet> mOrderWallets;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentWalletIncomeHistoryBinding binding = DataBindingUtil.inflate(inflater , R.layout.fragment_wallet_income_history
                , container , false);

        mOrderWallets = new ArrayList<>();
        mAdapter = new WalletRecyclerViewAdapter(getActivity() , mOrderWallets);
        mViewModel = new WalletIncomeHistoryViewModel(getActivity() , mAdapter);
        mPresenter = new WalletIncomeHistoryPresenter(getActivity() , mViewModel);

        mViewModel.setPresenter(mPresenter);
        mViewModel.onStart();


        binding.setViewModel((WalletIncomeHistoryViewModel) mViewModel);
        return binding.getRoot();
    }
}
