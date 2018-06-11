package com.sxzhwts.ticket.project.convert;

import com.sxzhwts.ticket.project.bean.response.Result;

/**
 * 作者：fcy on 2018/6/5 10:05
 */

public class ErrorResponse  extends Result{
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
