package vn.needy.buyer.screen.wallet.historyTransaction;

import java.util.List;

import vn.needy.buyer.domain.OrderWallet;
import vn.needy.buyer.screen.BasePresenter;
import vn.needy.buyer.screen.BaseViewModel;
import vn.needy.buyer.screen.wallet.WalletActivity;

/**
 * Created by lion on 02/01/2018.
 */

interface WalletHistoryTransactionContract {

    interface ViewModel extends BaseViewModel<Presenter> {

        void getCargoList(List<OrderWallet> cargos);

        void onViewAboutReceiveCoinClick();

    }

    interface Presenter extends BasePresenter{

        void getListProduct();

    }
}
