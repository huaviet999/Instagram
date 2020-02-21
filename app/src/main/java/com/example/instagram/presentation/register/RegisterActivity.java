package com.example.instagram.presentation.register;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.example.instagram.R;
import com.example.instagram.presentation.base.BaseActivity;
import com.example.instagram.presentation.login.LoginActivity;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

/**
 * Created by Viet Hua on 2/21/2020
 */
public class RegisterActivity extends BaseActivity implements RegisterContract.View {
    private static final String TAG = RegisterActivity.class.getSimpleName();
    @BindView(R.id.edt_username)
    EditText edtUsername;
    @BindView(R.id.edt_fullname)
    EditText edtFullname;
    @BindView(R.id.edt_email)
    EditText edtEmail;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.btn_register)
    Button btnRegister;
    @Inject
    RegisterContract.Presenter presenter;

    public static void showRegisterActivity(AppCompatActivity activity) {
        Intent intent = new Intent(activity, RegisterActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        checkIfEditTextIsChanged();
    }

    @Override
    protected int getResLayoutId() {
        return R.layout.activity_register;
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
    public void onSignUpSuccess() {
        showSuccessMessage("Đăng ký thành công");
    }

    @Override
    public void onSignUpFailed() {
        showErrorMessage("Đăng ký thất bại");
    }

    @Override
    public void disableRegisterButtonIfTrue(boolean disable) {
        btnRegister.setEnabled(!disable);
    }

    public void checkIfEditTextIsChanged() {
        edtUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presenter.disableRegisterButtonIfEmpty(charSequence, edtFullname.getText().toString(),edtEmail.getText().toString(),edtPassword.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edtFullname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presenter.disableRegisterButtonIfEmpty(edtUsername.getText().toString(),charSequence,edtEmail.getText().toString(),edtPassword.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presenter.disableRegisterButtonIfEmpty(edtUsername.getText().toString(), edtFullname.getText().toString(),charSequence,edtPassword.getText().toString());
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
                presenter.disableRegisterButtonIfEmpty(edtUsername.getText().toString(), edtFullname.getText().toString(),edtEmail.getText().toString(),charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @OnClick(R.id.btn_register)
    public void onRegisterButtonClick() {
        String username = edtUsername.getText().toString().trim();
        String fullname = edtFullname.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        presenter.signUp(username, fullname, email, password);
    }

    @OnClick(R.id.txt_signin)
    public void onSignInClick() {
        LoginActivity.showLoginActiviy(this);
    }
}
