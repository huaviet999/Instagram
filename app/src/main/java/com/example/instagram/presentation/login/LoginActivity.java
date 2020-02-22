package com.example.instagram.presentation.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.example.instagram.R;
import com.example.instagram.presentation.base.BaseActivity;
import com.example.instagram.presentation.home.HomeActivity;
import com.example.instagram.presentation.register.RegisterActivity;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

public class LoginActivity extends BaseActivity implements LoginContract.View {
    private static final String TAG = LoginActivity.class.getSimpleName();
    @BindView(R.id.edt_email)
    EditText edtEmail;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @Inject
    LoginContract.Presenter presenter;

    public static void showLoginActiviy(AppCompatActivity activity){
        Intent intent  = new Intent(activity,LoginActivity.class);
        activity.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        checkIfEditTextIsChanged();
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


    private void checkIfEditTextIsChanged() {

        edtEmail.addTextChangedListener(new TextWatcher() {
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
                presenter.disableLoginButtonIfEmpty(edtEmail.getText().toString(), charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @OnClick(R.id.btn_login)
    public void onLoginButtonClick() {
        String username = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        presenter.login(username, password);
    }

    @OnClick(R.id.txt_signup)
    public void onSignUpClick() {
        RegisterActivity.showRegisterActivity(this);
    }
}
