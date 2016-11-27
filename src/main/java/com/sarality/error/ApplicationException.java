package com.sarality.error;

import java.util.List;

/**
 * An application com.sarality.error with an associated ErrorCode.
 * <p/>
 * Allows business logic errors to be passed up to the UI layer and displayed as
 * errors.
 *
 * @author abhideep@ (Abhideep Singh)
 */
public class ApplicationException extends Exception {

  private final List<ErrorCode> errorCodeList;

  public ApplicationException(List<ErrorCode> errorCodeList) {
    super();
    this.errorCodeList = errorCodeList;
  }

  public ApplicationException(String detailMessage, List<ErrorCode> errorCodeList) {
    super(detailMessage);
    this.errorCodeList = errorCodeList;
  }

  public ApplicationException(String detailMessage, Throwable throwable, List<ErrorCode> errorCodeList) {
    super(detailMessage, throwable);
    this.errorCodeList = errorCodeList;
  }

  public ApplicationException(Throwable throwable, List<ErrorCode> errorCodeList) {
    super(throwable);
    this.errorCodeList = errorCodeList;
  }

  public boolean hasErrorCodes() {
    return !errorCodeList.isEmpty();
  }

  public List<ErrorCode> getErrorCodes() {
    return errorCodeList;
  }

}
