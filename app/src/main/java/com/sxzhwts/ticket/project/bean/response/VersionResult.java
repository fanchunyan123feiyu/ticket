package com.sxzhwts.ticket.project.bean.response;

/**
 * Created by fcy on 2017/12/7.
 */

public class VersionResult extends Result{
    public DataBean data;

    public  class DataBean {
        public String id;
        public String client_id;
        public String version;
        public String apk_url;
        public Object create_time;
        public String force_update;

        @Override
        public String toString() {
            return "DataBean{" +
                    "id='" + id + '\'' +
                    ", client_id='" + client_id + '\'' +
                    ", version='" + version + '\'' +
                    ", apk_url='" + apk_url + '\'' +
                    ", create_time=" + create_time +
                    ", force_update='" + force_update + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "VersionResult{" +
                "data=" + data +
                '}';
    }
}
