package vn.needy.buyer.screen.listProduct.priceLater;

import java.util.List;

import vn.needy.buyer.port.wrapper.ProductPlWrapper;
import vn.needy.buyer.screen.BasePresenter;
import vn.needy.buyer.screen.BaseViewModel;

/**
 * Created by truongpq on 03/01/2018.
 */

public interface ListProductPlContract {

    interface ViewModel extends BaseViewModel<Presenter> {
        void onBackPressed();

        void updateProducts(List<ProductPlWrapper> productPlWrappers);
    }

    interface Presenter extends BasePresenter {
        void getProductsOfStore(String category);
    }
}
