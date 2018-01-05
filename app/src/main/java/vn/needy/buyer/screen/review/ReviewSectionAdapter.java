package vn.needy.buyer.screen.review;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import vn.needy.buyer.R;
import vn.needy.buyer.screen.review.buyer.ReviewBuyerFragment;
import vn.needy.buyer.screen.review.vendor.ReviewVendorFragment;
import vn.needy.buyer.screen.wallet.historyIncome.WalletHistoryIncomeFragment;
import vn.needy.buyer.screen.wallet.historyPurchase.WalletHistoryPurchaseFragment;
import vn.needy.buyer.screen.wallet.historyTransaction.WalletHistoryTransactionFragment;

/**
 * Created by minh_dai on 03/01/2018.
 */

public class ReviewSectionAdapter extends FragmentPagerAdapter {

    private static final int CONTACTS = 0;
    private static final int CALLS = 1;

    private final int[] TABS = new int[]{CONTACTS, CALLS };

    private Context mContext;

    public ReviewSectionAdapter(final Context context, final FragmentManager fm) {
        super(fm);
        mContext = context.getApplicationContext();
    }

    @Override
    public Fragment getItem(int position) {
        switch (TABS[position]) {

            case CONTACTS:
                return ReviewBuyerFragment.getInstance();
            case CALLS:
                return ReviewVendorFragment.getInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return TABS.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (TABS[position]) {
            case CONTACTS:
                return mContext.getResources().getString(R.string.review_buyer);
            case CALLS:
                return mContext.getResources().getString(R.string.review_vendor);
        }
        return null;
    }

}