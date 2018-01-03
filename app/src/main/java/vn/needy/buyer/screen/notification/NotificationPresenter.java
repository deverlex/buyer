package vn.needy.buyer.screen.notification;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import vn.needy.buyer.domain.Notification;

/**
 * Created by lion on 16/12/2017.
 */

public class NotificationPresenter implements NotificationContract.Presenter{

    private NotificationContract.ViewModel mViewModel;

    public NotificationPresenter(NotificationContract.ViewModel mViewModel) {
        this.mViewModel = mViewModel;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onGetNotification() {
        List<Notification> notifications = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Notification notification = new Notification();
            notification.setId(i);
            notification.setSenderId("senderId");
            notification.setCreateTime("09:21 19-12-17");
            notification.setTitle("Khuyến mãi hấp dẫn");
            notification.setHtmlContent("<font color=\"red\">Mua một tặng một </font> cho tất cả các sản phẩm gas<br/><font color=\"red\">Miễn phí vẫn chuyển</font>  cho đơn hàng từ 500k trở lên");
            notification.setReferenceGUI(".screen.main.MainActivity");
            notifications.add(notification);
            Random random = new Random();
            notification.setIsReaded(random.nextBoolean());
        }
        mViewModel.onSetNotifications(notifications);
    }

    @Override
    public void onReadAll(List<Notification> notifications) {
        for (Notification notification : notifications) {
            notification.setIsReaded(true);
        }
    }
}
