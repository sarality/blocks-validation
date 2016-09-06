package com.sarality.validation;

/**
 * Interface for all Validators that operate on the data in a Field.
 *
 * @author abhideep@ (Abhideep Singh)
 */
public interface FieldValidator extends Validator {

  int getFieldId();
}
