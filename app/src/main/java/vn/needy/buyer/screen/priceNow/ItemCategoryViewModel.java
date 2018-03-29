package vn.needy.buyer.screen.priceNow;

import android.databinding.BaseObservable;

import vn.needy.buyer.model.Category;
import vn.needy.buyer.screen.BaseRecyclerViewAdapter;

/**
 * Created by truongpq on 20/12/2017.
 */

public class ItemCategoryViewModel extends BaseObservable{

    private Category mCategory;
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> mItemClickListener;

    public ItemCategoryViewModel(Category mCategory, BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> mItemClickListener) {
        this.mCategory = mCategory;
        this.mItemClickListener = mItemClickListener;
    }

    public String getTitle() {
        return mCategory.getTitle();
    }

    public void onItemClick() {
        if (mItemClickListener != null) {
            mItemClickListener.onItemRecyclerViewClick(mCategory);
        }
    }
}
