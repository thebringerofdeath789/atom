package com.logan.user.model.rev;

/* loaded from: classes3.dex */
public class RevUserSecurityTipsData extends BaseUserRevData {
    public static final int CODE_SUCCESS = 0;
    private int code;
    private SecurityTip data;
    private String msg;

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public SecurityTip getData() {
        return this.data;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setData(SecurityTip securityTip) {
        this.data = securityTip;
    }

    public static class SecurityTip {
        private String[] content;
        private int show_duration;
        private int show_interval;

        public int getShow_duration() {
            return this.show_duration;
        }

        public int getShow_interval() {
            return this.show_interval;
        }

        public String[] getContent() {
            return this.content;
        }

        public void setShow_duration(int i) {
            this.show_duration = i;
        }

        public void setShow_interval(int i) {
            this.show_interval = i;
        }

        public void setContent(String[] strArr) {
            this.content = strArr;
        }
    }
}