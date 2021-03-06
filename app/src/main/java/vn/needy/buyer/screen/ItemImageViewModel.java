package vn.needy.buyer.screen;

/**
 * Created by lion on 16/12/2017.
 */

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import vn.needy.buyer.model.Image;

/**
 * Created by lion on 08/11/2017.
 */
public class ItemImageViewModel extends BaseObservable {

    private static final String TAG = ItemImageViewModel.class.getName();

    private final Image mImage;
    private final BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object>
            mItemClickListener;

    public ItemImageViewModel(Image image,
                              BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> listener) {
        mImage = image;
        mItemClickListener = listener;
    }

    @Bindable
    public String getImageUri() {
        if (mImage != null && mImage.getUri().contains("http")) {
            return mImage.getUri();
        } else if (mImage != null) {
            return mImage.getPath();
        }
        return "";
    }

    public void onItemClicked() {
        if (mItemClickListener == null) {
            return;
        }
        mItemClickListener.onItemRecyclerViewClick(mImage);
    }
}
