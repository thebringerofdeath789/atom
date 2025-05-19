package io.netty.handler.codec.xml;

/* loaded from: classes.dex */
public abstract class XmlContent {
    private final String data;

    protected XmlContent(String str) {
        this.data = str;
    }

    public String data() {
        return this.data;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.data;
        String str2 = ((XmlContent) obj).data;
        return str == null ? str2 == null : str.equals(str2);
    }

    public int hashCode() {
        String str = this.data;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "XmlContent{data='" + this.data + "'}";
    }
}
