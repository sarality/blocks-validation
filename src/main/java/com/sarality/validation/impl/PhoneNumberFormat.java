package com.sarality.validation.impl;

/**
 * Enum for Phone Number Patterns supported by the system.
 *
 * @author abhideep@ (Abhideep Singh)
 */
public enum PhoneNumberFormat {
  INDIA(91, 10, 10);

  private final int countryCode;
  private final int minLength;
  private final int maxLength;

  PhoneNumberFormat(int countryCode, int minLength, int maxLength) {
    this.countryCode = countryCode;
    this.minLength = minLength;
    this.maxLength = maxLength;
  }

  public int getCountryCode() {
    return countryCode;
  }

  public int getMinLength() {
    return minLength;
  }

  public int getMaxLength() {
    return maxLength;
  }
}
