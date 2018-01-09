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
import vn.needy.buyer.domain.OrderWallet;
import vn.needy.buyer.screen.wallet.WalletRecyclerViewAdapter;

/**
 * Created by lion on 02/01/2018.
 */

public class WalletPurchaseHistoryFragment extends Fragment {


    public static WalletPurchaseHistoryFragment getInstance()
    {
        return new WalletPurchaseHistoryFragment();
    }

    private WalletPurchaseHistoryContract.ViewModel mViewModel;
    private WalletPurchaseHistoryContract.Presenter mPresenter;
    private WalletRecyclerViewAdapter mAdapter;
    private List<OrderWallet> mList;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mList = new ArrayList<>();

        mAdapter = new WalletRecyclerViewAdapter(getActivity() , mList);
        mViewModel = new WalletPurchaseHistoryViewModel(getActivity() , mAdapter);

        mPresenter = new WalletPruchaseHistoryPresenter(getActivity() , mViewModel);

        mViewModel.setPresenter(mPresenter);
        mViewModel.onStart();;


        FragmentWalletHistoryPurchaseBinding binding = DataBindingUtil.inflate(inflater , R.layout.fragment_wallet_history_purchase
                , container , false);
        binding.setViewModel((WalletPurchaseHistoryViewModel) mViewModel);

        return binding.getRoot();
    }
}
