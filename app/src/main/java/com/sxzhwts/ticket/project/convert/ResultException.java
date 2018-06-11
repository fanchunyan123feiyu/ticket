package com.sxzhwts.ticket.project.convert;

import java.io.IOException;

/**
 * 作者：fcy on 2018/6/5 10:06
 */

public class ResultException extends IOException {
private  int errorCode;
private  String errorMessage;
    public ResultException(int errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
