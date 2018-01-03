package vn.needy.buyer.screen.wallet.historyPurchase;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import vn.needy.buyer.R;
import vn.needy.buyer.screen.wallet.WalletActivity;
import vn.needy.buyer.screen.wallet.historyIncome.WalletHistoryIncomeContract;

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
        List<WalletActivity.Product> mList;
        WalletActivity.Product product = new WalletActivity.Product(mContext.getString(R.string.personal_buy)
                , mContext.getString(R.string.personal_complete) ,mContext.getString(R.string.personal_date_buy)
                ,  mContext.getString(R.string.personal_number_buy));

        mList = new ArrayList<>();
        mList.add(product);
        mList.add(product);
        mList.add(product);
        mList.add(product);
        mList.add(product);
        mList.add(product);

        mViewModel.getProductList(mList);
    }
}
