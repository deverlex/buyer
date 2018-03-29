package vn.needy.buyer.screen.priceNow;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.List;

import vn.needy.buyer.model.Category;
import vn.needy.buyer.model.Store;
import vn.needy.buyer.screen.BaseRecyclerViewAdapter;
import vn.needy.buyer.screen.listProduct.priceNow.ListProductPnActivity;
import vn.needy.buyer.utils.navigator.Navigator;


/**
 * Created by lion on 16/12/2017.
 */

public class PriceNowViewModel extends BaseObservable implements PriceNowContract.ViewModel,
        BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener{
    private PriceNowContract.Presenter mPresenter;

    private Context mContext;
    private CategoryAdapter mCategoryAdapter;
    private StoreAdapter mStoreAdapter;
    private Navigator mNavigator;

    public PriceNowViewModel(Context mContext, CategoryAdapter categoryAdapter, StoreAdapter storeAdapter, Navigator navigator) {
        this.mContext = mContext;
        mCategoryAdapter = categoryAdapter;
        mCategoryAdapter.setmIteClickListener(this);
        mStoreAdapter = storeAdapter;
        mStoreAdapter.setItemClickListener(this);
        mNavigator = navigator;
    }

    @Override
    public void onStart() {
        mPresenter.getCategories();
        mPresenter.getStores();
    }

    @Override
    public void onStop() {

    }

    @Override
    public void setPresenter(PriceNowContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Bindable
    public CategoryAdapter getCategoryAdapter() {
        return mCategoryAdapter;
    }

    @Bindable
    public StoreAdapter getStoreAdapter() {
        return mStoreAdapter;
    }

    @Override
    public void onItemRecyclerViewClick(Object item) {
        if (item instanceof Store) {
            mNavigator.startActivity(ListProductPnActivity.class);
        }
    }

    @Override
    public void setCategories(List<Category> categories) {
        mCategoryAdapter.setData(categories);
    }

    @Override
    public void setStores(List<Store> stores) {
        mStoreAdapter.setData(stores);
    }
}
