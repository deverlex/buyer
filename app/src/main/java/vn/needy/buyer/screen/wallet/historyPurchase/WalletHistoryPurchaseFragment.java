package vn.needy.buyer.screen.wallet.historyPurchase;

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
import vn.needy.buyer.databinding.FragmentWalletHistoryPurchaseBinding;
import vn.needy.buyer.screen.wallet.WalletActivity;
import vn.needy.buyer.screen.wallet.WalletRecyclerViewAdapter;
import vn.needy.buyer.screen.wallet.historyIncome.WalletHistoryIncomeViewModel;

/**
 * Created by lion on 02/01/2018.
 */

public class WalletHistoryPurchaseFragment extends Fragment {


    public static WalletHistoryPurchaseFragment getInstance()
    {
        return new WalletHistoryPurchaseFragment();
    }
    private WalletHistoryPurchaseContract.ViewModel mViewModel;
    private WalletHistoryPurchaseContract.Presenter mPresenter;
    private WalletRecyclerViewAdapter mAdapter;
    private List<WalletActivity.Product> mList;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mList = new ArrayList<>();

        mAdapter = new WalletRecyclerViewAdapter(getActivity() , mList);
        mViewModel = new WalletHistoryPurchaseViewModel(getActivity() , mAdapter);

        mPresenter = new WalletHistoryPruchasePresenter(getActivity() , mViewModel);

        mViewModel.setPresenter(mPresenter);
        mViewModel.onStart();;


        FragmentWalletHistoryPurchaseBinding binding = DataBindingUtil.inflate(inflater , R.layout.fragment_wallet_history_purchase , container , false);
        binding.setViewModel((WalletHistoryPurchaseViewModel) mViewModel);

        return binding.getRoot();
    }
}
