package org.apache.poi.hssf.usermodel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.poi.ddf.EscherBoolProperty;
import org.apache.poi.ddf.EscherChildAnchorRecord;
import org.apache.poi.ddf.EscherClientAnchorRecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherProperties;
import org.apache.poi.ddf.EscherProperty;
import org.apache.poi.ddf.EscherRGBProperty;
import org.apache.poi.ddf.EscherSimpleProperty;
import org.apache.poi.ddf.EscherSpRecord;
import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.util.LittleEndian;

/* loaded from: classes5.dex */
public abstract class HSSFShape {
    public static final int FILL__FILLCOLOR_DEFAULT = 134217737;
    public static final int LINESTYLE_DASHDOTDOTSYS = 4;
    public static final int LINESTYLE_DASHDOTGEL = 8;
    public static final int LINESTYLE_DASHDOTSYS = 3;
    public static final int LINESTYLE_DASHGEL = 6;
    public static final int LINESTYLE_DASHSYS = 1;
    public static final int LINESTYLE_DEFAULT = -1;
    public static final int LINESTYLE_DOTGEL = 5;
    public static final int LINESTYLE_DOTSYS = 2;
    public static final int LINESTYLE_LONGDASHDOTDOTGEL = 10;
    public static final int LINESTYLE_LONGDASHDOTGEL = 9;
    public static final int LINESTYLE_LONGDASHGEL = 7;
    public static final int LINESTYLE_NONE = -1;
    public static final int LINESTYLE_SOLID = 0;
    public static final int LINESTYLE__COLOR_DEFAULT = 134217792;
    public static final int LINEWIDTH_DEFAULT = 9525;
    public static final int LINEWIDTH_ONE_PT = 12700;
    public static final int NO_FILLHITTEST_FALSE = 65536;
    public static final int NO_FILLHITTEST_TRUE = 1114112;
    public static final boolean NO_FILL_DEFAULT = true;
    private final EscherContainerRecord _escherContainer;
    private final ObjRecord _objRecord;
    private final EscherOptRecord _optRecord;
    private HSSFPatriarch _patriarch;
    HSSFAnchor anchor;
    private HSSFShape parent;

    abstract void afterInsert(HSSFPatriarch hSSFPatriarch);

    protected abstract void afterRemove(HSSFPatriarch hSSFPatriarch);

    protected abstract HSSFShape cloneShape();

    public int countOfAllChildren() {
        return 1;
    }

    protected abstract ObjRecord createObjRecord();

    protected abstract EscherContainerRecord createSpContainer();

    public HSSFShape(EscherContainerRecord escherContainerRecord, ObjRecord objRecord) {
        this._escherContainer = escherContainerRecord;
        this._objRecord = objRecord;
        this._optRecord = (EscherOptRecord) escherContainerRecord.getChildById(EscherOptRecord.RECORD_ID);
        this.anchor = HSSFAnchor.createAnchorFromEscher(escherContainerRecord);
    }

    public HSSFShape(HSSFShape hSSFShape, HSSFAnchor hSSFAnchor) {
        this.parent = hSSFShape;
        this.anchor = hSSFAnchor;
        EscherContainerRecord createSpContainer = createSpContainer();
        this._escherContainer = createSpContainer;
        this._optRecord = (EscherOptRecord) createSpContainer.getChildById(EscherOptRecord.RECORD_ID);
        this._objRecord = createObjRecord();
    }

    void setShapeId(int i) {
        ((EscherSpRecord) this._escherContainer.getChildById(EscherSpRecord.RECORD_ID)).setShapeId(i);
        ((CommonObjectDataSubRecord) this._objRecord.getSubRecords().get(0)).setObjectId((short) (i % 1024));
    }

    int getShapeId() {
        return ((EscherSpRecord) this._escherContainer.getChildById(EscherSpRecord.RECORD_ID)).getShapeId();
    }

    protected EscherContainerRecord getEscherContainer() {
        return this._escherContainer;
    }

    protected ObjRecord getObjRecord() {
        return this._objRecord;
    }

    protected EscherOptRecord getOptRecord() {
        return this._optRecord;
    }

    public HSSFShape getParent() {
        return this.parent;
    }

    public HSSFAnchor getAnchor() {
        return this.anchor;
    }

    public void setAnchor(HSSFAnchor hSSFAnchor) {
        short s;
        int i = 0;
        if (this.parent == null) {
            if (hSSFAnchor instanceof HSSFChildAnchor) {
                throw new IllegalArgumentException("Must use client anchors for shapes directly attached to sheet.");
            }
            EscherClientAnchorRecord escherClientAnchorRecord = (EscherClientAnchorRecord) this._escherContainer.getChildById(EscherClientAnchorRecord.RECORD_ID);
            if (escherClientAnchorRecord != null) {
                s = -1;
                while (i < this._escherContainer.getChildRecords().size()) {
                    if (this._escherContainer.getChild(i).getRecordId() == -4080 && i != this._escherContainer.getChildRecords().size() - 1) {
                        s = this._escherContainer.getChild(i + 1).getRecordId();
                    }
                    i++;
                }
                this._escherContainer.removeChildRecord(escherClientAnchorRecord);
            }
            s = -1;
        } else {
            if (hSSFAnchor instanceof HSSFClientAnchor) {
                throw new IllegalArgumentException("Must use child anchors for shapes attached to groups.");
            }
            EscherChildAnchorRecord escherChildAnchorRecord = (EscherChildAnchorRecord) this._escherContainer.getChildById(EscherChildAnchorRecord.RECORD_ID);
            if (escherChildAnchorRecord != null) {
                s = -1;
                while (i < this._escherContainer.getChildRecords().size()) {
                    if (this._escherContainer.getChild(i).getRecordId() == -4081 && i != this._escherContainer.getChildRecords().size() - 1) {
                        s = this._escherContainer.getChild(i + 1).getRecordId();
                    }
                    i++;
                }
                this._escherContainer.removeChildRecord(escherChildAnchorRecord);
            }
            s = -1;
        }
        if (-1 == s) {
            this._escherContainer.addChildRecord(hSSFAnchor.getEscherAnchor());
        } else {
            this._escherContainer.addChildBefore(hSSFAnchor.getEscherAnchor(), s);
        }
        this.anchor = hSSFAnchor;
    }

    public int getLineStyleColor() {
        EscherRGBProperty escherRGBProperty = (EscherRGBProperty) this._optRecord.lookup(448);
        return escherRGBProperty == null ? LINESTYLE__COLOR_DEFAULT : escherRGBProperty.getRgbColor();
    }

    public void setLineStyleColor(int i) {
        setPropertyValue(new EscherRGBProperty(EscherProperties.LINESTYLE__COLOR, i));
    }

    public void setLineStyleColor(int i, int i2, int i3) {
        setPropertyValue(new EscherRGBProperty(EscherProperties.LINESTYLE__COLOR, i | (i2 << 8) | (i3 << 16)));
    }

    public int getFillColor() {
        EscherRGBProperty escherRGBProperty = (EscherRGBProperty) this._optRecord.lookup(385);
        return escherRGBProperty == null ? FILL__FILLCOLOR_DEFAULT : escherRGBProperty.getRgbColor();
    }

    public void setFillColor(int i) {
        setPropertyValue(new EscherRGBProperty(EscherProperties.FILL__FILLCOLOR, i));
    }

    public void setFillColor(int i, int i2, int i3) {
        setPropertyValue(new EscherRGBProperty(EscherProperties.FILL__FILLCOLOR, i | (i2 << 8) | (i3 << 16)));
    }

    public int getLineWidth() {
        EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty) this._optRecord.lookup(459);
        if (escherSimpleProperty == null) {
            return 9525;
        }
        return escherSimpleProperty.getPropertyValue();
    }

    public void setLineWidth(int i) {
        setPropertyValue(new EscherSimpleProperty(EscherProperties.LINESTYLE__LINEWIDTH, i));
    }

    public int getLineStyle() {
        EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty) this._optRecord.lookup(462);
        if (escherSimpleProperty == null) {
            return -1;
        }
        return escherSimpleProperty.getPropertyValue();
    }

    public void setLineStyle(int i) {
        setPropertyValue(new EscherSimpleProperty(EscherProperties.LINESTYLE__LINEDASHING, i));
        if (getLineStyle() != 0) {
            setPropertyValue(new EscherSimpleProperty(EscherProperties.LINESTYLE__LINEENDCAPSTYLE, 0));
            if (getLineStyle() == -1) {
                setPropertyValue(new EscherBoolProperty(EscherProperties.LINESTYLE__NOLINEDRAWDASH, 524288));
            } else {
                setPropertyValue(new EscherBoolProperty(EscherProperties.LINESTYLE__NOLINEDRAWDASH, 524296));
            }
        }
    }

    public boolean isNoFill() {
        EscherBoolProperty escherBoolProperty = (EscherBoolProperty) this._optRecord.lookup(447);
        return escherBoolProperty == null || escherBoolProperty.getPropertyValue() == 1114112;
    }

    public void setNoFill(boolean z) {
        setPropertyValue(new EscherBoolProperty(EscherProperties.FILL__NOFILLHITTEST, z ? NO_FILLHITTEST_TRUE : 65536));
    }

    protected void setPropertyValue(EscherProperty escherProperty) {
        this._optRecord.setEscherProperty(escherProperty);
    }

    public void setFlipVertical(boolean z) {
        EscherSpRecord escherSpRecord = (EscherSpRecord) getEscherContainer().getChildById(EscherSpRecord.RECORD_ID);
        if (z) {
            escherSpRecord.setFlags(escherSpRecord.getFlags() | 128);
        } else {
            escherSpRecord.setFlags(escherSpRecord.getFlags() & 2147483519);
        }
    }

    public void setFlipHorizontal(boolean z) {
        EscherSpRecord escherSpRecord = (EscherSpRecord) getEscherContainer().getChildById(EscherSpRecord.RECORD_ID);
        if (z) {
            escherSpRecord.setFlags(escherSpRecord.getFlags() | 64);
        } else {
            escherSpRecord.setFlags(escherSpRecord.getFlags() & 2147483583);
        }
    }

    public boolean isFlipVertical() {
        return (((EscherSpRecord) getEscherContainer().getChildById(EscherSpRecord.RECORD_ID)).getFlags() & 128) != 0;
    }

    public boolean isFlipHorizontal() {
        return (((EscherSpRecord) getEscherContainer().getChildById(EscherSpRecord.RECORD_ID)).getFlags() & 64) != 0;
    }

    public int getRotationDegree() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty) getOptRecord().lookup(4);
        if (escherSimpleProperty == null) {
            return 0;
        }
        try {
            LittleEndian.putInt(escherSimpleProperty.getPropertyValue(), byteArrayOutputStream);
            return LittleEndian.getShort(byteArrayOutputStream.toByteArray(), 2);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void setRotationDegree(short s) {
        setPropertyValue(new EscherSimpleProperty((short) 4, s << 16));
    }

    protected void setPatriarch(HSSFPatriarch hSSFPatriarch) {
        this._patriarch = hSSFPatriarch;
    }

    public HSSFPatriarch getPatriarch() {
        return this._patriarch;
    }

    protected void setParent(HSSFShape hSSFShape) {
        this.parent = hSSFShape;
    }
}
