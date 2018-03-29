package vn.needy.buyer;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import vn.needy.buyer.database.realm.DataLocalMigration;
import vn.needy.buyer.database.sharedprf.SharedPrefsImpl;
import vn.needy.buyer.port.service.BuyerServiceClient;

/**
 * Created by lion on 16/12/2017.
 */

public class BuyerApplication extends Application {
    private static final String REALM_SCHEMA_NAME = "buyer.realm";
    private static final int REALM_SCHEMA_VERSION = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPrefsImpl.initialize(this);
        BuyerServiceClient.initialize(this);
        // migrate realm
        initAndMigrateRealmIfNeeded();
    }

    private void initAndMigrateRealmIfNeeded() {
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name(REALM_SCHEMA_NAME)
                .schemaVersion(REALM_SCHEMA_VERSION)
                .migration(new DataLocalMigration())
                .build();
        Realm.setDefaultConfiguration(config);
        Realm realm = Realm.getDefaultInstance(); // Automatically run migration if needed
        realm.close();
    }
}
