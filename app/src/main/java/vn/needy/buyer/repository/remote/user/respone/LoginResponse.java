package vn.needy.buyer.repository.remote.user.respone;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import vn.needy.buyer.port.wrapper.UserWrapper;


/**
 * Created by lion on 11/12/2017.
 */

public class LoginResponse {

    @Expose
    @SerializedName("user")
    private UserWrapper mUser;
    @Expose
    @SerializedName("token")
    private String mToken;

    public UserWrapper getUser() {
        return mUser;
    }

    public void setUser(UserWrapper user) {
        mUser = user;
    }

    public String getToken() {
        return mToken;
    }

    public void setToken(String token) {
        mToken = token;
    }
}