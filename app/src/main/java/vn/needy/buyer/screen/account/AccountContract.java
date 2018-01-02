package vn.needy.buyer.screen.account;

import vn.needy.buyer.screen.BasePresenter;
import vn.needy.buyer.screen.BaseViewModel;

/**
 * Created by lion on 16/12/2017.
 */

interface AccountContract {

    interface ViewModel extends BaseViewModel<Presenter> {

        void onUserProfileClicked();

        void onDeleteAccountClicked();

        void onClearCacheClicked();

        void onReviewApplicationClicked();

        void onBackPressed();

        void onPersonalSettingClicked();

        void onNotificationSettingClicked();

        void onLanguageSettingClicked();

        void onSupportClicked();

        void onTipAndTrickClicked();

        void onCommunityRulesClicked();

        void onNeedRulesClicked();

        void onLogout();

    }

    interface Presenter extends BasePresenter {

    }

}
