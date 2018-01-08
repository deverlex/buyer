package vn.needy.buyer.screen.personal;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.needy.buyer.R;
import vn.needy.buyer.databinding.FragmentPersonalBinding;
import vn.needy.buyer.utils.navigator.Navigator;

/**
 * Created by truongpq on 20/12/2017.
 */

public class PersonalFragment extends Fragment{
    public static PersonalFragment newInstance() {

        Bundle args = new Bundle();

        PersonalFragment fragment = new PersonalFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private PersonalContract.ViewModel mViewModel;
    private PersonalContract.Presenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Navigator mNavigator = new Navigator(this);
        mViewModel = new PersonalViewModel(getActivity() , mNavigator);
        mPresenter = new PersonalPresenter();

        FragmentPersonalBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_personal, container, false);
        binding.setViewModel((PersonalViewModel) mViewModel);

        return binding.getRoot();
    }
}
