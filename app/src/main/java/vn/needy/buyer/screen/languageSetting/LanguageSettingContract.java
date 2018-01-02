package vn.needy.buyer.screen.languageSetting;

import java.util.List;

import vn.needy.buyer.model.Language;
import vn.needy.buyer.screen.BasePresenter;
import vn.needy.buyer.screen.BaseViewModel;


/**
 * Created by lion on 25/12/2017.
 */

interface LanguageSettingContract {

    interface ViewModel extends BaseViewModel<Presenter> {

        void onBackPressed();

        void setLanguageList(List<Language> languageList);

        void setDefaultLanguage(Language defaultLanguage);

        void onLanguageSave();

    }

    interface Presenter extends BasePresenter {

        void loadSupportLanguage();

        void getLanguageList();

        void getDefaultLanguage();

    }
}
