package vn.needy.buyer.screen.listProduct.priceLater;

import java.util.ArrayList;
import java.util.List;

import vn.needy.buyer.port.wrapper.ProductPlWrapper;

/**
 * Created by truongpq on 03/01/2018.
 */

public class ListProductPlPresenter implements ListProductPlContract.Presenter {
    private ListProductPlContract.ViewModel mViewModel;

    public ListProductPlPresenter(ListProductPlContract.ViewModel viewModel) {
        this.mViewModel = viewModel;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void getProductsOfStore(String category) {
        List<ProductPlWrapper> productPlWrappers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            productPlWrappers.add(new ProductPlWrapper());
        }

        mViewModel.updateProducts(productPlWrappers);
    }
}
