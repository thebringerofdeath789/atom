package org.apache.poi.hpsf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import org.apache.poi.hpsf.wellknown.PropertyIDMap;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.util.LittleEndian;

/* loaded from: classes4.dex */
public abstract class SpecialPropertySet extends MutablePropertySet {
    private MutablePropertySet delegate;

    public abstract PropertyIDMap getPropertySetIDMap();

    public SpecialPropertySet(PropertySet propertySet) {
        this.delegate = new MutablePropertySet(propertySet);
    }

    public SpecialPropertySet(MutablePropertySet mutablePropertySet) {
        this.delegate = mutablePropertySet;
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public int getByteOrder() {
        return this.delegate.getByteOrder();
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public int getFormat() {
        return this.delegate.getFormat();
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public int getOSVersion() {
        return this.delegate.getOSVersion();
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public ClassID getClassID() {
        return this.delegate.getClassID();
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public int getSectionCount() {
        return this.delegate.getSectionCount();
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public List<Section> getSections() {
        return this.delegate.getSections();
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public boolean isSummaryInformation() {
        return this.delegate.isSummaryInformation();
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public boolean isDocumentSummaryInformation() {
        return this.delegate.isDocumentSummaryInformation();
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public Section getFirstSection() {
        return this.delegate.getFirstSection();
    }

    @Override // org.apache.poi.hpsf.MutablePropertySet
    public void addSection(Section section) {
        this.delegate.addSection(section);
    }

    @Override // org.apache.poi.hpsf.MutablePropertySet
    public void clearSections() {
        this.delegate.clearSections();
    }

    @Override // org.apache.poi.hpsf.MutablePropertySet
    public void setByteOrder(int i) {
        this.delegate.setByteOrder(i);
    }

    @Override // org.apache.poi.hpsf.MutablePropertySet
    public void setClassID(ClassID classID) {
        this.delegate.setClassID(classID);
    }

    @Override // org.apache.poi.hpsf.MutablePropertySet
    public void setFormat(int i) {
        this.delegate.setFormat(i);
    }

    @Override // org.apache.poi.hpsf.MutablePropertySet
    public void setOSVersion(int i) {
        this.delegate.setOSVersion(i);
    }

    @Override // org.apache.poi.hpsf.MutablePropertySet
    public InputStream toInputStream() throws IOException, WritingNotSupportedException {
        return this.delegate.toInputStream();
    }

    @Override // org.apache.poi.hpsf.MutablePropertySet
    public void write(DirectoryEntry directoryEntry, String str) throws WritingNotSupportedException, IOException {
        this.delegate.write(directoryEntry, str);
    }

    @Override // org.apache.poi.hpsf.MutablePropertySet
    public void write(OutputStream outputStream) throws WritingNotSupportedException, IOException {
        this.delegate.write(outputStream);
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public boolean equals(Object obj) {
        return this.delegate.equals(obj);
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public Property[] getProperties() throws NoSingleSectionException {
        return this.delegate.getProperties();
    }

    @Override // org.apache.poi.hpsf.PropertySet
    protected Object getProperty(int i) throws NoSingleSectionException {
        return this.delegate.getProperty(i);
    }

    @Override // org.apache.poi.hpsf.PropertySet
    protected boolean getPropertyBooleanValue(int i) throws NoSingleSectionException {
        return this.delegate.getPropertyBooleanValue(i);
    }

    @Override // org.apache.poi.hpsf.PropertySet
    protected int getPropertyIntValue(int i) throws NoSingleSectionException {
        return this.delegate.getPropertyIntValue(i);
    }

    protected String getPropertyStringValue(int i) {
        return getPropertyStringValue(getProperty(i));
    }

    protected static String getPropertyStringValue(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (bArr.length == 0) {
                return "";
            }
            if (bArr.length == 1) {
                return Byte.toString(bArr[0]);
            }
            if (bArr.length == 2) {
                return Integer.toString(LittleEndian.getUShort(bArr));
            }
            if (bArr.length == 4) {
                return Long.toString(LittleEndian.getUInt(bArr));
            }
            return new String(bArr);
        }
        return obj.toString();
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public int hashCode() {
        return this.delegate.hashCode();
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public String toString() {
        return this.delegate.toString();
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public boolean wasNull() throws NoSingleSectionException {
        return this.delegate.wasNull();
    }
}
