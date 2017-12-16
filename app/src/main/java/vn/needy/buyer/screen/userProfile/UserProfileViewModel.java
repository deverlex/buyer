package vn.needy.buyer.screen.userProfile;

/**
 * Created by lion on 16/12/2017.
 */

public class UserProfileViewModel implements UserProfileContract.ViewModel {

    private UserProfileContract.Presenter mPresenter;

    public UserProfileViewModel() {

    }


    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void setPresenter(UserProfileContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
