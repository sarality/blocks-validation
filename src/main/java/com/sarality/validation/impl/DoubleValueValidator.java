package com.sarality.validation.impl;

import android.text.TextUtils;

import com.sarality.form.FormData;
import com.sarality.form.FormField;
import com.sarality.validation.FieldValidator;

/**
 * A Validator that checks if the field value is a valid Double Value
 *
 * @author abhideep@ (Abhideep Singh)
 */
public class DoubleValueValidator implements FieldValidator {

  private final FormField field;

  public DoubleValueValidator(FormField field) {
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
        Double.parseDouble(value);
      } catch (NumberFormatException e) {
        return false;
      }
    }
    return true;
  }
}
