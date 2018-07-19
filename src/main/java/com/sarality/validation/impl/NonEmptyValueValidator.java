package com.sarality.validation.impl;

import android.text.TextUtils;

import com.sarality.form.FormField;
import com.sarality.form.FormData;
import com.sarality.validation.FieldValidator;

/**
 * Validator that checks if the value is not empty or null.
 *
 * @author abhideep@ (Abhideep Singh)
 */
public class NonEmptyValueValidator implements FieldValidator {

  private final FormField field;


  public NonEmptyValueValidator(FormField field) {
    this.field = field;
  }

  @Override
  public boolean isValid(FormData fieldData) {
    String value = fieldData.getString(field, true);
    return isValid(value);
  }

  @Override
  public FormField getField() {
    return field;
  }

  @Override
  public boolean isValid(String value) {
    return !TextUtils.isEmpty(value);
  }
}
