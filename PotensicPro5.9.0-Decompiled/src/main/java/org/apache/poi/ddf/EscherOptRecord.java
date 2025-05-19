package org.apache.poi.ddf;

import java.util.Iterator;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.Internal;

/* loaded from: classes4.dex */
public class EscherOptRecord extends AbstractEscherOptRecord {
    public static final String RECORD_DESCRIPTION = "msofbtOPT";
    public static final short RECORD_ID = -4085;

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return "Opt";
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public short getInstance() {
        setInstance((short) this.properties.size());
        return super.getInstance();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    @Internal
    public short getOptions() {
        getInstance();
        getVersion();
        return super.getOptions();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public short getVersion() {
        setVersion((short) 3);
        return super.getVersion();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public void setVersion(short s) {
        if (s != 3) {
            throw new IllegalArgumentException("msofbtOPT can have only '0x3' version");
        }
        super.setVersion(s);
    }

    @Override // org.apache.poi.ddf.AbstractEscherOptRecord, org.apache.poi.ddf.EscherRecord
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
