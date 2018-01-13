package vn.needy.buyer.screen.review.buyer;

import vn.needy.buyer.screen.BasePresenter;
import vn.needy.buyer.screen.BaseViewModel;

/**
 * Created by minh_dai on 03/01/2018.
 */

public interface ReviewBuyerContract {

    interface ViewModel extends BaseViewModel<Presenter>{

        void onViewReviewByRatingClicked(int item);
    }

    interface Presenter extends BasePresenter{

    }

}
