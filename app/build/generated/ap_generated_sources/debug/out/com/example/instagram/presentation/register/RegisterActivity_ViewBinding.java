// Generated code from Butter Knife. Do not modify!
package com.example.instagram.presentation.register;

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

public class RegisterActivity_ViewBinding implements Unbinder {
  private RegisterActivity target;

  private View view7f09004b;

  private View view7f090130;

  @UiThread
  public RegisterActivity_ViewBinding(RegisterActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RegisterActivity_ViewBinding(final RegisterActivity target, View source) {
    this.target = target;

    View view;
    target.edtUsername = Utils.findRequiredViewAsType(source, R.id.edt_username, "field 'edtUsername'", EditText.class);
    target.edtFullname = Utils.findRequiredViewAsType(source, R.id.edt_fullname, "field 'edtFullname'", EditText.class);
    target.edtEmail = Utils.findRequiredViewAsType(source, R.id.edt_email, "field 'edtEmail'", EditText.class);
    target.edtPassword = Utils.findRequiredViewAsType(source, R.id.edt_password, "field 'edtPassword'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_register, "field 'btnRegister' and method 'onRegisterButtonClick'");
    target.btnRegister = Utils.castView(view, R.id.btn_register, "field 'btnRegister'", Button.class);
    view7f09004b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onRegisterButtonClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.txt_signin, "method 'onSignInClick'");
    view7f090130 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onSignInClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    RegisterActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edtUsername = null;
    target.edtFullname = null;
    target.edtEmail = null;
    target.edtPassword = null;
    target.btnRegister = null;

    view7f09004b.setOnClickListener(null);
    view7f09004b = null;
    view7f090130.setOnClickListener(null);
    view7f090130 = null;
  }
}
