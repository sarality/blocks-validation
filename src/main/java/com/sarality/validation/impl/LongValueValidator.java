package com.sarality.validation.impl;

import android.text.TextUtils;

import com.sarality.form.FormData;
import com.sarality.form.FormField;
import com.sarality.validation.FieldValidator;

/**
 * A Validator that checks if the field value is a valid Long Value
 *
 * @author abhideep@ (Abhideep Singh)
 */
public class LongValueValidator implements FieldValidator {

  private final FormField field;

  public LongValueValidator(FormField field) {
    this.field = field;
  }

  @Override
  public boolean isValid(FormData fieldData) {
    String value = fieldData.getString(field);
    return isValid(value);
  }

  @Override
  public FormField getField() {
    return field;
  }

  @Override
  public boolean isValid(String value) {
    if  (!TextUtils.isEmpty(value)) {
      try {
        Long.parseLong(value);
      } catch (NumberFormatException e) {
        return false;
      }
    }
    return true;
  }
}
