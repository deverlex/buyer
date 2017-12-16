package vn.needy.buyer.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

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
}
