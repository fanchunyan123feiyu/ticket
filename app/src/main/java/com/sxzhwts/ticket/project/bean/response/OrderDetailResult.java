package com.sxzhwts.ticket.project.bean.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 作者：fcy on 2018/4/19 16:35
 */

public class OrderDetailResult extends Result {

    /**
     * data : {"id":"E76BF9D4-2C6F-DD02-7E8E-9BD881F609FB","order_code":"20180419130251086554","user_id":"B2E61026-3C9B-83A9-E4E5-D9D1787E671B","order_type":"2","scenic_scenc_id":null,"scenic_id":"","pay_state":"0","state":"8","old_amount":null,"coupon_amount":null,"amount":"0.01","coupon_id":null,"pay_time":null,"geter_name":"RR","geter_tel":"18295715766","geter_card_id":"","create_admin_id":null,"update_admin_id":null,"create_time":"1524114171","update_time":"1524122401","wxordercode":null,"pay_method":null,"date":"2018-04-19","validate_code":"","shift_id":"690C23F7-CD1F-5C15-C7F4-8EA416551206","remark":"2小时未支付自动关闭","refundorderid":"","writeoff_admin_id":"","cp_time":"0","writeoff_time":"0","fx_id":"","commission":"0.00","is_reflect":"0","reflect_id":null,"youjian_title":"","youjian_code":"","youjian_content":"","platform":"Android设备手机厂商：Xiaomi 手机型号：Redmi Note 4X 系统版本号：6.0 系统语言：zh 唯一序列号imei：864718037517705APP版本号：4.0.5","content":null,"is_fanyong":null,"fanyong_time":null,"fanyong_amount":null,"start_place":{"id":"A2415F7C-AA18-89D0-5C68-89D0D1B3EA80","name":"五台山","longitude":"121231","latitude":"4564565555","create_time":"1478240497","update_time":"1491040175","create_admin_id":"6E6A87DA-B073-77CF-AFF8-B1DED555780D","update_admin_id":"6E6A87DA-B073-77CF-AFF8-B1DED555780D","get_addr":"五台山汽车站","get_phone":"18603506745"},"end_place":{"id":"6D258AE2-26E8-6ECF-49AF-C318406945D9","name":"测试","longitude":"1","latitude":"1","create_time":"1488522150","update_time":"1489741458","create_admin_id":"6E6A87DA-B073-77CF-AFF8-B1DED555780D","update_admin_id":"6E6A87DA-B073-77CF-AFF8-B1DED555780D","get_addr":"五台山汽车站","get_phone":"13633449577"},"sumcount":1,"detail":[{"id":"2DD80012-E495-45AF-1CC4-76E9DD4176B8","order_id":"E76BF9D4-2C6F-DD02-7E8E-9BD881F609FB","shifts_id":"690C23F7-CD1F-5C15-C7F4-8EA416551206","count":"1","total_amount":null,"discount_amount":null,"amount":"0.01","create_admin_id":null,"update_admin_id":null,"create_time":"1524114171","update_time":"1524114171","truename":"RR","telphone":"","idcard":"","state":"0","ip":""}],"shifts":{"id":"690C23F7-CD1F-5C15-C7F4-8EA416551206","name":"五台山-测试","type":"1","begin_datetime":"","end_datetime":"","code":"wts-cs16:30","start_place_id":"A2415F7C-AA18-89D0-5C68-89D0D1B3EA80","end_place_id":"6D258AE2-26E8-6ECF-49AF-C318406945D9","price":"0.01","time":"17:50","end_time":"23:00","create_time":"1503562563","update_time":"1503562775","create_admin_id":"6E6A87DA-B073-77CF-AFF8-B1DED555780D","update_admin_id":"6E6A87DA-B073-77CF-AFF8-B1DED555780D","hour":5,"minute":10}}
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
         * id : E76BF9D4-2C6F-DD02-7E8E-9BD881F609FB
         * order_code : 20180419130251086554
         * user_id : B2E61026-3C9B-83A9-E4E5-D9D1787E671B
         * order_type : 2
         * scenic_scenc_id : null
         * scenic_id :
         * pay_state : 0
         * state : 8
         * old_amount : null
         * coupon_amount : null
         * amount : 0.01
         * coupon_id : null
         * pay_time : null
         * geter_name : RR
         * geter_tel : 18295715766
         * geter_card_id :
         * create_admin_id : null
         * update_admin_id : null
         * create_time : 1524114171
         * update_time : 1524122401
         * wxordercode : null
         * pay_method : null
         * date : 2018-04-19
         * validate_code :
         * shift_id : 690C23F7-CD1F-5C15-C7F4-8EA416551206
         * remark : 2小时未支付自动关闭
         * refundorderid :
         * writeoff_admin_id :
         * cp_time : 0
         * writeoff_time : 0
         * fx_id :
         * commission : 0.00
         * is_reflect : 0
         * reflect_id : null
         * youjian_title :
         * youjian_code :
         * youjian_content :
         * platform : Android设备手机厂商：Xiaomi 手机型号：Redmi Note 4X 系统版本号：6.0 系统语言：zh 唯一序列号imei：864718037517705APP版本号：4.0.5
         * content : null
         * is_fanyong : null
         * fanyong_time : null
         * fanyong_amount : null
         * start_place : {"id":"A2415F7C-AA18-89D0-5C68-89D0D1B3EA80","name":"五台山","longitude":"121231","latitude":"4564565555","create_time":"1478240497","update_time":"1491040175","create_admin_id":"6E6A87DA-B073-77CF-AFF8-B1DED555780D","update_admin_id":"6E6A87DA-B073-77CF-AFF8-B1DED555780D","get_addr":"五台山汽车站","get_phone":"18603506745"}
         * end_place : {"id":"6D258AE2-26E8-6ECF-49AF-C318406945D9","name":"测试","longitude":"1","latitude":"1","create_time":"1488522150","update_time":"1489741458","create_admin_id":"6E6A87DA-B073-77CF-AFF8-B1DED555780D","update_admin_id":"6E6A87DA-B073-77CF-AFF8-B1DED555780D","get_addr":"五台山汽车站","get_phone":"13633449577"}
         * sumcount : 1
         * detail : [{"id":"2DD80012-E495-45AF-1CC4-76E9DD4176B8","order_id":"E76BF9D4-2C6F-DD02-7E8E-9BD881F609FB","shifts_id":"690C23F7-CD1F-5C15-C7F4-8EA416551206","count":"1","total_amount":null,"discount_amount":null,"amount":"0.01","create_admin_id":null,"update_admin_id":null,"create_time":"1524114171","update_time":"1524114171","truename":"RR","telphone":"","idcard":"","state":"0","ip":""}]
         * shifts : {"id":"690C23F7-CD1F-5C15-C7F4-8EA416551206","name":"五台山-测试","type":"1","begin_datetime":"","end_datetime":"","code":"wts-cs16:30","start_place_id":"A2415F7C-AA18-89D0-5C68-89D0D1B3EA80","end_place_id":"6D258AE2-26E8-6ECF-49AF-C318406945D9","price":"0.01","time":"17:50","end_time":"23:00","create_time":"1503562563","update_time":"1503562775","create_admin_id":"6E6A87DA-B073-77CF-AFF8-B1DED555780D","update_admin_id":"6E6A87DA-B073-77CF-AFF8-B1DED555780D","hour":5,"minute":10}
         */

        private String id;
        private String order_code;
        private String user_id;
        private String order_type;
        private Object scenic_scenc_id;
        private String scenic_id;
        private String pay_state;
        private String state;
        private Object old_amount;
        private Object coupon_amount;
        private String amount;
        private Object coupon_id;
        private Object pay_time;
        private String geter_name;
        private String geter_tel;
        private String geter_card_id;
        private Object create_admin_id;
        private Object update_admin_id;
        private String create_time;
        private String update_time;
        private Object wxordercode;
        private Object pay_method;
        private String date;
        private String validate_code;
        private String shift_id;
        private String remark;
        private String refundorderid;
        private String writeoff_admin_id;
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
        private StartPlaceEntity start_place;
        private EndPlaceEntity end_place;
        private int sumcount;
        private ShiftsEntity shifts;
        private List<DetailEntity> detail;

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

        public Object getScenic_scenc_id() {
            return scenic_scenc_id;
        }

        public void setScenic_scenc_id(Object scenic_scenc_id) {
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

        public Object getOld_amount() {
            return old_amount;
        }

        public void setOld_amount(Object old_amount) {
            this.old_amount = old_amount;
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

        public Object getCoupon_id() {
            return coupon_id;
        }

        public void setCoupon_id(Object coupon_id) {
            this.coupon_id = coupon_id;
        }

        public Object getPay_time() {
            return pay_time;
        }

        public void setPay_time(Object pay_time) {
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

        public String getGeter_card_id() {
            return geter_card_id;
        }

        public void setGeter_card_id(String geter_card_id) {
            this.geter_card_id = geter_card_id;
        }

        public Object getCreate_admin_id() {
            return create_admin_id;
        }

        public void setCreate_admin_id(Object create_admin_id) {
            this.create_admin_id = create_admin_id;
        }

        public Object getUpdate_admin_id() {
            return update_admin_id;
        }

        public void setUpdate_admin_id(Object update_admin_id) {
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

        public Object getWxordercode() {
            return wxordercode;
        }

        public void setWxordercode(Object wxordercode) {
            this.wxordercode = wxordercode;
        }

        public Object getPay_method() {
            return pay_method;
        }

        public void setPay_method(Object pay_method) {
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

        public String getShift_id() {
            return shift_id;
        }

        public void setShift_id(String shift_id) {
            this.shift_id = shift_id;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getRefundorderid() {
            return refundorderid;
        }

        public void setRefundorderid(String refundorderid) {
            this.refundorderid = refundorderid;
        }

        public String getWriteoff_admin_id() {
            return writeoff_admin_id;
        }

        public void setWriteoff_admin_id(String writeoff_admin_id) {
            this.writeoff_admin_id = writeoff_admin_id;
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

        public StartPlaceEntity getStart_place() {
            return start_place;
        }

        public void setStart_place(StartPlaceEntity start_place) {
            this.start_place = start_place;
        }

        public EndPlaceEntity getEnd_place() {
            return end_place;
        }

        public void setEnd_place(EndPlaceEntity end_place) {
            this.end_place = end_place;
        }

        public int getSumcount() {
            return sumcount;
        }

        public void setSumcount(int sumcount) {
            this.sumcount = sumcount;
        }

        public ShiftsEntity getShifts() {
            return shifts;
        }

        public void setShifts(ShiftsEntity shifts) {
            this.shifts = shifts;
        }

        public List<DetailEntity> getDetail() {
            return detail;
        }

        public void setDetail(List<DetailEntity> detail) {
            this.detail = detail;
        }

        public static class StartPlaceEntity {
            /**
             * id : A2415F7C-AA18-89D0-5C68-89D0D1B3EA80
             * name : 五台山
             * longitude : 121231
             * latitude : 4564565555
             * create_time : 1478240497
             * update_time : 1491040175
             * create_admin_id : 6E6A87DA-B073-77CF-AFF8-B1DED555780D
             * update_admin_id : 6E6A87DA-B073-77CF-AFF8-B1DED555780D
             * get_addr : 五台山汽车站
             * get_phone : 18603506745
             */

            private String id;
            private String name;
            private String longitude;
            private String latitude;
            private String create_time;
            private String update_time;
            private String create_admin_id;
            private String update_admin_id;
            private String get_addr;
            private String get_phone;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
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

            public String getCreate_admin_id() {
                return create_admin_id;
            }

            public void setCreate_admin_id(String create_admin_id) {
                this.create_admin_id = create_admin_id;
            }

            public String getUpdate_admin_id() {
                return update_admin_id;
            }

            public void setUpdate_admin_id(String update_admin_id) {
                this.update_admin_id = update_admin_id;
            }

            public String getGet_addr() {
                return get_addr;
            }

            public void setGet_addr(String get_addr) {
                this.get_addr = get_addr;
            }

            public String getGet_phone() {
                return get_phone;
            }

            public void setGet_phone(String get_phone) {
                this.get_phone = get_phone;
            }
        }

        public static class EndPlaceEntity {
            /**
             * id : 6D258AE2-26E8-6ECF-49AF-C318406945D9
             * name : 测试
             * longitude : 1
             * latitude : 1
             * create_time : 1488522150
             * update_time : 1489741458
             * create_admin_id : 6E6A87DA-B073-77CF-AFF8-B1DED555780D
             * update_admin_id : 6E6A87DA-B073-77CF-AFF8-B1DED555780D
             * get_addr : 五台山汽车站
             * get_phone : 13633449577
             */

            private String id;
            private String name;
            private String longitude;
            private String latitude;
            private String create_time;
            private String update_time;
            private String create_admin_id;
            private String update_admin_id;
            private String get_addr;
            private String get_phone;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
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

            public String getCreate_admin_id() {
                return create_admin_id;
            }

            public void setCreate_admin_id(String create_admin_id) {
                this.create_admin_id = create_admin_id;
            }

            public String getUpdate_admin_id() {
                return update_admin_id;
            }

            public void setUpdate_admin_id(String update_admin_id) {
                this.update_admin_id = update_admin_id;
            }

            public String getGet_addr() {
                return get_addr;
            }

            public void setGet_addr(String get_addr) {
                this.get_addr = get_addr;
            }

            public String getGet_phone() {
                return get_phone;
            }

            public void setGet_phone(String get_phone) {
                this.get_phone = get_phone;
            }
        }

        public static class ShiftsEntity {
            /**
             * id : 690C23F7-CD1F-5C15-C7F4-8EA416551206
             * name : 五台山-测试
             * type : 1
             * begin_datetime :
             * end_datetime :
             * code : wts-cs16:30
             * start_place_id : A2415F7C-AA18-89D0-5C68-89D0D1B3EA80
             * end_place_id : 6D258AE2-26E8-6ECF-49AF-C318406945D9
             * price : 0.01
             * time : 17:50
             * end_time : 23:00
             * create_time : 1503562563
             * update_time : 1503562775
             * create_admin_id : 6E6A87DA-B073-77CF-AFF8-B1DED555780D
             * update_admin_id : 6E6A87DA-B073-77CF-AFF8-B1DED555780D
             * hour : 5
             * minute : 10
             */

            private String id;
            private String name;
            private String type;
            private String begin_datetime;
            private String end_datetime;
            @SerializedName("code")
            private String codeX;
            private String start_place_id;
            private String end_place_id;
            private String price;
            private String time;
            private String end_time;
            private String create_time;
            private String update_time;
            private String create_admin_id;
            private String update_admin_id;
            private int hour;
            private int minute;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getBegin_datetime() {
                return begin_datetime;
            }

            public void setBegin_datetime(String begin_datetime) {
                this.begin_datetime = begin_datetime;
            }

            public String getEnd_datetime() {
                return end_datetime;
            }

            public void setEnd_datetime(String end_datetime) {
                this.end_datetime = end_datetime;
            }

            public String getCodeX() {
                return codeX;
            }

            public void setCodeX(String codeX) {
                this.codeX = codeX;
            }

            public String getStart_place_id() {
                return start_place_id;
            }

            public void setStart_place_id(String start_place_id) {
                this.start_place_id = start_place_id;
            }

            public String getEnd_place_id() {
                return end_place_id;
            }

            public void setEnd_place_id(String end_place_id) {
                this.end_place_id = end_place_id;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
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

            public String getCreate_admin_id() {
                return create_admin_id;
            }

            public void setCreate_admin_id(String create_admin_id) {
                this.create_admin_id = create_admin_id;
            }

            public String getUpdate_admin_id() {
                return update_admin_id;
            }

            public void setUpdate_admin_id(String update_admin_id) {
                this.update_admin_id = update_admin_id;
            }

            public int getHour() {
                return hour;
            }

            public void setHour(int hour) {
                this.hour = hour;
            }

            public int getMinute() {
                return minute;
            }

            public void setMinute(int minute) {
                this.minute = minute;
            }
        }

        public static class DetailEntity {
            /**
             * id : 2DD80012-E495-45AF-1CC4-76E9DD4176B8
             * order_id : E76BF9D4-2C6F-DD02-7E8E-9BD881F609FB
             * shifts_id : 690C23F7-CD1F-5C15-C7F4-8EA416551206
             * count : 1
             * total_amount : null
             * discount_amount : null
             * amount : 0.01
             * create_admin_id : null
             * update_admin_id : null
             * create_time : 1524114171
             * update_time : 1524114171
             * truename : RR
             * telphone :
             * idcard :
             * state : 0
             * ip :
             */

            private String id;
            private String order_id;
            private String shifts_id;
            private String count;
            private Object total_amount;
            private Object discount_amount;
            private String amount;
            private Object create_admin_id;
            private Object update_admin_id;
            private String create_time;
            private String update_time;
            private String truename;
            private String telphone;
            private String idcard;
            private String state;
            private String ip;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getOrder_id() {
                return order_id;
            }

            public void setOrder_id(String order_id) {
                this.order_id = order_id;
            }

            public String getShifts_id() {
                return shifts_id;
            }

            public void setShifts_id(String shifts_id) {
                this.shifts_id = shifts_id;
            }

            public String getCount() {
                return count;
            }

            public void setCount(String count) {
                this.count = count;
            }

            public Object getTotal_amount() {
                return total_amount;
            }

            public void setTotal_amount(Object total_amount) {
                this.total_amount = total_amount;
            }

            public Object getDiscount_amount() {
                return discount_amount;
            }

            public void setDiscount_amount(Object discount_amount) {
                this.discount_amount = discount_amount;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public Object getCreate_admin_id() {
                return create_admin_id;
            }

            public void setCreate_admin_id(Object create_admin_id) {
                this.create_admin_id = create_admin_id;
            }

            public Object getUpdate_admin_id() {
                return update_admin_id;
            }

            public void setUpdate_admin_id(Object update_admin_id) {
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

            public String getTruename() {
                return truename;
            }

            public void setTruename(String truename) {
                this.truename = truename;
            }

            public String getTelphone() {
                return telphone;
            }

            public void setTelphone(String telphone) {
                this.telphone = telphone;
            }

            public String getIdcard() {
                return idcard;
            }

            public void setIdcard(String idcard) {
                this.idcard = idcard;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getIp() {
                return ip;
            }

            public void setIp(String ip) {
                this.ip = ip;
            }
        }
    }
}
