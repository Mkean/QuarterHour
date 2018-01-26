package com.bwie.quarterhour.bean;

import java.util.List;

/**
 * 作者：王庆
 * 时间：2018/1/24
 */

public class EpisodeBean {

    /**
     * msg : 获取段子列表成功
     * code : 0
     * data : [{"commentNum":null,"content":"nihaoa","createTime":"2018-01-24T15:19:59","imgUrls":null,"jid":1052,"praiseNum":null,"shareNum":null,"uid":4212,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"\"\"","createTime":"2018-01-24T14:56:10","imgUrls":null,"jid":1051,"praiseNum":null,"shareNum":null,"uid":4212,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"\"\"","createTime":"2018-01-24T14:55:22","imgUrls":null,"jid":1050,"praiseNum":null,"shareNum":null,"uid":4212,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"\"你好\"","createTime":"2018-01-24T14:54:19","imgUrls":null,"jid":1049,"praiseNum":null,"shareNum":null,"uid":4212,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"123456","createTime":"2018-01-24T11:22:01","imgUrls":null,"jid":1048,"praiseNum":null,"shareNum":null,"uid":11864,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"123456","createTime":"2018-01-23T16:44:05","imgUrls":null,"jid":1047,"praiseNum":null,"shareNum":null,"uid":11864,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"\"你好\"","createTime":"2018-01-22T19:51:28","imgUrls":null,"jid":1046,"praiseNum":null,"shareNum":null,"uid":4212,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"\"你好\"","createTime":"2018-01-22T19:34:32","imgUrls":null,"jid":1045,"praiseNum":null,"shareNum":null,"uid":4212,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"93335521","createTime":"2018-01-20T08:57:24","imgUrls":null,"jid":1044,"praiseNum":null,"shareNum":null,"uid":1703,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1514641278805head.jpg","nickname":"我的世界","praiseNum":"null"}},{"commentNum":null,"content":"好好学习","createTime":"2018-01-19T11:03:12","imgUrls":null,"jid":1043,"praiseNum":null,"shareNum":null,"uid":1059,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}}]
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
         * commentNum : null
         * content : nihaoa
         * createTime : 2018-01-24T15:19:59
         * imgUrls : null
         * jid : 1052
         * praiseNum : null
         * shareNum : null
         * uid : 4212
         * user : {"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}
         */

        private Object commentNum;
        private String content;
        private String createTime;
        private Object imgUrls;
        private String jid;
        private Object praiseNum;
        private Object shareNum;
        private String uid;
        private UserBean user;

        public Object getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(Object commentNum) {
            this.commentNum = commentNum;
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

        public Object getImgUrls() {
            return imgUrls;
        }

        public void setImgUrls(Object imgUrls) {
            this.imgUrls = imgUrls;
        }

        public String getJid() {
            return jid;
        }

        public void setJid(String jid) {
            this.jid = jid;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public Object getShareNum() {
            return shareNum;
        }

        public void setShareNum(Object shareNum) {
            this.shareNum = shareNum;
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

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : null
             * nickname : null
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private Object icon;
            private Object nickname;
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

            public Object getIcon() {
                return icon;
            }

            public void setIcon(Object icon) {
                this.icon = icon;
            }

            public Object getNickname() {
                return nickname;
            }

            public void setNickname(Object nickname) {
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
