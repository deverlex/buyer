package vn.needy.buyer.screen.forgotPassWd;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import vn.needy.buyer.R;
import vn.needy.buyer.databinding.ActivityForgotPasswordBinding;
import vn.needy.buyer.screen.BaseActivity;
import vn.needy.buyer.utils.dialog.DialogManager;
import vn.needy.buyer.utils.navigator.Navigator;

/**
 * Created by lion on 16/12/2017.
 */

public class ForgotPassWdActivity extends BaseActivity{
    private ForgotPassWdContract.ViewModel mViewModel;
    private ForgotPassWdContract.Presenter mPresenter;

    public static final String KEY_PHONE_NUMBER = "phone_number";
    public static final String KEY_FIREBASE_TOKEN = "firebase_token";

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        getWindow().setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.background_login));

        Navigator navigator = new Navigator(this);
        DialogManager dialogManager = new DialogManager(this);

        mViewModel = new ForgotPassWdViewModel(this, getApplication(), navigator, dialogManager);

        mPresenter = new ForgotPassWdPresenter(this, mViewModel);
        mViewModel.setPresenter(mPresenter);

        ActivityForgotPasswordBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_forgot_password);
        binding.setViewModel((ForgotPassWdViewModel) mViewModel);
    }

    @Override
    public void onDestroy() {
        mPresenter.onStop();
        super.onDestroy();
    }
}
