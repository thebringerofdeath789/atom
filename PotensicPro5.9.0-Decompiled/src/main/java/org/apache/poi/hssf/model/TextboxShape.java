package org.apache.poi.hssf.model;

import org.apache.poi.ddf.EscherClientAnchorRecord;
import org.apache.poi.ddf.EscherClientDataRecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherSimpleProperty;
import org.apache.poi.ddf.EscherSpRecord;
import org.apache.poi.ddf.EscherTextboxRecord;
import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
import org.apache.poi.hssf.record.EndSubRecord;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.hssf.record.TextObjectRecord;
import org.apache.poi.hssf.usermodel.HSSFTextbox;

@Deprecated
/* loaded from: classes4.dex */
public class TextboxShape extends AbstractShape {
    private EscherTextboxRecord escherTextbox;
    private ObjRecord objRecord;
    private EscherContainerRecord spContainer;
    private TextObjectRecord textObjectRecord;

    TextboxShape(HSSFTextbox hSSFTextbox, int i) {
        this.spContainer = createSpContainer(hSSFTextbox, i);
        this.objRecord = createObjRecord(hSSFTextbox, i);
        this.textObjectRecord = createTextObjectRecord(hSSFTextbox, i);
    }

    private ObjRecord createObjRecord(HSSFTextbox hSSFTextbox, int i) {
        ObjRecord objRecord = new ObjRecord();
        CommonObjectDataSubRecord commonObjectDataSubRecord = new CommonObjectDataSubRecord();
        commonObjectDataSubRecord.setObjectType((short) hSSFTextbox.getShapeType());
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

    private EscherContainerRecord createSpContainer(HSSFTextbox hSSFTextbox, int i) {
        EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
        EscherSpRecord escherSpRecord = new EscherSpRecord();
        EscherOptRecord escherOptRecord = new EscherOptRecord();
        new EscherClientAnchorRecord();
        EscherClientDataRecord escherClientDataRecord = new EscherClientDataRecord();
        this.escherTextbox = new EscherTextboxRecord();
        escherContainerRecord.setRecordId(EscherContainerRecord.SP_CONTAINER);
        escherContainerRecord.setOptions((short) 15);
        escherSpRecord.setRecordId(EscherSpRecord.RECORD_ID);
        escherSpRecord.setOptions((short) 3234);
        escherSpRecord.setShapeId(i);
        escherSpRecord.setFlags(2560);
        escherOptRecord.setRecordId(EscherOptRecord.RECORD_ID);
        escherOptRecord.addEscherProperty(new EscherSimpleProperty((short) 128, 0));
        escherOptRecord.addEscherProperty(new EscherSimpleProperty((short) 129, hSSFTextbox.getMarginLeft()));
        escherOptRecord.addEscherProperty(new EscherSimpleProperty((short) 131, hSSFTextbox.getMarginRight()));
        escherOptRecord.addEscherProperty(new EscherSimpleProperty((short) 132, hSSFTextbox.getMarginBottom()));
        escherOptRecord.addEscherProperty(new EscherSimpleProperty((short) 130, hSSFTextbox.getMarginTop()));
        escherOptRecord.addEscherProperty(new EscherSimpleProperty((short) 133, 0));
        escherOptRecord.addEscherProperty(new EscherSimpleProperty((short) 135, 0));
        escherOptRecord.addEscherProperty(new EscherSimpleProperty((short) 959, 524288));
        addStandardOptions(hSSFTextbox, escherOptRecord);
        EscherRecord createAnchor = createAnchor(hSSFTextbox.getAnchor());
        escherClientDataRecord.setRecordId(EscherClientDataRecord.RECORD_ID);
        escherClientDataRecord.setOptions((short) 0);
        this.escherTextbox.setRecordId(EscherTextboxRecord.RECORD_ID);
        this.escherTextbox.setOptions((short) 0);
        escherContainerRecord.addChildRecord(escherSpRecord);
        escherContainerRecord.addChildRecord(escherOptRecord);
        escherContainerRecord.addChildRecord(createAnchor);
        escherContainerRecord.addChildRecord(escherClientDataRecord);
        escherContainerRecord.addChildRecord(this.escherTextbox);
        return escherContainerRecord;
    }

    private TextObjectRecord createTextObjectRecord(HSSFTextbox hSSFTextbox, int i) {
        TextObjectRecord textObjectRecord = new TextObjectRecord();
        textObjectRecord.setHorizontalTextAlignment(hSSFTextbox.getHorizontalAlignment());
        textObjectRecord.setVerticalTextAlignment(hSSFTextbox.getVerticalAlignment());
        textObjectRecord.setTextLocked(true);
        textObjectRecord.setTextOrientation(0);
        textObjectRecord.setStr(hSSFTextbox.getString());
        return textObjectRecord;
    }

    @Override // org.apache.poi.hssf.model.AbstractShape
    public EscherContainerRecord getSpContainer() {
        return this.spContainer;
    }

    @Override // org.apache.poi.hssf.model.AbstractShape
    public ObjRecord getObjRecord() {
        return this.objRecord;
    }

    public TextObjectRecord getTextObjectRecord() {
        return this.textObjectRecord;
    }

    public EscherRecord getEscherTextbox() {
        return this.escherTextbox;
    }
}
