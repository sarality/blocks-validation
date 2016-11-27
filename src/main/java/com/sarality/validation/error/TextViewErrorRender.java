package com.sarality.validation.error;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * A field based on an {@link EditText} Input Control.
 *
 * @author abhideep@ (Abhideep Singh)
 */
public class TextViewErrorRender implements ErrorRenderer {

  private boolean isInitialized = false;
  private final int fieldId;

  private TextView field;

  public TextViewErrorRender(int fieldId) {
    this.fieldId = fieldId;
  }

  @Override
  public void init(Activity activity) {
    if (!isInitialized) {
      field = (TextView) activity.findViewById(fieldId);
      isInitialized = true;
    }
  }

  @Override
  public void displayError(Activity activity, int messageResourceId) {
    field.setVisibility(View.VISIBLE);
    field.setText(activity.getString(messageResourceId));
    field.setError("");
  }

  @Override
  public void resetError(Activity activity) {
    field.setVisibility(View.GONE);
    field.setText("");
    field.setError(null);
  }
}
