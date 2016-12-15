package com.sarality.validation.impl;

import android.text.TextUtils;

import com.sarality.form.FormData;
import com.sarality.form.FormField;
import com.sarality.sanitize.impl.PhoneNumberSanitizer;
import com.sarality.validation.FieldValidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A Validator that checks if the field value is a valid phone numner (India Only)
 *
 * @author abhideep@ (Abhideep Singh)
 */
public class PhoneNumberValidator implements FieldValidator {

  private static final Logger logger = LoggerFactory.getLogger(PhoneNumberValidator.class);

  private static final Pattern PHONE_PATTERN = Pattern.compile("\\+([1-9][0-9])-([1-9][0-9]+)");

  private final FormField field;
  private final PhoneNumberFormat format;
  private final PhoneNumberSanitizer sanitizer;
  private String sanitizedValue;

  public PhoneNumberValidator(FormField field, PhoneNumberFormat format) {
    this.field = field;
    this.format = format;
    this.sanitizer = new PhoneNumberSanitizer(format);
  }

  @Override
  public boolean isValid(FormData fieldData) {
    String phoneNumber = fieldData.getString(field);
    return isValid(phoneNumber);
  }

  public String getSanitizedValue() {
    return sanitizedValue;
  }

  @Override
  public FormField getField() {
    return field;
  }

  @Override
  public boolean isValid(String phoneNumberValue) {
    if (TextUtils.isEmpty(phoneNumberValue)) {
      sanitizedValue = phoneNumberValue;
      return true;
    }

    String phoneNumber = sanitizer.sanitize(phoneNumberValue);

    Matcher matcher = PHONE_PATTERN.matcher(phoneNumber);
    if (matcher.matches()) {
      sanitizedValue = phoneNumber;
      String countryCode = matcher.group(1);
      String number = matcher.group(2);
      int numberLength = number.length();
      logger.debug("Phone number {} has country code {} and number {}", phoneNumber, countryCode, number);
      return Integer.valueOf(countryCode) == format.getCountryCode() && numberLength <= format.getMinLength()
          && numberLength >= format.getMaxLength();
    } else {
      logger.trace("Phone number {} does not match pattern", phoneNumber);
    }
    return false;
  }
}
