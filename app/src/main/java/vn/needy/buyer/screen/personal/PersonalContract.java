package vn.needy.buyer.screen.personal;

import vn.needy.buyer.screen.BasePresenter;
import vn.needy.buyer.screen.BaseViewModel;

/**
 * Created by truongpq on 20/12/2017.
 */

public class PersonalContract {

    interface ViewModel extends BaseViewModel<Presenter>{

        void onClickViewBudget();

        void onReviewActivityClick();
        
    }

    interface Presenter extends BasePresenter{

    }
}
