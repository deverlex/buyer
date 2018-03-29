package vn.needy.buyer.screen.listProduct.priceLater;

import java.util.ArrayList;
import java.util.List;

import vn.needy.buyer.repository.remote.product.context.ProductPlContext;

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
        List<ProductPlContext> productPlContexts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            productPlContexts.add(new ProductPlContext());
        }

        mViewModel.updateProducts(productPlContexts);
    }
}
