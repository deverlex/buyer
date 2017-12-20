package vn.needy.buyer.screen.priceLater;

import java.util.ArrayList;
import java.util.List;

import vn.needy.buyer.model.Category;
import vn.needy.buyer.model.Store;

/**
 * Created by lion on 16/12/2017.
 */

public class PriceLaterPresenter implements PriceLaterContract.Presenter{

    private PriceLaterContract.ViewModel mViewModel;

    public PriceLaterPresenter(PriceLaterContract.ViewModel viewModel) {
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
