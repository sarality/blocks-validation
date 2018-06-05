package com.sarality.error;

import java.util.List;

/**
 * Application Exception thrown when there is a conflict in writing data locally.
 * <p/>
 * Generally a result of attempts to perform data sync that will overwite local modifications or when there is
 * a version mismatch when updating data.
 *
 * @author abhideep@ (Abhideep Singh)
 */
public class ConflictException extends ApplicationException {
  public ConflictException(List<ErrorCode> errorCodeList) {
    super(errorCodeList);
  }

  public ConflictException(String detailMessage, List<ErrorCode> errorCodeList) {
    super(detailMessage, errorCodeList);
  }

  public ConflictException(String detailMessage, Throwable throwable,
      List<ErrorCode> errorCodeList) {
    super(detailMessage, throwable, errorCodeList);
  }

  public ConflictException(Throwable throwable, List<ErrorCode> errorCodeList) {
    super(throwable, errorCodeList);
  }
}
