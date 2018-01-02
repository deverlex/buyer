package vn.needy.buyer.screen.personalSetting;

import android.app.Activity;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by lion on 25/12/2017.
 */

public class PersonalSettingViewModel extends BaseObservable implements PersonalSettingContract.ViewModel{

    private PersonalSettingContract.Presenter mPresenter;
    private Activity mContext;
    private boolean checkBirthday;
    private boolean checkEmail;
    private boolean checkSex;

    public PersonalSettingViewModel( Activity mContext) {
        this.mContext = mContext;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void setPresenter(PersonalSettingContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onBackPressed() {
        mContext.onBackPressed();
    }


    @Override
    public void onCheckedEmail() {
        checkEmail = ! checkEmail;
        notifyPropertyChanged(BR.checkEmail);
    }

    @Override
    public void onCheckedBirthday() {
        checkBirthday = ! checkBirthday;
        notifyPropertyChanged(BR.checkBirthday);
    }

    @Override
    public void onCheckedSex() {
        checkSex = ! checkSex;
        notifyPropertyChanged(BR.checkSex);
    }

    @Bindable
    public boolean isCheckBirthday() {
        return checkBirthday;
    }
    @Bindable
    public boolean isCheckEmail() {
        return checkEmail;
    }
    @Bindable
    public boolean isCheckSex() {
        return checkSex;
    }
}
