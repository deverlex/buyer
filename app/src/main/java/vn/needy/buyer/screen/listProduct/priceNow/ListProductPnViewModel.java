package vn.needy.buyer.screen.listProduct.priceNow;

import android.app.Activity;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.List;

import vn.needy.buyer.port.wrapper.ProductPnWrapper;
import vn.needy.buyer.screen.BaseRecyclerViewAdapter;
import vn.needy.buyer.screen.productPnDetail.ProductPnDetailActivity;
import vn.needy.buyer.utils.navigator.Navigator;

/**
 * Created by truongpq on 03/01/2018.
 */

public class ListProductPnViewModel extends BaseObservable implements ListProductPnContract.ViewModel,
        BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener {

    private ListProductPnContract.Presenter mPresenter;
    private Context mContext;

    private ProductPnAdapter mProductPnAdapter;
    private Navigator mNavigator;

    public ListProductPnViewModel(Context context, Navigator navigator, ProductPnAdapter productPnAdapter) {
        mContext = context;
        mProductPnAdapter = productPnAdapter;
        mProductPnAdapter.setmItemClickListener(this);
        mNavigator = navigator;
    }

    @Override
    public void onStart() {
        mPresenter.getProductsOfStore(null);
    }

    @Override
    public void onStop() {

    }

    @Override
    public void setPresenter(ListProductPnContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onBackPressed() {
        ((Activity) mContext).onBackPressed();
    }

    @Override
    public void updateProducts(List<ProductPnWrapper> productPnWrappers) {
        mProductPnAdapter.setData(productPnWrappers);
    }

    @Bindable
    public ProductPnAdapter getProductPnAdapter() {
        return mProductPnAdapter;
    }

    @Override
    public void onItemRecyclerViewClick(Object item) {
        if (item instanceof ProductPnWrapper) {
            // show product pn detail
            mNavigator.startActivity(ProductPnDetailActivity.class);
        }
    }
}
