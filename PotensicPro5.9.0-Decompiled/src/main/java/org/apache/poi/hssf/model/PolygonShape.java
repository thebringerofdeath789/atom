package org.apache.poi.hssf.model;

import org.apache.poi.ddf.EscherArrayProperty;
import org.apache.poi.ddf.EscherClientDataRecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherProperties;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherShapePathProperty;
import org.apache.poi.ddf.EscherSimpleProperty;
import org.apache.poi.ddf.EscherSpRecord;
import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
import org.apache.poi.hssf.record.EndSubRecord;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.hssf.usermodel.HSSFPolygon;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.util.LittleEndian;

@Deprecated
/* loaded from: classes4.dex */
public class PolygonShape extends AbstractShape {
    public static final short OBJECT_TYPE_MICROSOFT_OFFICE_DRAWING = 30;
    private ObjRecord objRecord;
    private EscherContainerRecord spContainer;

    PolygonShape(HSSFPolygon hSSFPolygon, int i) {
        this.spContainer = createSpContainer(hSSFPolygon, i);
        this.objRecord = createObjRecord(hSSFPolygon, i);
    }

    private EscherContainerRecord createSpContainer(HSSFPolygon hSSFPolygon, int i) {
        EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
        EscherSpRecord escherSpRecord = new EscherSpRecord();
        EscherOptRecord escherOptRecord = new EscherOptRecord();
        EscherRecord escherClientDataRecord = new EscherClientDataRecord();
        escherContainerRecord.setRecordId(EscherContainerRecord.SP_CONTAINER);
        escherContainerRecord.setOptions((short) 15);
        escherSpRecord.setRecordId(EscherSpRecord.RECORD_ID);
        escherSpRecord.setOptions((short) 2);
        escherSpRecord.setShapeId(i);
        if (hSSFPolygon.getParent() == null) {
            escherSpRecord.setFlags(2560);
        } else {
            escherSpRecord.setFlags(2562);
        }
        escherOptRecord.setRecordId(EscherOptRecord.RECORD_ID);
        escherOptRecord.addEscherProperty(new EscherSimpleProperty((short) 4, false, false, 0));
        escherOptRecord.addEscherProperty(new EscherSimpleProperty(EscherProperties.GEOMETRY__RIGHT, false, false, hSSFPolygon.getDrawAreaWidth()));
        escherOptRecord.addEscherProperty(new EscherSimpleProperty(EscherProperties.GEOMETRY__BOTTOM, false, false, hSSFPolygon.getDrawAreaHeight()));
        escherOptRecord.addEscherProperty(new EscherShapePathProperty(EscherProperties.GEOMETRY__SHAPEPATH, 4));
        EscherArrayProperty escherArrayProperty = new EscherArrayProperty(EscherProperties.GEOMETRY__VERTICES, false, new byte[0]);
        escherArrayProperty.setNumberOfElementsInArray(hSSFPolygon.getXPoints().length + 1);
        escherArrayProperty.setNumberOfElementsInMemory(hSSFPolygon.getXPoints().length + 1);
        escherArrayProperty.setSizeOfElements(65520);
        for (int i2 = 0; i2 < hSSFPolygon.getXPoints().length; i2++) {
            byte[] bArr = new byte[4];
            LittleEndian.putShort(bArr, 0, (short) hSSFPolygon.getXPoints()[i2]);
            LittleEndian.putShort(bArr, 2, (short) hSSFPolygon.getYPoints()[i2]);
            escherArrayProperty.setElement(i2, bArr);
        }
        int length = hSSFPolygon.getXPoints().length;
        byte[] bArr2 = new byte[4];
        LittleEndian.putShort(bArr2, 0, (short) hSSFPolygon.getXPoints()[0]);
        LittleEndian.putShort(bArr2, 2, (short) hSSFPolygon.getYPoints()[0]);
        escherArrayProperty.setElement(length, bArr2);
        escherOptRecord.addEscherProperty(escherArrayProperty);
        EscherArrayProperty escherArrayProperty2 = new EscherArrayProperty(EscherProperties.GEOMETRY__SEGMENTINFO, false, null);
        escherArrayProperty2.setSizeOfElements(2);
        escherArrayProperty2.setNumberOfElementsInArray((hSSFPolygon.getXPoints().length * 2) + 4);
        escherArrayProperty2.setNumberOfElementsInMemory((hSSFPolygon.getXPoints().length * 2) + 4);
        escherArrayProperty2.setElement(0, new byte[]{0, 64});
        escherArrayProperty2.setElement(1, new byte[]{0, -84});
        for (int i3 = 0; i3 < hSSFPolygon.getXPoints().length; i3++) {
            int i4 = i3 * 2;
            escherArrayProperty2.setElement(i4 + 2, new byte[]{1, 0});
            escherArrayProperty2.setElement(i4 + 3, new byte[]{0, -84});
        }
        escherArrayProperty2.setElement(escherArrayProperty2.getNumberOfElementsInArray() - 2, new byte[]{1, 96});
        escherArrayProperty2.setElement(escherArrayProperty2.getNumberOfElementsInArray() - 1, new byte[]{0, Byte.MIN_VALUE});
        escherOptRecord.addEscherProperty(escherArrayProperty2);
        escherOptRecord.addEscherProperty(new EscherSimpleProperty(EscherProperties.GEOMETRY__FILLOK, false, false, 65537));
        escherOptRecord.addEscherProperty(new EscherSimpleProperty(EscherProperties.LINESTYLE__LINESTARTARROWHEAD, false, false, 0));
        escherOptRecord.addEscherProperty(new EscherSimpleProperty(EscherProperties.LINESTYLE__LINEENDARROWHEAD, false, false, 0));
        escherOptRecord.addEscherProperty(new EscherSimpleProperty(EscherProperties.LINESTYLE__LINEENDCAPSTYLE, false, false, 0));
        addStandardOptions(hSSFPolygon, escherOptRecord);
        EscherRecord createAnchor = createAnchor(hSSFPolygon.getAnchor());
        escherClientDataRecord.setRecordId(EscherClientDataRecord.RECORD_ID);
        escherClientDataRecord.setOptions((short) 0);
        escherContainerRecord.addChildRecord(escherSpRecord);
        escherContainerRecord.addChildRecord(escherOptRecord);
        escherContainerRecord.addChildRecord(createAnchor);
        escherContainerRecord.addChildRecord(escherClientDataRecord);
        return escherContainerRecord;
    }

    private ObjRecord createObjRecord(HSSFShape hSSFShape, int i) {
        ObjRecord objRecord = new ObjRecord();
        CommonObjectDataSubRecord commonObjectDataSubRecord = new CommonObjectDataSubRecord();
        commonObjectDataSubRecord.setObjectType((short) 30);
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
