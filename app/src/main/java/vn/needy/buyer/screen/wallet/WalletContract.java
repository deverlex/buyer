package vn.needy.buyer.screen.wallet;

import vn.needy.buyer.screen.BasePresenter;
import vn.needy.buyer.screen.BaseViewModel;

/**
 * Created by lion on 16/12/2017.
 */

public class WalletContract {

    interface ViewModel extends BaseViewModel<Presenter>{

        void onBackPressed();

        void onPersonalEarnedCoinClick();

        void getProductList(WalletActivity.Product product);
    }

    interface Presenter extends BasePresenter{

        void loadWalletList();

    }
}
