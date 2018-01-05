package vn.needy.buyer.screen.productPnDetail;

import android.view.View;
import android.widget.TextView;

import java.util.List;

import ss.com.bannerslider.banners.Banner;
import vn.needy.buyer.screen.BasePresenter;
import vn.needy.buyer.screen.BaseViewModel;

/**
 * Created by lion on 16/12/2017.
 */

interface ProductPnDetailContract {
    interface ViewModel extends BaseViewModel<Presenter> {
        void onBackPressed();

        void setBanners(List<Banner> banners);

        void addToCart(TextView view);

        void buyNow();
    }

    interface Presenter extends BasePresenter {
        void getProductPnInfo();
    }
}
