package vn.needy.buyer.model;

import com.google.gson.Gson;

/**
 * Created by lion on 16/12/2017.
 */

public abstract class BaseModel implements Cloneable {

    public BaseModel clone() throws CloneNotSupportedException {
        Gson gson = new Gson();
        return gson.fromJson(gson.toJson(this), this.getClass());
    }
}
