package vn.needy.buyer.screen.replyReview;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import vn.needy.buyer.R;
import vn.needy.buyer.databinding.ActivityReplyReviewBinding;
import vn.needy.buyer.screen.BaseActivity;

/**
 * Created by minh_dai on 04/01/2018.
 */

public class ReplyReviewActivity extends BaseActivity {

    public static ReplyReviewActivity getInstance(){
        return new ReplyReviewActivity();
    }

    private ReplyReviewContract.Presenter mPresenter;
    private ReplyReviewContract.ViewModel mViewModel;


    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        mViewModel = new ReplyReviewViewModel(this);
        mPresenter = new ReplyReviewPresenter();

        mViewModel.setPresenter(mPresenter);
        mViewModel.onStart();

        ActivityReplyReviewBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_reply_review);
        binding.setViewModel((ReplyReviewViewModel) mViewModel);
    }
}
