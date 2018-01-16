package vn.needy.buyer.screen.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

import vn.needy.buyer.R;
import vn.needy.buyer.database.sharedprf.SharedPrefsApi;
import vn.needy.buyer.database.sharedprf.SharedPrefsImpl;
import vn.needy.buyer.database.sharedprf.SharedPrefsKey;
import vn.needy.buyer.port.api.BuyerApi;
import vn.needy.buyer.port.service.BuyerServiceClient;
import vn.needy.buyer.repository.UserRepository;
import vn.needy.buyer.repository.local.UserDataLocal;
import vn.needy.buyer.repository.remote.user.UserDataRemote;
import vn.needy.buyer.screen.login.LoginActivity;
import vn.needy.buyer.screen.main.MainActivity;
import vn.needy.buyer.utils.navigator.Navigator;

/**
 * Created by lion on 16/12/2017.
 */

public class SplashActivity extends AppCompatActivity {
    private static final String TAG = SplashActivity.class.getName();

    private static final int SECOND_DELAYED = 500;
    private Handler mHandler;
    private Runnable mRunnable;
    private Intent mIntent;

    private UserRepository mUserRepository;
    private Navigator mNavigator;

    private SharedPrefsApi mPrefsApi;
    private BuyerApi mBuyerApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        setContentView(R.layout.activity_splash);

        mPrefsApi = SharedPrefsImpl.getInstance();
        mBuyerApi = BuyerServiceClient.getInstance();

        mUserRepository = new UserRepository(
                new UserDataRemote(mBuyerApi),
                new UserDataLocal(mPrefsApi)
        );

        mNavigator = new Navigator(this);
        mHandler = new Handler();
        mRunnable = new Runnable() {
            @Override
            public void run() {
//                if (TextUtils.isEmpty(token)) {
//                loginPage();
//                } else {
                    gateway();
//                }
//                new Navigator(SplashActivity.this).startActivity(mIntent);
            }
        };
        mHandler.postDelayed(mRunnable, SECOND_DELAYED);
    }

    public void loginPage() {
        mIntent = new Intent(this, LoginActivity.class);
        mNavigator.startActivity(mIntent);
        mNavigator.finishActivity();
    }

    private void gateway() {
        // will check each login app because user maybe remove by ceo/manager
        // if connect has error, redirect to main page
        mainPage();
    }

    public void mainPage() {
        mIntent = new Intent(this, MainActivity.class);
        mNavigator.startActivity(mIntent);
        mNavigator.finishActivity();
    }

    // We will getAsync it and refresh, if fail -> re-login
    private String getToken(SharedPrefsApi prefsApi) {
        return prefsApi.get(SharedPrefsKey.ACCESS_TOKEN, String.class);
    }
}
