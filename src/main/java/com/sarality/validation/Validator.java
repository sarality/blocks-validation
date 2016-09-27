package com.sarality.validation;

import com.sarality.form.FormData;

/**
 * Validates a field or set of fields, the value(s) for which are provided by the {@link FormData}.
 *
 * @author abhideep@ (Abhideep Singh)
 */
public interface Validator {

  boolean isValid(FormData fieldData);
}
