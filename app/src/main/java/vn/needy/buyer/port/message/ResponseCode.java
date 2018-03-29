package vn.needy.buyer.port.message;

import android.support.annotation.IntDef;

/**
 * Created by lion on 16/12/2017.
 */

@IntDef({ResponseCode.OK, ResponseCode.BAD_REQUEST, ResponseCode.NOT_FOUND,
        ResponseCode.UNAUTHORIZED, ResponseCode.NOT_IMPLEMENTED
})
public @interface ResponseCode {
    int OK = 200;
    int BAD_REQUEST = 400;
    int NOT_FOUND = 404;
    int ACCESS_DENIED = 403;
    int UNAUTHORIZED = 401;
    int NOT_IMPLEMENTED = 500;
}
