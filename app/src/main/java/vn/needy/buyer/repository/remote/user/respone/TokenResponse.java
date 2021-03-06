package vn.needy.buyer.repository.remote.user.respone;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import vn.needy.buyer.port.message.DataMessage;

/**
 * Created by lion on 15/10/2017.
 */

public class TokenResponse extends DataMessage {

    @Expose
    @SerializedName("token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
