package vn.needy.buyer.screen.listProduct.priceNow;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import vn.needy.buyer.R;
import vn.needy.buyer.databinding.ActivityListProductPnBinding;
import vn.needy.buyer.port.wrapper.ProductPnWrapper;
import vn.needy.buyer.screen.BaseActivity;

/**
 * Created by truongpq on 03/01/2018.
 */

public class ListProductPnActivity extends BaseActivity {

    private ListProductPnContract.ViewModel mViewModel;

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        super.onCreateActivity(savedInstanceState);

        List<ProductPnWrapper> productPnWrappers = new ArrayList<>();
        ProductPnAdapter productPnAdapter = new ProductPnAdapter(this, productPnWrappers);

        mViewModel = new ListProductPnViewModel(this, productPnAdapter);
        ListProductPnContract.Presenter presenter = new ListProductPnPresenter(mViewModel);
        mViewModel.setPresenter(presenter);
        ActivityListProductPnBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_list_product_pn);
        mViewModel.onStart();
        binding.setViewModel((ListProductPnViewModel) mViewModel);
    }
}
