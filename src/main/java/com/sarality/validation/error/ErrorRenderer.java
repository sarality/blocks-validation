package com.sarality.validation.error;

import android.app.Activity;

/**
 * Interface for all classes that display an error.
 *
 * @author abhideep@ (Abhideep Singh)
 */
public interface ErrorRenderer {

  void init(Activity activity);

  void displayError(Activity activity, int messageResourceId);

  void resetError(Activity activity);
}
