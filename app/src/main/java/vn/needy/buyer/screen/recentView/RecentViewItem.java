package vn.needy.buyer.screen.recentView;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import vn.needy.buyer.domain.RecentView;
import vn.needy.buyer.screen.BaseRecyclerViewAdapter;

/**
 * Created by lion on 08/01/2018.
 */

public class RecentViewItem extends BaseObservable{

    private RecentView mRecentView;
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object>
            mItemClickListener;

    public RecentViewItem(RecentView mRecentView, BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> mItemClickListener) {
        this.mRecentView = mRecentView;
        this.mItemClickListener = mItemClickListener;
    }

    @Bindable
    public RecentView getRecentView() {
        return mRecentView;
    }
}
