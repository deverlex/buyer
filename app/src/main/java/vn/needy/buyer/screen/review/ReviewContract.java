package vn.needy.buyer.screen.review;

import vn.needy.buyer.screen.BasePresenter;
import vn.needy.buyer.screen.BaseViewModel;

/**
 * Created by lion on 16/12/2017.
 */

public interface ReviewContract {

    interface ViewModel extends BaseViewModel<Presenter>{

        void onBackPressed();

    }

    interface Presenter extends BasePresenter{

    }
}
