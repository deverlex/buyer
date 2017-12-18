package vn.needy.buyer.screen.main;

import android.os.Bundle;

import com.roughike.bottombar.BottomBar;

import vn.needy.buyer.R;
import vn.needy.buyer.screen.BaseActivity;

/**
 * Created by lion on 16/12/2017.
 */

public class MainActivity extends BaseActivity {

    private BottomBar mBottomBar;

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
    }
}
