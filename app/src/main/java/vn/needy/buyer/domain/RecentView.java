package vn.needy.buyer.domain;

import io.realm.RealmObject;
import vn.needy.buyer.model.Image;

/**
 * Created by lion on 08/01/2018.
 */

public class RecentView extends RealmObject {

    private long product_id;
    private String name;
    private int liked;
    private float rating;
    private int voted;
    private String timeView;

    public RecentView() {
        super();
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLiked() {
        return liked;
    }

    public void setLiked(int liked) {
        this.liked = liked;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getVoted() {
        return voted;
    }

    public void setVoted(int voted) {
        this.voted = voted;
    }

    public String getTimeView() {
        return timeView;
    }

    public void setTimeView(String timeView) {
        this.timeView = timeView;
    }
}
