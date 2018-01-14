package vn.needy.buyer.domain;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import vn.needy.buyer.repository.remote.user.context.UserContext;

/**
 * Created by lion on 16/12/2017.
 */

public class User extends RealmObject {

    @PrimaryKey
    private String mId;
    private int mState;
    private String mFullName;
    private String mGender;
    private String mAddress;
    private String mEmail;
    private String mBirthday;
    private float mLat;
    private float mLng;
    private String mCreatedTime;
    private String mLastUpdatedTime;
    private String mLastResetPassword;

    public User() {
        super();
    }

    public User(UserContext userContext) {
        mId = userContext.getId();
        mState = userContext.getState();
        mFullName = userContext.getFullName();
        mGender = userContext.getGender();
        mAddress = userContext.getAddress();
        mEmail = userContext.getEmail();
        mBirthday = userContext.getBirthday();
        mLat = userContext.getLat();
        mLng = userContext.getLng();
        mCreatedTime = userContext.getCreatedTime();
        mLastUpdatedTime = userContext.getLastUpdatedTime();
        mLastResetPassword = userContext.getLastResetPassword();
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public int getState() {
        return mState;
    }

    public void setState(int state) {
        mState = state;
    }

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public String getGender() {
        return mGender;
    }

    public void setGender(String gender) {
        mGender = gender;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getBirthday() {
        return mBirthday;
    }

    public void setBirthday(String birthday) {
        mBirthday = birthday;
    }

    public float getLat() {
        return mLat;
    }

    public void setLat(float lat) {
        mLat = lat;
    }

    public float getLng() {
        return mLng;
    }

    public void setLng(float lng) {
        mLng = lng;
    }

    public String getCreatedTime() {
        return mCreatedTime;
    }

    public void setCreatedTime(String createdTime) {
        mCreatedTime = createdTime;
    }

    public String getLastUpdatedTime() {
        return mLastUpdatedTime;
    }

    public void setLastUpdatedTime(String lastUpdatedTime) {
        mLastUpdatedTime = lastUpdatedTime;
    }

    public String getLastResetPassword() {
        return mLastResetPassword;
    }

    public void setLastResetPassword(String lastResetPassword) {
        mLastResetPassword = lastResetPassword;
    }
}
