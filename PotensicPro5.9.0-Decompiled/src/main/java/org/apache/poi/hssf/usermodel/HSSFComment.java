package org.apache.poi.hssf.usermodel;

import org.apache.poi.ddf.DefaultEscherRecordFactory;
import org.apache.poi.ddf.EscherBSERecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherProperties;
import org.apache.poi.ddf.EscherSimpleProperty;
import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
import org.apache.poi.hssf.record.EndSubRecord;
import org.apache.poi.hssf.record.NoteRecord;
import org.apache.poi.hssf.record.NoteStructureSubRecord;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.hssf.record.TextObjectRecord;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.RichTextString;

/* loaded from: classes5.dex */
public class HSSFComment extends HSSFTextbox implements Comment {
    private static final int FILL_TYPE_PICTURE = 3;
    private static final int FILL_TYPE_SOLID = 0;
    private static final int GROUP_SHAPE_HIDDEN_MASK = 16777218;
    private static final int GROUP_SHAPE_NOT_HIDDEN_MASK = -16777219;
    private static final int GROUP_SHAPE_PROPERTY_DEFAULT_VALUE = 655362;
    private NoteRecord _note;

    @Override // org.apache.poi.ss.usermodel.Comment
    public /* bridge */ /* synthetic */ RichTextString getString() {
        return super.getString();
    }

    public HSSFComment(EscherContainerRecord escherContainerRecord, ObjRecord objRecord, TextObjectRecord textObjectRecord, NoteRecord noteRecord) {
        super(escherContainerRecord, objRecord, textObjectRecord);
        this._note = noteRecord;
    }

    public HSSFComment(HSSFShape hSSFShape, HSSFAnchor hSSFAnchor) {
        super(hSSFShape, hSSFAnchor);
        this._note = createNoteRecord();
        setFillColor(134217808);
        setVisible(false);
        setAuthor("");
        ((CommonObjectDataSubRecord) getObjRecord().getSubRecords().get(0)).setObjectType((short) 25);
    }

    protected HSSFComment(NoteRecord noteRecord, TextObjectRecord textObjectRecord) {
        this((HSSFShape) null, new HSSFClientAnchor());
        this._note = noteRecord;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFTextbox, org.apache.poi.hssf.usermodel.HSSFSimpleShape, org.apache.poi.hssf.usermodel.HSSFShape
    void afterInsert(HSSFPatriarch hSSFPatriarch) {
        super.afterInsert(hSSFPatriarch);
        hSSFPatriarch._getBoundAggregate().addTailRecord(getNoteRecord());
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFTextbox, org.apache.poi.hssf.usermodel.HSSFSimpleShape, org.apache.poi.hssf.usermodel.HSSFShape
    protected EscherContainerRecord createSpContainer() {
        EscherContainerRecord createSpContainer = super.createSpContainer();
        EscherOptRecord escherOptRecord = (EscherOptRecord) createSpContainer.getChildById(EscherOptRecord.RECORD_ID);
        escherOptRecord.removeEscherProperty(129);
        escherOptRecord.removeEscherProperty(131);
        escherOptRecord.removeEscherProperty(130);
        escherOptRecord.removeEscherProperty(132);
        escherOptRecord.setEscherProperty(new EscherSimpleProperty((short) 959, false, false, GROUP_SHAPE_PROPERTY_DEFAULT_VALUE));
        return createSpContainer;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFTextbox, org.apache.poi.hssf.usermodel.HSSFSimpleShape, org.apache.poi.hssf.usermodel.HSSFShape
    protected ObjRecord createObjRecord() {
        ObjRecord objRecord = new ObjRecord();
        CommonObjectDataSubRecord commonObjectDataSubRecord = new CommonObjectDataSubRecord();
        commonObjectDataSubRecord.setObjectType((short) 202);
        commonObjectDataSubRecord.setLocked(true);
        commonObjectDataSubRecord.setPrintable(true);
        commonObjectDataSubRecord.setAutofill(false);
        commonObjectDataSubRecord.setAutoline(true);
        NoteStructureSubRecord noteStructureSubRecord = new NoteStructureSubRecord();
        EndSubRecord endSubRecord = new EndSubRecord();
        objRecord.addSubRecord(commonObjectDataSubRecord);
        objRecord.addSubRecord(noteStructureSubRecord);
        objRecord.addSubRecord(endSubRecord);
        return objRecord;
    }

    private NoteRecord createNoteRecord() {
        NoteRecord noteRecord = new NoteRecord();
        noteRecord.setFlags((short) 0);
        noteRecord.setAuthor("");
        return noteRecord;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShape
    void setShapeId(int i) {
        if (i > 65535) {
            throw new IllegalArgumentException("Cannot add more than 65535 shapes");
        }
        super.setShapeId(i);
        ((CommonObjectDataSubRecord) getObjRecord().getSubRecords().get(0)).setObjectId(i);
        this._note.setShapeId(i);
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public void setVisible(boolean z) {
        this._note.setFlags(z ? (short) 2 : (short) 0);
        setHidden(!z);
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public boolean isVisible() {
        return this._note.getFlags() == 2;
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public int getRow() {
        return this._note.getRow();
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public void setRow(int i) {
        this._note.setRow(i);
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public int getColumn() {
        return this._note.getColumn();
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public void setColumn(int i) {
        this._note.setColumn(i);
    }

    @Deprecated
    public void setColumn(short s) {
        setColumn((int) s);
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public String getAuthor() {
        return this._note.getAuthor();
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public void setAuthor(String str) {
        NoteRecord noteRecord = this._note;
        if (noteRecord != null) {
            noteRecord.setAuthor(str);
        }
    }

    protected NoteRecord getNoteRecord() {
        return this._note;
    }

    public boolean hasPosition() {
        return this._note != null && getColumn() >= 0 && getRow() >= 0;
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public ClientAnchor getClientAnchor() {
        Object anchor = super.getAnchor();
        if (anchor instanceof ClientAnchor) {
            return (ClientAnchor) anchor;
        }
        throw new IllegalStateException("Anchor can not be changed in " + ClientAnchor.class.getSimpleName());
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFTextbox, org.apache.poi.hssf.usermodel.HSSFSimpleShape
    public void setShapeType(int i) {
        throw new IllegalStateException("Shape type can not be changed in " + getClass().getSimpleName());
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFTextbox, org.apache.poi.hssf.usermodel.HSSFSimpleShape, org.apache.poi.hssf.usermodel.HSSFShape
    public void afterRemove(HSSFPatriarch hSSFPatriarch) {
        super.afterRemove(hSSFPatriarch);
        hSSFPatriarch._getBoundAggregate().removeTailRecord(getNoteRecord());
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFTextbox, org.apache.poi.hssf.usermodel.HSSFSimpleShape, org.apache.poi.hssf.usermodel.HSSFShape
    protected HSSFShape cloneShape() {
        TextObjectRecord textObjectRecord = (TextObjectRecord) getTextObjectRecord().cloneViaReserialise();
        EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
        escherContainerRecord.fillFields(getEscherContainer().serialize(), 0, new DefaultEscherRecordFactory());
        return new HSSFComment(escherContainerRecord, (ObjRecord) getObjRecord().cloneViaReserialise(), textObjectRecord, (NoteRecord) getNoteRecord().cloneViaReserialise());
    }

    public void setBackgroundImage(int i) {
        setPropertyValue(new EscherSimpleProperty(EscherProperties.FILL__PATTERNTEXTURE, false, true, i));
        setPropertyValue(new EscherSimpleProperty(EscherProperties.FILL__FILLTYPE, false, false, 3));
        EscherBSERecord bSERecord = getPatriarch().getSheet().getWorkbook().getWorkbook().getBSERecord(i);
        bSERecord.setRef(bSERecord.getRef() + 1);
    }

    public void resetBackgroundImage() {
        EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty) getOptRecord().lookup(390);
        if (escherSimpleProperty != null) {
            getPatriarch().getSheet().getWorkbook().getWorkbook().getBSERecord(escherSimpleProperty.getPropertyValue()).setRef(r0.getRef() - 1);
            getOptRecord().removeEscherProperty(390);
        }
        setPropertyValue(new EscherSimpleProperty(EscherProperties.FILL__FILLTYPE, false, false, 0));
    }

    public int getBackgroundImageId() {
        EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty) getOptRecord().lookup(390);
        if (escherSimpleProperty == null) {
            return 0;
        }
        return escherSimpleProperty.getPropertyValue();
    }

    private void setHidden(boolean z) {
        EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty) getOptRecord().lookup(959);
        if (z) {
            setPropertyValue(new EscherSimpleProperty((short) 959, false, false, escherSimpleProperty.getPropertyValue() | GROUP_SHAPE_HIDDEN_MASK));
        } else {
            setPropertyValue(new EscherSimpleProperty((short) 959, false, false, escherSimpleProperty.getPropertyValue() & GROUP_SHAPE_NOT_HIDDEN_MASK));
        }
    }
}
