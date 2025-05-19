package jxl.write.biff;

import com.logan.flight.FlightConfig;
import jxl.biff.Type;
import jxl.biff.WritableRecordData;

/* loaded from: classes4.dex */
class InterfaceHeaderRecord extends WritableRecordData {
    public InterfaceHeaderRecord() {
        super(Type.INTERFACEHDR);
    }

    @Override // jxl.biff.WritableRecordData
    public byte[] getData() {
        return new byte[]{FlightConfig.ATOM_SE, 4};
    }
}
