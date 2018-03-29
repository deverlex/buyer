package vn.needy.buyer.screen.listProduct.priceLater;

import java.util.List;

import vn.needy.buyer.repository.remote.product.context.ProductPlContext;
import vn.needy.buyer.screen.BasePresenter;
import vn.needy.buyer.screen.BaseViewModel;

/**
 * Created by truongpq on 03/01/2018.
 */

public interface ListProductPlContract {

    interface ViewModel extends BaseViewModel<Presenter> {
        void onBackPressed();

        void updateProducts(List<ProductPlContext> productPlContexts);
    }

    interface Presenter extends BasePresenter {
        void getProductsOfStore(String category);
    }
}
