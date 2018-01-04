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
import vn.needy.buyer.databinding.FragmentWalletHistoryIncomeBinding;
import vn.needy.buyer.screen.wallet.WalletActivity;
import vn.needy.buyer.screen.wallet.WalletRecyclerViewAdapter;

/**
 * Created by lion on 02/01/2018.
 */

public class WalletHistoryIncomeFragment extends Fragment {

    public static WalletHistoryIncomeFragment getInstance()
    {
        return new WalletHistoryIncomeFragment();
    }

    private WalletHistoryIncomeContract.Presenter mPresenter;
    private WalletHistoryIncomeContract.ViewModel mViewModel;
    private WalletRecyclerViewAdapter mAdapter;
    private List<WalletActivity.Cargo> mList;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentWalletHistoryIncomeBinding binding = DataBindingUtil.inflate(inflater , R.layout.fragment_wallet_history_income , container , false);

        mList = new ArrayList<>();
        mAdapter = new WalletRecyclerViewAdapter(getActivity() , mList);
        mViewModel = new WalletHistoryIncomeViewModel(getActivity() , mAdapter);
        mPresenter = new WalletHistoryIncomePresenter(getActivity() , mViewModel);

        mViewModel.setPresenter(mPresenter);
        mViewModel.onStart();


        binding.setViewModel((WalletHistoryIncomeViewModel) mViewModel);
        return binding.getRoot();
    }
}
