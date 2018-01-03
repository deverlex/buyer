package vn.needy.buyer.screen.notificationSetting;

import vn.needy.buyer.screen.BasePresenter;
import vn.needy.buyer.screen.BaseViewModel;

/**
 * Created by lion on 25/12/2017.
 */

interface NotificationSettingContract {

    interface ViewModel extends BaseViewModel<Presenter> {

        void onNotificationCLick();

        void onNotificationEmailCLick();

        void onBackPressed();

        void onNotification();

        void onNotificationSettingEmail();

        void onNotificationSetting();

        void onGetUpdateOrderClick();

        void onNotificationChatClick();

        void onNotificationProductPromotionClick();

        void onNotificationFollowCLick();

        void onNotificationProductEndCLick();

        void onNotificationUpdateAppClick();

        void onNotificationProductClick();

        void notificationEmailApp();

        void notificationNewClick();

        void onNotificationPersonalClick();

        void onNotificationGroupClick();

        void onNotificationSave();
    }

    interface Presenter extends BasePresenter {

    }

}
