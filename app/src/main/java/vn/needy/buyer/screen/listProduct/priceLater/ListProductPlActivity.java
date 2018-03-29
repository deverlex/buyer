package vn.needy.buyer.screen.listProduct.priceLater;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import vn.needy.buyer.R;
import vn.needy.buyer.databinding.ActivityListProductPlBinding;
import vn.needy.buyer.repository.remote.product.context.ProductPlContext;
import vn.needy.buyer.screen.BaseActivity;

/**
 * Created by truongpq on 03/01/2018.
 */

public class ListProductPlActivity extends BaseActivity {

    private ListProductPlContract.ViewModel mViewModel;

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        super.onCreateActivity(savedInstanceState);

        List<ProductPlContext> productPlContexts = new ArrayList<>();
        ProductPlAdapter productPlAdapter = new ProductPlAdapter(this, productPlContexts);

        mViewModel = new ListProductPlViewModel(this, productPlAdapter);
        ListProductPlContract.Presenter presenter = new ListProductPlPresenter(mViewModel);
        mViewModel.setPresenter(presenter);
        ActivityListProductPlBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_list_product_pl);
        mViewModel.onStart();
        binding.setViewModel((ListProductPlViewModel) mViewModel);
    }
}
