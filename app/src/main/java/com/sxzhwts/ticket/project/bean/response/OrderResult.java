package com.sxzhwts.ticket.project.bean.response;

import java.util.List;

/**
 * 作者：fcy on 2018/4/18 13:41
 */

public class OrderResult extends Result {


    /**
     * data : {"ordercount":32,"orderamount":3901.67,"sum":26,"orderlist":{"total":null,"per_page":5,"current_page":"4","data":[{"id":"B65E4F36-21D3-8CEE-FA00-5CBC4749B0FA","order_code":"20170422085451566215","user_id":"2E042454-07D0-FE50-F901-3417E7724DA7","order_type":"1","scenic_scenc_id":"0","scenic_id":"751ED38B-9EA2-1F78-3FC5-E779CDB0CCC6","pay_state":"1","state":"2","old_amount":null,"coupon_amount":null,"amount":"0.12","coupon_id":null,"pay_time":"1492822510","geter_name":"测试账号丨任杰","geter_tel":"18234049433","geter_card_id":"","create_admin_id":null,"update_admin_id":"6E6A87DA-B073-77CF-AFF8-B1DED555780D","create_time":"1492822491","update_time":"1492822491","wxordercode":null,"pay_method":"1","date":"2017-4-22","validate_code":"7946-8944-9282-2522","shift_id":"","remark":"","refundorderid":"","writeoff_admin_id":"","cp_time":"1492822522","writeoff_time":"0","fx_id":"2E042454-07D0-FE50-F901-3417E7724DA7","commission":"80.00","is_reflect":"0","reflect_id":null,"youjian_title":"","youjian_code":"","youjian_content":"","platform":"ios","content":null,"is_fanyong":null,"fanyong_time":null,"fanyong_amount":null,"count":8,"name":"朝台车票"},{"id":"D1E5918B-06B4-B20B-CE33-8F55CD602541","order_code":"20170421225400335996","user_id":"2E042454-07D0-FE50-F901-3417E7724DA7","order_type":"1","scenic_scenc_id":"0","scenic_id":"751ED38B-9EA2-1F78-3FC5-E779CDB0CCC6","pay_state":"1","state":"2","old_amount":null,"coupon_amount":null,"amount":"0.08","coupon_id":null,"pay_time":"1492786466","geter_name":"测试账号丨任杰","geter_tel":"18234049433","geter_card_id":"","create_admin_id":null,"update_admin_id":"6E6A87DA-B073-77CF-AFF8-B1DED555780D","create_time":"1492786440","update_time":"1492786440","wxordercode":null,"pay_method":"1","date":"2017-04-27","validate_code":"6601-8594-9278-6477","shift_id":"","remark":"","refundorderid":"","writeoff_admin_id":"","cp_time":"1492786477","writeoff_time":"0","fx_id":"2E042454-07D0-FE50-F901-3417E7724DA7","commission":"0.00","is_reflect":"0","reflect_id":null,"youjian_title":"","youjian_code":"","youjian_content":"","platform":"ios","content":null,"is_fanyong":null,"fanyong_time":null,"fanyong_amount":null,"count":4,"name":"朝台车票"},{"id":"0122AEF1-3287-D491-8FD4-F363B0BD6EEB","order_code":"20170421224954713877","user_id":"2E042454-07D0-FE50-F901-3417E7724DA7","order_type":"1","scenic_scenc_id":"0","scenic_id":"751ED38B-9EA2-1F78-3FC5-E779CDB0CCC6","pay_state":"1","state":"2","old_amount":null,"coupon_amount":null,"amount":"0.05","coupon_id":null,"pay_time":"1492786203","geter_name":"测试账号丨任杰","geter_tel":"18234049433","geter_card_id":"","create_admin_id":null,"update_admin_id":"6E6A87DA-B073-77CF-AFF8-B1DED555780D","create_time":"1492786194","update_time":"1492786194","wxordercode":null,"pay_method":"1","date":"2017-04-22","validate_code":"8206-7094-9278-6255","shift_id":"","remark":"","refundorderid":"","writeoff_admin_id":"","cp_time":"1492786255","writeoff_time":"0","fx_id":"2E042454-07D0-FE50-F901-3417E7724DA7","commission":"100.00","is_reflect":"0","reflect_id":null,"youjian_title":"","youjian_code":"","youjian_content":"","platform":"ios","content":null,"is_fanyong":null,"fanyong_time":null,"fanyong_amount":null,"count":5,"name":"朝台车票"},{"id":"8F93D04F-4235-29E9-46F6-A235453314EF","order_code":"20170421195201423420","user_id":"2E042454-07D0-FE50-F901-3417E7724DA7","order_type":"1","scenic_scenc_id":"0","scenic_id":"751ED38B-9EA2-1F78-3FC5-E779CDB0CCC6","pay_state":"1","state":"2","old_amount":null,"coupon_amount":null,"amount":"0.01","coupon_id":null,"pay_time":"1492775529","geter_name":"测试账号丨任杰","geter_tel":"18234049433","geter_card_id":"","create_admin_id":null,"update_admin_id":"E68B5DB5-5045-EF0B-54A1-6595EFA234BF","create_time":"1492775521","update_time":"1492775521","wxordercode":null,"pay_method":"1","date":"2017-04-23","validate_code":"3028-4954-9281-7042","shift_id":"","remark":"","refundorderid":"","writeoff_admin_id":"","cp_time":"1492817042","writeoff_time":"0","fx_id":"2E042454-07D0-FE50-F901-3417E7724DA7","commission":"20.00","is_reflect":"0","reflect_id":null,"youjian_title":"","youjian_code":"","youjian_content":"","platform":"","content":null,"is_fanyong":null,"fanyong_time":null,"fanyong_amount":null,"count":1,"name":"朝台车票"},{"id":"7A28951B-6C05-8221-0B67-D59BF633CB55","order_code":"20170421190817536122","user_id":"2E042454-07D0-FE50-F901-3417E7724DA7","order_type":"1","scenic_scenc_id":"0","scenic_id":"751ED38B-9EA2-1F78-3FC5-E779CDB0CCC6","pay_state":"1","state":"2","old_amount":null,"coupon_amount":null,"amount":"0.13","coupon_id":null,"pay_time":"1492772906","geter_name":"测试账号丨任杰","geter_tel":"18234049433","geter_card_id":"","create_admin_id":null,"update_admin_id":"E68B5DB5-5045-EF0B-54A1-6595EFA234BF","create_time":"1492772897","update_time":"1492772897","wxordercode":null,"pay_method":"1","date":"2017-04-22","validate_code":"9810-8494-9281-7048","shift_id":"","remark":"","refundorderid":"","writeoff_admin_id":"","cp_time":"1492817048","writeoff_time":"0","fx_id":"","commission":"0.00","is_reflect":"0","reflect_id":null,"youjian_title":"","youjian_code":"","youjian_content":"","platform":"ios","content":null,"is_fanyong":null,"fanyong_time":null,"fanyong_amount":null,"count":8,"name":"朝台车票"}]}}
     */

    private DataEntityX data;

    public DataEntityX getData() {
        return data;
    }

    public void setData(DataEntityX data) {
        this.data = data;
    }

    public static class DataEntityX {
        /**
         * ordercount : 32
         * orderamount : 3901.67
         * sum : 26
         * orderlist : {"total":null,"per_page":5,"current_page":"4","data":[{"id":"B65E4F36-21D3-8CEE-FA00-5CBC4749B0FA","order_code":"20170422085451566215","user_id":"2E042454-07D0-FE50-F901-3417E7724DA7","order_type":"1","scenic_scenc_id":"0","scenic_id":"751ED38B-9EA2-1F78-3FC5-E779CDB0CCC6","pay_state":"1","state":"2","old_amount":null,"coupon_amount":null,"amount":"0.12","coupon_id":null,"pay_time":"1492822510","geter_name":"测试账号丨任杰","geter_tel":"18234049433","geter_card_id":"","create_admin_id":null,"update_admin_id":"6E6A87DA-B073-77CF-AFF8-B1DED555780D","create_time":"1492822491","update_time":"1492822491","wxordercode":null,"pay_method":"1","date":"2017-4-22","validate_code":"7946-8944-9282-2522","shift_id":"","remark":"","refundorderid":"","writeoff_admin_id":"","cp_time":"1492822522","writeoff_time":"0","fx_id":"2E042454-07D0-FE50-F901-3417E7724DA7","commission":"80.00","is_reflect":"0","reflect_id":null,"youjian_title":"","youjian_code":"","youjian_content":"","platform":"ios","content":null,"is_fanyong":null,"fanyong_time":null,"fanyong_amount":null,"count":8,"name":"朝台车票"},{"id":"D1E5918B-06B4-B20B-CE33-8F55CD602541","order_code":"20170421225400335996","user_id":"2E042454-07D0-FE50-F901-3417E7724DA7","order_type":"1","scenic_scenc_id":"0","scenic_id":"751ED38B-9EA2-1F78-3FC5-E779CDB0CCC6","pay_state":"1","state":"2","old_amount":null,"coupon_amount":null,"amount":"0.08","coupon_id":null,"pay_time":"1492786466","geter_name":"测试账号丨任杰","geter_tel":"18234049433","geter_card_id":"","create_admin_id":null,"update_admin_id":"6E6A87DA-B073-77CF-AFF8-B1DED555780D","create_time":"1492786440","update_time":"1492786440","wxordercode":null,"pay_method":"1","date":"2017-04-27","validate_code":"6601-8594-9278-6477","shift_id":"","remark":"","refundorderid":"","writeoff_admin_id":"","cp_time":"1492786477","writeoff_time":"0","fx_id":"2E042454-07D0-FE50-F901-3417E7724DA7","commission":"0.00","is_reflect":"0","reflect_id":null,"youjian_title":"","youjian_code":"","youjian_content":"","platform":"ios","content":null,"is_fanyong":null,"fanyong_time":null,"fanyong_amount":null,"count":4,"name":"朝台车票"},{"id":"0122AEF1-3287-D491-8FD4-F363B0BD6EEB","order_code":"20170421224954713877","user_id":"2E042454-07D0-FE50-F901-3417E7724DA7","order_type":"1","scenic_scenc_id":"0","scenic_id":"751ED38B-9EA2-1F78-3FC5-E779CDB0CCC6","pay_state":"1","state":"2","old_amount":null,"coupon_amount":null,"amount":"0.05","coupon_id":null,"pay_time":"1492786203","geter_name":"测试账号丨任杰","geter_tel":"18234049433","geter_card_id":"","create_admin_id":null,"update_admin_id":"6E6A87DA-B073-77CF-AFF8-B1DED555780D","create_time":"1492786194","update_time":"1492786194","wxordercode":null,"pay_method":"1","date":"2017-04-22","validate_code":"8206-7094-9278-6255","shift_id":"","remark":"","refundorderid":"","writeoff_admin_id":"","cp_time":"1492786255","writeoff_time":"0","fx_id":"2E042454-07D0-FE50-F901-3417E7724DA7","commission":"100.00","is_reflect":"0","reflect_id":null,"youjian_title":"","youjian_code":"","youjian_content":"","platform":"ios","content":null,"is_fanyong":null,"fanyong_time":null,"fanyong_amount":null,"count":5,"name":"朝台车票"},{"id":"8F93D04F-4235-29E9-46F6-A235453314EF","order_code":"20170421195201423420","user_id":"2E042454-07D0-FE50-F901-3417E7724DA7","order_type":"1","scenic_scenc_id":"0","scenic_id":"751ED38B-9EA2-1F78-3FC5-E779CDB0CCC6","pay_state":"1","state":"2","old_amount":null,"coupon_amount":null,"amount":"0.01","coupon_id":null,"pay_time":"1492775529","geter_name":"测试账号丨任杰","geter_tel":"18234049433","geter_card_id":"","create_admin_id":null,"update_admin_id":"E68B5DB5-5045-EF0B-54A1-6595EFA234BF","create_time":"1492775521","update_time":"1492775521","wxordercode":null,"pay_method":"1","date":"2017-04-23","validate_code":"3028-4954-9281-7042","shift_id":"","remark":"","refundorderid":"","writeoff_admin_id":"","cp_time":"1492817042","writeoff_time":"0","fx_id":"2E042454-07D0-FE50-F901-3417E7724DA7","commission":"20.00","is_reflect":"0","reflect_id":null,"youjian_title":"","youjian_code":"","youjian_content":"","platform":"","content":null,"is_fanyong":null,"fanyong_time":null,"fanyong_amount":null,"count":1,"name":"朝台车票"},{"id":"7A28951B-6C05-8221-0B67-D59BF633CB55","order_code":"20170421190817536122","user_id":"2E042454-07D0-FE50-F901-3417E7724DA7","order_type":"1","scenic_scenc_id":"0","scenic_id":"751ED38B-9EA2-1F78-3FC5-E779CDB0CCC6","pay_state":"1","state":"2","old_amount":null,"coupon_amount":null,"amount":"0.13","coupon_id":null,"pay_time":"1492772906","geter_name":"测试账号丨任杰","geter_tel":"18234049433","geter_card_id":"","create_admin_id":null,"update_admin_id":"E68B5DB5-5045-EF0B-54A1-6595EFA234BF","create_time":"1492772897","update_time":"1492772897","wxordercode":null,"pay_method":"1","date":"2017-04-22","validate_code":"9810-8494-9281-7048","shift_id":"","remark":"","refundorderid":"","writeoff_admin_id":"","cp_time":"1492817048","writeoff_time":"0","fx_id":"","commission":"0.00","is_reflect":"0","reflect_id":null,"youjian_title":"","youjian_code":"","youjian_content":"","platform":"ios","content":null,"is_fanyong":null,"fanyong_time":null,"fanyong_amount":null,"count":8,"name":"朝台车票"}]}
         */

        private int ordercount;
        private double orderamount;
        private int sum;
        private OrderlistEntity orderlist;

        public int getOrdercount() {
            return ordercount;
        }

        public void setOrdercount(int ordercount) {
            this.ordercount = ordercount;
        }

        public double getOrderamount() {
            return orderamount;
        }

        public void setOrderamount(double orderamount) {
            this.orderamount = orderamount;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }

        public OrderlistEntity getOrderlist() {
            return orderlist;
        }

        public void setOrderlist(OrderlistEntity orderlist) {
            this.orderlist = orderlist;
        }

        public static class OrderlistEntity {
            /**
             * total : null
             * per_page : 5
             * current_page : 4
             * data : [{"id":"B65E4F36-21D3-8CEE-FA00-5CBC4749B0FA","order_code":"20170422085451566215","user_id":"2E042454-07D0-FE50-F901-3417E7724DA7","order_type":"1","scenic_scenc_id":"0","scenic_id":"751ED38B-9EA2-1F78-3FC5-E779CDB0CCC6","pay_state":"1","state":"2","old_amount":null,"coupon_amount":null,"amount":"0.12","coupon_id":null,"pay_time":"1492822510","geter_name":"测试账号丨任杰","geter_tel":"18234049433","geter_card_id":"","create_admin_id":null,"update_admin_id":"6E6A87DA-B073-77CF-AFF8-B1DED555780D","create_time":"1492822491","update_time":"1492822491","wxordercode":null,"pay_method":"1","date":"2017-4-22","validate_code":"7946-8944-9282-2522","shift_id":"","remark":"","refundorderid":"","writeoff_admin_id":"","cp_time":"1492822522","writeoff_time":"0","fx_id":"2E042454-07D0-FE50-F901-3417E7724DA7","commission":"80.00","is_reflect":"0","reflect_id":null,"youjian_title":"","youjian_code":"","youjian_content":"","platform":"ios","content":null,"is_fanyong":null,"fanyong_time":null,"fanyong_amount":null,"count":8,"name":"朝台车票"},{"id":"D1E5918B-06B4-B20B-CE33-8F55CD602541","order_code":"20170421225400335996","user_id":"2E042454-07D0-FE50-F901-3417E7724DA7","order_type":"1","scenic_scenc_id":"0","scenic_id":"751ED38B-9EA2-1F78-3FC5-E779CDB0CCC6","pay_state":"1","state":"2","old_amount":null,"coupon_amount":null,"amount":"0.08","coupon_id":null,"pay_time":"1492786466","geter_name":"测试账号丨任杰","geter_tel":"18234049433","geter_card_id":"","create_admin_id":null,"update_admin_id":"6E6A87DA-B073-77CF-AFF8-B1DED555780D","create_time":"1492786440","update_time":"1492786440","wxordercode":null,"pay_method":"1","date":"2017-04-27","validate_code":"6601-8594-9278-6477","shift_id":"","remark":"","refundorderid":"","writeoff_admin_id":"","cp_time":"1492786477","writeoff_time":"0","fx_id":"2E042454-07D0-FE50-F901-3417E7724DA7","commission":"0.00","is_reflect":"0","reflect_id":null,"youjian_title":"","youjian_code":"","youjian_content":"","platform":"ios","content":null,"is_fanyong":null,"fanyong_time":null,"fanyong_amount":null,"count":4,"name":"朝台车票"},{"id":"0122AEF1-3287-D491-8FD4-F363B0BD6EEB","order_code":"20170421224954713877","user_id":"2E042454-07D0-FE50-F901-3417E7724DA7","order_type":"1","scenic_scenc_id":"0","scenic_id":"751ED38B-9EA2-1F78-3FC5-E779CDB0CCC6","pay_state":"1","state":"2","old_amount":null,"coupon_amount":null,"amount":"0.05","coupon_id":null,"pay_time":"1492786203","geter_name":"测试账号丨任杰","geter_tel":"18234049433","geter_card_id":"","create_admin_id":null,"update_admin_id":"6E6A87DA-B073-77CF-AFF8-B1DED555780D","create_time":"1492786194","update_time":"1492786194","wxordercode":null,"pay_method":"1","date":"2017-04-22","validate_code":"8206-7094-9278-6255","shift_id":"","remark":"","refundorderid":"","writeoff_admin_id":"","cp_time":"1492786255","writeoff_time":"0","fx_id":"2E042454-07D0-FE50-F901-3417E7724DA7","commission":"100.00","is_reflect":"0","reflect_id":null,"youjian_title":"","youjian_code":"","youjian_content":"","platform":"ios","content":null,"is_fanyong":null,"fanyong_time":null,"fanyong_amount":null,"count":5,"name":"朝台车票"},{"id":"8F93D04F-4235-29E9-46F6-A235453314EF","order_code":"20170421195201423420","user_id":"2E042454-07D0-FE50-F901-3417E7724DA7","order_type":"1","scenic_scenc_id":"0","scenic_id":"751ED38B-9EA2-1F78-3FC5-E779CDB0CCC6","pay_state":"1","state":"2","old_amount":null,"coupon_amount":null,"amount":"0.01","coupon_id":null,"pay_time":"1492775529","geter_name":"测试账号丨任杰","geter_tel":"18234049433","geter_card_id":"","create_admin_id":null,"update_admin_id":"E68B5DB5-5045-EF0B-54A1-6595EFA234BF","create_time":"1492775521","update_time":"1492775521","wxordercode":null,"pay_method":"1","date":"2017-04-23","validate_code":"3028-4954-9281-7042","shift_id":"","remark":"","refundorderid":"","writeoff_admin_id":"","cp_time":"1492817042","writeoff_time":"0","fx_id":"2E042454-07D0-FE50-F901-3417E7724DA7","commission":"20.00","is_reflect":"0","reflect_id":null,"youjian_title":"","youjian_code":"","youjian_content":"","platform":"","content":null,"is_fanyong":null,"fanyong_time":null,"fanyong_amount":null,"count":1,"name":"朝台车票"},{"id":"7A28951B-6C05-8221-0B67-D59BF633CB55","order_code":"20170421190817536122","user_id":"2E042454-07D0-FE50-F901-3417E7724DA7","order_type":"1","scenic_scenc_id":"0","scenic_id":"751ED38B-9EA2-1F78-3FC5-E779CDB0CCC6","pay_state":"1","state":"2","old_amount":null,"coupon_amount":null,"amount":"0.13","coupon_id":null,"pay_time":"1492772906","geter_name":"测试账号丨任杰","geter_tel":"18234049433","geter_card_id":"","create_admin_id":null,"update_admin_id":"E68B5DB5-5045-EF0B-54A1-6595EFA234BF","create_time":"1492772897","update_time":"1492772897","wxordercode":null,"pay_method":"1","date":"2017-04-22","validate_code":"9810-8494-9281-7048","shift_id":"","remark":"","refundorderid":"","writeoff_admin_id":"","cp_time":"1492817048","writeoff_time":"0","fx_id":"","commission":"0.00","is_reflect":"0","reflect_id":null,"youjian_title":"","youjian_code":"","youjian_content":"","platform":"ios","content":null,"is_fanyong":null,"fanyong_time":null,"fanyong_amount":null,"count":8,"name":"朝台车票"}]
             */

            private List<DataEntity> data;

            public List<DataEntity> getData() {
                return data;
            }

            public void setData(List<DataEntity> data) {
                this.data = data;
            }

            public static class DataEntity {
                /**
                 * id : B65E4F36-21D3-8CEE-FA00-5CBC4749B0FA
                 * order_code : 20170422085451566215
                 * user_id : 2E042454-07D0-FE50-F901-3417E7724DA7
                 * order_type : 1
                 * scenic_scenc_id : 0
                 * scenic_id : 751ED38B-9EA2-1F78-3FC5-E779CDB0CCC6
                 * pay_state : 1
                 * state : 2
                 * old_amount : null
                 * coupon_amount : null
                 * amount : 0.12
                 * coupon_id : null
                 * pay_time : 1492822510
                 * geter_name : 测试账号丨任杰
                 * geter_tel : 18234049433
                 * geter_card_id :
                 * create_admin_id : null
                 * update_admin_id : 6E6A87DA-B073-77CF-AFF8-B1DED555780D
                 * create_time : 1492822491
                 * update_time : 1492822491
                 * wxordercode : null
                 * pay_method : 1
                 * date : 2017-4-22
                 * validate_code : 7946-8944-9282-2522
                 * shift_id :
                 * remark :
                 * refundorderid :
                 * writeoff_admin_id :
                 * cp_time : 1492822522
                 * writeoff_time : 0
                 * fx_id : 2E042454-07D0-FE50-F901-3417E7724DA7
                 * commission : 80.00
                 * is_reflect : 0
                 * reflect_id : null
                 * youjian_title :
                 * youjian_code :
                 * youjian_content :
                 * platform : ios
                 * content : null
                 * is_fanyong : null
                 * fanyong_time : null
                 * fanyong_amount : null
                 * count : 8
                 * name : 朝台车票
                 */

                private String id;
                private String order_code;
                private String user_id;
                private String order_type;
                private String scenic_scenc_id;
                private String scenic_id;
                private String pay_state;
                private String state;
                private Object coupon_amount;
                private String amount;
                private String pay_time;
                private String geter_name;
                private String geter_tel;
                private String geter_card_id;
                private String remark;
                public String getRemark() {
                    return remark;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
                }

                public String getGeter_card_id() {
                    return geter_card_id;
                }

                public void setGeter_card_id(String geter_card_id) {
                    this.geter_card_id = geter_card_id;
                }

                private String update_admin_id;
                private String create_time;
                private String update_time;
                private String pay_method;
                private String date;
                private String validate_code;
                private String cp_time;
                private String writeoff_time;
                private String fx_id;
                private String commission;
                private String is_reflect;
                private Object reflect_id;
                private String platform;
                private int count;
                private String name;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getOrder_code() {
                    return order_code;
                }

                public void setOrder_code(String order_code) {
                    this.order_code = order_code;
                }

                public String getUser_id() {
                    return user_id;
                }

                public void setUser_id(String user_id) {
                    this.user_id = user_id;
                }

                public String getOrder_type() {
                    return order_type;
                }

                public void setOrder_type(String order_type) {
                    this.order_type = order_type;
                }

                public String getScenic_scenc_id() {
                    return scenic_scenc_id;
                }

                public void setScenic_scenc_id(String scenic_scenc_id) {
                    this.scenic_scenc_id = scenic_scenc_id;
                }

                public String getScenic_id() {
                    return scenic_id;
                }

                public void setScenic_id(String scenic_id) {
                    this.scenic_id = scenic_id;
                }

                public String getPay_state() {
                    return pay_state;
                }

                public void setPay_state(String pay_state) {
                    this.pay_state = pay_state;
                }

                public String getState() {
                    return state;
                }

                public void setState(String state) {
                    this.state = state;
                }

                public Object getCoupon_amount() {
                    return coupon_amount;
                }

                public void setCoupon_amount(Object coupon_amount) {
                    this.coupon_amount = coupon_amount;
                }

                public String getAmount() {
                    return amount;
                }

                public void setAmount(String amount) {
                    this.amount = amount;
                }

                public String getPay_time() {
                    return pay_time;
                }

                public void setPay_time(String pay_time) {
                    this.pay_time = pay_time;
                }

                public String getGeter_name() {
                    return geter_name;
                }

                public void setGeter_name(String geter_name) {
                    this.geter_name = geter_name;
                }

                public String getGeter_tel() {
                    return geter_tel;
                }

                public void setGeter_tel(String geter_tel) {
                    this.geter_tel = geter_tel;
                }

                public String getUpdate_admin_id() {
                    return update_admin_id;
                }

                public void setUpdate_admin_id(String update_admin_id) {
                    this.update_admin_id = update_admin_id;
                }

                public String getCreate_time() {
                    return create_time;
                }

                public void setCreate_time(String create_time) {
                    this.create_time = create_time;
                }

                public String getUpdate_time() {
                    return update_time;
                }

                public void setUpdate_time(String update_time) {
                    this.update_time = update_time;
                }

                public String getPay_method() {
                    return pay_method;
                }

                public void setPay_method(String pay_method) {
                    this.pay_method = pay_method;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getValidate_code() {
                    return validate_code;
                }

                public void setValidate_code(String validate_code) {
                    this.validate_code = validate_code;
                }

                public String getCp_time() {
                    return cp_time;
                }

                public void setCp_time(String cp_time) {
                    this.cp_time = cp_time;
                }

                public String getWriteoff_time() {
                    return writeoff_time;
                }

                public void setWriteoff_time(String writeoff_time) {
                    this.writeoff_time = writeoff_time;
                }

                public String getFx_id() {
                    return fx_id;
                }

                public void setFx_id(String fx_id) {
                    this.fx_id = fx_id;
                }

                public String getCommission() {
                    return commission;
                }

                public void setCommission(String commission) {
                    this.commission = commission;
                }

                public String getIs_reflect() {
                    return is_reflect;
                }

                public void setIs_reflect(String is_reflect) {
                    this.is_reflect = is_reflect;
                }

                public Object getReflect_id() {
                    return reflect_id;
                }

                public void setReflect_id(Object reflect_id) {
                    this.reflect_id = reflect_id;
                }

                public String getPlatform() {
                    return platform;
                }

                public void setPlatform(String platform) {
                    this.platform = platform;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }
    }
}
