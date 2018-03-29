package vn.needy.buyer.screen.productFavorite;

import vn.needy.buyer.screen.BasePresenter;
import vn.needy.buyer.screen.BaseViewModel;

/**
 * Created by minh_dai on 09/01/2018.
 */

public interface ProductFavoriteContract {

    interface ViewModel extends BaseViewModel<Presenter>{

        void onBackPressed();
    }

    interface Presenter extends BasePresenter{

    }
}
