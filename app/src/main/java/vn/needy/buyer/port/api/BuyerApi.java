package vn.needy.buyer.port.api;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import vn.needy.buyer.port.message.RequestWrapper;
import vn.needy.buyer.port.message.ResponseWrapper;
import vn.needy.buyer.repository.remote.user.request.LoginReq;
import vn.needy.buyer.repository.remote.user.request.RegisterReq;
import vn.needy.buyer.repository.remote.user.request.ResetAccountReq;
import vn.needy.buyer.repository.remote.user.respone.LoginResp;
import vn.needy.buyer.repository.remote.user.respone.TokenResponse;

/**
 * Created by lion on 16/12/2017.
 */

public interface BuyerApi {
    @POST("v1/authentications")
    Observable<ResponseWrapper<LoginResp>> login(@Body RequestWrapper<LoginReq> request);

    @POST("v1/users")
    Observable<ResponseWrapper<TokenResponse>> register(@Body RequestWrapper<RegisterReq> request);

    @GET("v1/users/finds")
    Observable<ResponseWrapper> findUserExist(@Query("username") String phoneNumber);

    @POST("v1/users/resets")
    Observable<ResponseWrapper<TokenResponse>> resetPassword(@Query("username") String phoneNumber,
                                                             @Body RequestWrapper<ResetAccountReq> request);
//
//    @GET("v1/users/informations/details")
//    Observable<ResponseWrapper<UserInfoResponse>> getUserInformation();
//
//    @PUT("v1/users/informations/details")
//    Observable<ResponseWrapper> updateUserInformation(@Body RequestWrapper<UpdateUserInfoRequest> request);
}
