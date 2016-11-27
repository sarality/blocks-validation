package com.sarality.validation.error;

/**
 * A definition of the Error message that needs to be displayed and where it will be displayed.
 *
 * @author abhideep@ (Abhideep Singh)
 */
public class ErrorMessage {

  private final int messageResourceId;
  private final ErrorRenderer errorRenderer;

  public ErrorMessage(int messageResourceId, int errorRendererFieldId, ErrorRendererType errorRendererType) {
    this(messageResourceId, createRenderer(errorRendererFieldId, errorRendererType));
  }

  public ErrorMessage(int messageResourceId, ErrorRenderer errorRenderer) {
    this.errorRenderer = errorRenderer;
    this.messageResourceId = messageResourceId;
  }

  public ErrorRenderer getErrorRenderer() {
    return errorRenderer;
  }

  public int getMessageResourceId() {
    return messageResourceId;
  }

  private static ErrorRenderer createRenderer(int errorRendererFieldId, ErrorRendererType errorRendererType) {
    if (ErrorRendererType.TEXT_INPUT_LAYOUT.equals(errorRendererType)) {
      return new TextInputErrorRenderer(errorRendererFieldId);
    } else if (ErrorRendererType.EDIT_TEXT.equals(errorRendererType)) {
      return new EditTextErrorRender(errorRendererFieldId);
    } else if (ErrorRendererType.TEXT_VIEW.equals(errorRendererType)) {
      return new TextViewErrorRender(errorRendererFieldId);
    }
    throw new IllegalArgumentException("Error Renderer not supported for type " + errorRendererType);
  }
}
