package org.apache.poi.hpsf;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.hpsf.wellknown.SectionIDMap;
import org.apache.poi.util.LittleEndian;

/* loaded from: classes4.dex */
public class PropertySet {
    static final byte[] BYTE_ORDER_ASSERTION = {-2, -1};
    static final byte[] FORMAT_ASSERTION = {0, 0};
    public static final int OS_MACINTOSH = 1;
    public static final int OS_WIN16 = 0;
    public static final int OS_WIN32 = 2;
    protected int byteOrder;
    protected ClassID classID;
    protected int format;
    protected int osVersion;
    protected List<Section> sections;

    public int getByteOrder() {
        return this.byteOrder;
    }

    public int getFormat() {
        return this.format;
    }

    public int getOSVersion() {
        return this.osVersion;
    }

    public ClassID getClassID() {
        return this.classID;
    }

    public int getSectionCount() {
        return this.sections.size();
    }

    public List<Section> getSections() {
        return this.sections;
    }

    protected PropertySet() {
    }

    public PropertySet(InputStream inputStream) throws NoPropertySetStreamException, MarkUnsupportedException, IOException, UnsupportedEncodingException {
        if (isPropertySetStream(inputStream)) {
            int available = inputStream.available();
            byte[] bArr = new byte[available];
            inputStream.read(bArr, 0, available);
            init(bArr, 0, available);
            return;
        }
        throw new NoPropertySetStreamException();
    }

    public PropertySet(byte[] bArr, int i, int i2) throws NoPropertySetStreamException, UnsupportedEncodingException {
        if (isPropertySetStream(bArr, i, i2)) {
            init(bArr, i, i2);
            return;
        }
        throw new NoPropertySetStreamException();
    }

    public PropertySet(byte[] bArr) throws NoPropertySetStreamException, UnsupportedEncodingException {
        this(bArr, 0, bArr.length);
    }

    public static boolean isPropertySetStream(InputStream inputStream) throws MarkUnsupportedException, IOException {
        if (!inputStream.markSupported()) {
            throw new MarkUnsupportedException(inputStream.getClass().getName());
        }
        inputStream.mark(50);
        byte[] bArr = new byte[50];
        boolean isPropertySetStream = isPropertySetStream(bArr, 0, inputStream.read(bArr, 0, Math.min(50, inputStream.available())));
        inputStream.reset();
        return isPropertySetStream;
    }

    public static boolean isPropertySetStream(byte[] bArr, int i, int i2) {
        int uShort = LittleEndian.getUShort(bArr, i);
        int i3 = i + 2;
        byte[] bArr2 = new byte[2];
        LittleEndian.putShort(bArr2, 0, (short) uShort);
        if (!Util.equal(bArr2, BYTE_ORDER_ASSERTION)) {
            return false;
        }
        int uShort2 = LittleEndian.getUShort(bArr, i3);
        int i4 = i3 + 2;
        byte[] bArr3 = new byte[2];
        LittleEndian.putShort(bArr3, 0, (short) uShort2);
        return Util.equal(bArr3, FORMAT_ASSERTION) && LittleEndian.getUInt(bArr, (i4 + 4) + 16) >= 0;
    }

    private void init(byte[] bArr, int i, int i2) throws UnsupportedEncodingException {
        this.byteOrder = LittleEndian.getUShort(bArr, i);
        int i3 = i + 2;
        this.format = LittleEndian.getUShort(bArr, i3);
        int i4 = i3 + 2;
        this.osVersion = (int) LittleEndian.getUInt(bArr, i4);
        int i5 = i4 + 4;
        this.classID = new ClassID(bArr, i5);
        int i6 = i5 + 16;
        int i7 = LittleEndian.getInt(bArr, i6);
        int i8 = i6 + 4;
        if (i7 < 0) {
            throw new HPSFRuntimeException("Section count " + i7 + " is negative.");
        }
        this.sections = new ArrayList(i7);
        for (int i9 = 0; i9 < i7; i9++) {
            Section section = new Section(bArr, i8);
            i8 += 20;
            this.sections.add(section);
        }
    }

    public boolean isSummaryInformation() {
        if (this.sections.size() <= 0) {
            return false;
        }
        return Util.equal(this.sections.get(0).getFormatID().getBytes(), SectionIDMap.SUMMARY_INFORMATION_ID);
    }

    public boolean isDocumentSummaryInformation() {
        if (this.sections.size() <= 0) {
            return false;
        }
        return Util.equal(this.sections.get(0).getFormatID().getBytes(), SectionIDMap.DOCUMENT_SUMMARY_INFORMATION_ID[0]);
    }

    public Property[] getProperties() throws NoSingleSectionException {
        return getFirstSection().getProperties();
    }

    protected Object getProperty(int i) throws NoSingleSectionException {
        return getFirstSection().getProperty(i);
    }

    protected boolean getPropertyBooleanValue(int i) throws NoSingleSectionException {
        return getFirstSection().getPropertyBooleanValue(i);
    }

    protected int getPropertyIntValue(int i) throws NoSingleSectionException {
        return getFirstSection().getPropertyIntValue(i);
    }

    public boolean wasNull() throws NoSingleSectionException {
        return getFirstSection().wasNull();
    }

    public Section getFirstSection() {
        if (getSectionCount() < 1) {
            throw new MissingSectionException("Property set does not contain any sections.");
        }
        return this.sections.get(0);
    }

    public Section getSingleSection() {
        int sectionCount = getSectionCount();
        if (sectionCount != 1) {
            throw new NoSingleSectionException("Property set contains " + sectionCount + " sections.");
        }
        return this.sections.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof PropertySet)) {
            PropertySet propertySet = (PropertySet) obj;
            int byteOrder = propertySet.getByteOrder();
            int byteOrder2 = getByteOrder();
            ClassID classID = propertySet.getClassID();
            ClassID classID2 = getClassID();
            int format = propertySet.getFormat();
            int format2 = getFormat();
            int oSVersion = propertySet.getOSVersion();
            int oSVersion2 = getOSVersion();
            int sectionCount = propertySet.getSectionCount();
            int sectionCount2 = getSectionCount();
            if (byteOrder == byteOrder2 && classID.equals(classID2) && format == format2 && oSVersion == oSVersion2 && sectionCount == sectionCount2) {
                return Util.equals(getSections(), propertySet.getSections());
            }
        }
        return false;
    }

    public int hashCode() {
        throw new UnsupportedOperationException("FIXME: Not yet implemented.");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        int sectionCount = getSectionCount();
        stringBuffer.append(getClass().getName());
        stringBuffer.append(PropertyUtils.INDEXED_DELIM);
        stringBuffer.append("byteOrder: ");
        stringBuffer.append(getByteOrder());
        stringBuffer.append(", classID: ");
        stringBuffer.append(getClassID());
        stringBuffer.append(", format: ");
        stringBuffer.append(getFormat());
        stringBuffer.append(", OSVersion: ");
        stringBuffer.append(getOSVersion());
        stringBuffer.append(", sectionCount: ");
        stringBuffer.append(sectionCount);
        stringBuffer.append(", sections: [\n");
        Iterator<Section> it = getSections().iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
        }
        stringBuffer.append(PropertyUtils.INDEXED_DELIM2);
        stringBuffer.append(PropertyUtils.INDEXED_DELIM2);
        return stringBuffer.toString();
    }
}
