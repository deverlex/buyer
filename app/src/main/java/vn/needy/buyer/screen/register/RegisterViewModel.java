package vn.needy.buyer.screen.register;

import android.app.Application;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.Log;

import com.android.databinding.library.baseAdapters.BR;

import vn.needy.buyer.R;
import vn.needy.buyer.port.service.BuyerServiceClient;
import vn.needy.buyer.repository.remote.user.request.RegisterRequest;
import vn.needy.buyer.screen.main.MainActivity;
import vn.needy.buyer.utils.Utils;
import vn.needy.buyer.utils.dialog.DialogManager;
import vn.needy.buyer.utils.navigator.Navigator;

/**
 * Created by lion on 16/12/2017.
 */

public class RegisterViewModel  extends BaseObservable implements RegisterContract.ViewModel{
    private static final String TAG = RegisterViewModel.class.getName();

    private final Context mContext;
    private final Application mApplication;
    private final Navigator mNavigator;
    private final DialogManager mDialogManager;
    private RegisterContract.Presenter mPresenter;

    private String mIntroContent;

    private String mPhoneNumberError;
    private String mPasswordError;
    private String mOtpCodeError;

    private String mPhoneNumber;
    private String mPassword;
    private String mOtpCode;

    private int mDrawableShowPassword;
    private boolean mVisibleShowPassword;
    private TransformationMethod mTransformationMethod;

    private boolean mVisibleOptCode;

    public RegisterViewModel(Context context, Application application, Navigator navigator, DialogManager dialogManager) {
        mContext = context;
        mApplication = application;
        mNavigator = navigator;
        mDialogManager = dialogManager;
        mIntroContent = context.getString(R.string.intro_validate_phone);

        mVisibleOptCode = false;

        mDrawableShowPassword = R.drawable.ic_eye_off;
        mTransformationMethod = PasswordTransformationMethod.getInstance();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onRegisterError(String message) {
        mDialogManager.dismissProgressDialog();
        mNavigator.showToastCenterText(message);
    }

    @Override
    public void onRegisterError(int errorMsg) {
        mDialogManager.dismissProgressDialog();
        mNavigator.showToastCenterText(mContext.getString(errorMsg));
    }

    @Override
    public void onRegisterSuccess() {
        mDialogManager.dismissProgressDialog();
        BuyerServiceClient.initialize(mApplication);
        mNavigator.startActivity(MainActivity.class);
        mNavigator.finishActivity();
    }

    @Override
    public void onVerificationSuccess(String firebaseUid, String firebaseToken) {
        mDialogManager.dismissProgressDialog();
        RegisterRequest request = new RegisterRequest();
        request.setPhoneNumber(Utils.PhoneNumberUtils.formatPhoneNumber(mPhoneNumber));
        request.setPassword(mPassword);
        request.setFirebaseUid(firebaseUid);
        request.setFirebaseToken(firebaseToken);
        mPresenter.register(request);
    }

    @Override
    public void onVerificationError(String message) {
        mDialogManager.dismissProgressDialog();
        mNavigator.showToastCenterText(message);
    }

    @Override
    public void onVerificationError(int errorMsg) {
        mDialogManager.dismissProgressDialog();

        mNavigator.showToastCenterText(mContext.getString(errorMsg));

        mIntroContent = mContext.getString(R.string.intro_validate_opt);
        mVisibleOptCode = true;
        notifyPropertyChanged(BR.visibleOptCode);
        notifyPropertyChanged(BR.introContent);
    }

    @Override
    public void onWaitingTimeForResend(int duration) {
        String msg = String.format(mContext.getString(R.string.waiting_otp), String.valueOf(duration));
        mNavigator.showToastCenterText(msg);
    }

    @Override
    public void onInputPhoneNumberError(int errorMsg) {
        mPhoneNumberError = mContext.getString(errorMsg);
        notifyPropertyChanged(BR.phoneNumberError);
    }

    @Override
    public void onInputPasswordError(int errorMsg) {
        mPasswordError = mContext.getString(errorMsg);
        notifyPropertyChanged(BR.passwordError);
    }

    @Override
    public void onInputOtpCodeError(int errorMsg) {
        mOtpCodeError = mContext.getString(errorMsg);
        notifyPropertyChanged(BR.otpCodeError);
    }

    @Override
    public void onSendVerificationSuccess() {
        mDialogManager.dismissProgressDialog();
        // change intro content for add otp code
        mIntroContent = mContext.getString(R.string.intro_validate_opt);
        mVisibleOptCode = true;

        notifyPropertyChanged(BR.visibleOptCode);
        notifyPropertyChanged(BR.introContent);
    }

    @Override
    public void onSendVerificationClick() {
        // send verify number
        Log.d(TAG, mPhoneNumber + " - " + mPassword);
        mPresenter.sendVerification(mPhoneNumber, mPassword);
    }

    @Override
    public void onResendVerificationClick() {
        // resend verify number
        mPresenter.resendVerification(mPhoneNumber);
    }

    @Override
    public void onValidateClick() {
        // verify using code
        mPresenter.validateVerification(mOtpCode);
    }

    @Override
    public void onShowProgressBar() {
        mDialogManager.showProgressDialog();
    }

    @Override
    public void onHideProgressBar() {
        mDialogManager.dismissProgressDialog();
    }

    @Override
    public void onBackPressed() {
        if (mVisibleOptCode) {
            reset();
        } else mNavigator.onBackPressed();
    }

    private void reset() {
        mIntroContent = mContext.getString(R.string.intro_validate_phone);
        mVisibleOptCode = false;
        notifyPropertyChanged(BR.introContent);
        notifyPropertyChanged(BR.visibleOptCode);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s.length() > 0) {
            mVisibleShowPassword = true;
        } else mVisibleShowPassword = false;
        notifyPropertyChanged(BR.visibleShowPassword);
    }

    @Override
    public void onViewPasswordClick() {
        notifyPropertyChanged(BR.visibleShowPassword);
        if (mDrawableShowPassword == R.drawable.ic_eye) {
            mDrawableShowPassword = R.drawable.ic_eye_off;
            mTransformationMethod = PasswordTransformationMethod.getInstance();
        } else {
            mDrawableShowPassword = R.drawable.ic_eye;
            mTransformationMethod = HideReturnsTransformationMethod.getInstance();
        }
        notifyPropertyChanged(BR.drawableShowPassword);
        notifyPropertyChanged(BR.transformationMethod);
    }

    @Bindable
    public String getIntroContent() {
        return mIntroContent;
    }

    public void setIntroContent(String mIntroContent) {
        this.mIntroContent = mIntroContent;
    }

    @Bindable
    public String getPhoneNumberError() {
        return mPhoneNumberError;
    }

    @Bindable
    public String getPasswordError() {
        return mPasswordError;
    }

    @Bindable
    public String getOtpCodeError() {
        return mOtpCodeError;
    }

    @Bindable
    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }

    @Bindable
    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        this.mPassword = password;
    }

    @Bindable
    public String getOptCode() {
        return mOtpCode;
    }

    public void setOptCode(String optCode) {
        this.mOtpCode = optCode;
    }

    @Bindable
    public boolean isVisibleOptCode() {
        return mVisibleOptCode;
    }

    public void setVisibleOptCode(boolean visibleOptCode) {
        mVisibleOptCode = visibleOptCode;
    }

    @Bindable
    public int getDrawableShowPassword() {
        return mDrawableShowPassword;
    }

    @Bindable
    public TransformationMethod getTransformationMethod() {
        return mTransformationMethod;
    }

    @Bindable
    public boolean isVisibleShowPassword() {
        return mVisibleShowPassword;
    }
}
