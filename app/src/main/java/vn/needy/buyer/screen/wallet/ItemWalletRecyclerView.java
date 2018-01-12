package vn.needy.buyer.screen.wallet;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import vn.needy.buyer.domain.OrderWallet;
import vn.needy.buyer.screen.BaseRecyclerViewAdapter;

/**
 * Created by minh_dai on 02/01/2018.
 */

public class ItemWalletRecyclerView extends BaseObservable {

    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> mItemClickListener;
    private OrderWallet mOrderWallet;

    public ItemWalletRecyclerView(OrderWallet orderWallet, BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
        this.mOrderWallet = orderWallet;
    }

    public void onProductCLick(){

    }

    @Bindable
    public String getTitleState() {
        return "Đã hoàn thành";
    }

    @Bindable
    public OrderWallet getOrderWallet() {
        return mOrderWallet;
    }
}
