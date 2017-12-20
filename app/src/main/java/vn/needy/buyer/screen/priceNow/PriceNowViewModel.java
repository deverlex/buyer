package vn.needy.buyer.screen.priceNow;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.List;

import vn.needy.buyer.model.Category;
import vn.needy.buyer.model.Store;
import vn.needy.buyer.screen.BaseRecyclerViewAdapter;


/**
 * Created by lion on 16/12/2017.
 */

public class PriceNowViewModel extends BaseObservable implements PriceNowContract.ViewModel,
        BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener{
    private PriceNowContract.Presenter mPresenter;

    private Context mContext;
    private CategoryAdapter mCategoryAdapter;
    private StoreAdapter mStoreAdapter;

    public PriceNowViewModel(Context mContext, CategoryAdapter categoryAdapter, StoreAdapter storeAdapter) {
        this.mContext = mContext;
        mCategoryAdapter = categoryAdapter;
        mCategoryAdapter.setmIteClickListener(this);
        mStoreAdapter = storeAdapter;
        mStoreAdapter.setItemClickListener(this);
    }

    @Override
    public void onStart() {
        mPresenter.getCategories();
        mPresenter.getProductPn();
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

    }

    @Override
    public void setCategories(List<Category> categories) {
        mCategoryAdapter.setData(categories);
    }

    @Override
    public void setProduct(List<Store> stores) {
        mStoreAdapter.setData(stores);
    }
}
