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

  private final int fieldId;

  public NonEmptyValueValidator(int fieldId) {
    this.fieldId = fieldId;
  }

  public NonEmptyValueValidator(FormField field) {
    this(field.getViewId());
  }

  @Override
  public boolean isValid(FormData fieldData) {
    String value = fieldData.getString(fieldId);
    return !TextUtils.isEmpty(value);
  }

  @Override
  public int getFieldId() {
    return fieldId;
  }
}
