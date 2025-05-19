package com.logan.user.model.rev;

import java.io.Serializable;
import java.util.List;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public class RevUserGetTeachVideoResult extends BaseUserRevData implements Serializable {
    private int code;
    private List<Document> documents;
    private String msg;
    private int num;

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int i) {
        this.num = i;
    }

    public List<Document> getDocuments() {
        return this.documents;
    }

    public void setDocuments(List<Document> list) {
        this.documents = list;
    }

    public static class Document {
        private String date;
        private String detail;
        private String downloadurl;
        private String name;
        private String size;
        private String thumbnail;

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getDate() {
            return this.date;
        }

        public void setDate(String str) {
            this.date = str;
        }

        public String getSize() {
            return this.size;
        }

        public void setSize(String str) {
            this.size = str;
        }

        public String getDetail() {
            return this.detail;
        }

        public void setDetail(String str) {
            this.detail = str;
        }

        public String getThumbnail() {
            return this.thumbnail;
        }

        public void setThumbnail(String str) {
            this.thumbnail = str;
        }

        public String getDownloadurl() {
            return this.downloadurl;
        }

        public void setDownloadurl(String str) {
            this.downloadurl = str;
        }

        public String toString() {
            return "Document{name='" + this.name + "', date='" + this.date + "', size='" + this.size + "', detail='" + this.detail + "', thumbnail='" + this.thumbnail + "', downloadurl='" + this.downloadurl + "'}";
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RevUserGetTeachVideoResult{code=" + this.code + ", msg='" + this.msg + "', num=" + this.num + ", documents=");
        if (this.documents != null) {
            sb.append("{");
            for (int i = 0; i < this.documents.size(); i++) {
                sb.append(this.documents.get(i).toString());
            }
            sb.append(StringSubstitutor.DEFAULT_VAR_END);
        }
        return sb.toString();
    }
}
