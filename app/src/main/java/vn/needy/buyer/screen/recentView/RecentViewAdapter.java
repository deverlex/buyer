package vn.needy.buyer.screen.recentView;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import vn.needy.buyer.R;
import vn.needy.buyer.databinding.ItemRecentViewBinding;
import vn.needy.buyer.domain.RecentView;
import vn.needy.buyer.screen.BaseRecyclerViewAdapter;

/**
 * Created by lion on 08/01/2018.
 */

public class RecentViewAdapter  extends BaseRecyclerViewAdapter<RecentViewAdapter.ItemViewHolder>{

    private int mPosition = -1;
    private List<RecentView> mList;
    private Context mContext;
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> mItemClickListener;


    public RecentViewAdapter(@NonNull Context context, List<RecentView> mList) {
        super(context);
        this.mList = mList;
        this.mContext = context;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemRecentViewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext) , R.layout.item_recent_view
                , parent ,false);

        return new RecentViewAdapter.ItemViewHolder(binding , mItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecentViewAdapter.ItemViewHolder holder, int position) {
        holder.bind(mList.get(position));
    }

    public void setItemClickListener(OnRecyclerViewItemClickListener<Object> itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public void updateData(List<RecentView> list) {
        if (list == null) {
            return;
        }
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }

    public int getPosition(RecentView recentView){
        return mList.indexOf(recentView);
    }

    public void setPosition(int position){
        this.mPosition = position;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object>
                mItemClickListener;
        private ItemRecentViewBinding mBinding;

        public ItemViewHolder(ItemRecentViewBinding binding , BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> itemClickListener) {
            super(binding.getRoot());
            mBinding = binding;
            mItemClickListener = itemClickListener;
        }

        void bind(RecentView recentView ) {
            mBinding.setViewModel(new RecentViewItem(recentView , mItemClickListener));
            mBinding.executePendingBindings();
        }
    }
}
