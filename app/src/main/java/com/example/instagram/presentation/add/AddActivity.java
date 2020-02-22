package com.example.instagram.presentation.add;

import android.content.Intent;
import android.os.Bundle;

import com.example.instagram.R;
import com.example.instagram.presentation.base.BaseActivity;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import dagger.android.AndroidInjection;

/**
 * Created by Viet Hua on 2/22/2020
 */
public class AddActivity extends BaseActivity implements AddContract.View {
    private static final String TAG = AddActivity.class.getSimpleName();

    public static void showAddActivity(AppCompatActivity activity) {
        Intent intent = new Intent(activity, AddActivity.class);
        activity.startActivity(intent);
    }

    @Inject
    AddContract.Presenter presenter;

    @Override
    protected int getResLayoutId() {
        return R.layout.activity_add;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.takeView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dropView();
    }
}
