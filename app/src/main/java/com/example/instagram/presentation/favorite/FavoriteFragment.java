package com.example.instagram.presentation.favorite;

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
 * Created by Viet Hua on 2/14/2020
 */
public class FavoriteFragment extends BaseFragment implements FavoriteContract.View {
    public static final String TAG = FavoriteFragment.class.getSimpleName();
    public static FavoriteFragment getInstance(){
        FavoriteFragment fragment = new FavoriteFragment();
        Bundle data = new Bundle();
        fragment.setArguments(data);
        return fragment;
    }
    @Inject
    FavoriteContract.Presenter presenter;
    Context mContext;

    @Override
    protected void onAttachToContext(Context context) {
        mContext = context;
    }

    @Override
    protected int getResLayoutId() {
        return R.layout.fragment_favorite;
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
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_bottom_navigation,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dropView();
    }
}
