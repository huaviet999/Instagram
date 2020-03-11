// Generated code from Butter Knife. Do not modify!
package com.example.instagram.presentation.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.instagram.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  private View view7f09004a;

  private View view7f090131;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(final LoginActivity target, View source) {
    this.target = target;

    View view;
    target.edtEmail = Utils.findRequiredViewAsType(source, R.id.edt_email, "field 'edtEmail'", EditText.class);
    target.edtPassword = Utils.findRequiredViewAsType(source, R.id.edt_password, "field 'edtPassword'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_login, "field 'btnLogin' and method 'onLoginButtonClick'");
    target.btnLogin = Utils.castView(view, R.id.btn_login, "field 'btnLogin'", Button.class);
    view7f09004a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLoginButtonClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.txt_signup, "method 'onSignUpClick'");
    view7f090131 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onSignUpClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edtEmail = null;
    target.edtPassword = null;
    target.btnLogin = null;

    view7f09004a.setOnClickListener(null);
    view7f09004a = null;
    view7f090131.setOnClickListener(null);
    view7f090131 = null;
  }
}
