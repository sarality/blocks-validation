package com.sarality.validation.error;

import android.app.Activity;
import android.support.design.widget.TextInputLayout;
import android.view.View;

/**
 * Displays the error is a {@link TextInputLayout} for a Material Design look and feel.
 *
 * @author abhideep@ (Abhideep Singh)
 */
public class TextInputErrorRenderer implements ErrorRenderer {

  private final int layoutId;

  private TextInputLayout layout;

  public TextInputErrorRenderer(int layoutId) {
    this.layoutId = layoutId;
  }

  @Override
  public void init(Activity activity) {
    layout = (TextInputLayout) activity.findViewById(layoutId);
  }

  @Override
  public void displayError(Activity activity, int messageResourceId) {
    layout.setError(activity.getString(messageResourceId));
  }

  @Override
  public void resetError(Activity activity) {
    layout.setError(null);
    layout.setErrorEnabled(false);
    // Error in Android implementation introduces extra child which shows up as extra spacing
    if (layout.getChildCount() == 2) {
      layout.getChildAt(1).setVisibility(View.GONE);
    }
  }
}
