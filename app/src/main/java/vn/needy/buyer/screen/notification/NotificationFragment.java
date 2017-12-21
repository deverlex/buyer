package vn.needy.buyer.screen.notification;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import vn.needy.buyer.R;
import vn.needy.buyer.databinding.FragmentNotificationBinding;
import vn.needy.buyer.model.Notification;

/**
 * Created by lion on 16/12/2017.
 */

public class NotificationFragment extends Fragment {
    public static NotificationFragment newInstance() {

        Bundle args = new Bundle();

        NotificationFragment fragment = new NotificationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private NotificationContract.ViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentNotificationBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_notification, container, false);

        List<Notification> notifications = new ArrayList<>();
        NotificationAdapter adapter = new NotificationAdapter(getActivity(), notifications);

        mViewModel = new NotificationViewModel(getActivity(), adapter);
        NotificationContract.Presenter presenter = new NotificationPresenter(mViewModel);
        mViewModel.setPresenter(presenter);
        mViewModel.onStart();

        binding.setViewModel((NotificationViewModel) mViewModel);

        return binding.getRoot();
    }
}
