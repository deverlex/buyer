package vn.needy.buyer.repository.local;

import android.util.Log;

import io.reactivex.ObservableEmitter;
import io.reactivex.functions.BiConsumer;
import io.realm.Realm;
import vn.needy.buyer.database.realm.RealmApi;
import vn.needy.buyer.database.sharedprf.SharedPrefsApi;
import vn.needy.buyer.database.sharedprf.SharedPrefsKey;
import vn.needy.buyer.domain.User;
import vn.needy.buyer.repository.UserData;

/**
 * Created by lion on 16/12/2017.
 */

public class UserDataLocal implements UserData.Local {
    private static final String TAG = UserDataLocal.class.getName();

    private SharedPrefsApi mPrefsApi;

    public UserDataLocal(SharedPrefsApi prefsApi) {
        mPrefsApi = prefsApi;
    }

    @Override
    public void saveUserSync(final User user) {
        RealmApi.getSync().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.insertOrUpdate(user);
                Log.w(TAG, "saveUserSync....................DONE");
            }
        });
    }

    @Override
    public void saveTokenSync(String token) {
        mPrefsApi.put(SharedPrefsKey.ACCESS_TOKEN, token);
    }

    @Override
    public void clearToken() {
        mPrefsApi.remove(SharedPrefsKey.ACCESS_TOKEN);
    }

    @Override
    public void clearAll() {
        mPrefsApi.clear();
        (new RealmApi()).transactionAsync(new BiConsumer<ObservableEmitter<? super Object>, Realm>() {
            @Override
            public void accept(ObservableEmitter<? super Object> observableEmitter, Realm realm) throws Exception {
                realm.deleteAll();
            }
        });
    }
}
