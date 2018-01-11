package vn.needy.buyer.screen.recentView;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import vn.needy.buyer.R;
import vn.needy.buyer.databinding.ActivityRecentViewBinding;
import vn.needy.buyer.domain.RecentView;
import vn.needy.buyer.screen.BaseActivity;

/**
 * Created by lion on 08/01/2018.
 */

public class RecentViewActivity extends BaseActivity{

    private RecentViewContract.ViewModel mViewModel;
    private RecentViewContract.Presenter mPrsenter;
    private RecentViewAdapter mAdapter;
    private List<RecentView> mList;

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {

        mList = new ArrayList<>();
        mAdapter = new RecentViewAdapter(this , mList);

        mViewModel = new RecentViewViewModel(mAdapter , this);
        mPrsenter = new RecentViewPresenter(mViewModel);

        mViewModel.setPresenter(mPrsenter);
        mViewModel.onStart();

        ActivityRecentViewBinding binding = DataBindingUtil.setContentView(this , R.layout.activity_recent_view);

        binding.setViewModel((RecentViewViewModel) mViewModel);

    }
}
