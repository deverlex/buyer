package vn.needy.buyer.repository.remote.user.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import vn.needy.buyer.port.message.DataMessage;

/**
 * Created by lion on 14/10/2017.
 */

public class RegisterRequest extends DataMessage {

    @Expose
    @SerializedName("firebaseUid")
    private String mFirebaseUid;
    @Expose
    @SerializedName("firebaseToken")
    private String mFirebaseToken;
    @Expose
    @SerializedName("username")
    private String mPhoneNumber;
    @Expose
    @SerializedName("password")
    private String mPassword;

    public RegisterRequest() {
        super();
    }

    public String getFirebaseUid() {
        return mFirebaseUid;
    }

    public void setFirebaseUid(String firebaseUid) {
        mFirebaseUid = firebaseUid;
    }

    public String getFirebaseToken() {
        return mFirebaseToken;
    }

    public void setFirebaseToken(String firebaseToken) {
        mFirebaseToken = firebaseToken;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.mPhoneNumber = phoneNumber;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        this.mPassword = password;
    }

}
