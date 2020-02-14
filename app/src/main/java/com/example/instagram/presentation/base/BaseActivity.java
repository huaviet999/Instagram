package com.example.instagram.presentation.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import utils.AndroidDialogUtils;

/**
 * Created by Viet Hua on 2/14/2020
 */
public abstract class BaseActivity extends AppCompatActivity implements HasAndroidInjector {
    private static final String TAG = BaseActivity.class.getSimpleName();
    @Inject
    DispatchingAndroidInjector<Object> androidInjector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResLayoutId());
        getApplicationContext();

    }

    Unbinder mUnbinder;

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        mUnbinder = ButterKnife.bind(this);
    }

    protected abstract int getResLayoutId();

    @Override
    public AndroidInjector<Object> androidInjector() {
        return androidInjector;
    }


    //Show toast message
    public void showToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    //Show Sweet Dialog
    public void showSuccessMessage(String message) {
        AndroidDialogUtils.getInstance().showSuccessSweetAlertDialog(this, message);
    }

    public void showErrorMessage(String message) {
        AndroidDialogUtils.getInstance().showErrorSweetAlertDialog(this, message);
    }

    public void showLoadingMessage(String message) {
        AndroidDialogUtils.getInstance().showLoadingSweetAlertDialog(this, message);
    }

    public void showWarningMessage(String message) {
        AndroidDialogUtils.getInstance().showWarningSweetAlertDialog(this, message);
    }
}
