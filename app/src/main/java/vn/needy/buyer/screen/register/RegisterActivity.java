package vn.needy.buyer.screen.register;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.google.firebase.auth.FirebaseAuth;

import vn.needy.buyer.R;
import vn.needy.buyer.database.sharedprf.SharedPrefsApi;
import vn.needy.buyer.database.sharedprf.SharedPrefsImpl;
import vn.needy.buyer.databinding.ActivityRegisterBinding;
import vn.needy.buyer.port.api.BuyerApi;
import vn.needy.buyer.port.service.BuyerServiceClient;
import vn.needy.buyer.screen.BaseActivity;
import vn.needy.buyer.utils.dialog.DialogManager;
import vn.needy.buyer.utils.navigator.Navigator;

/**
 * Created by lion on 16/12/2017.
 */

public class RegisterActivity extends BaseActivity {
    private static final String TAG = RegisterActivity.class.getName();

    private RegisterContract.ViewModel mViewModel;
    private BuyerApi mBuyerApi;
    private SharedPrefsApi mPrefsApi;

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        getWindow().setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.background_login));

        FirebaseAuth.getInstance().signOut();

        Navigator navigator = new Navigator(this);
        DialogManager dialogManager = new DialogManager(this);

        mBuyerApi = BuyerServiceClient.getInstance();
        mPrefsApi = SharedPrefsImpl.getInstance();

        mViewModel = new RegisterViewModel(this, getApplication(), navigator, dialogManager);
        RegisterContract.Presenter presenter = new RegisterPresenter(
                this, mViewModel, mBuyerApi, mPrefsApi
        );

        mViewModel.setPresenter(presenter);
        ActivityRegisterBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_register);
        binding.setViewModel((RegisterViewModel) mViewModel);

//        if (!isNetworkConnected()) {
//            dialogManager.dialogWarning(R.string.error_connection).show();
//        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
