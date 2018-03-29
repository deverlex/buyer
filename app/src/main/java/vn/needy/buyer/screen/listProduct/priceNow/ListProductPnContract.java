package vn.needy.buyer.screen.listProduct.priceNow;

import java.util.List;

import vn.needy.buyer.repository.remote.product.context.ProductPnContext;
import vn.needy.buyer.screen.BasePresenter;
import vn.needy.buyer.screen.BaseViewModel;

/**
 * Created by truongpq on 03/01/2018.
 */

public interface ListProductPnContract {
    interface ViewModel extends BaseViewModel<Presenter> {
        void onBackPressed();

        void updateProducts(List<ProductPnContext> productPnContexts);
    }

    interface Presenter extends BasePresenter {
        void getProductsOfStore(String category);
    }
}
