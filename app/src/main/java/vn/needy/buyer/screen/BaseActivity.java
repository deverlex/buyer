package vn.needy.buyer.screen;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewConfiguration;

import java.lang.reflect.Field;
import java.util.Locale;

import vn.needy.buyer.R;

/**
 * Created by lion on 16/12/2017.
 */

public class BaseActivity  extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getSimpleName();

    public static final String LOCALE_EXTRA = "locale_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        prepareCreate();
        if (BaseFragmentActivity.isMenuWorkaroundRequired()) {
            forceOverflowMenu();
        }
        super.onCreate(savedInstanceState);
        if (!isFinishing()) {
            onCreateActivity(savedInstanceState);
        }
    }

    /**
     * Modified from: http://stackoverflow.com/a/13098824
     */
    private void forceOverflowMenu() {
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if (menuKeyField != null) {
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(config, false);
            }
        } catch (IllegalAccessException e) {
            Log.w(TAG, "Failed to force overflow menu.");
        } catch (NoSuchFieldException e) {
            Log.w(TAG, "Failed to force overflow menu.");
        }
    }

    protected void prepareCreate() {}

    protected void onCreateActivity(Bundle savedInstanceState) {}

    ////////////////////////////////////////

    protected <T extends Fragment> T initFragment(@IdRes int target,
                                                  @NonNull T fragment) {
        return initFragment(target, fragment, null, null);
    }

    protected <T extends Fragment> T initFragment(@IdRes int target,
                                                  @NonNull T fragment,
                                                  @Nullable Locale locale) {
        return initFragment(target, fragment, locale, null);
    }

    protected <T extends Fragment> T initFragment(@IdRes int target,
                                                  @NonNull T fragment,
                                                  @Nullable Bundle extras) {
        return initFragment(target, fragment, null, extras);
    }

    protected <T extends Fragment> T initFragment(@IdRes int target,
                                                  @NonNull T fragment,
                                                  @Nullable Locale locale,
                                                  @Nullable Bundle extras) {
        Bundle args = new Bundle();
        args.putSerializable(LOCALE_EXTRA, locale);

        if (extras != null) {
            args.putAll(extras);
        }

        fragment.setArguments(args);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,
                android.R.anim.fade_in, android.R.anim.fade_out);
        transaction.replace(target, fragment)
                .commit();
        transaction.addToBackStack(fragment.getClass().getName());
        return fragment;
    }

    @Override
    protected void onPause(){
        super.onPause();
        overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out);
    }

    public void onBackPressed(){
        //you can do your other onBackPressed logic here..

        //Then just call finish()
        finish();
    }
}
