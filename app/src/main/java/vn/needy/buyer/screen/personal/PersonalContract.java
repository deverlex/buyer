package vn.needy.buyer.screen.personal;

import vn.needy.buyer.screen.BasePresenter;
import vn.needy.buyer.screen.BaseViewModel;

/**
 * Created by truongpq on 20/12/2017.
 */

public interface PersonalContract {

    interface ViewModel extends BaseViewModel<Presenter>{

        void onCLickRecentViewActivity();

    }

    interface Presenter extends BasePresenter{

    }
}
