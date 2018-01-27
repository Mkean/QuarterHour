package com.bwie.quarterhour.bean;

import java.util.List;

/**
 * 作者：王庆
 * 时间：2018/1/27
 */

public class VideoDetailsBean {

    /**
     * msg : 获取详情成功
     * code : 0
     * data : {"commentNum":7,"comments":[{"cid":59,"content":"%E4%BD%A0%E5%A5%BD","createTime":"2017-12-16T11:16:00","jid":null,"mvp":null,"nickname":"李灿灿","praiseNum":0,"uid":148,"wid":221},{"cid":70,"content":"yy","createTime":"2017-12-16T11:56:56","jid":null,"mvp":null,"nickname":"李灿灿","praiseNum":0,"uid":148,"wid":221},{"cid":96,"content":"123","createTime":"2017-12-18T14:51:02","jid":null,"mvp":null,"nickname":"123","praiseNum":0,"uid":2719,"wid":221},{"cid":98,"content":"狗","createTime":"2017-12-18T15:26:52","jid":null,"mvp":null,"nickname":"linnnn","praiseNum":0,"uid":114,"wid":221},{"cid":113,"content":"好好？","createTime":"2017-12-18T16:29:19","jid":null,"mvp":null,"nickname":"笑出腹肌的男人","praiseNum":0,"uid":154,"wid":221},{"cid":124,"content":"额","createTime":"2017-12-18T20:43:20","jid":null,"mvp":null,"nickname":"小五","praiseNum":0,"uid":313,"wid":221},{"cid":243,"content":"kasdjkasdjk","createTime":"2018-01-27T11:25:49","jid":null,"mvp":null,"nickname":"淘宝","praiseNum":0,"uid":2825,"wid":221}],"cover":"https://www.zhaoapi.cn/images/quarter/1513334984104cover.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":3,"latitude":"","localUri":null,"longitude":"","playNum":72,"praiseNum":4,"uid":154,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15136653175981513592154181.jpg","nickname":"笑出腹肌的男人","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/15133349841041513246461819.mp4","wid":221,"workDesc":"  "}
     */

    private String msg;
    private String code;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * commentNum : 7
         * comments : [{"cid":59,"content":"%E4%BD%A0%E5%A5%BD","createTime":"2017-12-16T11:16:00","jid":null,"mvp":null,"nickname":"李灿灿","praiseNum":0,"uid":148,"wid":221},{"cid":70,"content":"yy","createTime":"2017-12-16T11:56:56","jid":null,"mvp":null,"nickname":"李灿灿","praiseNum":0,"uid":148,"wid":221},{"cid":96,"content":"123","createTime":"2017-12-18T14:51:02","jid":null,"mvp":null,"nickname":"123","praiseNum":0,"uid":2719,"wid":221},{"cid":98,"content":"狗","createTime":"2017-12-18T15:26:52","jid":null,"mvp":null,"nickname":"linnnn","praiseNum":0,"uid":114,"wid":221},{"cid":113,"content":"好好？","createTime":"2017-12-18T16:29:19","jid":null,"mvp":null,"nickname":"笑出腹肌的男人","praiseNum":0,"uid":154,"wid":221},{"cid":124,"content":"额","createTime":"2017-12-18T20:43:20","jid":null,"mvp":null,"nickname":"小五","praiseNum":0,"uid":313,"wid":221},{"cid":243,"content":"kasdjkasdjk","createTime":"2018-01-27T11:25:49","jid":null,"mvp":null,"nickname":"淘宝","praiseNum":0,"uid":2825,"wid":221}]
         * cover : https://www.zhaoapi.cn/images/quarter/1513334984104cover.jpg
         * createTime : 2017-12-17T19:20:44
         * favoriteNum : 3
         * latitude : 
         * localUri : null
         * longitude : 
         * playNum : 72
         * praiseNum : 4
         * uid : 154
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15136653175981513592154181.jpg","nickname":"笑出腹肌的男人","praiseNum":"null"}
         * videoUrl : https://www.zhaoapi.cn/images/quarter/15133349841041513246461819.mp4
         * wid : 221
         * workDesc :   
         */

        private String commentNum;
        private String cover;
        private String createTime;
        private String favoriteNum;
        private String latitude;
        private Object localUri;
        private String longitude;
        private String playNum;
        private String praiseNum;
        private String uid;
        private UserBean user;
        private String videoUrl;
        private String wid;
        private String workDesc;
        private List<CommentsBean> comments;

        public String getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(String commentNum) {
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

        public String getFavoriteNum() {
            return favoriteNum;
        }

        public void setFavoriteNum(String favoriteNum) {
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

        public String getPlayNum() {
            return playNum;
        }

        public void setPlayNum(String playNum) {
            this.playNum = playNum;
        }

        public String getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(String praiseNum) {
            this.praiseNum = praiseNum;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
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

        public String getWid() {
            return wid;
        }

        public void setWid(String wid) {
            this.wid = wid;
        }

        public String getWorkDesc() {
            return workDesc;
        }

        public void setWorkDesc(String workDesc) {
            this.workDesc = workDesc;
        }

        public List<CommentsBean> getComments() {
            return comments;
        }

        public void setComments(List<CommentsBean> comments) {
            this.comments = comments;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/15136653175981513592154181.jpg
             * nickname : 笑出腹肌的男人
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

        public static class CommentsBean {
            /**
             * cid : 59
             * content : %E4%BD%A0%E5%A5%BD
             * createTime : 2017-12-16T11:16:00
             * jid : null
             * mvp : null
             * nickname : 李灿灿
             * praiseNum : 0
             * uid : 148
             * wid : 221
             */

            private String cid;
            private String content;
            private String createTime;
            private Object jid;
            private Object mvp;
            private String nickname;
            private String praiseNum;
            private String uid;
            private String wid;

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getJid() {
                return jid;
            }

            public void setJid(Object jid) {
                this.jid = jid;
            }

            public Object getMvp() {
                return mvp;
            }

            public void setMvp(Object mvp) {
                this.mvp = mvp;
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

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getWid() {
                return wid;
            }

            public void setWid(String wid) {
                this.wid = wid;
            }
        }
    }
}
