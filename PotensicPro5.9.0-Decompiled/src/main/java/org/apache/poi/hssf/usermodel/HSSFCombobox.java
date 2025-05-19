package org.apache.poi.hssf.usermodel;

import android.R;
import org.apache.poi.ddf.EscherBoolProperty;
import org.apache.poi.ddf.EscherClientDataRecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherProperties;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherSimpleProperty;
import org.apache.poi.ddf.EscherSpRecord;
import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
import org.apache.poi.hssf.record.EndSubRecord;
import org.apache.poi.hssf.record.FtCblsSubRecord;
import org.apache.poi.hssf.record.LbsDataSubRecord;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.hssf.record.TextObjectRecord;

/* loaded from: classes5.dex */
public class HSSFCombobox extends HSSFSimpleShape {
    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape
    protected TextObjectRecord createTextObjRecord() {
        return null;
    }

    public HSSFCombobox(EscherContainerRecord escherContainerRecord, ObjRecord objRecord) {
        super(escherContainerRecord, objRecord);
    }

    public HSSFCombobox(HSSFShape hSSFShape, HSSFAnchor hSSFAnchor) {
        super(hSSFShape, hSSFAnchor);
        super.setShapeType(201);
        ((CommonObjectDataSubRecord) getObjRecord().getSubRecords().get(0)).setObjectType((short) 20);
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape, org.apache.poi.hssf.usermodel.HSSFShape
    protected EscherContainerRecord createSpContainer() {
        EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
        EscherSpRecord escherSpRecord = new EscherSpRecord();
        EscherOptRecord escherOptRecord = new EscherOptRecord();
        EscherClientDataRecord escherClientDataRecord = new EscherClientDataRecord();
        escherContainerRecord.setRecordId(EscherContainerRecord.SP_CONTAINER);
        escherContainerRecord.setOptions((short) 15);
        escherSpRecord.setRecordId(EscherSpRecord.RECORD_ID);
        escherSpRecord.setOptions((short) 3218);
        escherSpRecord.setFlags(2560);
        escherOptRecord.setRecordId(EscherOptRecord.RECORD_ID);
        escherOptRecord.addEscherProperty(new EscherBoolProperty((short) 127, R.string.accessibility_system_action_dpad_left_label));
        escherOptRecord.addEscherProperty(new EscherBoolProperty((short) 191, 524296));
        escherOptRecord.addEscherProperty(new EscherBoolProperty(EscherProperties.LINESTYLE__NOLINEDRAWDASH, 524288));
        escherOptRecord.addEscherProperty(new EscherSimpleProperty((short) 959, 131072));
        HSSFClientAnchor hSSFClientAnchor = (HSSFClientAnchor) getAnchor();
        hSSFClientAnchor.setAnchorType(1);
        EscherRecord escherAnchor = hSSFClientAnchor.getEscherAnchor();
        escherClientDataRecord.setRecordId(EscherClientDataRecord.RECORD_ID);
        escherClientDataRecord.setOptions((short) 0);
        escherContainerRecord.addChildRecord(escherSpRecord);
        escherContainerRecord.addChildRecord(escherOptRecord);
        escherContainerRecord.addChildRecord(escherAnchor);
        escherContainerRecord.addChildRecord(escherClientDataRecord);
        return escherContainerRecord;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape, org.apache.poi.hssf.usermodel.HSSFShape
    protected ObjRecord createObjRecord() {
        ObjRecord objRecord = new ObjRecord();
        CommonObjectDataSubRecord commonObjectDataSubRecord = new CommonObjectDataSubRecord();
        commonObjectDataSubRecord.setObjectType((short) 201);
        commonObjectDataSubRecord.setLocked(true);
        commonObjectDataSubRecord.setPrintable(false);
        commonObjectDataSubRecord.setAutofill(true);
        commonObjectDataSubRecord.setAutoline(false);
        FtCblsSubRecord ftCblsSubRecord = new FtCblsSubRecord();
        LbsDataSubRecord newAutoFilterInstance = LbsDataSubRecord.newAutoFilterInstance();
        EndSubRecord endSubRecord = new EndSubRecord();
        objRecord.addSubRecord(commonObjectDataSubRecord);
        objRecord.addSubRecord(ftCblsSubRecord);
        objRecord.addSubRecord(newAutoFilterInstance);
        objRecord.addSubRecord(endSubRecord);
        return objRecord;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape
    public void setShapeType(int i) {
        throw new IllegalStateException("Shape type can not be changed in " + getClass().getSimpleName());
    }
}
