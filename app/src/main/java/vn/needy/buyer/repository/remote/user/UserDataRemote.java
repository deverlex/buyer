package vn.needy.buyer.repository.remote.user;

import io.reactivex.Observable;
import vn.needy.buyer.port.api.BuyerApi;
import vn.needy.buyer.port.message.RequestWrapper;
import vn.needy.buyer.port.message.ResponseWrapper;
import vn.needy.buyer.repository.UserData;
import vn.needy.buyer.repository.remote.BaseDataRemote;
import vn.needy.buyer.repository.remote.user.request.LoginRequest;
import vn.needy.buyer.repository.remote.user.request.RegisterRequest;
import vn.needy.buyer.repository.remote.user.request.ResetAccountRequest;
import vn.needy.buyer.repository.remote.user.respone.LoginResponse;
import vn.needy.buyer.repository.remote.user.respone.TokenResponse;

/**
 * Created by lion on 16/12/2017.
 */

public class UserDataRemote extends BaseDataRemote<BuyerApi> implements UserData.Remote {

    public UserDataRemote(BuyerApi api) {
        super(api);
    }

    @Override
    public Observable<ResponseWrapper<LoginResponse>> login(LoginRequest request) {
        return mApi.login(new RequestWrapper<LoginRequest>().setData(request));
    }

    @Override
    public Observable<ResponseWrapper<TokenResponse>> register(RegisterRequest request) {
        return mApi.register(new RequestWrapper<RegisterRequest>().setData(request));
    }
    @Override
    public Observable<ResponseWrapper> findUserExist(String phoneNumber) {
        return mApi.findUserExist(phoneNumber);
    }

    @Override
    public Observable<ResponseWrapper<TokenResponse>> resetPassword(String phoneNumber, ResetAccountRequest request) {
        return mApi.resetPassword(phoneNumber, new RequestWrapper<ResetAccountRequest>().setData(request));
    }
}
