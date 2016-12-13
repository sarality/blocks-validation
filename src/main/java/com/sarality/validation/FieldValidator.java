package com.sarality.validation;

import com.sarality.form.FormField;

/**
 * Interface for all Validators that operate on the data in a Field.
 *
 * @author abhideep@ (Abhideep Singh)
 */
public interface FieldValidator extends Validator {

  FormField getField();

  // TODO(abhideep): Move this to a non Form Field Based Validator
  boolean isValid(String value);
}
