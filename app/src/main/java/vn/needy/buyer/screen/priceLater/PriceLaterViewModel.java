package vn.needy.buyer.screen.priceLater;

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

public class PriceLaterViewModel extends BaseObservable implements PriceLaterContract.ViewModel,
        BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener{

    private PriceLaterContract.Presenter mPresenter;

    private Context mContext;
    private CategoryPlAdapter mCategoryPlAdapter;
    private StorePlAdapter mStorePlAdapter;

    public PriceLaterViewModel(Context mContext, CategoryPlAdapter mCategoryPlAdapter, StorePlAdapter storePlAdapter) {
        this.mContext = mContext;
        this.mCategoryPlAdapter = mCategoryPlAdapter;
        mCategoryPlAdapter.setmIteClickListener(this);
        mStorePlAdapter = storePlAdapter;
        mStorePlAdapter.setItemClickListener(this);
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
    public void setPresenter(PriceLaterContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Bindable
    public CategoryPlAdapter getCategoryPlAdapter() {
        return mCategoryPlAdapter;
    }

    @Bindable
    public StorePlAdapter getStorePlAdapter() {
        return mStorePlAdapter;
    }

    @Override
    public void setCategories(List<Category> categories) {
        mCategoryPlAdapter.setData(categories);
    }

    @Override
    public void setStores(List<Store> stores) {
        mStorePlAdapter.setData(stores);
    }

    @Override
    public void onItemRecyclerViewClick(Object item) {

    }
}
