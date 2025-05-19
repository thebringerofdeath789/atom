package org.apache.poi.hssf.usermodel;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.ddf.EscherClientDataRecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
import org.apache.poi.hssf.record.EmbeddedObjectRefSubRecord;
import org.apache.poi.hssf.record.EscherAggregate;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.SubRecord;
import org.apache.poi.hssf.record.TextObjectRecord;
import org.apache.poi.poifs.filesystem.DirectoryNode;

/* loaded from: classes5.dex */
public class HSSFShapeFactory {
    private static final short OBJECT_TYPE_ARC = 4;
    private static final short OBJECT_TYPE_LINE = 1;
    private static final short OBJECT_TYPE_OVAL = 3;
    private static final short OBJECT_TYPE_PICTURE = 8;
    private static final short OBJECT_TYPE_RECTANGLE = 2;

    public static void createShapeTree(EscherContainerRecord escherContainerRecord, EscherAggregate escherAggregate, HSSFShapeContainer hSSFShapeContainer, DirectoryNode directoryNode) {
        HSSFShape hSSFSimpleShape;
        if (escherContainerRecord.getRecordId() == -4093) {
            EscherClientDataRecord escherClientDataRecord = (EscherClientDataRecord) ((EscherContainerRecord) escherContainerRecord.getChild(0)).getChildById(EscherClientDataRecord.RECORD_ID);
            HSSFShapeGroup hSSFShapeGroup = new HSSFShapeGroup(escherContainerRecord, escherClientDataRecord != null ? (ObjRecord) escherAggregate.getShapeToObjMapping().get(escherClientDataRecord) : null);
            List<EscherContainerRecord> childContainers = escherContainerRecord.getChildContainers();
            for (int i = 0; i < childContainers.size(); i++) {
                EscherContainerRecord escherContainerRecord2 = childContainers.get(i);
                if (i != 0) {
                    createShapeTree(escherContainerRecord2, escherAggregate, hSSFShapeGroup, directoryNode);
                }
            }
            hSSFShapeContainer.addShape(hSSFShapeGroup);
            return;
        }
        if (escherContainerRecord.getRecordId() == -4092) {
            Map<EscherRecord, Record> shapeToObjMapping = escherAggregate.getShapeToObjMapping();
            TextObjectRecord textObjectRecord = null;
            for (EscherRecord escherRecord : escherContainerRecord.getChildRecords()) {
                short recordId = escherRecord.getRecordId();
                if (recordId == -4083) {
                    textObjectRecord = (TextObjectRecord) shapeToObjMapping.get(escherRecord);
                } else if (recordId == -4079) {
                    r3 = (ObjRecord) shapeToObjMapping.get(escherRecord);
                }
            }
            if (isEmbeddedObject(r3)) {
                hSSFShapeContainer.addShape(new HSSFObjectData(escherContainerRecord, r3, directoryNode));
                return;
            }
            short objectType = ((CommonObjectDataSubRecord) r3.getSubRecords().get(0)).getObjectType();
            if (objectType == 1) {
                hSSFSimpleShape = new HSSFSimpleShape(escherContainerRecord, r3);
            } else if (objectType == 2) {
                hSSFSimpleShape = new HSSFSimpleShape(escherContainerRecord, r3, textObjectRecord);
            } else if (objectType == 6) {
                hSSFSimpleShape = new HSSFTextbox(escherContainerRecord, r3, textObjectRecord);
            } else if (objectType == 8) {
                hSSFSimpleShape = new HSSFPicture(escherContainerRecord, r3);
            } else if (objectType == 20) {
                hSSFSimpleShape = new HSSFCombobox(escherContainerRecord, r3);
            } else if (objectType == 25) {
                hSSFSimpleShape = new HSSFComment(escherContainerRecord, r3, textObjectRecord, escherAggregate.getNoteRecordByObj(r3));
            } else if (objectType == 30) {
                if (((EscherOptRecord) escherContainerRecord.getChildById(EscherOptRecord.RECORD_ID)).lookup(325) != null) {
                    hSSFSimpleShape = new HSSFPolygon(escherContainerRecord, r3, textObjectRecord);
                } else {
                    hSSFSimpleShape = new HSSFSimpleShape(escherContainerRecord, r3, textObjectRecord);
                }
            } else {
                hSSFSimpleShape = new HSSFSimpleShape(escherContainerRecord, r3, textObjectRecord);
            }
            hSSFShapeContainer.addShape(hSSFSimpleShape);
        }
    }

    private static boolean isEmbeddedObject(ObjRecord objRecord) {
        Iterator<SubRecord> it = objRecord.getSubRecords().iterator();
        while (it.hasNext()) {
            if (it.next() instanceof EmbeddedObjectRefSubRecord) {
                return true;
            }
        }
        return false;
    }
}
