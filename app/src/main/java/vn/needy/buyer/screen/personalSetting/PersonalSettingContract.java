package vn.needy.buyer.screen.personalSetting;

import vn.needy.buyer.screen.BasePresenter;
import vn.needy.buyer.screen.BaseViewModel;

/**
 * Created by minh_dai on 30/12/2017.
 */

public interface PersonalSettingContract {

    interface ViewModel extends BaseViewModel<Presenter> {

        void onBackPressed();

        void onCheckedEmail();

        void onCheckedBirthday();

        void onCheckedSex();
    }

    interface Presenter extends BasePresenter {

    }
}
