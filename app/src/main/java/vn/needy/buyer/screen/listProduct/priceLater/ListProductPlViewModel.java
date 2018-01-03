package vn.needy.buyer.screen.listProduct.priceLater;

import android.app.Activity;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.List;

import vn.needy.buyer.port.wrapper.ProductPlWrapper;

/**
 * Created by truongpq on 03/01/2018.
 */

public class ListProductPlViewModel extends BaseObservable implements ListProductPlContract.ViewModel {
    private Context mContext;
    private ListProductPlContract.Presenter mPresenter;

    private ProductPlAdapter mProductPlAdapter;

    public ListProductPlViewModel(Context context, ProductPlAdapter productPlAdapter) {
        this.mContext = context;
        mProductPlAdapter = productPlAdapter;
    }

    @Override
    public void onStart() {
        mPresenter.getProductsOfStore(null);
    }

    @Override
    public void onStop() {

    }

    @Override
    public void setPresenter(ListProductPlContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onBackPressed() {
        ((Activity)mContext).onBackPressed();
    }

    @Override
    public void updateProducts(List<ProductPlWrapper> productPlWrappers) {
        mProductPlAdapter.setData(productPlWrappers);
    }

    @Bindable
    public ProductPlAdapter getProductPlAdapter() {
        return mProductPlAdapter;
    }
}
