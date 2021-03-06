package vn.needy.buyer.screen.wallet.historyIncome;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import vn.needy.buyer.domain.OrderWallet;

/**
 * Created by minh_dai on 02/01/2018.
 */

public class WalletIncomeHistoryPresenter implements WalletIncomeHistoryContract.Presenter {

    private Context mContext;
    private WalletIncomeHistoryContract.ViewModel mViewModel;

    public WalletIncomeHistoryPresenter(Context mContext, WalletIncomeHistoryContract.ViewModel mViewModel) {
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
        orderWallet.setCoinChange("+11");

        orderWallet.setTransactionTime("11:30 21/12/2018");
        orderWallet.setState(123);
        
        mList = new ArrayList<>();
        mList.add(orderWallet);
        mList.add(orderWallet);
        mList.add(orderWallet);
        mList.add(orderWallet);
        mList.add(orderWallet);
        mList.add(orderWallet);

        mViewModel.setOrderWalletList(mList);
    }
}
