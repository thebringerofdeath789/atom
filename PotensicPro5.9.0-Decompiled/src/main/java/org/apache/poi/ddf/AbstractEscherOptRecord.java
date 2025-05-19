package org.apache.poi.ddf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;

/* loaded from: classes4.dex */
public abstract class AbstractEscherOptRecord extends EscherRecord {
    protected List<EscherProperty> properties = new ArrayList();

    public void addEscherProperty(EscherProperty escherProperty) {
        this.properties.add(escherProperty);
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        int readHeader = readHeader(bArr, i);
        short readInstance = readInstance(bArr, i);
        this.properties = new EscherPropertyFactory().createProperties(bArr, i + 8, readInstance);
        return readHeader + 8;
    }

    public List<EscherProperty> getEscherProperties() {
        return this.properties;
    }

    public EscherProperty getEscherProperty(int i) {
        return this.properties.get(i);
    }

    private int getPropertiesSize() {
        Iterator<EscherProperty> it = this.properties.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().getPropertySize();
        }
        return i;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return getPropertiesSize() + 8;
    }

    public <T extends EscherProperty> T lookup(int i) {
        Iterator<EscherProperty> it = this.properties.iterator();
        while (it.hasNext()) {
            T t = (T) it.next();
            if (t.getPropertyNumber() == i) {
                return t;
            }
        }
        return null;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        LittleEndian.putShort(bArr, i, getOptions());
        LittleEndian.putShort(bArr, i + 2, getRecordId());
        LittleEndian.putInt(bArr, i + 4, getPropertiesSize());
        int i2 = i + 8;
        Iterator<EscherProperty> it = this.properties.iterator();
        while (it.hasNext()) {
            i2 += it.next().serializeSimplePart(bArr, i2);
        }
        Iterator<EscherProperty> it2 = this.properties.iterator();
        while (it2.hasNext()) {
            i2 += it2.next().serializeComplexPart(bArr, i2);
        }
        int i3 = i2 - i;
        escherSerializationListener.afterRecordSerialize(i2, getRecordId(), i3, this);
        return i3;
    }

    public void sortProperties() {
        Collections.sort(this.properties, new Comparator<EscherProperty>() { // from class: org.apache.poi.ddf.AbstractEscherOptRecord.1
            @Override // java.util.Comparator
            public int compare(EscherProperty escherProperty, EscherProperty escherProperty2) {
                short propertyNumber = escherProperty.getPropertyNumber();
                short propertyNumber2 = escherProperty2.getPropertyNumber();
                if (propertyNumber < propertyNumber2) {
                    return -1;
                }
                return propertyNumber == propertyNumber2 ? 0 : 1;
            }
        });
    }

    public void setEscherProperty(EscherProperty escherProperty) {
        Iterator<EscherProperty> it = this.properties.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == escherProperty.getId()) {
                it.remove();
            }
        }
        this.properties.add(escherProperty);
        sortProperties();
    }

    public void removeEscherProperty(int i) {
        Iterator<EscherProperty> it = getEscherProperties().iterator();
        while (it.hasNext()) {
            if (it.next().getPropertyNumber() == i) {
                it.remove();
            }
        }
    }

    public String toString() {
        String property = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append(":");
        sb.append(property);
        sb.append("  isContainer: ");
        sb.append(isContainerRecord());
        sb.append(property);
        sb.append("  version: 0x");
        sb.append(HexDump.toHex(getVersion()));
        sb.append(property);
        sb.append("  instance: 0x");
        sb.append(HexDump.toHex(getInstance()));
        sb.append(property);
        sb.append("  recordId: 0x");
        sb.append(HexDump.toHex(getRecordId()));
        sb.append(property);
        sb.append("  numchildren: ");
        sb.append(getChildRecords().size());
        sb.append(property);
        sb.append("  properties:");
        sb.append(property);
        Iterator<EscherProperty> it = this.properties.iterator();
        while (it.hasNext()) {
            sb.append("    " + it.next().toString() + property);
        }
        return sb.toString();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String toXml(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(formatXmlRecordHeader(getClass().getSimpleName(), HexDump.toHex(getRecordId()), HexDump.toHex(getVersion()), HexDump.toHex(getInstance())));
        Iterator<EscherProperty> it = getEscherProperties().iterator();
        while (it.hasNext()) {
            sb.append(it.next().toXml(str + "\t"));
        }
        sb.append(str).append("</").append(getClass().getSimpleName()).append(">\n");
        return sb.toString();
    }
}
