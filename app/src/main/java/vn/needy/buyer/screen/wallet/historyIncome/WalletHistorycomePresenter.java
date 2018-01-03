package vn.needy.buyer.screen.wallet.historyIncome;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import vn.needy.buyer.R;
import vn.needy.buyer.screen.wallet.WalletActivity;
import vn.needy.buyer.screen.wallet.WalletContract;

/**
 * Created by minh_dai on 02/01/2018.
 */

public class WalletHistorycomePresenter implements WalletHistoryIncomeContract.Presenter {

    private Context mContext;
    private WalletHistoryIncomeContract.ViewModel mViewModel;

    public WalletHistorycomePresenter(Context mContext, WalletHistoryIncomeContract.ViewModel mViewModel) {
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
