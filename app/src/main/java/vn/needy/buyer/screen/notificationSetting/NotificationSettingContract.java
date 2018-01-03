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

        void onNotificationSettingEmail();

        void onNotificationSetting();

        void onReceiveUpdateOrderClick();

        void onReceiveChatNotifyClick();

        void onReceiveNewPromotionClick();

        void onReceiveNewFollowOrCommentClick();

        void onReceiveAppUpdateClick();

        void onReceiveUpdateOrderAndPaymentClick();

        void onReceiveNewsClick();

    }

    interface Presenter extends BasePresenter {

    }

}
