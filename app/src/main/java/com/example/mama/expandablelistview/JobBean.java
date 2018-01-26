package com.example.mama.expandablelistview;

import java.util.List;

/**
 * Created by mama on 2018/1/23.
 */

public class JobBean{
    /**
     * id : 1
     * name : 互联网/游戏/软件
     * name_en : Internet/Online Games/Software
     * code : cate-01
     * data : [{"id":13,"name":"互联网/移动互联网/电子商务","name_en":"Internet/Mobile Internet/E-Business","code":"cate-01-01","data":[{"id":63,"name":"不限","name_en":"Unlimited","code":"cate-01-01"},{"id":64,"name":"技术","name_en":"Technology","code":"542"},{"id":65,"name":"测试","name_en":"Testing","code":"543"},{"id":66,"name":"运维","name_en":"Operation Maintenance","code":"544"},{"id":67,"name":"运营","name_en":"Operation","code":"545"},{"id":68,"name":"产品","name_en":"Product","code":"546"},{"id":69,"name":"UI/UE/平面设计","name_en":"UI/UE/Design","code":"547"}]},{"id":14,"name":"网络游戏","name_en":"Online Game","code":"cate-01-02","data":[{"id":70,"name":"不限","name_en":"Unlimited","code":"cate-01-02"},{"id":71,"name":"技术","name_en":"Technology","code":"542"},{"id":72,"name":"测试","name_en":"Testing","code":"543"},{"id":73,"name":"运维","name_en":"Operation Maintenance","code":"544"},{"id":74,"name":"UI/UE/平面设计","name_en":"UI/UE/Design","code":"547"},{"id":75,"name":"产品","name_en":"Product","code":"548"},{"id":76,"name":"运营","name_en":"Operations","code":"619"}]},{"id":15,"name":"计算机软件","name_en":"Computer Software","code":"cate-01-03","data":[{"id":77,"name":"不限","name_en":"Unlimited","code":"cate-01-03"},{"id":78,"name":"技术","name_en":"Technology","code":"542"},{"id":79,"name":"测试","name_en":"Testing","code":"543"},{"id":80,"name":"运维","name_en":"Operation Maintenance","code":"544"},{"id":81,"name":"产品","name_en":"Product","code":"546"},{"id":82,"name":"UI/UE/平面设计","name_en":"UI/UE/Design","code":"547"},{"id":83,"name":"运营","name_en":"Operations","code":"619"}]},{"id":16,"name":"IT服务/系统集成","name_en":"IT Services/Systems Integration","code":"cate-01-04","data":[{"id":84,"name":"不限","name_en":"Unlimited","code":"cate-01-04"},{"id":85,"name":"技术","name_en":"Technology","code":"542"},{"id":86,"name":"测试","name_en":"Testing","code":"543"},{"id":87,"name":"运维","name_en":"Operation Maintenance","code":"544"},{"id":88,"name":"产品","name_en":"Product","code":"546"},{"id":89,"name":"UI/UE/平面设计","name_en":"UI/UE/Design","code":"547"},{"id":90,"name":"运营","name_en":"Operations","code":"619"}]}]
     */

    private int id;
    private String name;
    private String name_en;
    private String code;
    private List<DataBeanX> data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBeanX> getData() {
        return data;
    }

    public void setData(List<DataBeanX> data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * id : 13
         * name : 互联网/移动互联网/电子商务
         * name_en : Internet/Mobile Internet/E-Business
         * code : cate-01-01
         * data : [{"id":63,"name":"不限","name_en":"Unlimited","code":"cate-01-01"},{"id":64,"name":"技术","name_en":"Technology","code":"542"},{"id":65,"name":"测试","name_en":"Testing","code":"543"},{"id":66,"name":"运维","name_en":"Operation Maintenance","code":"544"},{"id":67,"name":"运营","name_en":"Operation","code":"545"},{"id":68,"name":"产品","name_en":"Product","code":"546"},{"id":69,"name":"UI/UE/平面设计","name_en":"UI/UE/Design","code":"547"}]
         */

        private int id;
        private String name;
        private String name_en;
        private String code;
        private List<DataBean> data;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 63
             * name : 不限
             * name_en : Unlimited
             * code : cate-01-01
             */

            private int id;
            private String name;
            private String name_en;
            private String code;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getName_en() {
                return name_en;
            }

            public void setName_en(String name_en) {
                this.name_en = name_en;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }
        }
    }
}
