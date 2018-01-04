package vn.needy.buyer.screen.wallet.historyPurchase;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

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
        List<WalletActivity.Cargo> mList;
        WalletActivity.Cargo cargo = new WalletActivity.Cargo("Set 10 đôi tất Uni cổ thấp loại đẹp"
                , "Đã hoàn thành" ,"30-12-2018 14:02"
                ,  "+11");

        mList = new ArrayList<>();
        mList.add(cargo);
        mList.add(cargo);
        mList.add(cargo);
        mList.add(cargo);
        mList.add(cargo);
        mList.add(cargo);

        mViewModel.getCargoList(mList);
    }
}
