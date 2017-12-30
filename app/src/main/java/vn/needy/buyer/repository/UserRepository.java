package vn.needy.buyer.repository;

import io.reactivex.Observable;
import vn.needy.buyer.domain.User;
import vn.needy.buyer.port.message.ResponseWrapper;
import vn.needy.buyer.repository.remote.user.request.LoginReq;
import vn.needy.buyer.repository.remote.user.request.RegisterReq;
import vn.needy.buyer.repository.remote.user.request.ResetAccountReq;
import vn.needy.buyer.repository.remote.user.respone.LoginResp;
import vn.needy.buyer.repository.remote.user.respone.TokenResponse;

/**
 * Created by lion on 16/12/2017.
 */

public class UserRepository {
    private UserData.Local mLocal;
    private UserData.Remote mRemote;

    public UserRepository(UserData.Remote remote, UserData.Local local) {
        mRemote = remote;
        mLocal = local;
    }

    public Observable<ResponseWrapper<TokenResponse>> registerUser(RegisterReq request) {
        return mRemote.register(request);
    }

    public Observable<ResponseWrapper<LoginResp>> login(LoginReq request) {
        return mRemote.login(request);
    }

    public Observable<ResponseWrapper> findUserExist(String phoneNumber) {
        return mRemote.findUserExist(phoneNumber);
    }

    public Observable<ResponseWrapper<TokenResponse>> resetPassword(String phoneNumber, ResetAccountReq request) {
        return mRemote.resetPassword(phoneNumber, request);
    }

    public void saveUserSync(User user) {
        mLocal.saveUserSync(user);
    }

    public void saveTokenSync(String token) {
        mLocal.saveTokenSync(token);
    }
}
