package vn.needy.buyer.screen.review.vendor;

import android.app.Activity;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;
import android.widget.Toast;

import vn.needy.buyer.BR;
import vn.needy.buyer.R;
import vn.needy.buyer.screen.BaseRecyclerViewAdapter;
import vn.needy.buyer.screen.replyReview.ReplyReviewActivity;
import vn.needy.buyer.utils.navigator.Navigator;

/**
 * Created by minh_dai on 03/01/2018.
 */

public class ReviewVendorViewModel extends BaseObservable implements ReviewVendorContract.ViewModel,
        BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object>{

    private Navigator mNavigator;
    private Context mContext;
    private ReviewVendorContract.Presenter mPresenter;

    private boolean hasReview;

    private int mItemFocus;


    public ReviewVendorViewModel(Context mContext , Navigator navigator) {
        this.mContext = mContext;
        this.mNavigator = navigator;

        mItemFocus = 0;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void setPresenter(ReviewVendorContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Bindable
    public boolean isHasReview() {
        return hasReview;
    }

    @Override
    public void onViewReviewByRatingClicked(int item) {
        mItemFocus = item;
        notifyPropertyChanged(BR.itemFocus);
    }

    @Override
    public void onVendorCommentClick() {

        mNavigator.startActivity(ReplyReviewActivity.class);
    }

    @Override
    public void onItemRecyclerViewClick(Object item) {

    }

    @Bindable
    public int getItemFocus() {
        return mItemFocus;
    }
}

