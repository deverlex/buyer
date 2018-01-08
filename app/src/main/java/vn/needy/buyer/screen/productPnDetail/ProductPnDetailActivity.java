package vn.needy.buyer.screen.productPnDetail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import vn.needy.buyer.R;
import vn.needy.buyer.databinding.ActivityProductPnDetailBinding;
import vn.needy.buyer.screen.BaseActivity;

/**
 * Created by lion on 16/12/2017.
 */

public class ProductPnDetailActivity extends BaseActivity {

    private ProductPnDetailContract.ViewModel mViewModel;

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        super.onCreateActivity(savedInstanceState);
        mViewModel = new ProductPnDetailViewModel(this);
        ProductPnDetailContract.Presenter presenter = new ProductPnDetailPresenter(mViewModel);
        mViewModel.setPresenter(presenter);
        ActivityProductPnDetailBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_product_pn_detail);
        mViewModel.onStart();
        binding.setViewModel((ProductPnDetailViewModel) mViewModel);
    }
}
