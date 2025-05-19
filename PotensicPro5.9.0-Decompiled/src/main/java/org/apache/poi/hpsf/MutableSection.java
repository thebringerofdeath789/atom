package org.apache.poi.hpsf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.apache.poi.util.CodePageUtil;

/* loaded from: classes4.dex */
public class MutableSection extends Section {
    private boolean dirty;
    private List<Property> preprops;
    private byte[] sectionBytes;

    public MutableSection() {
        this.dirty = true;
        this.dirty = true;
        this.formatID = null;
        this.offset = -1L;
        this.preprops = new LinkedList();
    }

    public MutableSection(Section section) {
        this.dirty = true;
        setFormatID(section.getFormatID());
        Property[] properties = section.getProperties();
        MutableProperty[] mutablePropertyArr = new MutableProperty[properties.length];
        for (int i = 0; i < properties.length; i++) {
            mutablePropertyArr[i] = new MutableProperty(properties[i]);
        }
        setProperties(mutablePropertyArr);
        setDictionary(section.getDictionary());
    }

    public void setFormatID(ClassID classID) {
        this.formatID = classID;
    }

    public void setFormatID(byte[] bArr) {
        ClassID formatID = getFormatID();
        if (formatID == null) {
            formatID = new ClassID();
            setFormatID(formatID);
        }
        formatID.setBytes(bArr);
    }

    public void setProperties(Property[] propertyArr) {
        this.properties = propertyArr;
        this.preprops = new LinkedList();
        for (Property property : propertyArr) {
            this.preprops.add(property);
        }
        this.dirty = true;
    }

    public void setProperty(int i, String str) {
        setProperty(i, 31L, str);
        this.dirty = true;
    }

    public void setProperty(int i, int i2) {
        setProperty(i, 3L, Integer.valueOf(i2));
        this.dirty = true;
    }

    public void setProperty(int i, long j) {
        setProperty(i, 20L, Long.valueOf(j));
        this.dirty = true;
    }

    public void setProperty(int i, boolean z) {
        setProperty(i, 11L, Boolean.valueOf(z));
        this.dirty = true;
    }

    public void setProperty(int i, long j, Object obj) {
        MutableProperty mutableProperty = new MutableProperty();
        mutableProperty.setID(i);
        mutableProperty.setType(j);
        mutableProperty.setValue(obj);
        setProperty(mutableProperty);
        this.dirty = true;
    }

    public void setProperty(Property property) {
        removeProperty(property.getID());
        this.preprops.add(property);
        this.dirty = true;
    }

    public void removeProperty(long j) {
        Iterator<Property> it = this.preprops.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().getID() == j) {
                it.remove();
                break;
            }
        }
        this.dirty = true;
    }

    protected void setPropertyBooleanValue(int i, boolean z) {
        setProperty(i, 11L, Boolean.valueOf(z));
    }

    @Override // org.apache.poi.hpsf.Section
    public int getSize() {
        if (this.dirty) {
            try {
                this.size = calcSize();
                this.dirty = false;
            } catch (HPSFRuntimeException e) {
                throw e;
            } catch (Exception e2) {
                throw new HPSFRuntimeException(e2);
            }
        }
        return this.size;
    }

    private int calcSize() throws WritingNotSupportedException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        write(byteArrayOutputStream);
        byteArrayOutputStream.close();
        byte[] pad4 = Util.pad4(byteArrayOutputStream.toByteArray());
        this.sectionBytes = pad4;
        return pad4.length;
    }

    public int write(OutputStream outputStream) throws WritingNotSupportedException, IOException {
        int i;
        int writeDictionary;
        byte[] bArr;
        if (!this.dirty && (bArr = this.sectionBytes) != null) {
            outputStream.write(bArr);
            return this.sectionBytes.length;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        int propertyCount = (getPropertyCount() * 2 * 4) + 8 + 0;
        if (getProperty(0L) != null) {
            Object property = getProperty(1L);
            if (property != null) {
                if (!(property instanceof Integer)) {
                    throw new IllegalPropertySetDataException("The codepage property (ID = 1) must be an Integer object.");
                }
            } else {
                setProperty(1, 2L, 1200);
            }
            i = getCodepage();
        } else {
            i = -1;
        }
        Collections.sort(this.preprops, new Comparator<Property>() { // from class: org.apache.poi.hpsf.MutableSection.1
            @Override // java.util.Comparator
            public int compare(Property property2, Property property3) {
                if (property2.getID() < property3.getID()) {
                    return -1;
                }
                return property2.getID() == property3.getID() ? 0 : 1;
            }
        });
        ListIterator<Property> listIterator = this.preprops.listIterator();
        while (listIterator.hasNext()) {
            MutableProperty mutableProperty = (MutableProperty) listIterator.next();
            long id = mutableProperty.getID();
            TypeWriter.writeUIntToStream(byteArrayOutputStream2, mutableProperty.getID());
            TypeWriter.writeUIntToStream(byteArrayOutputStream2, propertyCount);
            if (id != 0) {
                writeDictionary = mutableProperty.write(byteArrayOutputStream, getCodepage());
            } else {
                if (i == -1) {
                    throw new IllegalPropertySetDataException("Codepage (property 1) is undefined.");
                }
                writeDictionary = writeDictionary(byteArrayOutputStream, this.dictionary, i);
            }
            propertyCount += writeDictionary;
        }
        byteArrayOutputStream.close();
        byteArrayOutputStream2.close();
        byte[] byteArray = byteArrayOutputStream2.toByteArray();
        byte[] byteArray2 = byteArrayOutputStream.toByteArray();
        TypeWriter.writeToStream(outputStream, byteArray.length + 8 + byteArray2.length);
        TypeWriter.writeToStream(outputStream, getPropertyCount());
        outputStream.write(byteArray);
        outputStream.write(byteArray2);
        return byteArray.length + 8 + byteArray2.length;
    }

    private static int writeDictionary(OutputStream outputStream, Map<Long, String> map, int i) throws IOException {
        int writeUIntToStream = TypeWriter.writeUIntToStream(outputStream, map.size());
        for (Long l : map.keySet()) {
            String str = map.get(l);
            if (i == 1200) {
                int length = str.length() + 1;
                if (length % 2 == 1) {
                    length++;
                }
                writeUIntToStream = writeUIntToStream + TypeWriter.writeUIntToStream(outputStream, l.longValue()) + TypeWriter.writeUIntToStream(outputStream, length);
                byte[] bytesInCodePage = CodePageUtil.getBytesInCodePage(str, i);
                for (int i2 = 2; i2 < bytesInCodePage.length; i2 += 2) {
                    outputStream.write(bytesInCodePage[i2 + 1]);
                    outputStream.write(bytesInCodePage[i2]);
                    writeUIntToStream += 2;
                }
                for (int length2 = length - str.length(); length2 > 0; length2--) {
                    outputStream.write(0);
                    outputStream.write(0);
                    writeUIntToStream += 2;
                }
            } else {
                int writeUIntToStream2 = writeUIntToStream + TypeWriter.writeUIntToStream(outputStream, l.longValue()) + TypeWriter.writeUIntToStream(outputStream, str.length() + 1);
                byte[] bytesInCodePage2 = CodePageUtil.getBytesInCodePage(str, i);
                for (byte b : bytesInCodePage2) {
                    outputStream.write(b);
                    writeUIntToStream2++;
                }
                outputStream.write(0);
                writeUIntToStream = writeUIntToStream2 + 1;
            }
        }
        return writeUIntToStream;
    }

    @Override // org.apache.poi.hpsf.Section
    public int getPropertyCount() {
        return this.preprops.size();
    }

    @Override // org.apache.poi.hpsf.Section
    public Property[] getProperties() {
        this.properties = (Property[]) this.preprops.toArray(new Property[0]);
        return this.properties;
    }

    @Override // org.apache.poi.hpsf.Section
    public Object getProperty(long j) {
        getProperties();
        return super.getProperty(j);
    }

    public void setDictionary(Map<Long, String> map) throws IllegalPropertySetDataException {
        if (map != null) {
            this.dictionary = map;
            setProperty(0, -1L, map);
            if (((Integer) getProperty(1L)) == null) {
                setProperty(1, 2L, 1200);
                return;
            }
            return;
        }
        removeProperty(0L);
    }

    public void setProperty(int i, Object obj) {
        if (obj instanceof String) {
            setProperty(i, (String) obj);
            return;
        }
        if (obj instanceof Long) {
            setProperty(i, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Integer) {
            setProperty(i, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Short) {
            setProperty(i, ((Short) obj).intValue());
        } else if (obj instanceof Boolean) {
            setProperty(i, ((Boolean) obj).booleanValue());
        } else {
            if (obj instanceof java.util.Date) {
                setProperty(i, 64L, obj);
                return;
            }
            throw new HPSFRuntimeException("HPSF does not support properties of type " + obj.getClass().getName() + ".");
        }
    }

    public void clear() {
        for (Property property : getProperties()) {
            removeProperty(property.getID());
        }
    }

    public void setCodepage(int i) {
        setProperty(1, 2L, Integer.valueOf(i));
    }
}
