package vn.needy.buyer.screen.listProduct.priceNow;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import vn.needy.buyer.R;
import vn.needy.buyer.databinding.ItemProductPnBinding;
import vn.needy.buyer.port.wrapper.ProductPnWrapper;
import vn.needy.buyer.screen.BaseRecyclerViewAdapter;

/**
 * Created by truongpq on 03/01/2018.
 */

public class ProductPnAdapter extends BaseRecyclerViewAdapter<ProductPnAdapter.ItemViewHolder>{

    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> mItemClickListener;
    private List<ProductPnWrapper> mProductPns;

    protected ProductPnAdapter(@NonNull Context context, List<ProductPnWrapper> productPns) {
        super(context);
        this.mProductPns = productPns;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemProductPnBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_product_pn, parent, false);
        return new ItemViewHolder(binding, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.bind(mProductPns.get(position));
    }

    @Override
    public int getItemCount() {
        return mProductPns.size();
    }

    public void setmItemClickListener(OnRecyclerViewItemClickListener<Object> itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    public void setData(List<ProductPnWrapper> productPnWrappers) {
        mProductPns.clear();
        mProductPns.addAll(productPnWrappers);
        notifyDataSetChanged();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        private final ItemProductPnBinding mBinding;
        private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> mItemClickListener;

        public ItemViewHolder(ItemProductPnBinding binding, BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> itemClickListener) {
            super(binding.getRoot());
            this.mBinding = binding;
            this.mItemClickListener = itemClickListener;
        }

        void bind(ProductPnWrapper productPnWrapper) {
            mBinding.setViewModel(new ItemProductPnViewModel(productPnWrapper, mItemClickListener));
            mBinding.executePendingBindings();
        }
    }
}
