package org.apache.poi.openxml4j.opc.internal;

import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.openxml4j.opc.ContentTypes;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageProperties;
import org.apache.poi.openxml4j.util.Nullable;

/* loaded from: classes5.dex */
public final class PackagePropertiesPart extends PackagePart implements PackageProperties {
    public static final String NAMESPACE_CP_URI = "http://schemas.openxmlformats.org/package/2006/metadata/core-properties";
    public static final String NAMESPACE_DCTERMS_URI = "http://purl.org/dc/terms/";
    public static final String NAMESPACE_DC_URI = "http://purl.org/dc/elements/1.1/";
    protected Nullable<String> category;
    protected Nullable<String> contentStatus;
    protected Nullable<String> contentType;
    protected Nullable<Date> created;
    protected Nullable<String> creator;
    protected Nullable<String> description;
    protected Nullable<String> identifier;
    protected Nullable<String> keywords;
    protected Nullable<String> language;
    protected Nullable<String> lastModifiedBy;
    protected Nullable<Date> lastPrinted;
    protected Nullable<Date> modified;
    protected Nullable<String> revision;
    protected Nullable<String> subject;
    protected Nullable<String> title;
    protected Nullable<String> version;

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public void close() {
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public void flush() {
    }

    public PackagePropertiesPart(OPCPackage oPCPackage, PackagePartName packagePartName) throws InvalidFormatException {
        super(oPCPackage, packagePartName, ContentTypes.CORE_PROPERTIES_PART);
        this.category = new Nullable<>();
        this.contentStatus = new Nullable<>();
        this.contentType = new Nullable<>();
        this.created = new Nullable<>();
        this.creator = new Nullable<>();
        this.description = new Nullable<>();
        this.identifier = new Nullable<>();
        this.keywords = new Nullable<>();
        this.language = new Nullable<>();
        this.lastModifiedBy = new Nullable<>();
        this.lastPrinted = new Nullable<>();
        this.modified = new Nullable<>();
        this.revision = new Nullable<>();
        this.subject = new Nullable<>();
        this.title = new Nullable<>();
        this.version = new Nullable<>();
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<String> getCategoryProperty() {
        return this.category;
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<String> getContentStatusProperty() {
        return this.contentStatus;
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<String> getContentTypeProperty() {
        return this.contentType;
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<Date> getCreatedProperty() {
        return this.created;
    }

    public String getCreatedPropertyString() {
        return getDateValue(this.created);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<String> getCreatorProperty() {
        return this.creator;
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<String> getDescriptionProperty() {
        return this.description;
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<String> getIdentifierProperty() {
        return this.identifier;
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<String> getKeywordsProperty() {
        return this.keywords;
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<String> getLanguageProperty() {
        return this.language;
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<String> getLastModifiedByProperty() {
        return this.lastModifiedBy;
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<Date> getLastPrintedProperty() {
        return this.lastPrinted;
    }

    public String getLastPrintedPropertyString() {
        return getDateValue(this.lastPrinted);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<Date> getModifiedProperty() {
        return this.modified;
    }

    public String getModifiedPropertyString() {
        if (this.modified.hasValue()) {
            return getDateValue(this.modified);
        }
        return getDateValue(new Nullable<>(new Date()));
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<String> getRevisionProperty() {
        return this.revision;
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<String> getSubjectProperty() {
        return this.subject;
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<String> getTitleProperty() {
        return this.title;
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public Nullable<String> getVersionProperty() {
        return this.version;
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setCategoryProperty(String str) {
        this.category = setStringValue(str);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setContentStatusProperty(String str) {
        this.contentStatus = setStringValue(str);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setContentTypeProperty(String str) {
        this.contentType = setStringValue(str);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setCreatedProperty(String str) {
        try {
            this.created = setDateValue(str);
        } catch (InvalidFormatException e) {
            new IllegalArgumentException("created  : " + e.getLocalizedMessage());
        }
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setCreatedProperty(Nullable<Date> nullable) {
        if (nullable.hasValue()) {
            this.created = nullable;
        }
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setCreatorProperty(String str) {
        this.creator = setStringValue(str);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setDescriptionProperty(String str) {
        this.description = setStringValue(str);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setIdentifierProperty(String str) {
        this.identifier = setStringValue(str);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setKeywordsProperty(String str) {
        this.keywords = setStringValue(str);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setLanguageProperty(String str) {
        this.language = setStringValue(str);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setLastModifiedByProperty(String str) {
        this.lastModifiedBy = setStringValue(str);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setLastPrintedProperty(String str) {
        try {
            this.lastPrinted = setDateValue(str);
        } catch (InvalidFormatException e) {
            new IllegalArgumentException("lastPrinted  : " + e.getLocalizedMessage());
        }
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setLastPrintedProperty(Nullable<Date> nullable) {
        if (nullable.hasValue()) {
            this.lastPrinted = nullable;
        }
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setModifiedProperty(String str) {
        try {
            this.modified = setDateValue(str);
        } catch (InvalidFormatException e) {
            new IllegalArgumentException("modified  : " + e.getLocalizedMessage());
        }
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setModifiedProperty(Nullable<Date> nullable) {
        if (nullable.hasValue()) {
            this.modified = nullable;
        }
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setRevisionProperty(String str) {
        this.revision = setStringValue(str);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setSubjectProperty(String str) {
        this.subject = setStringValue(str);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setTitleProperty(String str) {
        this.title = setStringValue(str);
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setVersionProperty(String str) {
        this.version = setStringValue(str);
    }

    private Nullable<String> setStringValue(String str) {
        if (str == null || str.equals("")) {
            return new Nullable<>();
        }
        return new Nullable<>(str);
    }

    private Nullable<Date> setDateValue(String str) throws InvalidFormatException {
        if (str == null || str.equals("")) {
            return new Nullable<>();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date parse = simpleDateFormat.parse(str, new ParsePosition(0));
        if (parse == null) {
            throw new InvalidFormatException("Date not well formated");
        }
        return new Nullable<>(parse);
    }

    private String getDateValue(Nullable<Date> nullable) {
        Date value;
        if (nullable == null || (value = nullable.getValue()) == null) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(value);
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    protected InputStream getInputStreamImpl() {
        throw new InvalidOperationException("Operation not authorized. This part may only be manipulated using the getters and setters on PackagePropertiesPart");
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    protected OutputStream getOutputStreamImpl() {
        throw new InvalidOperationException("Can't use output stream to set properties !");
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public boolean save(OutputStream outputStream) {
        throw new InvalidOperationException("Operation not authorized. This part may only be manipulated using the getters and setters on PackagePropertiesPart");
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public boolean load(InputStream inputStream) {
        throw new InvalidOperationException("Operation not authorized. This part may only be manipulated using the getters and setters on PackagePropertiesPart");
    }
}
