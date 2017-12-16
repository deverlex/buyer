package vn.needy.buyer.port.service;

import android.app.Application;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import vn.needy.buyer.database.sharedprf.SharedPrefsApi;
import vn.needy.buyer.database.sharedprf.SharedPrefsImpl;
import vn.needy.buyer.database.sharedprf.SharedPrefsKey;
import vn.needy.buyer.port.ServiceClient;
import vn.needy.buyer.port.api.BuyerApi;
import vn.needy.buyer.port.middleware.RetrofitInterceptor;
import vn.needy.buyer.utils.Constant;

/**
 * Created by lion on 16/12/2017.
 */

public class BuyerServiceClient extends ServiceClient {

    private static BuyerApi mVendorApi;

    public static BuyerApi initialize(@NonNull Application application) {
        SharedPrefsApi prefsApi = SharedPrefsImpl.getInstance();
        String token = prefsApi.get(SharedPrefsKey.TOKEN_KEY, String.class);
        RetrofitInterceptor interceptor = null;
        if (!TextUtils.isEmpty(token)) {
            interceptor = new RetrofitInterceptor(token);
        }
        mVendorApi = createService(application, Constant.API_END_POINT_URL, BuyerApi.class, interceptor);
        return mVendorApi;
    }

    public static BuyerApi getInstance() {
        if (mVendorApi == null) {
            throw new RuntimeException("Need call method FOrderServiceClient#initialize() first");
        }
        return mVendorApi;
    }

}
