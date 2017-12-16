package vn.needy.buyer.screen.userProfile;

/**
 * Created by lion on 16/12/2017.
 */

public class UserProfilePresenter implements UserProfileContract.Presenter {

    private final UserProfileContract.ViewModel mViewModel;

    public UserProfilePresenter(UserProfileContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}
