package vn.needy.buyer.repository.remote.user.respone;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import vn.needy.buyer.port.message.DataMessage;
import vn.needy.buyer.repository.remote.user.context.UserContext;


/**
 * Created by lion on 11/12/2017.
 */

public class LoginResponse extends DataMessage {

    @Expose
    @SerializedName("user")
    private UserContext mUser;
    @Expose
    @SerializedName("token")
    private String mToken;

    public UserContext getUser() {
        return mUser;
    }

    public void setUser(UserContext user) {
        mUser = user;
    }

    public String getToken() {
        return mToken;
    }

    public void setToken(String token) {
        mToken = token;
    }
}
