package vn.needy.buyer.screen.personal;

import android.content.Context;
import android.databinding.BaseObservable;

import vn.needy.buyer.screen.account.AccountActivity;
import vn.needy.buyer.utils.navigator.Navigator;

/**
 * Created by truongpq on 20/12/2017.
 */

public class PersonalViewModel extends BaseObservable implements PersonalContract.ViewModel{

    Navigator mNavigator;
    Context mContext;

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
    public void onAccountActivityClick() {
        mNavigator.startActivity(AccountActivity.class);
    }

    @Override
    public void onClickViewOrderHistory() {

    }

    @Override
    public void onClickViewBudget() {

    }

    @Override
    public void onClickViewCompany() {

    }

    @Override
    public void onClickViewStore() {

    }

    @Override
    public void onClickViewSupport() {

    }

    @Override
    public void onClickHeader() {

    }
}
