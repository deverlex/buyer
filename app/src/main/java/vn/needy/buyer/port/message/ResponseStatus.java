package vn.needy.buyer.port.message;

import android.support.annotation.StringDef;

/**
 * Created by lion on 16/12/2017.
 */

@StringDef({ResponseStatus.OK, ResponseStatus.ERROR})
public @interface ResponseStatus {
    String OK = "ok";
    String ERROR = "error";
}
