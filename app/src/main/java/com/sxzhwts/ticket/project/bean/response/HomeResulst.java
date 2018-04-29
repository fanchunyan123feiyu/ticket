package com.sxzhwts.ticket.project.bean.response;

import java.util.List;

/**
 * 作者：fcy on 2018/4/18 15:57
 */

public class HomeResulst extends Result {

    /**
     * data : {"sumcount":8137,"confirmsum":2,"list":[{"id":"0120B399-A337-95AA-1054-A1541D0656E5","order_code":"20180418144041062813","user_id":"86053975-29B1-26B6-CCA5-9863E87C6C34","order_type":"1","scenic_scenc_id":"0","scenic_id":"751ED38B-9EA2-1F78-3FC5-E779CDB0CCC6","pay_state":"1","old_amount":"210.00","coupon_amount":"0.00","amount":"210.00","coupon_id":"","geter_name":"孙守备","geter_tel":"15525470003","geter_card_id":"","create_time":"1524033641","pay_method":"1","date":"2018-4-18","shift_id":"","cp_time":"0","writeoff_time":"0","fx_id":"null","commission":"0.00","is_reflect":"0","reflect_id":null,"youjian_title":"","youjian_code":"","youjian_content":"","platform":"weixin","content":null,"is_fanyong":null,"fanyong_time":null,"fanyong_amount":null,"count":3,"name":"朝台车票"},{"id":"03B7B636-308A-2331-E1B5-8717660E86FF","order_code":"20180418143437603893","user_id":"86053975-29B1-26B6-CCA5-9863E87C6C34","order_type":"1","scenic_scenc_id":"0","scenic_id":"751ED38B-9EA2-1F78-3FC5-E779CDB0CCC6","pay_state":"1","old_amount":"210.00","coupon_amount":"0.00","amount":"210.00","coupon_id":"","geter_name":"孙守备","geter_tel":"15525470003","geter_card_id":"","create_time":"1524033277","pay_method":"1","date":"2018-4-18","shift_id":"","cp_time":"0","writeoff_time":"0","fx_id":"null","commission":"0.00","is_reflect":"0","reflect_id":null,"youjian_title":"","youjian_code":"","youjian_content":"","platform":"weixin","content":null,"is_fanyong":null,"fanyong_time":null,"fanyong_amount":null,"count":3,"name":"朝台车票"}]}
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
         * sumcount : 8137
         * confirmsum : 2
         * list : [{"id":"0120B399-A337-95AA-1054-A1541D0656E5","order_code":"20180418144041062813","user_id":"86053975-29B1-26B6-CCA5-9863E87C6C34","order_type":"1","scenic_scenc_id":"0","scenic_id":"751ED38B-9EA2-1F78-3FC5-E779CDB0CCC6","pay_state":"1","old_amount":"210.00","coupon_amount":"0.00","amount":"210.00","coupon_id":"","geter_name":"孙守备","geter_tel":"15525470003","geter_card_id":"","create_time":"1524033641","pay_method":"1","date":"2018-4-18","shift_id":"","cp_time":"0","writeoff_time":"0","fx_id":"null","commission":"0.00","is_reflect":"0","reflect_id":null,"youjian_title":"","youjian_code":"","youjian_content":"","platform":"weixin","content":null,"is_fanyong":null,"fanyong_time":null,"fanyong_amount":null,"count":3,"name":"朝台车票"},{"id":"03B7B636-308A-2331-E1B5-8717660E86FF","order_code":"20180418143437603893","user_id":"86053975-29B1-26B6-CCA5-9863E87C6C34","order_type":"1","scenic_scenc_id":"0","scenic_id":"751ED38B-9EA2-1F78-3FC5-E779CDB0CCC6","pay_state":"1","old_amount":"210.00","coupon_amount":"0.00","amount":"210.00","coupon_id":"","geter_name":"孙守备","geter_tel":"15525470003","geter_card_id":"","create_time":"1524033277","pay_method":"1","date":"2018-4-18","shift_id":"","cp_time":"0","writeoff_time":"0","fx_id":"null","commission":"0.00","is_reflect":"0","reflect_id":null,"youjian_title":"","youjian_code":"","youjian_content":"","platform":"weixin","content":null,"is_fanyong":null,"fanyong_time":null,"fanyong_amount":null,"count":3,"name":"朝台车票"}]
         */

        private int sumcount;
        private int confirmsum;
        private List<ListEntity> list;

        public int getSumcount() {
            return sumcount;
        }

        public void setSumcount(int sumcount) {
            this.sumcount = sumcount;
        }

        public int getConfirmsum() {
            return confirmsum;
        }

        public void setConfirmsum(int confirmsum) {
            this.confirmsum = confirmsum;
        }

        public List<ListEntity> getList() {
            return list;
        }

        public void setList(List<ListEntity> list) {
            this.list = list;
        }

        public static class ListEntity {
            /**
             * id : 0120B399-A337-95AA-1054-A1541D0656E5
             * order_code : 20180418144041062813
             * user_id : 86053975-29B1-26B6-CCA5-9863E87C6C34
             * order_type : 1
             * scenic_scenc_id : 0
             * scenic_id : 751ED38B-9EA2-1F78-3FC5-E779CDB0CCC6
             * pay_state : 1
             * old_amount : 210.00
             * coupon_amount : 0.00
             * amount : 210.00
             * coupon_id :
             * geter_name : 孙守备
             * geter_tel : 15525470003
             * geter_card_id :
             * create_time : 1524033641
             * pay_method : 1
             * date : 2018-4-18
             * shift_id :
             * cp_time : 0
             * writeoff_time : 0
             * fx_id : null
             * commission : 0.00
             * is_reflect : 0
             * reflect_id : null
             * youjian_title :
             * youjian_code :
             * youjian_content :
             * platform : weixin
             * content : null
             * is_fanyong : null
             * fanyong_time : null
             * fanyong_amount : null
             * count : 3
             * name : 朝台车票
             */

            private String id;
            private String order_code;
            private String user_id;
            private String order_type;
            private String scenic_scenc_id;
            private String scenic_id;
            private String pay_state;
            private String old_amount;
            private String coupon_amount;
            private String amount;
            private String coupon_id;
            private String geter_name;
            private String geter_tel;
            private String geter_card_id;
            private String create_time;
            private String pay_method;
            private String date;
            private String shift_id;
            private String cp_time;
            private String writeoff_time;
            private String fx_id;
            private String commission;
            private String is_reflect;
            private Object reflect_id;
            private String youjian_title;
            private String youjian_code;
            private String youjian_content;
            private String platform;
            private Object content;
            private Object is_fanyong;
            private Object fanyong_time;
            private Object fanyong_amount;
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

            public String getOld_amount() {
                return old_amount;
            }

            public void setOld_amount(String old_amount) {
                this.old_amount = old_amount;
            }

            public String getCoupon_amount() {
                return coupon_amount;
            }

            public void setCoupon_amount(String coupon_amount) {
                this.coupon_amount = coupon_amount;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getCoupon_id() {
                return coupon_id;
            }

            public void setCoupon_id(String coupon_id) {
                this.coupon_id = coupon_id;
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

            public String getGeter_card_id() {
                return geter_card_id;
            }

            public void setGeter_card_id(String geter_card_id) {
                this.geter_card_id = geter_card_id;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
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

            public String getShift_id() {
                return shift_id;
            }

            public void setShift_id(String shift_id) {
                this.shift_id = shift_id;
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

            public String getYoujian_title() {
                return youjian_title;
            }

            public void setYoujian_title(String youjian_title) {
                this.youjian_title = youjian_title;
            }

            public String getYoujian_code() {
                return youjian_code;
            }

            public void setYoujian_code(String youjian_code) {
                this.youjian_code = youjian_code;
            }

            public String getYoujian_content() {
                return youjian_content;
            }

            public void setYoujian_content(String youjian_content) {
                this.youjian_content = youjian_content;
            }

            public String getPlatform() {
                return platform;
            }

            public void setPlatform(String platform) {
                this.platform = platform;
            }

            public Object getContent() {
                return content;
            }

            public void setContent(Object content) {
                this.content = content;
            }

            public Object getIs_fanyong() {
                return is_fanyong;
            }

            public void setIs_fanyong(Object is_fanyong) {
                this.is_fanyong = is_fanyong;
            }

            public Object getFanyong_time() {
                return fanyong_time;
            }

            public void setFanyong_time(Object fanyong_time) {
                this.fanyong_time = fanyong_time;
            }

            public Object getFanyong_amount() {
                return fanyong_amount;
            }

            public void setFanyong_amount(Object fanyong_amount) {
                this.fanyong_amount = fanyong_amount;
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
