package vn.needy.buyer.model;

import io.realm.annotations.PrimaryKey;

/**
 * Created by truongpq on 20/12/2017.
 */

public class Category {
    @PrimaryKey
    private String mName;
    private String mTitle;

    public Category() {
        super();
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }
}
