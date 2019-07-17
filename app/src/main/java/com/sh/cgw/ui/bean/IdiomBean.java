package com.sh.cgw.ui.bean;

import java.util.List;

/**
 * 作者：created by cgw on 2019/7/15 23:13
 * 类注释：
 */
public class IdiomBean {


    /**
     * reason : success
     * result : {"bushou":"亠","head":"亡","pinyin":"wáng yáng bǔ láo","chengyujs":" 亡：逃亡，丢失；牢：关牲口的圈。羊逃跑了再去修补羊圈，还不算晚。比喻出了问题以后想办法补救，可以防止继续受损失。","from_":" 《战国策·楚策》：\u201c见兔而顾犬，未为晚也；亡羊而补牢，未为迟也。\u201d","example":" 张学良始则失地，今幸固守锦州，～，可称晚悟。 章炳麟《与孙思昉论时事书》二","yufa":" 连动式；作主语、谓语、宾语；含贬义","ciyujs":null,"yinzhengjs":"《战国策·楚策四》：\u201c见菟而顾犬，未为晚也；亡羊而补牢，未为迟也。\u201d谓走失了羊，赶快修补羊圈，还不算晚。比喻失误后及时补救。 宋 陆游 《秋兴》诗：\u201c惩羹吹虀岂其非，亡羊补牢理所宜。\u201d中国近代史资料丛刊《辛亥革命·武昌起义清方档案·清吏条陈》：\u201c以上所陈，皆今日维繫人心，亡羊补牢之计。\u201d","tongyi":null,"fanyi":["时不我待"]}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * bushou : 亠
         * head : 亡
         * pinyin : wáng yáng bǔ láo
         * chengyujs :  亡：逃亡，丢失；牢：关牲口的圈。羊逃跑了再去修补羊圈，还不算晚。比喻出了问题以后想办法补救，可以防止继续受损失。
         * from_ :  《战国策·楚策》：“见兔而顾犬，未为晚也；亡羊而补牢，未为迟也。”
         * example :  张学良始则失地，今幸固守锦州，～，可称晚悟。 章炳麟《与孙思昉论时事书》二
         * yufa :  连动式；作主语、谓语、宾语；含贬义
         * ciyujs : null
         * yinzhengjs : 《战国策·楚策四》：“见菟而顾犬，未为晚也；亡羊而补牢，未为迟也。”谓走失了羊，赶快修补羊圈，还不算晚。比喻失误后及时补救。 宋 陆游 《秋兴》诗：“惩羹吹虀岂其非，亡羊补牢理所宜。”中国近代史资料丛刊《辛亥革命·武昌起义清方档案·清吏条陈》：“以上所陈，皆今日维繫人心，亡羊补牢之计。”
         * tongyi : null
         * fanyi : ["时不我待"]
         */

        private String bushou;
        private String head;
        private String pinyin;
        private String chengyujs;
        private String from_;
        private String example;
        private String yufa;
        private Object ciyujs;
        private String yinzhengjs;
        private Object tongyi;
        private List<String> fanyi;

        public String getBushou() {
            return bushou;
        }

        public void setBushou(String bushou) {
            this.bushou = bushou;
        }

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public String getPinyin() {
            return pinyin;
        }

        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }

        public String getChengyujs() {
            return chengyujs;
        }

        public void setChengyujs(String chengyujs) {
            this.chengyujs = chengyujs;
        }

        public String getFrom_() {
            return from_;
        }

        public void setFrom_(String from_) {
            this.from_ = from_;
        }

        public String getExample() {
            return example;
        }

        public void setExample(String example) {
            this.example = example;
        }

        public String getYufa() {
            return yufa;
        }

        public void setYufa(String yufa) {
            this.yufa = yufa;
        }

        public Object getCiyujs() {
            return ciyujs;
        }

        public void setCiyujs(Object ciyujs) {
            this.ciyujs = ciyujs;
        }

        public String getYinzhengjs() {
            return yinzhengjs;
        }

        public void setYinzhengjs(String yinzhengjs) {
            this.yinzhengjs = yinzhengjs;
        }

        public Object getTongyi() {
            return tongyi;
        }

        public void setTongyi(Object tongyi) {
            this.tongyi = tongyi;
        }

        public List<String> getFanyi() {
            return fanyi;
        }

        public void setFanyi(List<String> fanyi) {
            this.fanyi = fanyi;
        }
    }
}
