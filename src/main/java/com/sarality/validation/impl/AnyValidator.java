package com.sarality.validation.impl;

import com.sarality.form.FormFieldData;
import com.sarality.validation.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A composite validator that is composed of a list of validators. It is valid if ANY of the validators is valid.
 *
 * @author abhideep@ (Abhideep Singh)
 */
public class AnyValidator implements Validator {

  private final List<Validator> validatorList = new ArrayList<>();

  public AnyValidator(Validator... validators) {
    if (validators != null) {
      validatorList.addAll(Arrays.asList(validators));
    }
  }

  @Override
  public boolean isValid(FormFieldData fieldData) {
    for (Validator validator : validatorList) {
      if (validator.isValid(fieldData)) {
        return true;
      }
    }
    return false;
  }
}
