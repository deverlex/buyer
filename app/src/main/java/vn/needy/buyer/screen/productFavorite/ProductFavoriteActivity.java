package vn.needy.buyer.screen.productFavorite;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import vn.needy.buyer.R;
import vn.needy.buyer.databinding.ActivityProductFavoriteBinding;
import vn.needy.buyer.screen.BaseActivity;

/**
 * Created by minh_dai on 09/01/2018.
 */

public class ProductFavoriteActivity extends BaseActivity{

    private ProductFavoriteContract.Presenter mPresenter;
    private ProductFavoriteContract.ViewModel mViewModel;
    private ProductFavoretiAdapter mAdapter;

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {

        mAdapter = new ProductFavoretiAdapter(this);

        mViewModel = new ProductFavoriteViewModel(mAdapter , this);
        mPresenter = new ProductFavoritePresenter();

        mViewModel.setPresenter(mPresenter);
        mViewModel.onStart();

        ActivityProductFavoriteBinding binding = DataBindingUtil.setContentView(this , R.layout.activity_product_favorite);
        binding.setViewModel( (ProductFavoriteViewModel) mViewModel);
    }
}
