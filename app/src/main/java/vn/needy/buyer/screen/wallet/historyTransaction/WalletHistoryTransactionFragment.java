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
import vn.needy.buyer.databinding.FragmentWalletHistoryTransactionBinding;
import vn.needy.buyer.screen.wallet.WalletActivity;
import vn.needy.buyer.screen.wallet.WalletRecyclerViewAdapter;

/**
 * Created by lion on 02/01/2018.
 */

public class WalletHistoryTransactionFragment extends Fragment {


    public static WalletHistoryTransactionFragment getInstance()
    {
        return new WalletHistoryTransactionFragment();
    }

    private WalletHistoryTransactionContract.ViewModel mViewModel;
    private WalletHistoryTransactionContract.Presenter mPresenter;
    private WalletRecyclerViewAdapter mAdapter;
    private List<WalletActivity.Cargo> mList;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mList = new ArrayList<>();
        mAdapter = new WalletRecyclerViewAdapter(getActivity() , mList);
        mViewModel = new WalletHistoryTransactionViewModel(getActivity() , mAdapter);

        mPresenter = new WalletHistoryTransactionPresenter(getActivity() , mViewModel);

        mViewModel.setPresenter(mPresenter);
        mViewModel.onStart();

        FragmentWalletHistoryTransactionBinding binding = DataBindingUtil.inflate(inflater , R.layout.fragment_wallet_history_transaction
                , container , false);
        binding.setViewModel((WalletHistoryTransactionViewModel) mViewModel);

        return binding.getRoot();
    }
}
