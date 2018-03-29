package vn.needy.buyer.screen.priceLater;

import java.util.List;

import vn.needy.buyer.model.Category;
import vn.needy.buyer.model.Store;
import vn.needy.buyer.screen.BasePresenter;
import vn.needy.buyer.screen.BaseViewModel;

/**
 * Created by lion on 16/12/2017.
 */

interface PriceLaterContract {
    interface ViewModel extends BaseViewModel<Presenter> {
        void setCategories(List<Category> categories);
        void setStores(List<Store> stores);
    }

    interface Presenter extends BasePresenter {
        void getCategories();

        void getStores();
    }
}
