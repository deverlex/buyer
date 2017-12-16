package vn.needy.buyer.screen.main;

import vn.needy.buyer.screen.BasePresenter;

/**
 * Created by lion on 16/12/2017.
 */

public interface MainContract {

    interface Presenter extends BasePresenter {

        void loadCartList();

        void loadNotifications();
    }
}
