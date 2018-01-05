package vn.needy.buyer.screen.review.vendor;

import android.widget.TextView;

import vn.needy.buyer.screen.BasePresenter;
import vn.needy.buyer.screen.BaseViewModel;

/**
 * Created by minh_dai on 03/01/2018.
 */

public interface ReviewVendorContract {

    interface ViewModel extends BaseViewModel<Presenter>{

        void onViewReviewByRatingClicked(TextView view);

        void onPersonalCommentClick();

    }

    interface Presenter extends BasePresenter{

    }

}
