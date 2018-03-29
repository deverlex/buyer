package vn.needy.buyer.screen.listProduct.priceNow;

import java.util.ArrayList;
import java.util.List;

import vn.needy.buyer.repository.remote.product.context.ProductPnContext;

/**
 * Created by truongpq on 03/01/2018.
 */

public class ListProductPnPresenter implements ListProductPnContract.Presenter {
    private ListProductPnContract.ViewModel mViewModel;

    public ListProductPnPresenter(ListProductPnContract.ViewModel viewModel) {
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
        List<ProductPnContext> productPnContexts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            productPnContexts.add(new ProductPnContext());
        }

        mViewModel.updateProducts(productPnContexts);
    }
}
