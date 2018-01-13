package vn.needy.buyer.domain;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by lion on 08/01/2018.
 */

public class OrderWallet extends RealmObject {

    private long mProductId;
    private String mTitle;
    private int mState;
    private String mTransactionTime;
    private String mCoinChange;

    public long getProductId() {
        return mProductId;
    }

    public void setProductId(long productId) {
        mProductId = productId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public int getState() {
        return mState;
    }

    public void setState(int state) {
        mState = state;
    }

    public String getTransactionTime() {
        return mTransactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        mTransactionTime = transactionTime;
    }

    public String getCoinChange() {
        return mCoinChange;
    }

    public void setCoinChange(String coinChange) {
        mCoinChange = coinChange;
    }
}
