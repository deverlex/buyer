package vn.needy.buyer.screen.recentView;

import android.app.Activity;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingBuildInfo;

import java.util.List;

import vn.needy.buyer.domain.RecentView;
import vn.needy.buyer.screen.BaseRecyclerViewAdapter;

/**
 * Created by lion on 08/01/2018.
 */

public class RecentViewViewModel extends BaseObservable implements RecentViewContract.ViewModel,
        BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> {

    private RecentViewAdapter mAdapter;
    private RecentViewContract.Prsenter mPrsenter;
    private Context mContext;

    public RecentViewViewModel(RecentViewAdapter mAdapter, Context mContext) {
        this.mAdapter = mAdapter;
        this.mContext = mContext;

        mAdapter.setItemClickListener(this);
    }

    @Override
    public void onStart() {
        mPrsenter.getListRecentView();
    }

    @Override
    public void onStop() {

    }

    @Override
    public void setPresenter(RecentViewContract.Prsenter presenter) {
        mPrsenter = presenter;
    }

    @Override
    public void onBackPressed() {
        ((Activity) mContext).onBackPressed();
    }

    @Override
    public void setListRecentView(List<RecentView> list) {
       mAdapter.updateData(list);
    }

    @Bindable
    public RecentViewAdapter getAdapter() {
        return mAdapter;
    }

    @Override
    public void onItemRecyclerViewClick(Object item) {
        int position = mAdapter.getPosition((RecentView) item);
        mAdapter.setPosition(position);
    }
}
