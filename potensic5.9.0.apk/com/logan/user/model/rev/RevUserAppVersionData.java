package com.logan.user.model.rev;

/* loaded from: classes3.dex */
public class RevUserAppVersionData extends BaseUserRevData {
    public static final int has_new_version = 0;
    private int code;
    private Version data;
    private String msg;

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public Version getData() {
        return this.data;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setData(Version version) {
        this.data = version;
    }

    public static class Version {
        String appname;
        String appver;
        int brandcode;
        int clienttype;
        String content;
        String down_url;
        int enable;

        /* renamed from: id */
        int f2677id;
        int isforceupdate;
        String modification_date;
        String release_date;

        public int getId() {
            return this.f2677id;
        }

        public int getBrandcode() {
            return this.brandcode;
        }

        public String getAppver() {
            return this.appver;
        }

        public String getAppname() {
            return this.appname;
        }

        public int getClienttype() {
            return this.clienttype;
        }

        public int getIsforceupdate() {
            return this.isforceupdate;
        }

        public int getEnable() {
            return this.enable;
        }

        public String getRelease_date() {
            return this.release_date;
        }

        public String getModification_date() {
            return this.modification_date;
        }

        public String getDown_url() {
            return this.down_url;
        }

        public String getContent() {
            return this.content;
        }

        public void setId(int i) {
            this.f2677id = i;
        }

        public void setBrandcode(int i) {
            this.brandcode = i;
        }

        public void setAppver(String str) {
            this.appver = str;
        }

        public void setAppname(String str) {
            this.appname = str;
        }

        public void setClienttype(int i) {
            this.clienttype = i;
        }

        public void setIsforceupdate(int i) {
            this.isforceupdate = i;
        }

        public void setEnable(int i) {
            this.enable = i;
        }

        public void setRelease_date(String str) {
            this.release_date = str;
        }

        public void setModification_date(String str) {
            this.modification_date = str;
        }

        public void setDown_url(String str) {
            this.down_url = str;
        }

        public void setContent(String str) {
            this.content = str;
        }
    }
}