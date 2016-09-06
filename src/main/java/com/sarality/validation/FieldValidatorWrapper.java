package com.sarality.validation;

import com.sarality.validation.error.ErrorMessage;

/**
 * Wrapper over a validator along with the field that should trigger the validator as well as the error message to
 * be shown when the validation fails.
 *
 * @author abhideep@ (Abhideep Singh)
 */
class FieldValidatorWrapper {
  private final int fieldId;
  private final Validator validator;
  private final ErrorMessage errorMessage;

  FieldValidatorWrapper(int fieldId, Validator validator, ErrorMessage errorMessage) {
    this.fieldId = fieldId;
    this.validator = validator;
    this.errorMessage = errorMessage;
  }

  int getFieldId() {
    return fieldId;
  }

  Validator getValidator() {
    return validator;
  }

  ErrorMessage getErrorMessage() {
    return errorMessage;
  }
}
