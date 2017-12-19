package vn.needy.buyer.screen.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import vn.needy.buyer.R;
import vn.needy.buyer.database.sharedprf.SharedPrefsApi;
import vn.needy.buyer.database.sharedprf.SharedPrefsImpl;
import vn.needy.buyer.databinding.ActivityLoginBinding;
import vn.needy.buyer.port.service.BuyerServiceClient;
import vn.needy.buyer.screen.BaseActivity;
import vn.needy.buyer.utils.dialog.DialogManager;
import vn.needy.buyer.utils.navigator.Navigator;

/**
 * Created by lion on 02/10/2017.
 */
public class LoginActivity extends BaseActivity {

    private LoginContract.ViewModel mViewModel;
    private Navigator mNavigator;

    private SharedPrefsApi mPrefsApi;

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        getWindow().setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.background_login));

        //Clear data
        mPrefsApi = SharedPrefsImpl.getInstance();
        mPrefsApi.clear();
        BuyerServiceClient.initialize(getApplication());

        mNavigator = new Navigator(this);

        DialogManager dialogManager = new DialogManager(this);
        mViewModel = new LoginViewModel(this, getApplication(), mNavigator, dialogManager);

        LoginContract.Presenter presenter = new LoginPresenter(mViewModel, mNavigator);

        mViewModel.setPresenter(presenter);

        ActivityLoginBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setViewModel((LoginViewModel) mViewModel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    protected void onStop() {
        mViewModel.onStop();
        super.onStop();
    }
}
