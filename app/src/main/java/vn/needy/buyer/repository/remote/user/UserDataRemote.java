package vn.needy.buyer.repository.remote.user;

import io.reactivex.Observable;
import vn.needy.buyer.port.api.BuyerApi;
import vn.needy.buyer.port.message.RequestWrapper;
import vn.needy.buyer.port.message.ResponseWrapper;
import vn.needy.buyer.repository.UserData;
import vn.needy.buyer.repository.remote.BaseDataRemote;
import vn.needy.buyer.repository.remote.user.request.LoginReq;
import vn.needy.buyer.repository.remote.user.request.RegisterReq;
import vn.needy.buyer.repository.remote.user.request.ResetAccountReq;
import vn.needy.buyer.repository.remote.user.respone.LoginResp;
import vn.needy.buyer.repository.remote.user.respone.TokenResponse;

/**
 * Created by lion on 16/12/2017.
 */

public class UserDataRemote extends BaseDataRemote<BuyerApi> implements UserData.Remote {

    public UserDataRemote(BuyerApi api) {
        super(api);
    }

    @Override
    public Observable<ResponseWrapper<LoginResp>> login(LoginReq request) {
        return mApi.login(new RequestWrapper<LoginReq>().setData(request));
    }

    @Override
    public Observable<ResponseWrapper<TokenResponse>> register(RegisterReq request) {
        return mApi.register(new RequestWrapper<RegisterReq>().setData(request));
    }
    @Override
    public Observable<ResponseWrapper> findUserExist(String phoneNumber) {
        return mApi.findUserExist(phoneNumber);
    }

    @Override
    public Observable<ResponseWrapper<TokenResponse>> resetPassword(String phoneNumber, ResetAccountReq request) {
        return mApi.resetPassword(phoneNumber, new RequestWrapper<ResetAccountReq>().setData(request));
    }
}
