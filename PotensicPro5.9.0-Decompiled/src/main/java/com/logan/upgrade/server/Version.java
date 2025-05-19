package com.logan.upgrade.server;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class Version implements Serializable {
    private String brandcode;
    private String classname;
    private String classname_en;
    private String comparedate;
    private String downloadurl;
    private String downloadurl_backup;
    private String filename;
    private String filesize;
    private byte flightCode;
    private String flightType;
    private String id;
    private int isdel;
    private int isforce;
    private String json_link;
    private String language_more;
    private String localPath;
    private String md5file;
    private int priority_app;
    private String productclass;
    private String remark;
    private ArrayList<ProductData> typeList;
    private String updatedate;
    private String updatenote_cn;
    private String updatenote_en;
    private String version;
    private int weight;

    public ArrayList<ProductData> getTypeList() {
        return this.typeList;
    }

    public void setTypeList(ArrayList<ProductData> arrayList) {
        this.typeList = arrayList;
    }

    public static class ProductData {
        private String content;
        private int dev_id;
        private int size;
        private String type;
        private String version;

        public int getDev_id() {
            return this.dev_id;
        }

        public void setDev_id(int i) {
            this.dev_id = i;
        }

        public String getType() {
            return this.type;
        }

        public void setType(String str) {
            this.type = str;
        }

        public String getContent() {
            return this.content;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public String getVersion() {
            return this.version;
        }

        public void setVersion(String str) {
            this.version = str;
        }

        public int getSize() {
            return this.size;
        }

        public void setSize(int i) {
            this.size = i;
        }

        public String toString() {
            return "ProductData{dev_id=" + this.dev_id + ", type='" + this.type + "', content='" + this.content + "', version='" + this.version + "', size=" + this.size + '}';
        }
    }

    public String getJson_link() {
        return this.json_link;
    }

    public void setJson_link(String str) {
        this.json_link = str;
    }

    public String getLanguage_more() {
        return this.language_more;
    }

    public void setLanguage_more(String str) {
        this.language_more = str;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public byte getFlightCode() {
        return this.flightCode;
    }

    public void setFlightCode(byte b) {
        this.flightCode = b;
    }

    public int getIsforce() {
        return this.isforce;
    }

    public void setIsforce(int i) {
        this.isforce = i;
    }

    public String getFlightType() {
        return this.flightType;
    }

    public void setFlightType(String str) {
        this.flightType = str;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public void setLocalPath(String str) {
        this.localPath = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getClassname() {
        return this.classname;
    }

    public void setClassname(String str) {
        this.classname = str;
    }

    public String getProductclass() {
        return this.productclass;
    }

    public void setProductclass(String str) {
        this.productclass = str;
    }

    public String getFilesize() {
        return this.filesize;
    }

    public void setFilesize(String str) {
        this.filesize = str;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String str) {
        this.filename = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String getDownloadurl() {
        return this.downloadurl;
    }

    public void setDownloadurl(String str) {
        this.downloadurl = str;
    }

    public String getDownloadUrlBackup() {
        return this.downloadurl_backup;
    }

    public void setDownloadUrlBackup(String str) {
        this.downloadurl_backup = str;
    }

    public String getUpdatedate() {
        return this.updatedate;
    }

    public void setUpdatedate(String str) {
        this.updatedate = str;
    }

    public String getUpdatenote_en() {
        return this.updatenote_en;
    }

    public void setUpdatenote_en(String str) {
        this.updatenote_en = str;
    }

    public String getUpdatenote_cn() {
        return this.updatenote_cn;
    }

    public void setUpdatenote_cn(String str) {
        this.updatenote_cn = str;
    }

    public String getClassname_en() {
        return this.classname_en;
    }

    public void setClassname_en(String str) {
        this.classname_en = str;
    }

    public String getBrandcode() {
        return this.brandcode;
    }

    public void setBrandcode(String str) {
        this.brandcode = str;
    }

    public String getComparedate() {
        return this.comparedate;
    }

    public void setComparedate(String str) {
        this.comparedate = str;
    }

    public String getMd5file() {
        return this.md5file;
    }

    public void setMd5file(String str) {
        this.md5file = str;
    }

    public int getIsdel() {
        return this.isdel;
    }

    public void setIsdel(int i) {
        this.isdel = i;
    }

    public int getPriority_app() {
        return this.priority_app;
    }

    public void setPriority_app(int i) {
        this.priority_app = i;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int i) {
        this.weight = i;
    }

    public String toString() {
        return "Version{flightType='" + this.flightType + "', id='" + this.id + "', classname='" + this.classname + "', productclass='" + this.productclass + "', filesize='" + this.filesize + "', filename='" + this.filename + "', version='" + this.version + "', downloadurl='" + this.downloadurl + "', downloadurl_backup='" + this.downloadurl_backup + "', updatedate='" + this.updatedate + "', updatenote_en='" + this.updatenote_en + "', updatenote_cn='" + this.updatenote_cn + "', classname_en='" + this.classname_en + "', brandcode='" + this.brandcode + "', localPath='" + this.localPath + "', comparedate='" + this.comparedate + "', md5file='" + this.md5file + "', isdel=" + this.isdel + ", priority_app=" + this.priority_app + ", weight=" + this.weight + ", isforce=" + this.isforce + ", flightCode=" + ((int) this.flightCode) + ", remark='" + this.remark + "', json_link='" + this.json_link + "', language_more='" + this.language_more + "', typeList=" + this.typeList + '}';
    }
}
