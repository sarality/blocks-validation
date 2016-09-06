package com.sarality.validation;

import com.sarality.form.FormFieldData;

/**
 * Validates a field or set of fields, the value(s) for which are provided by the {@link FormFieldData}.
 *
 * @author abhideep@ (Abhideep Singh)
 */
public interface Validator {

  boolean isValid(FormFieldData fieldData);
}
