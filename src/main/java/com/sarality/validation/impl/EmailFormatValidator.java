package com.sarality.validation.impl;

import android.text.TextUtils;

import com.sarality.form.FormData;
import com.sarality.form.FormField;
import com.sarality.validation.FieldValidator;

import org.apache.commons.validator.routines.EmailValidator;

/**
 * A Validator that checks if the field value is a valid email address
 *
 * @author abhideep@ (Abhideep Singh)
 */
public class EmailFormatValidator implements FieldValidator {

  private final FormField field;
  private final EmailValidator emailValidator = EmailValidator.getInstance(false, false);

  public EmailFormatValidator(FormField field) {
    this.field = field;
  }

  @Override
  public boolean isValid(FormData fieldData) {
    String email = fieldData.getString(field);
    return isValid(email);
  }

  @Override
  public FormField getField() {
    return field;
  }

  @Override
  public boolean isValid(String email) {
    // We no longer use android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() to keep things in sync
    // with the API server
    return TextUtils.isEmpty(email) || emailValidator.isValid(email);
  }
}
