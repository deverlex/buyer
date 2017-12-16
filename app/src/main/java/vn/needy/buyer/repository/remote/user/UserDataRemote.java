package vn.needy.buyer.repository.remote.user;

import vn.needy.buyer.port.api.BuyerApi;
import vn.needy.buyer.repository.UserData;
import vn.needy.buyer.repository.remote.BaseDataRemote;

/**
 * Created by lion on 16/12/2017.
 */

public class UserDataRemote extends BaseDataRemote<BuyerApi> implements UserData.Remote {

    public UserDataRemote(BuyerApi api) {
        super(api);
    }

}
