package com.example.instagram.presentation.login;

import android.os.Bundle;
import android.widget.EditText;

import com.example.instagram.R;
import com.example.instagram.presentation.base.BaseActivity;
import com.example.instagram.presentation.home.HomeActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

public class LoginActivity extends BaseActivity implements LoginContract.View {
    private static final String TAG = LoginActivity.class.getSimpleName();
    @BindView(R.id.edt_username)
    EditText edtUsername;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @Inject
    LoginContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

    @Override
    protected int getResLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void onSignInSuccess() {
        showSuccessMessage("DANG NHAP THANH CONG");
        HomeActivity.showHomeActivity(this);
    }

    @Override
    public void onSignInFailed() {
        showErrorMessage("DANG NHAP THAT BAI");
    }

    @OnClick(R.id.btn_login)
    public void onLoginButtonClick() {
        String username = edtUsername.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        presenter.login(username, password);
    }
}
