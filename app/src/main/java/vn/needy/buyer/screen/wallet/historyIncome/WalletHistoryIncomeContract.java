package vn.needy.buyer.screen.wallet.historyIncome;

import java.util.List;

import vn.needy.buyer.screen.BasePresenter;
import vn.needy.buyer.screen.BaseViewModel;
import vn.needy.buyer.screen.wallet.WalletActivity;

/**
 * Created by lion on 02/01/2018.
 */

public interface WalletHistoryIncomeContract {

    interface ViewModel extends BaseViewModel<Presenter> {

        void getProductList(List<WalletActivity.Product> products);
        void onPersonalEarnedCoinClick();
    }

    interface Presenter extends BasePresenter{

        void getListProduct();
    }
}
