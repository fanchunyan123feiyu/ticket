package com.sxzhwts.ticket.project.bean.response;

/**
 * Created by fcy on 2017/12/5.
 */

public class TokenResult {

    /**
     * access_token : da84b6d9dbff7162bf643b38cf4f68f0ee97b2fe
     * expires_in : 3600
     * token_type : Bearer
     * scope : null
     */

    private String access_token;
    private int expires_in;
    private String token_type;
    private Object scope;

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public void setScope(Object scope) {
        this.scope = scope;
    }

    public String getAccess_token() {
        return access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public String getToken_type() {
        return token_type;
    }

    public Object getScope() {
        return scope;
    }

    @Override
    public String toString() {
        return "TokenResult{" +
                "access_token='" + access_token + '\'' +
                ", expires_in=" + expires_in +
                ", token_type='" + token_type + '\'' +
                ", scope=" + scope +
                '}';
    }
}
