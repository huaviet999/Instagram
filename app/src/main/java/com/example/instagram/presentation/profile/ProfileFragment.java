package com.example.instagram.presentation.profile;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.instagram.R;
import com.example.instagram.presentation.base.BaseFragment;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

/**
 * Create by Viet Hua on 2/14/2020
 */
public class ProfileFragment extends BaseFragment implements ProfileContract.View {

    public static final String TAG = ProfileFragment.class.getSimpleName();

    public static ProfileFragment getInstance() {
        ProfileFragment fragment = new ProfileFragment();
        Bundle data = new Bundle();
        fragment.setArguments(data);
        return fragment;
    }

    @Inject
    ProfileContract.Presenter presenter;
    Context mContext;

    @Override
    protected void onAttachToContext(Context context) {
        mContext = context;
    }

    @Override
    protected int getResLayoutId() {
        return R.layout.fragment_profile;
    }


    @Override
    protected void onMyCreateView(View view) {
        presenter.takeView(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidSupportInjection.inject(this);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dropView();
    }
}
