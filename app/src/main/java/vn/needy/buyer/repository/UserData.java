package vn.needy.buyer.repository;

import io.reactivex.Observable;
import vn.needy.buyer.model.User;
import vn.needy.buyer.port.message.ResponseWrapper;
import vn.needy.buyer.repository.remote.user.request.LoginReq;
import vn.needy.buyer.repository.remote.user.request.RegisterReq;
import vn.needy.buyer.repository.remote.user.request.ResetAccountReq;
import vn.needy.buyer.repository.remote.user.respone.LoginResp;
import vn.needy.buyer.repository.remote.user.respone.TokenResponse;

/**
 * Created by lion on 16/12/2017.
 */

public interface UserData {
    interface Remote {
        Observable<ResponseWrapper<LoginResp>> login(LoginReq request);

        Observable<ResponseWrapper<TokenResponse>> register(RegisterReq request);

        Observable<ResponseWrapper> findUserExist(String phoneNumber);

        Observable<ResponseWrapper<TokenResponse>> resetPassword(String phoneNumber, ResetAccountReq request);
    }

    interface Local {
        void saveUserSync(User user);

        void saveTokenSync(String token);

        void clearToken();

        void clearAll();
    }
}
