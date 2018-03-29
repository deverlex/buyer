package vn.needy.buyer.screen.productPnDetail;

import java.util.ArrayList;
import java.util.List;

import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.RemoteBanner;

/**
 * Created by lion on 16/12/2017.
 */

public class ProductPnDetailPresenter implements ProductPnDetailContract.Presenter{
    private ProductPnDetailContract.ViewModel mViewModel;

    public ProductPnDetailPresenter(ProductPnDetailContract.ViewModel viewModel) {
        this.mViewModel = viewModel;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void getProductPnInfo() {
        List<Banner> banners = new ArrayList<>();
        banners.add(new RemoteBanner("http://www.thegioibepgas.vn/media/product/3584_4163.jpg"));
        banners.add(new RemoteBanner("http://www.thegioibepgas.vn/media/product/3584_4163.jpg"));
        banners.add(new RemoteBanner("http://www.thegioibepgas.vn/media/product/3584_4163.jpg"));
        banners.add(new RemoteBanner("http://www.thegioibepgas.vn/media/product/3584_4163.jpg"));
        banners.add(new RemoteBanner("http://www.thegioibepgas.vn/media/product/3584_4163.jpg"));
        banners.add(new RemoteBanner("http://www.thegioibepgas.vn/media/product/3584_4163.jpg"));
        banners.add(new RemoteBanner("http://www.thegioibepgas.vn/media/product/3584_4163.jpg"));
        mViewModel.setBanners(banners);
    }
}
