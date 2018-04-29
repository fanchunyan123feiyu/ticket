package com.sxzhwts.ticket.project.bean.response;

import java.util.List;

/**
 * 作者：fcy on 2018/4/16 13:39
 */

public class SceneryResult extends Result {

    private List<DataEntity> data;

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public static class DataEntity {
        /**
         * resourceId : BusOrder
         * name : 大巴订单
         * type : 3
         */

        private String resourceId;
        private String name;
        private int type;

        public String getResourceId() {
            return resourceId;
        }

        public void setResourceId(String resourceId) {
            this.resourceId = resourceId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
