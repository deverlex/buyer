package vn.needy.buyer.screen.productFavorite;

import android.app.Activity;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by minh_dai on 09/01/2018.
 */

public class ProductFavoriteViewModel extends BaseObservable implements ProductFavoriteContract.ViewModel {

    private ProductFavoretiAdapter mAdapter;
    private Context mContext;
    private ProductFavoriteContract.Presenter mPresenter;

    public ProductFavoriteViewModel(ProductFavoretiAdapter mAdapter, Context mContext) {
        this.mAdapter = mAdapter;
        this.mContext = mContext;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void setPresenter(ProductFavoriteContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Bindable
    public ProductFavoretiAdapter getAdapter() {
        return mAdapter;
    }

    @Override
    public void onBackPressed(){
        ((Activity) mContext).onBackPressed();
    }
}
