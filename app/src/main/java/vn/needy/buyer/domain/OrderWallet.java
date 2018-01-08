package vn.needy.buyer.domain;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by lion on 08/01/2018.
 */

public class OrderWallet extends RealmObject {

    private long productId;
    private String title;
    private int state;
    private Date time;
    private int cointChange;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getCointChange() {
        return cointChange;
    }

    public void setCointChange(int cointChange) {
        this.cointChange = cointChange;
    }
}
