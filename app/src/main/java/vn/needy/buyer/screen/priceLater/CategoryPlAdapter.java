package vn.needy.buyer.screen.priceLater;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import vn.needy.buyer.R;
import vn.needy.buyer.databinding.ItemCategoryPlBinding;
import vn.needy.buyer.model.Category;
import vn.needy.buyer.screen.BaseRecyclerViewAdapter;

/**
 * Created by truongpq on 20/12/2017.
 */

public class CategoryPlAdapter extends BaseRecyclerViewAdapter<CategoryPlAdapter.ItemViewHolder>{
    private List<Category> mCategories;
    private OnRecyclerViewItemClickListener<Object> mItemClickListener;

    protected CategoryPlAdapter(@NonNull Context context, List<Category> categories) {
        super(context);
        mCategories = categories;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemCategoryPlBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_category_pl, parent, false);
        return new CategoryPlAdapter.ItemViewHolder(binding, mItemClickListener);
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

        private final ItemCategoryPlBinding mBinding;
        private OnRecyclerViewItemClickListener<Object> mItemClickListener;

        public ItemViewHolder(ItemCategoryPlBinding binding, OnRecyclerViewItemClickListener<Object> itemClickListener) {
            super(binding.getRoot());
            this.mBinding = binding;
            this.mItemClickListener = itemClickListener;
        }

        void bind(Category category) {
            mBinding.setViewModel(new ItemCategoryPlViewModel(category, mItemClickListener));
            mBinding.executePendingBindings();
        }
    }
}
