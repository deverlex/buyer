package vn.needy.buyer.screen.personal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import vn.needy.buyer.screen.wallet.WalletActivity;
import vn.needy.buyer.utils.navigator.Navigator;

/**
 * Created by truongpq on 20/12/2017.
 */

public class PersonalViewModel implements PersonalContract.ViewModel{

    private Navigator mNavigator;
    private Context mContext;

    public PersonalViewModel(Navigator mNavigator, Context mContext) {
        this.mNavigator = mNavigator;
        this.mContext = mContext;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void setPresenter(PersonalContract.Persenter presenter) {

    }

    @Override
    public void onClickViewBudget() {
        mNavigator.startActivity(WalletActivity.class);
    }


}
