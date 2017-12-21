package vn.needy.buyer.screen.notification;

import java.util.List;

import vn.needy.buyer.model.Notification;
import vn.needy.buyer.screen.BasePresenter;
import vn.needy.buyer.screen.BaseViewModel;

/**
 * Created by lion on 16/12/2017.
 */

interface NotificationContract {
    interface ViewModel extends BaseViewModel<Presenter> {
        void onSetNotifications(List<Notification> notifications);

        void onClickReadAll();
    }

    interface Presenter extends BasePresenter {
        void onGetNotification();
        void onReadAll(List<Notification> notifications);
    }
}
