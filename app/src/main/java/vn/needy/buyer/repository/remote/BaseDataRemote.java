package vn.needy.buyer.repository.remote;

/**
 * Created by lion on 16/12/2017.
 */

public abstract class BaseDataRemote<T> {

    protected T mApi;

    public BaseDataRemote(T api) {
        mApi = api;
    }
}
