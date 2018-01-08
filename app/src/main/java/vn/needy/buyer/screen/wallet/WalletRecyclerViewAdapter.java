package vn.needy.buyer.screen.wallet;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import vn.needy.buyer.R;
import vn.needy.buyer.databinding.ItemWalletTransactionBinding;
import vn.needy.buyer.screen.BaseRecyclerViewAdapter;

/**
 * Created by minh_dai on 02/01/2018.
 */

public class WalletRecyclerViewAdapter extends BaseRecyclerViewAdapter<WalletRecyclerViewAdapter.ItemViewHolder> {

    private List<WalletActivity.Cargo> mList;
    private Context mContext;
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> mItemClickListener;

    public WalletRecyclerViewAdapter(@NonNull Context context, List<WalletActivity.Cargo> mList) {
        super(context);
        this.mList = mList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemWalletTransactionBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
                , R.layout.item_wallet_transaction, parent, false);

        return new WalletRecyclerViewAdapter.ItemViewHolder(binding , mItemClickListener);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.bind(mList.get(position));
    }

    public void setItemClickListener(OnRecyclerViewItemClickListener<Object> itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public void updateData(List<WalletActivity.Cargo> list) {
        if (list == null) {
            return;
        }
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }

    public int getPosition(WalletActivity.Cargo list){
        return mList.indexOf(list);
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object>
                mItemClickListener;
        private ItemWalletTransactionBinding mBinding;


        public ItemViewHolder(ItemWalletTransactionBinding binding, BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> itemClickListener) {
            super(binding.getRoot());
            this.mBinding = binding;
            this.mItemClickListener = itemClickListener;
        }

        void bind(WalletActivity.Cargo cargo) {
            mBinding.setViewModel(new ItemWalletRecyclerView(cargo, mItemClickListener));
            mBinding.executePendingBindings();
        }

    }
}
