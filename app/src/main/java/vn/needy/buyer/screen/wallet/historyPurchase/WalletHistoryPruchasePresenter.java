package vn.needy.buyer.screen.wallet.historyPurchase;

import android.content.Context;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import vn.needy.buyer.domain.OrderWallet;
import vn.needy.buyer.screen.wallet.WalletActivity;

/**
 * Created by minh_dai on 02/01/2018.
 */

public class WalletHistoryPruchasePresenter implements WalletHistoryPurchaseContract.Presenter {

    private Context mContext;
    private WalletHistoryPurchaseContract.ViewModel mViewModel;

    public WalletHistoryPruchasePresenter(Context mContext, WalletHistoryPurchaseContract.ViewModel viewModel) {
        this.mContext = mContext;
        this.mViewModel = viewModel;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void getListProduct(){
        List<OrderWallet> mList;
        
        OrderWallet orderWallet = new OrderWallet();

        orderWallet.setTitle("Set 10  tất Uni cổ thấp loại đẹp");
        orderWallet.setCointChange(11);

        Date currentTime = Calendar.getInstance().getTime();

        orderWallet.setTime(currentTime);
        orderWallet.setState(123);

        mList = new ArrayList<>();
        mList.add(orderWallet);
        mList.add(orderWallet);
        mList.add(orderWallet);
        mList.add(orderWallet);
        mList.add(orderWallet);
        mList.add(orderWallet);

        mViewModel.getCargoList(mList);
    }
}
