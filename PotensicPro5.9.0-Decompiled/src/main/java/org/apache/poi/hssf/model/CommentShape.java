package org.apache.poi.hssf.model;

import java.util.Iterator;
import java.util.List;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherProperties;
import org.apache.poi.ddf.EscherProperty;
import org.apache.poi.ddf.EscherSimpleProperty;
import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
import org.apache.poi.hssf.record.NoteRecord;
import org.apache.poi.hssf.record.NoteStructureSubRecord;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.hssf.record.SubRecord;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFShape;

@Deprecated
/* loaded from: classes4.dex */
public final class CommentShape extends TextboxShape {
    private NoteRecord _note;

    @Override // org.apache.poi.hssf.model.AbstractShape
    int getCmoObjectId(int i) {
        return i;
    }

    public CommentShape(HSSFComment hSSFComment, int i) {
        super(hSSFComment, i);
        this._note = createNoteRecord(hSSFComment, i);
        ObjRecord objRecord = getObjRecord();
        List<SubRecord> subRecords = objRecord.getSubRecords();
        int i2 = 0;
        for (int i3 = 0; i3 < subRecords.size(); i3++) {
            SubRecord subRecord = subRecords.get(i3);
            if (subRecord instanceof CommonObjectDataSubRecord) {
                ((CommonObjectDataSubRecord) subRecord).setAutofill(false);
                i2 = i3;
            }
        }
        objRecord.addSubRecord(i2 + 1, new NoteStructureSubRecord());
    }

    private NoteRecord createNoteRecord(HSSFComment hSSFComment, int i) {
        NoteRecord noteRecord = new NoteRecord();
        noteRecord.setColumn(hSSFComment.getColumn());
        noteRecord.setRow(hSSFComment.getRow());
        noteRecord.setFlags(hSSFComment.isVisible() ? (short) 2 : (short) 0);
        noteRecord.setShapeId(i);
        noteRecord.setAuthor(hSSFComment.getAuthor() == null ? "" : hSSFComment.getAuthor());
        return noteRecord;
    }

    @Override // org.apache.poi.hssf.model.AbstractShape
    protected int addStandardOptions(HSSFShape hSSFShape, EscherOptRecord escherOptRecord) {
        super.addStandardOptions(hSSFShape, escherOptRecord);
        Iterator<EscherProperty> it = escherOptRecord.getEscherProperties().iterator();
        while (it.hasNext()) {
            short id = it.next().getId();
            if (id != 387 && id != 448 && id != 959) {
                switch (id) {
                }
            }
            it.remove();
        }
        escherOptRecord.addEscherProperty(new EscherSimpleProperty((short) 959, ((HSSFComment) hSSFShape).isVisible() ? 655360 : 655362));
        escherOptRecord.addEscherProperty(new EscherSimpleProperty(EscherProperties.SHADOWSTYLE__SHADOWOBSURED, 196611));
        escherOptRecord.addEscherProperty(new EscherSimpleProperty((short) 513, 0));
        escherOptRecord.sortProperties();
        return escherOptRecord.getEscherProperties().size();
    }

    public NoteRecord getNoteRecord() {
        return this._note;
    }
}
