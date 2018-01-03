package vn.needy.buyer.screen.priceLater;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import vn.needy.buyer.R;
import vn.needy.buyer.databinding.ItemStorePlBinding;
import vn.needy.buyer.model.Store;
import vn.needy.buyer.screen.BaseRecyclerViewAdapter;

/**
 * Created by truongpq on 20/12/2017.
 */

public class StorePlAdapter extends BaseRecyclerViewAdapter<StorePlAdapter.ItemViewHolder>{

    private OnRecyclerViewItemClickListener<Object> mItemClickListener;
    private List<Store> mStores;

    protected StorePlAdapter(@NonNull Context context, List<Store> stores) {
        super(context);
        mStores = stores;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemStorePlBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_store_pl, parent, false);
        return new StorePlAdapter.ItemViewHolder(binding, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.bind(mStores.get(position));
    }

    @Override
    public int getItemCount() {
        return mStores.size();
    }

    public void setItemClickListener(OnRecyclerViewItemClickListener<Object> itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    public void setData(List<Store> stores) {
        mStores.clear();
        mStores.addAll(stores);
        notifyDataSetChanged();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        private final ItemStorePlBinding mBinding;
        private OnRecyclerViewItemClickListener<Object> mItemClickListener;

        public ItemViewHolder(ItemStorePlBinding binding, OnRecyclerViewItemClickListener<Object> itemClickListener) {
            super(binding.getRoot());
            this.mBinding = binding;
            this.mItemClickListener = itemClickListener;
        }

        void bind(Store store) {
            mBinding.setViewModel(new ItemStorePlViewModel(store, mItemClickListener));
            mBinding.executePendingBindings();
        }
    }
}
