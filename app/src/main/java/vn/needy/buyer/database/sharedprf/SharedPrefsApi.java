package vn.needy.buyer.database.sharedprf;

/**
 * Created by lion on 16/12/2017.
 */

public interface SharedPrefsApi {
    <T> T get(String key, Class<T> clazz);

    <T> void put(String key, T data);

    <T> T getObject(String key, Class<T> clazz);

    <T> void putObject(String key, T data);

    void remove(String key);

    void clear();
}
