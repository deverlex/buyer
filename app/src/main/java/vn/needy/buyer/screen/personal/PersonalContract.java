package vn.needy.buyer.screen.personal;

import vn.needy.buyer.screen.BasePresenter;
import vn.needy.buyer.screen.BaseViewModel;

/**
 * Created by truongpq on 20/12/2017.
 */

public class PersonalContract {

    interface ViewModel extends BaseViewModel<Persenter>{

        void onAccountActivityClick();

        void onClickViewOrderHistory();

        void onClickViewBudget();

        void onClickViewCompany();

        void onClickViewStore();

        void onClickViewSupport();

        void onClickHeader();

    }

    interface Persenter extends BasePresenter{

    }
}
