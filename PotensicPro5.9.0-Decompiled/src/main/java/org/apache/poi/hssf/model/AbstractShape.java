package org.apache.poi.hssf.model;

import org.apache.poi.ddf.EscherBoolProperty;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherProperties;
import org.apache.poi.ddf.EscherRGBProperty;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherSimpleProperty;
import org.apache.poi.ddf.EscherSpRecord;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.hssf.usermodel.HSSFAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFPolygon;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSimpleShape;
import org.apache.poi.hssf.usermodel.HSSFTextbox;

@Deprecated
/* loaded from: classes4.dex */
public abstract class AbstractShape {
    int getCmoObjectId(int i) {
        return i - 1024;
    }

    public abstract ObjRecord getObjRecord();

    public abstract EscherContainerRecord getSpContainer();

    public static AbstractShape createShape(HSSFShape hSSFShape, int i) {
        AbstractShape simpleFilledShape;
        AbstractShape abstractShape;
        if (hSSFShape instanceof HSSFComment) {
            abstractShape = new CommentShape((HSSFComment) hSSFShape, i);
        } else if (hSSFShape instanceof HSSFTextbox) {
            abstractShape = new TextboxShape((HSSFTextbox) hSSFShape, i);
        } else if (hSSFShape instanceof HSSFPolygon) {
            abstractShape = new PolygonShape((HSSFPolygon) hSSFShape, i);
        } else if (hSSFShape instanceof HSSFSimpleShape) {
            HSSFSimpleShape hSSFSimpleShape = (HSSFSimpleShape) hSSFShape;
            int shapeType = hSSFSimpleShape.getShapeType();
            if (shapeType == 1 || shapeType == 3) {
                simpleFilledShape = new SimpleFilledShape(hSSFSimpleShape, i);
            } else if (shapeType == 20) {
                simpleFilledShape = new LineShape(hSSFSimpleShape, i);
            } else if (shapeType == 75) {
                simpleFilledShape = new PictureShape(hSSFSimpleShape, i);
            } else if (shapeType == 201) {
                simpleFilledShape = new ComboboxShape(hSSFSimpleShape, i);
            } else {
                throw new IllegalArgumentException("Do not know how to handle this type of shape");
            }
            abstractShape = simpleFilledShape;
        } else {
            throw new IllegalArgumentException("Unknown shape type");
        }
        EscherSpRecord escherSpRecord = (EscherSpRecord) abstractShape.getSpContainer().getChildById(EscherSpRecord.RECORD_ID);
        if (hSSFShape.getParent() != null) {
            escherSpRecord.setFlags(escherSpRecord.getFlags() | 2);
        }
        return abstractShape;
    }

    protected AbstractShape() {
    }

    protected EscherRecord createAnchor(HSSFAnchor hSSFAnchor) {
        return ConvertAnchor.createAnchor(hSSFAnchor);
    }

    protected int addStandardOptions(HSSFShape hSSFShape, EscherOptRecord escherOptRecord) {
        escherOptRecord.addEscherProperty(new EscherBoolProperty((short) 191, 524288));
        if (hSSFShape.isNoFill()) {
            escherOptRecord.addEscherProperty(new EscherBoolProperty(EscherProperties.FILL__NOFILLHITTEST, HSSFShape.NO_FILLHITTEST_TRUE));
        } else {
            escherOptRecord.addEscherProperty(new EscherBoolProperty(EscherProperties.FILL__NOFILLHITTEST, 65536));
        }
        escherOptRecord.addEscherProperty(new EscherRGBProperty(EscherProperties.FILL__FILLCOLOR, hSSFShape.getFillColor()));
        escherOptRecord.addEscherProperty(new EscherBoolProperty((short) 959, 524288));
        escherOptRecord.addEscherProperty(new EscherRGBProperty(EscherProperties.LINESTYLE__COLOR, hSSFShape.getLineStyleColor()));
        int i = 5;
        if (hSSFShape.getLineWidth() != 9525) {
            escherOptRecord.addEscherProperty(new EscherSimpleProperty(EscherProperties.LINESTYLE__LINEWIDTH, hSSFShape.getLineWidth()));
            i = 6;
        }
        if (hSSFShape.getLineStyle() != 0) {
            escherOptRecord.addEscherProperty(new EscherSimpleProperty(EscherProperties.LINESTYLE__LINEDASHING, hSSFShape.getLineStyle()));
            escherOptRecord.addEscherProperty(new EscherSimpleProperty(EscherProperties.LINESTYLE__LINEENDCAPSTYLE, 0));
            if (hSSFShape.getLineStyle() == -1) {
                escherOptRecord.addEscherProperty(new EscherBoolProperty(EscherProperties.LINESTYLE__NOLINEDRAWDASH, 524288));
            } else {
                escherOptRecord.addEscherProperty(new EscherBoolProperty(EscherProperties.LINESTYLE__NOLINEDRAWDASH, 524296));
            }
            i += 3;
        }
        escherOptRecord.sortProperties();
        return i;
    }
}
