package vn.needy.buyer.screen.review;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import vn.needy.buyer.R;
import vn.needy.buyer.databinding.ActivityReviewBinding;
import vn.needy.buyer.screen.BaseActivity;

/**
 * Created by lion on 16/12/2017.
 */

public class ReviewActivity extends BaseActivity {

    private ReviewSectionAdapter mSectionAdapter;
    private ReviewContract.Presenter mPresenter;
    private ReviewContract.ViewModel mViewModel;
    private ReviewRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {

        mSectionAdapter = new ReviewSectionAdapter(this , getSupportFragmentManager());

        mViewModel = new ReviewViewModel(this , mSectionAdapter);
        mPresenter = new ReviewPresenter(this , mViewModel);

        mViewModel.setPresenter(mPresenter);
        mViewModel.onStart();

        ActivityReviewBinding binding = DataBindingUtil.setContentView(this , R.layout.activity_review);

        binding.setViewModel((ReviewViewModel) mViewModel);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0)
            getSupportFragmentManager().popBackStack();
        else {
            super.onBackPressed();
        }
    }

}
