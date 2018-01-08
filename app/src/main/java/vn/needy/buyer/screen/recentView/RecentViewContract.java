package vn.needy.buyer.screen.recentView;

import java.util.List;

import vn.needy.buyer.domain.RecentView;
import vn.needy.buyer.screen.BasePresenter;
import vn.needy.buyer.screen.BaseViewModel;

/**
 * Created by lion on 08/01/2018.
 */

public interface RecentViewContract {

    interface ViewModel extends BaseViewModel<Prsenter>{

        void onBackPressed();

        void setListRecentView(List<RecentView> list);
    }

    interface Prsenter extends BasePresenter{

        void getListRecentView();

    }
}
