package org.apache.poi;

/* loaded from: classes.dex */
public abstract class POIXMLRelation {
    private Class<? extends POIXMLDocumentPart> _cls;
    protected String _defaultName;
    protected String _relation;
    protected String _type;

    public POIXMLRelation(String str, String str2, String str3, Class<? extends POIXMLDocumentPart> cls) {
        this._type = str;
        this._relation = str2;
        this._defaultName = str3;
        this._cls = cls;
    }

    public POIXMLRelation(String str, String str2, String str3) {
        this(str, str2, str3, null);
    }

    public String getContentType() {
        return this._type;
    }

    public String getRelation() {
        return this._relation;
    }

    public String getDefaultFileName() {
        return this._defaultName;
    }

    public String getFileName(int i) {
        if (this._defaultName.indexOf("#") == -1) {
            return getDefaultFileName();
        }
        return this._defaultName.replace("#", Integer.toString(i));
    }

    public Integer getFileNameIndex(POIXMLDocumentPart pOIXMLDocumentPart) {
        return Integer.valueOf(Integer.parseInt(pOIXMLDocumentPart.getPackageRelationship().getTargetURI().getPath().replaceAll(this._defaultName.replace("#", "(\\d+)"), "$1")));
    }

    public Class<? extends POIXMLDocumentPart> getRelationClass() {
        return this._cls;
    }
}
