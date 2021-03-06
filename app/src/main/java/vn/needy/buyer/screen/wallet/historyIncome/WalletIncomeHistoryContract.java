package vn.needy.buyer.screen.wallet.historyIncome;

import java.util.List;

import vn.needy.buyer.domain.OrderWallet;
import vn.needy.buyer.screen.BasePresenter;
import vn.needy.buyer.screen.BaseViewModel;
import vn.needy.buyer.screen.wallet.WalletActivity;

/**
 * Created by lion on 02/01/2018.
 */

public interface WalletIncomeHistoryContract {

    interface ViewModel extends BaseViewModel<Presenter> {

        void setOrderWalletList(List<OrderWallet> orderWallets);

        void onViewAboutReceiveCoinClick();
    }

    interface Presenter extends BasePresenter{

        void getListProduct();
    }
}
