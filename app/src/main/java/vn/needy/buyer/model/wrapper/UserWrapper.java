package vn.needy.buyer.model.wrapper;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by lion on 16/12/2017.
 */

public class UserWrapper {

    @SerializedName("id")
    @Expose
    private String mId;
    @SerializedName("state")
    @Expose
    private int mState;
    @SerializedName("fullName")
    @Expose
    private String mFullName;
    @SerializedName("gender")
    @Expose
    private String mGender;
    @SerializedName("address")
    @Expose
    private String mAddress;
    @SerializedName("email")
    @Expose
    private String mEmail;
    @SerializedName("birthday")
    @Expose
    private String mBirthday;
    @SerializedName("lat")
    @Expose
    private float mLat;
    @SerializedName("lng")
    @Expose
    private float mLng;
    @SerializedName("createdTime")
    @Expose
    private String mCreatedTime;
    @SerializedName("lastUpdatedTime")
    @Expose
    private String mLastUpdatedTime;
    @SerializedName("lastResetPassword")
    @Expose
    private String mLastResetPassword;
}
