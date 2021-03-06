package vn.needy.buyer.screen.productPnDetail;

import android.app.Activity;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

import java.util.List;

import ss.com.bannerslider.banners.Banner;
import vn.needy.buyer.BR;

/**
 * Created by lion on 16/12/2017.
 */

public class ProductPnDetailViewModel extends BaseObservable implements ProductPnDetailContract.ViewModel{

    private Context mContext;
    private ProductPnDetailContract.Presenter mPresenter;
    private List<Banner> mBanners;


    public ProductPnDetailViewModel(Context context) {
        this.mContext = context;
    }

    @Override
    public void onStart() {
        mPresenter.getProductPnInfo();
    }

    @Override
    public void onStop() {

    }

    @Override
    public void setPresenter(ProductPnDetailContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onBackPressed() {
        ((Activity)mContext).onBackPressed();
    }

    @Override
    public void setBanners(List<Banner> banners) {
        mBanners = banners;
        notifyPropertyChanged(BR.banners);
    }

    @Override
    public void addToCart(TextView view) {
//        BottomSheetAddToCart addToCart = BottomSheetAddToCart.newInstance();
//        addToCart.show(((AppCompatActivity)mContext).getSupportFragmentManager(), BottomSheetAddToCart.class.getName());
        view.setText("7");
        scaleView(view);
    }

    @Override
    public void buyNow() {
        BottomSheetBuyNowDialog buyNow = BottomSheetBuyNowDialog.newInstance();
        buyNow.show(((AppCompatActivity)mContext).getSupportFragmentManager(), BottomSheetBuyNowDialog.class.getName());
    }

    @Bindable
    public List<Banner> getBanners() {
        return mBanners;
    }

    public void scaleView(View v) {
        Animation anim = new ScaleAnimation(
                1.3f, 1f,
                1.3f, 1f);
        anim.setFillAfter(false);
        anim.setDuration(500);
        v.startAnimation(anim);
    }
}
