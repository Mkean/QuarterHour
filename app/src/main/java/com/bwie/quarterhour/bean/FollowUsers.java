package com.bwie.quarterhour.bean;

import java.util.List;

/**
 * 作者：王庆
 * 时间：2018/1/26
 */

public class FollowUsers {

    /**
     * msg : 获取关注用户列表成功
     * code : 0
     * data : [{"age":null,"appkey":"c7140875b5fcc94c","appsecret":"2D86BE777F50E23DA8547C126D4D063A","createtime":"2018-01-10T14:32:49","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"17316441397","money":null,"nickname":"12","password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"647423828267DCC07D9AFC7CE93058A2","uid":11336,"userId":null,"username":"17316441397"},{"age":null,"appkey":"58b1f7865a6ab2d9","appsecret":"79DFADE1DE9A60E1AF1A549D9D528092","createtime":"2018-01-26T13:56:26","email":null,"fans":null,"follow":null,"gender":null,"icon":"https://www.zhaoapi.cn/images/15169569254102017-05-11-18380166_305443499890139_8426655762360565760_n.jpg","latitude":null,"longitude":null,"mobile":"18701053989","money":null,"nickname":"ConstraString","password":"FB108FEA6FF16EBB3D0F585D6385C2A5","praiseNum":null,"token":"020806C2725FDD45D84D57BCDFAD80B8","uid":4043,"userId":null,"username":"18701053989"},{"age":null,"appkey":"8157cea74c894b5c","appsecret":"3E075303BFAD6E7521E278B90A455FBF","createtime":"2018-01-26T14:04:30","email":null,"fans":null,"follow":null,"gender":null,"icon":"https://www.zhaoapi.cn/images/151575551828852d4ae27f2029.jpg","latitude":null,"longitude":null,"mobile":"17301393946","money":null,"nickname":"哈哈哈","password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"57C40FDDB9D537A09B46FD83BC088ACC","uid":1600,"userId":null,"username":"17301393946"},{"age":null,"appkey":"c4885ae02b0fc2e7","appsecret":"7845F1887906FD1CA1A000F043EE8F79","createtime":"2018-01-26T14:25:18","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"15606589914","money":null,"nickname":"四海八荒","password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"271CE099A7FBC1BFA7CD381242593CB5","uid":11844,"userId":null,"username":"15606589914"}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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
         * age : null
         * appkey : c7140875b5fcc94c
         * appsecret : 2D86BE777F50E23DA8547C126D4D063A
         * createtime : 2018-01-10T14:32:49
         * email : null
         * fans : null
         * follow : null
         * gender : null
         * icon : null
         * latitude : null
         * longitude : null
         * mobile : 17316441397
         * money : null
         * nickname : 12
         * password : 8F669074CAF5513351A2DE5CC22AC04C
         * praiseNum : null
         * token : 647423828267DCC07D9AFC7CE93058A2
         * uid : 11336
         * userId : null
         * username : 17316441397
         */

        private Object age;
        private String appkey;
        private String appsecret;
        private String createtime;
        private Object email;
        private Object fans;
        private Object follow;
        private Object gender;
        private Object icon;
        private Object latitude;
        private Object longitude;
        private String mobile;
        private Object money;
        private String nickname;
        private String password;
        private Object praiseNum;
        private String token;
        private String uid;
        private Object userId;
        private String username;

        public Object getAge() {
            return age;
        }

        public void setAge(Object age) {
            this.age = age;
        }

        public String getAppkey() {
            return appkey;
        }

        public void setAppkey(String appkey) {
            this.appkey = appkey;
        }

        public String getAppsecret() {
            return appsecret;
        }

        public void setAppsecret(String appsecret) {
            this.appsecret = appsecret;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getFans() {
            return fans;
        }

        public void setFans(Object fans) {
            this.fans = fans;
        }

        public Object getFollow() {
            return follow;
        }

        public void setFollow(Object follow) {
            this.follow = follow;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public Object getIcon() {
            return icon;
        }

        public void setIcon(Object icon) {
            this.icon = icon;
        }

        public Object getLatitude() {
            return latitude;
        }

        public void setLatitude(Object latitude) {
            this.latitude = latitude;
        }

        public Object getLongitude() {
            return longitude;
        }

        public void setLongitude(Object longitude) {
            this.longitude = longitude;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getMoney() {
            return money;
        }

        public void setMoney(Object money) {
            this.money = money;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
