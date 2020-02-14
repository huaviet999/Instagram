package com.example.instagram.presentation.search;

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

import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;

/**
 * Created by Viet Hua on 2/14/2020
 */
public class SearchFragment extends BaseFragment implements SearchContract.View {
    public static final String TAG = SearchFragment.class.getSimpleName();
    @Inject
    SearchContract.Presenter presenter;
    Context mContext;

    public static SearchFragment getInstance() {
        SearchFragment searchFragment = new SearchFragment();
        Bundle data = new Bundle();
        searchFragment.setArguments(data);
        return searchFragment;
    }

    @Override
    protected void onAttachToContext(Context context) {
        mContext = context;
    }

    @Override
    protected int getResLayoutId() {
        return R.layout.fragment_search;
    }


    @Override
    protected void onMyCreateView(View view) {
        presenter.takeView(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidSupportInjection.inject(this);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dropView();
    }
}
