package vn.needy.buyer.screen.listProduct.priceLater;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import vn.needy.buyer.R;
import vn.needy.buyer.databinding.ItemProductPlBinding;
import vn.needy.buyer.repository.remote.product.context.ProductPlContext;
import vn.needy.buyer.screen.BaseRecyclerViewAdapter;

/**
 * Created by truongpq on 03/01/2018.
 */

public class ProductPlAdapter extends BaseRecyclerViewAdapter<ProductPlAdapter.ItemViewHolder>{

    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> mItemClickListener;
    private List<ProductPlContext> mProductPl;

    protected ProductPlAdapter(@NonNull Context context, List<ProductPlContext> productPlContexts) {
        super(context);
        this.mProductPl = productPlContexts;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemProductPlBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_product_pl, parent, false);
        return new ItemViewHolder(binding, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.bind(mProductPl.get(position));
    }

    @Override
    public int getItemCount() {
        return mProductPl.size();
    }

    public void setItemClickListener(OnRecyclerViewItemClickListener<Object> itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    public void setData(List<ProductPlContext> productPlWrappers) {
        mProductPl.clear();
        mProductPl.addAll(productPlWrappers);
        notifyDataSetChanged();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        private final ItemProductPlBinding mBinding;
        private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> mItemClickListener;

        public ItemViewHolder(ItemProductPlBinding binding, BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> itemClickListener) {
            super(binding.getRoot());
            this.mBinding = binding;
            this.mItemClickListener = itemClickListener;
        }

        void bind(ProductPlContext productPlWrapper) {
            mBinding.setViewModel(new ItemProductPlViewModel(productPlWrapper, mItemClickListener));
            mBinding.executePendingBindings();
        }
    }
}
