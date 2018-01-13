package vn.needy.buyer.screen.wallet;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import vn.needy.buyer.R;
import vn.needy.buyer.screen.wallet.historyIncome.WalletIncomeHistoryFragment;
import vn.needy.buyer.screen.wallet.historyPurchase.WalletPurchaseHistoryFragment;
import vn.needy.buyer.screen.wallet.historyTransaction.WalletTransactionHistoryFragment;

/**
 * Created by minh_dai on 02/01/2018.
 */

public class WalletSectionsAdapter extends FragmentPagerAdapter{

        private static final int mIncomeHistory = 0;
        private static final int mPurchaseHistory = 1;
        private static final int mTransactionHistory = 2;

        private final int[] TABS = new int[]{mIncomeHistory, mPurchaseHistory, mTransactionHistory};

        private Context mContext;

        public WalletSectionsAdapter(final Context context, final FragmentManager fm) {
            super(fm);
            mContext = context.getApplicationContext();
        }

        @Override
        public Fragment getItem(int position) {
            switch (TABS[position]) {

                case mIncomeHistory:
                    return WalletIncomeHistoryFragment.getInstance();
                case mPurchaseHistory:
                    return WalletPurchaseHistoryFragment.getInstance();
                case mTransactionHistory:
                    return WalletTransactionHistoryFragment.getInstance();
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
                case mIncomeHistory:
                    return mContext.getResources().getString(R.string.personal_history_income);
                case mPurchaseHistory:
                    return mContext.getResources().getString(R.string.personal_history_Purchase);
                case mTransactionHistory:
                    return mContext.getResources().getString(R.string.personal_history_Transaction);
            }
            return null;
        }

}
