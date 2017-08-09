package com.sarality.validation.error;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;

/**
 * A field based on an {@link EditText} Input Control.
 *
 * @author abhideep@ (Abhideep Singh)
 */
public class EditTextErrorRender implements ErrorRenderer {

  private boolean isInitialized = false;
  private final int fieldId;

  private EditText field;

  public EditTextErrorRender(int fieldId) {
    this.fieldId = fieldId;
  }

  @Override
  public void init(Activity activity) {
    init(activity, null);
  }

  @Override
  public void init(Activity activity, View contextView) {
    if (!isInitialized) {
      field = (EditText) (contextView == null ? activity.findViewById(fieldId) : contextView.findViewById(fieldId));
      isInitialized = true;
    }
  }

  @Override
  public void displayError(Activity activity, int messageResourceId) {
    field.setError(activity.getString(messageResourceId));
  }

  @Override
  public void resetError(Activity activity) {
    field.setError(null);
  }
}
