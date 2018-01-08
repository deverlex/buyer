package vn.needy.buyer.screen.recentView;

import java.util.ArrayList;
import java.util.List;

import vn.needy.buyer.domain.RecentView;

/**
 * Created by lion on 08/01/2018.
 */

public class RecentViewPresenter implements RecentViewContract.Prsenter{

    private List<RecentView> mList;
    private RecentViewContract.ViewModel mViewModel;

    public RecentViewPresenter(RecentViewContract.ViewModel mViewModel) {
        this.mViewModel = mViewModel;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void getListRecentView() {

        mList = new ArrayList<>();

        RecentView recentView = new RecentView();

        recentView.setName("Áo thun nam ngắn tay có cổ");
        recentView.setTimeView("12:02 30-12-2017");

        for (int i =0 ; i< 10 ; ++i) {
            mList.add(recentView);
        }


        mViewModel.setListRecentView(mList);
    }
}
