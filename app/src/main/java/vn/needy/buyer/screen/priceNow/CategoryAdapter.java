package vn.needy.buyer.screen.priceNow;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import vn.needy.buyer.R;
import vn.needy.buyer.databinding.ItemCategoryBinding;
import vn.needy.buyer.model.Category;
import vn.needy.buyer.screen.BaseRecyclerViewAdapter;

/**
 * Created by truongpq on 20/12/2017.
 */

public class CategoryAdapter extends BaseRecyclerViewAdapter<CategoryAdapter.ItemViewHolder>{
    private List<Category> mCategories;
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> mItemClickListener;

    protected CategoryAdapter(@NonNull Context context, List<Category> categories) {
        super(context);
        mCategories = categories;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemCategoryBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_category, parent, false);
        return new CategoryAdapter.ItemViewHolder(binding, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.bind(mCategories.get(position));
    }

    @Override
    public int getItemCount() {
        return mCategories.size();
    }

    public void setmIteClickListener(OnRecyclerViewItemClickListener<Object> itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    public void setData(List<Category> categories) {
        mCategories.clear();;
        mCategories.addAll(categories);
        notifyDataSetChanged();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        private final ItemCategoryBinding mBinding;
        private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> mItemClickListener;

        public ItemViewHolder(ItemCategoryBinding binding, OnRecyclerViewItemClickListener<Object> itemClickListener) {
            super(binding.getRoot());
            this.mBinding = binding;
            this.mItemClickListener = itemClickListener;
        }

        void bind(Category category) {
            mBinding.setViewModel(new ItemCategoryViewModel(category, mItemClickListener));
            mBinding.executePendingBindings();
        }
    }
}
