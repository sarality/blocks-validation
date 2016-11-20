package com.sarality.validation.impl;

import android.text.TextUtils;

import com.sarality.form.FormField;
import com.sarality.form.FormData;
import com.sarality.validation.FieldValidator;

/**
 * A Validator that checks if the field value is a valid email address
 *
 * @author abhideep@ (Abhideep Singh)
 */
public class EmailFormatValidator implements FieldValidator {

  private final FormField field;


  public EmailFormatValidator(FormField field) {
    this.field = field;
  }

  @Override
  public boolean isValid(FormData fieldData) {
    String email = fieldData.getString(field);
    return TextUtils.isEmpty(email) || android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
  }

  @Override
  public FormField getField() {
    return field;
  }
}
