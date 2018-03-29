package vn.needy.buyer.screen.login;

import android.text.TextUtils;
import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import vn.needy.buyer.R;
import vn.needy.buyer.database.sharedprf.SharedPrefsImpl;
import vn.needy.buyer.domain.User;
import vn.needy.buyer.port.error.BaseException;
import vn.needy.buyer.port.error.SafetyError;
import vn.needy.buyer.port.message.ResponseStatus;
import vn.needy.buyer.port.message.ResponseWrapper;
import vn.needy.buyer.port.service.BuyerServiceClient;
import vn.needy.buyer.repository.UserRepository;
import vn.needy.buyer.repository.local.UserDataLocal;
import vn.needy.buyer.repository.remote.user.UserDataRemote;
import vn.needy.buyer.repository.remote.user.request.LoginRequest;
import vn.needy.buyer.repository.remote.user.respone.LoginResponse;
import vn.needy.buyer.utils.Utils;
import vn.needy.buyer.utils.navigator.Navigator;

/**
 * Created by lion on 05/10/2017.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private static final String TAG = LoginPresenter.class.getName();

    private final LoginContract.ViewModel mViewModel;

    private Navigator mNavigator;
    private UserRepository mUserRepository;


    LoginPresenter(LoginContract.ViewModel viewModel, Navigator navigator) {
        mViewModel = viewModel;
        mNavigator = navigator;
        mUserRepository = new UserRepository(
                new UserDataRemote(BuyerServiceClient.getInstance()),
                new UserDataLocal(SharedPrefsImpl.getInstance())
        );
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void login(final String phoneNumber, final String passWord) {
        if (!validateDataInput(phoneNumber, passWord)) {
            return;
        }
        final LoginRequest request = new LoginRequest(phoneNumber, passWord);
        mUserRepository.login(request)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe(new Consumer<Disposable>() {
                @Override
                public void accept(Disposable disposable) throws Exception {
                    mViewModel.onShowProgressBar();
                }
            })
            .doOnError(new SafetyError() {
                @Override
                public void onSafetyError(BaseException error) {
                    mNavigator.showToastCenterText(error.getMessage());
                }
            }).observeOn(Schedulers.computation())
            .map(new Function<ResponseWrapper<LoginResponse>, ResponseWrapper<LoginResponse>>() {
                @Override
                public ResponseWrapper<LoginResponse> apply(ResponseWrapper<LoginResponse> resp) throws Exception {
                    LoginResponse data = resp.getData();
                    if (data != null && data.getToken() != null) {
                        // save user info & token to database
                        User user = new User(data.getUser());
                        // save user to realm
                        mUserRepository.saveUserSync(user);
                        mUserRepository.saveTokenSync(data.getToken());
                    }
                    return resp;
                }
            })
            .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ResponseWrapper<LoginResponse>>() {
                @Override
                public void accept(ResponseWrapper<LoginResponse> resp) throws Exception {
                    mViewModel.onHideProgressBar();
                    Log.d(TAG, resp.getStatus());
                    if (resp.getStatus().equals(ResponseStatus.ERROR)) {
                        mViewModel.onLoginError(resp.getMessage());
                    }  else {
                        mViewModel.onLoginSuccess();
                    }
                }
            }, new SafetyError() {
                @Override
                public void onSafetyError(BaseException error) {
                    mViewModel.onHideProgressBar();
                    Log.d(TAG, error.getMessage());
                    mViewModel.onLoginError(R.string.error_credential);
                }
            });
//        String deviceToken = FirebaseInstanceId.getInstance().getToken();
    }

    @Override
    public boolean validateDataInput(String phoneNumber, String passWord) {
        boolean isValidate = true;
        if (TextUtils.isEmpty(phoneNumber)) {
            isValidate = false;
            mViewModel.onInputPhoneNumberError(R.string.phone_number_empty);
        }
        if (!Utils.PhoneNumberUtils.isValidPhoneNumber(phoneNumber)) {
            isValidate = false;
            mViewModel.onInputPhoneNumberError(R.string.is_not_phone_number);
        }
        if (TextUtils.isEmpty(passWord)) {
            isValidate = false;
            mViewModel.onInputPasswordError(R.string.password_empty);
        }
        if (!TextUtils.isEmpty(passWord) && passWord.length() > 32) {
            isValidate = false;
            mViewModel.onInputPasswordError(R.string.password_over_limit);
        }
        if (!TextUtils.isEmpty(passWord) && passWord.length() < 8) {
            isValidate = false;
            mViewModel.onInputPasswordError(R.string.password_miss_length);
        }
        return isValidate;
    }

    private void updateRepositoryAfterResetApi() {
        // update API
        mUserRepository = new UserRepository(
                new UserDataRemote(BuyerServiceClient.getInstance()),
                new UserDataLocal(SharedPrefsImpl.getInstance())
        );
    }
}
