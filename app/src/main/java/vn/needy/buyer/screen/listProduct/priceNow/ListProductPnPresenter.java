package vn.needy.buyer.screen.listProduct.priceNow;

import java.util.ArrayList;
import java.util.List;

import vn.needy.buyer.port.wrapper.ProductPnWrapper;

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
        List<ProductPnWrapper> productPnWrappers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            productPnWrappers.add(new ProductPnWrapper());
        }

        mViewModel.updateProducts(productPnWrappers);
    }
}
