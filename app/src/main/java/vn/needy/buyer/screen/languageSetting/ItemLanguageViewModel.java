package vn.needy.buyer.screen.languageSetting;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import vn.needy.buyer.model.Language;
import vn.needy.buyer.screen.BaseRecyclerViewAdapter;
import vn.needy.buyer.screen.BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener;

/**
 * Created by minh_dai on 26/12/2017.
 */

public class ItemLanguageViewModel extends BaseObservable {

    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Object> mItemClickListener;
    private Language mLanguage;
    private boolean isChecked;

    public ItemLanguageViewModel(Language mLanguage,
         OnRecyclerViewItemClickListener<Object> mItemClickListener, boolean isChecked) {
        this.mLanguage = mLanguage;
        this.mItemClickListener = mItemClickListener;
        this.isChecked = isChecked;
    }

    public void onItemClicked() {
        if (mItemClickListener == null) {
            return;
        }
        mItemClickListener.onItemRecyclerViewClick(mLanguage);
    }

    @Bindable
    public Language getLanguage() {
        return mLanguage;
    }

    @Bindable
    public boolean isChecked() {
        return isChecked;
    }
}
