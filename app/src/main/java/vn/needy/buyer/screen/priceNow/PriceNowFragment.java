package vn.needy.buyer.screen.priceNow;

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
import vn.needy.buyer.databinding.FragmentPriceNowBinding;
import vn.needy.buyer.model.Category;
import vn.needy.buyer.model.Store;
import vn.needy.buyer.utils.navigator.Navigator;

/**
 * Created by lion on 16/12/2017.
 */

public class PriceNowFragment extends Fragment{
    public static PriceNowFragment newInstance() {

        Bundle args = new Bundle();

        PriceNowFragment fragment = new PriceNowFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private PriceNowContract.ViewModel mViewModel;
    private Navigator mNavigator;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentPriceNowBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_price_now, container, false);

        mNavigator = new Navigator(this);

        List<Category> categories = new ArrayList<>();
        CategoryAdapter categoryAdapter = new CategoryAdapter(getActivity(), categories);

        List<Store> stores = new ArrayList<>();
        StoreAdapter storeAdapter = new StoreAdapter(getActivity(), stores);

        mViewModel = new PriceNowViewModel(getActivity(), categoryAdapter, storeAdapter, mNavigator);
        PriceNowContract.Presenter presenter = new PriceNowPresenter(mViewModel);
        mViewModel.setPresenter(presenter);
        mViewModel.onStart();

        binding.setViewModel((PriceNowViewModel) mViewModel);

        return binding.getRoot();
    }
}
