package com.sarality.validation;

import com.sarality.validation.error.ErrorMessage;

/**
 * Wrapper over a validator along with the field that should trigger the validator as well as the error message to
 * be shown when the validation fails.
 *
 * @author abhideep@ (Abhideep Singh)
 */
class FieldValidatorWrapper {
  private final Validator validator;
  private final ErrorMessage errorMessage;

  FieldValidatorWrapper(Validator validator, ErrorMessage errorMessage) {
    this.validator = validator;
    this.errorMessage = errorMessage;
  }

  Validator getValidator() {
    return validator;
  }

  ErrorMessage getErrorMessage() {
    return errorMessage;
  }
}
