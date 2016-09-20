package com.sarality.validation;

import android.app.Activity;

import com.sarality.form.FormField;
import com.sarality.form.FormData;
import com.sarality.validation.error.ErrorMessage;
import com.sarality.validation.error.ErrorRenderer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that defines the set of validators on a Form or set of Fields.
 *
 * @author abhideep@ (Abhideep Singh)
 */
public class Validators {

  private final Map<Integer, List<FieldValidatorWrapper>> validatorListMap = new HashMap<>();

  public Validators register(FormField field, Validator validator, ErrorMessage errorMessage) {
    return register(field.getViewId(), validator, errorMessage);
  }

  public Validators register(FieldValidator validator, ErrorMessage errorMessage) {
    return register(validator.getFieldId(), validator, errorMessage);
  }

  private Validators register(int fieldId, Validator validator, ErrorMessage errorMessage) {
    if (!validatorListMap.containsKey(fieldId)) {
      validatorListMap.put(fieldId, new ArrayList<FieldValidatorWrapper>());
    }
    List<FieldValidatorWrapper> validatorList = validatorListMap.get(fieldId);
    validatorList.add(new FieldValidatorWrapper(fieldId, validator, errorMessage));
    return this;
  }

  public boolean validate(Activity activity, FormData formFieldData) {
    boolean isValidForm = true;
    for (Integer fieldId : validatorListMap.keySet()) {
      boolean isValidField = validateField(activity, formFieldData, fieldId);
      isValidForm = isValidForm & isValidField;
    }
    return isValidForm;
  }

  private boolean validateField(Activity activity, FormData formFieldData, int fieldId) {
    boolean isValid = true;
    List<FieldValidatorWrapper> validatorList = validatorListMap.get(fieldId);
    for (FieldValidatorWrapper validator : validatorList) {
      if (!validator.getValidator().isValid(formFieldData)) {
        isValid = false;
        displayError(activity, validator.getErrorMessage());
        break;
      } else {
        resetError(activity, validator.getErrorMessage().getErrorRenderer());
      }
    }
    return isValid;
  }

  private void resetError(Activity activity, ErrorRenderer renderer) {
    renderer.init(activity);
    renderer.resetError(activity);
  }

  private void displayError(Activity activity, ErrorMessage errorMessage) {
    ErrorRenderer renderer = errorMessage.getErrorRenderer();
    renderer.init(activity);
    renderer.displayError(activity, errorMessage.getMessageResourceId());
  }
}
