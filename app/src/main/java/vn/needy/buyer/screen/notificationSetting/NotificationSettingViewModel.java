package vn.needy.buyer.screen.notificationSetting;

import android.app.Activity;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

import vn.needy.buyer.R;

/**
 * Created by lion on 25/12/2017.
 */

public class NotificationSettingViewModel extends BaseObservable implements NotificationSettingContract.ViewModel{

    private Context mContext;
    private NotificationSettingContract.Presenter mPresenter;
    private boolean mShowNotificationSetting;
    private boolean mShowReceiveEmailSetting;
    private int mIconNotificationEmail ;
    private int mIconNotification ;
    private int mIconExpand = R.drawable.ic_expand;
    private boolean mReceiveEmail;
    private boolean mNotification;
    private boolean mReceiveUpdateOrder;
    private boolean mChatNotify;
    private boolean mReceiveNewPromotion;
    private boolean mReceiveNewFollowOrComment;
    private boolean mReceiveAppUpdate;
    private boolean mReceiveUpdateOrderAndPayment;
    private boolean mReceiveNews;

    public NotificationSettingViewModel(Context mContext) {
        this.mContext = mContext;
        mIconNotificationEmail = R.drawable.ic_next_right;
        mIconNotification = R.drawable.ic_next_right;
        mReceiveEmail = false;
        mNotification = false;
        mReceiveUpdateOrderAndPayment = true;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void setPresenter(NotificationSettingContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onNotificationCLick() {
        mShowNotificationSetting = !mShowNotificationSetting;
        notifyPropertyChanged(BR.showNotificationSetting);

        mIconNotification = (mIconNotification == mIconExpand ? R.drawable.ic_next_right : mIconExpand);

        notifyPropertyChanged(BR.iconNotification);
    }

    @Override
    public void onReceiveEmailCLick() {
        mShowReceiveEmailSetting = !mShowReceiveEmailSetting;
        notifyPropertyChanged(BR.showReceiveEmailSetting);

        mIconNotificationEmail = (mIconNotificationEmail == mIconExpand ? R.drawable.ic_next_right: mIconExpand);

        notifyPropertyChanged(BR.iconNotificationEmail);
    }

    @Override
    public void onBackPressed() {
        ((Activity) mContext).onBackPressed();
    }

    @Override
    public void onTurnOnReceiveEmail() {
        mReceiveEmail = !mReceiveEmail;
        notifyPropertyChanged(BR.receiveEmail);
    }

    @Override
    public void onTurnOnReceiveNotify() {
        mNotification = !mNotification;
        notifyPropertyChanged(BR.notification);
    }

    @Override
    public void onReceiveUpdateOrderClick() {
        mReceiveUpdateOrder = !mReceiveUpdateOrder;
        notifyPropertyChanged(BR.receiveUpdateOrder);
    }

    @Override
    public void onReceiveChatNotifyClick() {
        mChatNotify =!mChatNotify;
        notifyPropertyChanged(BR.chatNotify);
    }

    @Override
    public void onReceiveNewPromotionClick() {
        mReceiveNewPromotion = !mReceiveNewPromotion;
        notifyPropertyChanged(BR.receiveNewPromotion);
    }

    @Override
    public void onReceiveNewFollowOrCommentClick() {
        mReceiveNewFollowOrComment = !mReceiveNewFollowOrComment;
        notifyPropertyChanged(BR.receiveNewFollowOrComment);
    }

    @Override
    public void onReceiveAppUpdateClick() {
        mReceiveAppUpdate = !mReceiveAppUpdate;
        notifyPropertyChanged(BR.receiveAppUpdate);
    }

    @Override
    public void onReceiveUpdateOrderAndPaymentClick() {
        mReceiveUpdateOrderAndPayment = !mReceiveUpdateOrderAndPayment;
        notifyPropertyChanged(BR.receiveUpdateOrderAndPayment);
    }

    @Override
    public void onReceiveNewsClick() {
        mReceiveNews = !mReceiveNews;
        notifyPropertyChanged(BR.receiveNews);
    }

    @Bindable
    public int getIconNotificationEmail() {
        return mIconNotificationEmail;
    }
    @Bindable
    public int getIconNotification() {
        return mIconNotification;
    }
    @Bindable
    public boolean isShowNotificationSetting() {
        return mShowNotificationSetting;
    }

    @Bindable
    public boolean isShowReceiveEmailSetting() {
        return mShowReceiveEmailSetting;
    }

    @Bindable
    public boolean isReceiveEmail() {
        return mReceiveEmail;
    }

    @Bindable
    public boolean isNotification() {
        return mNotification;
    }

    @Bindable
    public boolean isReceiveUpdateOrder() {
        return mReceiveUpdateOrder;
    }
    @Bindable
    public boolean isChatNotify() {
        return mChatNotify;
    }

    @Bindable
    public boolean isReceiveNewPromotion() {
        return mReceiveNewPromotion;
    }
    @Bindable
    public boolean isReceiveNewFollowOrComment() {
        return mReceiveNewFollowOrComment;
    }

    @Bindable
    public boolean isReceiveAppUpdate() {
        return mReceiveAppUpdate;
    }

    @Bindable
    public boolean isReceiveUpdateOrderAndPayment() {
        return mReceiveUpdateOrderAndPayment;
    }

    @Bindable
    public boolean isReceiveNews() {
        return mReceiveNews;
    }

}
