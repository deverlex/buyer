package vn.needy.buyer.screen.priceNow;

import java.util.ArrayList;
import java.util.List;

import vn.needy.buyer.model.Category;
import vn.needy.buyer.model.Store;

/**
 * Created by lion on 16/12/2017.
 */

public class PriceNowPresenter implements PriceNowContract.Presenter{

    private PriceNowContract.ViewModel mViewModel;

    public PriceNowPresenter(PriceNowContract.ViewModel viewModel) {
        this.mViewModel = viewModel;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void getCategories() {
        List<Category> categories = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Category category = new Category();
            category.setTitle("Danh mục " + i);
            categories.add(category);
        }

        mViewModel.setCategories(categories);
    }

    @Override
    public void getStores() {
        List<Store> stores = new ArrayList<>();
        for (int i = 1 ; i <= 20; i++) {
            stores.add(new Store());
        }

        mViewModel.setStores(stores);
    }
}
