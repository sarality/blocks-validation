package com.sarality.validation.impl;

import com.sarality.form.FormData;
import com.sarality.validation.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A composite validator that is composed of a list of validators. It is valid if ALL of the validators are valid.
 *
 * @author abhideep@ (Abhideep Singh)
 */
public class AllValidator implements Validator {

  private final List<Validator> validatorList = new ArrayList<>();

  public AllValidator(Validator... validators) {
    if (validators != null) {
      validatorList.addAll(Arrays.asList(validators));
    }
  }

  @Override
  public boolean isValid(FormData fieldData) {
    for (Validator validator : validatorList) {
      if (!validator.isValid(fieldData)) {
        return false;
      }
    }
    return true;
  }
}
