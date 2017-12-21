package vn.needy.buyer.screen.priceLater;

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
import vn.needy.buyer.databinding.FragmentPriceLaterBinding;
import vn.needy.buyer.model.Category;
import vn.needy.buyer.model.Store;

/**
 * Created by lion on 16/12/2017.
 */

public class PriceLaterFragment extends Fragment{
    public static PriceLaterFragment newInstance() {

        Bundle args = new Bundle();

        PriceLaterFragment fragment = new PriceLaterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private PriceLaterContract.ViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentPriceLaterBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_price_later, container, false);

        List<Category> categories = new ArrayList<>();
        CategoryPlAdapter categoryAdapter = new CategoryPlAdapter(getActivity(), categories);

        List<Store> stores = new ArrayList<>();
        StorePlAdapter storePlAdapter = new StorePlAdapter(getActivity(), stores);

        mViewModel = new PriceLaterViewModel(getActivity(), categoryAdapter, storePlAdapter);
        PriceLaterContract.Presenter presenter = new PriceLaterPresenter(mViewModel);
        mViewModel.setPresenter(presenter);
        mViewModel.onStart();

        binding.setViewModel((PriceLaterViewModel) mViewModel);

        return binding.getRoot();
    }
}
