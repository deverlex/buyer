package vn.needy.buyer.screen.personal;

import android.content.Context;
import android.databinding.BaseObservable;

import vn.needy.buyer.domain.RecentView;
import vn.needy.buyer.screen.recentView.RecentViewActivity;
import vn.needy.buyer.utils.navigator.Navigator;

/**
 * Created by truongpq on 20/12/2017.
 */

public class PersonalViewModel extends BaseObservable implements PersonalContract.ViewModel{

    private Context mContext;
    private Navigator mNavigator;

    public PersonalViewModel(Context mContext, Navigator mNavigator) {
        this.mContext = mContext;
        this.mNavigator = mNavigator;
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
    public void onClickRecentViewActivity() {
        mNavigator.startActivity(RecentViewActivity.class);
    }
}
