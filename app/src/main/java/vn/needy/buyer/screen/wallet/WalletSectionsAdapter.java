package vn.needy.buyer.screen.wallet;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import vn.needy.buyer.R;
import vn.needy.buyer.screen.wallet.historyIncome.WalletHistoryIncomeFragment;
import vn.needy.buyer.screen.wallet.historyPurchase.WalletHistoryPurchaseFragment;
import vn.needy.buyer.screen.wallet.historyTransaction.WalletHistoryTransactionFragment;

/**
 * Created by minh_dai on 02/01/2018.
 */

public class WalletSectionsAdapter extends FragmentPagerAdapter{

        private static final int mPersonalHistoryIncome = 0;
        private static final int mPersonalHistoryPurchase = 1;
        private static final int mPersonalHistoryTransaction = 2;

        private final int[] TABS = new int[]{mPersonalHistoryIncome, mPersonalHistoryPurchase, mPersonalHistoryTransaction};

        private Context mContext;

        public WalletSectionsAdapter(final Context context, final FragmentManager fm) {
            super(fm);
            mContext = context.getApplicationContext();
        }

        @Override
        public Fragment getItem(int position) {
            switch (TABS[position]) {

                case mPersonalHistoryIncome:
                    return WalletHistoryIncomeFragment.getInstance();
                case mPersonalHistoryPurchase:
                    return WalletHistoryPurchaseFragment.getInstance();
                case mPersonalHistoryTransaction:
                    return WalletHistoryTransactionFragment.getInstance();
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
                case mPersonalHistoryIncome:
                    return mContext.getResources().getString(R.string.personal_history_income);
                case mPersonalHistoryPurchase:
                    return mContext.getResources().getString(R.string.personal_history_Purchase);
                case mPersonalHistoryTransaction:
                    return mContext.getResources().getString(R.string.personal_history_Transaction);
            }
            return null;
        }

}
