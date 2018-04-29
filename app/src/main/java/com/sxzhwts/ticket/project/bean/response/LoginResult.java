package com.sxzhwts.ticket.project.bean.response;

/**
 * 作者：fcy on 2018/4/14 16:54
 */

public class LoginResult extends Result{

    /**
     * data : {"admin_id":"6E6A87DA-B073-77CF-AFF8-B1DED555780D","admin_name":"ticketadmin","phone":"13888888888","access_token":"f9ab0a5c72b7d200dfb727803b5a5c91faae7260"}
     */

    private DataEntity data;

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity {
        /**
         * admin_id : 6E6A87DA-B073-77CF-AFF8-B1DED555780D
         * admin_name : ticketadmin
         * phone : 13888888888
         * access_token : f9ab0a5c72b7d200dfb727803b5a5c91faae7260
         */

        private String admin_id;
        private String admin_name;
        private String phone;
        private String access_token;

        public String getAdmin_id() {
            return admin_id;
        }

        public void setAdmin_id(String admin_id) {
            this.admin_id = admin_id;
        }

        public String getAdmin_name() {
            return admin_name;
        }

        public void setAdmin_name(String admin_name) {
            this.admin_name = admin_name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }
    }

    @Override
    public String toString() {
        return "LoginResult{" +
                "data=" + data +
                '}';
    }
}
