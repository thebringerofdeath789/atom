package org.apache.poi.hssf.model;

import org.apache.poi.ddf.EscherClientDataRecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherSpRecord;
import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
import org.apache.poi.hssf.record.EndSubRecord;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSimpleShape;

@Deprecated
/* loaded from: classes4.dex */
public class SimpleFilledShape extends AbstractShape {
    private ObjRecord objRecord;
    private EscherContainerRecord spContainer;

    SimpleFilledShape(HSSFSimpleShape hSSFSimpleShape, int i) {
        this.spContainer = createSpContainer(hSSFSimpleShape, i);
        this.objRecord = createObjRecord(hSSFSimpleShape, i);
    }

    private EscherContainerRecord createSpContainer(HSSFSimpleShape hSSFSimpleShape, int i) {
        EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
        EscherSpRecord escherSpRecord = new EscherSpRecord();
        EscherOptRecord escherOptRecord = new EscherOptRecord();
        EscherClientDataRecord escherClientDataRecord = new EscherClientDataRecord();
        escherContainerRecord.setRecordId(EscherContainerRecord.SP_CONTAINER);
        escherContainerRecord.setOptions((short) 15);
        escherSpRecord.setRecordId(EscherSpRecord.RECORD_ID);
        escherSpRecord.setOptions((short) ((objTypeToShapeType(hSSFSimpleShape.getShapeType()) << 4) | 2));
        escherSpRecord.setShapeId(i);
        escherSpRecord.setFlags(2560);
        escherOptRecord.setRecordId(EscherOptRecord.RECORD_ID);
        addStandardOptions(hSSFSimpleShape, escherOptRecord);
        EscherRecord createAnchor = createAnchor(hSSFSimpleShape.getAnchor());
        escherClientDataRecord.setRecordId(EscherClientDataRecord.RECORD_ID);
        escherClientDataRecord.setOptions((short) 0);
        escherContainerRecord.addChildRecord(escherSpRecord);
        escherContainerRecord.addChildRecord(escherOptRecord);
        escherContainerRecord.addChildRecord(createAnchor);
        escherContainerRecord.addChildRecord(escherClientDataRecord);
        return escherContainerRecord;
    }

    private short objTypeToShapeType(int i) {
        if (i == 3) {
            return (short) 3;
        }
        if (i == 1) {
            return (short) 1;
        }
        throw new IllegalArgumentException("Unable to handle an object of this type");
    }

    private ObjRecord createObjRecord(HSSFShape hSSFShape, int i) {
        ObjRecord objRecord = new ObjRecord();
        CommonObjectDataSubRecord commonObjectDataSubRecord = new CommonObjectDataSubRecord();
        commonObjectDataSubRecord.setObjectType((short) ((HSSFSimpleShape) hSSFShape).getShapeType());
        commonObjectDataSubRecord.setObjectId(getCmoObjectId(i));
        commonObjectDataSubRecord.setLocked(true);
        commonObjectDataSubRecord.setPrintable(true);
        commonObjectDataSubRecord.setAutofill(true);
        commonObjectDataSubRecord.setAutoline(true);
        EndSubRecord endSubRecord = new EndSubRecord();
        objRecord.addSubRecord(commonObjectDataSubRecord);
        objRecord.addSubRecord(endSubRecord);
        return objRecord;
    }

    @Override // org.apache.poi.hssf.model.AbstractShape
    public EscherContainerRecord getSpContainer() {
        return this.spContainer;
    }

    @Override // org.apache.poi.hssf.model.AbstractShape
    public ObjRecord getObjRecord() {
        return this.objRecord;
    }
}
