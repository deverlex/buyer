package vn.needy.buyer.screen.personal;

import android.content.Context;
import android.databinding.BaseObservable;

import vn.needy.buyer.screen.account.AccountActivity;
import vn.needy.buyer.screen.productFavorite.ProductFavoriteActivity;
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
    public void setPresenter(PersonalContract.Presenter presenter) {

    }

    @Override
    public void onViewAccountClicked() {
        mNavigator.startActivity(AccountActivity.class);
    }

    @Override
    public void onClickProductFavorite(){
        mNavigator.startActivity(ProductFavoriteActivity.class);
    }
    @Override
    public void onViewOrderHistoryClicked() {

    }

    @Override
    public void onViewBudgetClicked() {

    }

    @Override
    public void onViewSupportClicked() {

    }

    @Override
    public void onClickHeader() {

    }
}
