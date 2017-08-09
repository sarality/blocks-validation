package com.sarality.validation.error;

import android.app.Activity;
import android.view.View;

/**
 * Interface for all classes that display an error.
 *
 * @author abhideep@ (Abhideep Singh)
 */
public interface ErrorRenderer {

  void init(Activity activity);

  void init(Activity activity, View contextView);

  void displayError(Activity activity, int messageResourceId);

  void resetError(Activity activity);
}
