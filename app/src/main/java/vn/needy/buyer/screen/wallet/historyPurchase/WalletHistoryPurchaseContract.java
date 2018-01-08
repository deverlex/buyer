package vn.needy.buyer.screen.wallet.historyPurchase;

import java.util.List;

import vn.needy.buyer.screen.BasePresenter;
import vn.needy.buyer.screen.BaseViewModel;
import vn.needy.buyer.screen.wallet.WalletActivity;

/**
 * Created by lion on 02/01/2018.
 */

interface WalletHistoryPurchaseContract {

    interface ViewModel extends BaseViewModel<Presenter>{

        void getCargoList(List<WalletActivity.Cargo> cargos);

        void onViewAboutReceiveCoinClick();

    }

    interface Presenter extends BasePresenter{

        void getListProduct();

    }
}
