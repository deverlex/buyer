package vn.needy.buyer.screen.wallet.historyIncome;

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

public class WalletHistoryIncomePresenter implements WalletHistoryIncomeContract.Presenter {

    private Context mContext;
    private WalletHistoryIncomeContract.ViewModel mViewModel;

    public WalletHistoryIncomePresenter(Context mContext, WalletHistoryIncomeContract.ViewModel mViewModel) {
        this.mContext = mContext;
        this.mViewModel = mViewModel;
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

        mViewModel.getProductList(mList);
    }
}
