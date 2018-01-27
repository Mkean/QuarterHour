package com.bwie.quarterhour.bean;

import java.util.List;

/**
 * 作者：王庆
 * 时间：2018/1/27
 */

public class VideosBean {

    /**
     * msg : 获取作品列表成功
     * code : 0
     * data : [{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1517025486173xniao.jpg","createTime":"2018-01-27T11:58:06","favoriteNum":0,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":1,"uid":2322,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15169660139571516966011147.png","nickname":"小翠\n","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517025486173minion_09.mp4","wid":268,"workDesc":"俞敏洪小视频"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1517017952764nyxb20170906-1-l.jpg","createTime":"2018-01-27T09:52:32","favoriteNum":0,"latitude":"156","localUri":null,"longitude":"150","playNum":0,"praiseNum":2,"uid":4814,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1517017459017nyxb20170906-1-l.jpg","nickname":"叫我飞哥好吗!","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517017952764xiaohuang.mp4","wid":267,"workDesc":"111"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1517016896244jqr.png","createTime":"2018-01-27T09:34:56","favoriteNum":1,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":0,"uid":2322,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15169660139571516966011147.png","nickname":"小翠\n","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517016896244ymh.mp4","wid":266,"workDesc":"俞敏洪小视频"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/15170166607103.jpg","createTime":"2018-01-27T09:31:00","favoriteNum":0,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":1,"uid":1497,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15160825477571516082546650.png","nickname":"哈哈","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517016660710xiaohuang.mp4","wid":265,"workDesc":"测试"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1517016640785car.jpg","createTime":"2018-01-27T09:30:40","favoriteNum":0,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":0,"uid":2322,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15169660139571516966011147.png","nickname":"小翠\n","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517016640785father.mp4","wid":264,"workDesc":"筷子兄弟\u2014父亲"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1517016424550jqr.png","createTime":"2018-01-27T09:27:04","favoriteNum":0,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":0,"uid":2322,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15169660139571516966011147.png","nickname":"小翠\n","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517016424550minion_09.mp4","wid":263,"workDesc":"minion_09"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1517016314502bz.png","createTime":"2018-01-27T09:25:14","favoriteNum":0,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":0,"uid":2322,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15169660139571516966011147.png","nickname":"小翠\n","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517016314502xiaohuang.mp4","wid":262,"workDesc":"xiaohuang"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1517015733057bz.png","createTime":"2018-01-27T09:15:33","favoriteNum":0,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":0,"uid":2322,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15169660139571516966011147.png","nickname":"小翠\n","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517015733057xiaoniao.mp4","wid":261,"workDesc":"xiaoniao"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1517015670876asddsa.jpg","createTime":"2018-01-27T09:14:31","favoriteNum":0,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":0,"uid":1497,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15160825477571516082546650.png","nickname":"哈哈","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517015670876xiaohuang.mp4","wid":260,"workDesc":"测试"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/15170151136271513341066240.jpg","createTime":"2018-01-27T09:05:13","favoriteNum":0,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":0,"uid":1758,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1516841991537timg.jpg","nickname":"熊猫","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517015113627haodeba.mp4","wid":259,"workDesc":null}]
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
         * commentNum : 0
         * comments : []
         * cover : https://www.zhaoapi.cn/images/quarter/1517025486173xniao.jpg
         * createTime : 2018-01-27T11:58:06
         * favoriteNum : 0
         * latitude : 39.95
         * localUri : null
         * longitude : 116.30
         * playNum : 0
         * praiseNum : 1
         * uid : 2322
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15169660139571516966011147.png","nickname":"小翠\n","praiseNum":"null"}
         * videoUrl : https://www.zhaoapi.cn/images/quarter/1517025486173minion_09.mp4
         * wid : 268
         * workDesc : 俞敏洪小视频
         */

        private int commentNum;
        private String cover;
        private String createTime;
        private int favoriteNum;
        private String latitude;
        private Object localUri;
        private String longitude;
        private int playNum;
        private int praiseNum;
        private int uid;
        private UserBean user;
        private String videoUrl;
        private int wid;
        private String workDesc;
        private List<?> comments;

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getFavoriteNum() {
            return favoriteNum;
        }

        public void setFavoriteNum(int favoriteNum) {
            this.favoriteNum = favoriteNum;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public Object getLocalUri() {
            return localUri;
        }

        public void setLocalUri(Object localUri) {
            this.localUri = localUri;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public int getPlayNum() {
            return playNum;
        }

        public void setPlayNum(int playNum) {
            this.playNum = playNum;
        }

        public int getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(int praiseNum) {
            this.praiseNum = praiseNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public int getWid() {
            return wid;
        }

        public void setWid(int wid) {
            this.wid = wid;
        }

        public String getWorkDesc() {
            return workDesc;
        }

        public void setWorkDesc(String workDesc) {
            this.workDesc = workDesc;
        }

        public List<?> getComments() {
            return comments;
        }

        public void setComments(List<?> comments) {
            this.comments = comments;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/15169660139571516966011147.png
             * nickname : 小翠

             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private String nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }
    }
}
