package vn.needy.buyer.screen.notification;

import android.databinding.BaseObservable;

import vn.needy.buyer.model.Notification;
import vn.needy.buyer.screen.BaseRecyclerViewAdapter;

/**
 * Created by lion on 18/12/2017.
 */

public class ItemNotificationViewModel extends BaseObservable {

    private final Notification mNotification;
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> mItemClickListener;

    public ItemNotificationViewModel(Notification notification,
                                     BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> itemClickListener) {
        this.mNotification = notification;
        this.mItemClickListener = itemClickListener;
    }

    public String getTitle() {
        return mNotification.getTitle();
    }

    public String getContent() {
        return mNotification.getHtmlContent();
    }

    public String getDate() {
        return mNotification.getCreateTime();
    }

    public boolean isRead() {
        return mNotification.isRead();
    }

    public void onItemClicked() {
        if (mItemClickListener == null) {
            return;
        }
        mItemClickListener.onItemRecyclerViewClick(mNotification);
    }
}
