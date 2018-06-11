package com.sxzhwts.ticket.project.convert;

import com.sxzhwts.ticket.project.bean.response.Result;

/**
 * 作者：fcy on 2018/6/5 09:39
 */

public class HttpResult<T> extends Result {
    private T result;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
