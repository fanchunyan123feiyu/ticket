package com.sxzhwts.ticket.project.bean.response;

import java.util.List;

/**
 * 作者：fcy on 2018/4/19 17:43
 */

public class BusOrderDetailResult extends Result {


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

        private String order_code;
        private String order_type;
        private String pay_state;
        private String state;
        private String amount;
        private String geter_name;
        private String scenic_id;

        public String getScenic_id() {
            return scenic_id;
        }

        public void setScenic_id(String scenic_id) {
            this.scenic_id = scenic_id;
        }

        private String create_time;
        private String geter_tel;
        private String geter_card_id;
        private String pay_method;
        private String date;
        private String remark;

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        private StartPlaceEntity start_place;
        private EndPlaceEntity end_place;
        private int sumcount;
        private ShiftsEntity shifts;
        private List<DetailEntity> detail;
        public String getDate() {
            return date;
        }
        private ScenicEntity  scenic;
        public void setDate(String date) {
            this.date = date;
        }

        public ScenicEntity getScenic() {
            return scenic;
        }

        public void setScenic(ScenicEntity scenic) {
            this.scenic = scenic;
        }

        public String getCreate_time() {
            return create_time;
        }

        public String getPay_method() {
            return pay_method;
        }

        public void setPay_method(String pay_method) {
            this.pay_method = pay_method;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getOrder_code() {
            return order_code;
        }

        public void setOrder_code(String order_code) {
            this.order_code = order_code;
        }

        public String getOrder_type() {
            return order_type;
        }

        public void setOrder_type(String order_type) {
            this.order_type = order_type;
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

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
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
            private String price;
            private String time;

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
        }
        public static class ScenicEntity {
            private String name;
            public String getName() {
                return name;
            }
            public void setName(String name) {
                this.name = name;
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
            private String amount;
            private String create_time;
            private String update_time;
            private String truename;
            private String idcard;
            private String state;
            private String ip;
            private String telphone;
            private String price;
            private String ticketname;

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getTicketname() {
                return ticketname;
            }

            public void setTicketname(String ticketname) {
                this.ticketname = ticketname;
            }

            public String getTelphone() {
                return telphone;
            }

            public void setTelphone(String telphone) {
                this.telphone = telphone;
            }

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

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
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
