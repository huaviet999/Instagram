package com.example.instagram.presentation.login;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
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
    @BindView(R.id.btn_login)
    Button btnLogin;
    @Inject
    LoginContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        disableLoginButtonIfEmpty();
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

    @Override
    public void disableLoginButtonIfTrue(boolean disable) {
        btnLogin.setEnabled(!disable);
    }


    private void disableLoginButtonIfEmpty() {

        edtUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presenter.disableLoginButtonIfEmpty(charSequence, edtPassword.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presenter.disableLoginButtonIfEmpty(edtUsername.getText().toString(), charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @OnClick(R.id.btn_login)
    public void onLoginButtonClick() {
        String username = edtUsername.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        presenter.login(username, password);
    }

    @OnClick(R.id.txt_signup)
    public void onSignUpClick() {
        showWarningMessage("ĐANG ĐƯỢC PHÁT TRIỂN");
    }
}
