// Generated code from Butter Knife. Do not modify!
package com.example.instagram.presentation.favorite;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.instagram.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FavoriteFragment_ViewBinding implements Unbinder {
  private FavoriteFragment target;

  private View view7f09012f;

  @UiThread
  public FavoriteFragment_ViewBinding(final FavoriteFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.txt_recommend, "method 'onRecommendTextClick'");
    view7f09012f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onRecommendTextClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view7f09012f.setOnClickListener(null);
    view7f09012f = null;
  }
}
