package vn.needy.buyer.repository;

import io.reactivex.Observable;
import vn.needy.buyer.domain.User;
import vn.needy.buyer.port.message.ResponseWrapper;
import vn.needy.buyer.repository.remote.user.request.LoginRequest;
import vn.needy.buyer.repository.remote.user.request.RegisterRequest;
import vn.needy.buyer.repository.remote.user.request.ResetAccountRequest;
import vn.needy.buyer.repository.remote.user.respone.LoginResponse;
import vn.needy.buyer.repository.remote.user.respone.TokenResponse;

/**
 * Created by lion on 16/12/2017.
 */

public interface UserData {
    interface Remote {
        Observable<ResponseWrapper<LoginResponse>> login(LoginRequest request);

        Observable<ResponseWrapper<TokenResponse>> register(RegisterRequest request);

        Observable<ResponseWrapper> findUserExist(String phoneNumber);

        Observable<ResponseWrapper<TokenResponse>> resetPassword(String phoneNumber, ResetAccountRequest request);
    }

    interface Local {
        void saveUserSync(User user);

        void saveTokenSync(String token);

        void clearToken();

        void clearAll();
    }
}
