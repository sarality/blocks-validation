package com.sarality.sanitize.impl;

import com.sarality.sanitize.Sanitizer;
import com.sarality.validation.impl.PhoneNumberFormat;

/**
 * Sanitizes a String to form a phone number that matches standard pattern
 *
 * @author abhideep@ (Abhideep Singh)
 */
public class PhoneNumberSanitizer implements Sanitizer {

  private final String countryCodeString;

  public PhoneNumberSanitizer(PhoneNumberFormat format) {
    this.countryCodeString = "+" + format.getCountryCode();
  }

  @Override
  public String sanitize(String value) {
    String number = value;
    // If it starts with expected country code.
    if (value.startsWith(countryCodeString)) {
      number = value.substring(countryCodeString.length());
    }

    // Remove all symbols and non numeric chars
    number = number.replaceAll("\\D", "");

    // Remove the zero
    while (number.startsWith("0")) {
      number = number.substring(1);
    }
    return countryCodeString + "-" + number;
  }
}
