package com.sxzhwts.ticket.common.utils.okhttp;

/**
 * Created by ljd on 4/12/16.
 */
public class ProgressBean {

    private long bytesRead;//当前字节
    private long contentLength;//总字节
    private boolean done;//是否下载完成

    public long getBytesRead() {
        return bytesRead;
    }

    public void setBytesRead(long bytesRead) {
        this.bytesRead = bytesRead;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
