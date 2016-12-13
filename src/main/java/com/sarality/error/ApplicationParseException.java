package com.sarality.error;

import java.util.List;

/**
 * Exception ot be throw when a Field cannot be parsed.
 *
 * @author abhideep@ (Abhideep Singh)
 */
public class ApplicationParseException extends Exception {

  private final List<String> fieldNames;

  public ApplicationParseException(List<String> fieldNames) {
    this.fieldNames = fieldNames;
  }

  public ApplicationParseException(String detailMessage, List<String> fieldNames) {
    super(detailMessage);
    this.fieldNames = fieldNames;
  }

  public ApplicationParseException(String detailMessage, Throwable throwable, List<String> fieldNames) {
    super(detailMessage, throwable);
    this.fieldNames = fieldNames;
  }

  public ApplicationParseException(Throwable throwable, List<String> fieldNames) {
    super(throwable);
    this.fieldNames = fieldNames;
  }

  public List<String> getFieldNames() {
    return fieldNames;
  }
}
