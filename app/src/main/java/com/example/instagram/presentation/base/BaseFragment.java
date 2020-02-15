package com.example.instagram.presentation.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.HasAndroidInjector;

/**
 * Created by Viet Hua on 2/14/2020
 */
public abstract class BaseFragment extends Fragment {
    private static final String TAG = BaseFragment.class.getSimpleName();
    private Unbinder unbinder;
    protected Context mContext;

    @TargetApi(23)
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onAttachToContext(context);
        mContext = context;
    }

    /**
     * deprecated on API 23
     * use onAttachToContext instead
     *
     * @param activity
     */
    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (Build.VERSION.SDK_INT < 23) {
            onAttachToContext(activity);
            mContext = activity;
        }
    }

    protected abstract void onAttachToContext(Context context);


    protected abstract int getResLayoutId();

    protected abstract void onMyCreateView(View view);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getResLayoutId(), container, false);
        unbinder = ButterKnife.bind(this,view);
        onMyCreateView(view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    public void showProgressDialog(){

    }
    public void hideProgressDialog(){

    }
    public void showFWarningMessage(String message) {
        Activity act = getActivity();
        if (act instanceof BaseActivity) {
            ((BaseActivity) act).showToastMessage(message);
        }
    }

    public void showFWarningDialog(String msg) {
        Activity act = getActivity();
        if (act instanceof BaseActivity) {
            ((BaseActivity) act).showWarningMessage(msg);
        }
    }

    public void alertErrors(String title, String msg, int type) {
        Activity act = getActivity();
        if (act instanceof BaseActivity) {
            switch (type){
                case SweetAlertDialog.SUCCESS_TYPE:
                    ((BaseActivity) act).showSuccessMessage(msg);
                    break;
                case SweetAlertDialog.PROGRESS_TYPE:
                    ((BaseActivity) act).showLoadingMessage(msg);
                    break;
            }

        }
    }

    public void RB_hideDialog() {
        Activity act = getActivity();

        if (act instanceof BaseActivity) {
            ((BaseActivity) act).dismissSweetAlertDialog();

        }
    }
    // theredbean
    public void RB_Succeess_MSg(String msg) {
        Activity act = getActivity();
        if (act instanceof BaseActivity) {
            ((BaseActivity) act).showSuccessMessage(msg);
        }
    }

    public void RB_Error_MSg(String msg) {
        Activity act = getActivity();
        if (act instanceof BaseActivity) {
            ((BaseActivity) act).showErrorMessage(msg);
        }
    }

    public void RB_Loading_MSg(String msg) {
        Activity act = getActivity();
        if (act instanceof BaseActivity) {
            ((BaseActivity) act).showLoadingMessage(msg);
        }
    }

    public void RB_Warning_MSg(String msg) {
        Activity act = getActivity();
        if (act instanceof BaseActivity) {
            ((BaseActivity) act).showWarningMessage(msg);
        }
    }


    //
    public void showMessage(String message) {
        alertErrors(message, message, SweetAlertDialog.SUCCESS_TYPE);
    }

    public void showLoading() {
        RB_Loading_MSg("");
    }

    public void showLoading(String msg) {
        RB_Loading_MSg(msg);
    }

    public void hideLoading() {
        RB_hideDialog();
    }

    public void showAlertDialog(String msg) {RB_Warning_MSg(msg);}

}
