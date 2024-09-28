package Model;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
    String errorMessage;
    int errorCode;
    String description;

    public ErrorMessage() {
    }

    public ErrorMessage(String errorMessage, int errorCode, String description) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.description = description;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
