package vn.needy.buyer.screen.main;

import android.os.Bundle;
import android.support.annotation.IdRes;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import vn.needy.buyer.R;
import vn.needy.buyer.screen.BaseActivity;
import vn.needy.buyer.screen.priceNow.PriceNowFragment;
import vn.needy.buyer.utils.ViewUtil;

/**
 * Created by lion on 16/12/2017.
 */

public class MainActivity extends BaseActivity {

    private BottomBar mBottomBar;

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);

        initializeBottomBar();
    }

    private void initializeBottomBar() {
        mBottomBar = ViewUtil.findById(this, R.id.bottomBar);
        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.price_now:
                        initFragment(R.id.contentContainer, PriceNowFragment.newInstance());
                        break;
                    case R.id.price_later:

                        break;
                    case R.id.notification:

                        break;
                    case R.id.personal:

                        break;
                    default:
                }
            }
        });

    }
}
