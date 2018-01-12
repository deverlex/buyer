package vn.needy.buyer.screen.review.buyer;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import vn.needy.buyer.BR;
import vn.needy.buyer.screen.BaseRecyclerViewAdapter;

/**
 * Created by minh_dai on 03/01/2018.
 */

public class ReviewBuyerViewModel extends BaseObservable implements ReviewBuyerContract.ViewModel,
        BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object>{

    private static final String TAG = ReviewBuyerViewModel.class.getName();

    private boolean mHasReview;
    private Context mContext;
    private ReviewBuyerContract.Presenter mPresenter;

    private int mItemFocus;

    public ReviewBuyerViewModel(Context mContext) {
        this.mContext = mContext;
        mHasReview = true;

        mItemFocus = 0;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void setPresenter(ReviewBuyerContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Bindable
    public boolean isHasReview() {
        return mHasReview;
    }

    @Override
    public void onViewReviewByRatingClicked(int item) {
        mItemFocus = item;
        notifyPropertyChanged(BR.itemFocus);
    }

    @Bindable
    public int getItemFocus() {
        return mItemFocus;
    }

    @Override
    public void onItemRecyclerViewClick(Object item) {

    }
}
