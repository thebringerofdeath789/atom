package org.apache.poi.hssf.usermodel;

import androidx.core.app.FrameMetricsAggregator;
import java.awt.Dimension;
import java.io.ByteArrayInputStream;
import org.apache.poi.ddf.DefaultEscherRecordFactory;
import org.apache.poi.ddf.EscherBSERecord;
import org.apache.poi.ddf.EscherClientDataRecord;
import org.apache.poi.ddf.EscherComplexProperty;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherSimpleProperty;
import org.apache.poi.ddf.EscherTextboxRecord;
import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.util.ImageUtils;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.StringUtil;

/* loaded from: classes5.dex */
public class HSSFPicture extends HSSFSimpleShape implements Picture {
    public static final int PICTURE_TYPE_DIB = 7;
    public static final int PICTURE_TYPE_EMF = 2;
    public static final int PICTURE_TYPE_JPEG = 5;
    public static final int PICTURE_TYPE_PICT = 4;
    public static final int PICTURE_TYPE_PNG = 6;
    public static final int PICTURE_TYPE_WMF = 3;
    private static POILogger logger = POILogFactory.getLogger((Class<?>) HSSFPicture.class);

    public HSSFPicture(EscherContainerRecord escherContainerRecord, ObjRecord objRecord) {
        super(escherContainerRecord, objRecord);
    }

    public HSSFPicture(HSSFShape hSSFShape, HSSFAnchor hSSFAnchor) {
        super(hSSFShape, hSSFAnchor);
        super.setShapeType(75);
        ((CommonObjectDataSubRecord) getObjRecord().getSubRecords().get(0)).setObjectType((short) 8);
    }

    public int getPictureIndex() {
        EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty) getOptRecord().lookup(260);
        if (escherSimpleProperty == null) {
            return -1;
        }
        return escherSimpleProperty.getPropertyValue();
    }

    public void setPictureIndex(int i) {
        setPropertyValue(new EscherSimpleProperty((short) 260, false, true, i));
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape, org.apache.poi.hssf.usermodel.HSSFShape
    protected EscherContainerRecord createSpContainer() {
        EscherContainerRecord createSpContainer = super.createSpContainer();
        EscherOptRecord escherOptRecord = (EscherOptRecord) createSpContainer.getChildById(EscherOptRecord.RECORD_ID);
        escherOptRecord.removeEscherProperty(462);
        escherOptRecord.removeEscherProperty(FrameMetricsAggregator.EVERY_DURATION);
        createSpContainer.removeChildRecord(createSpContainer.getChildById(EscherTextboxRecord.RECORD_ID));
        return createSpContainer;
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public void resize() {
        resize(Double.MAX_VALUE);
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public void resize(double d) {
        resize(d, d);
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public void resize(double d, double d2) {
        HSSFClientAnchor clientAnchor = getClientAnchor();
        clientAnchor.setAnchorType(2);
        HSSFClientAnchor preferredSize = getPreferredSize(d, d2);
        int row1 = clientAnchor.getRow1() + (preferredSize.getRow2() - preferredSize.getRow1());
        clientAnchor.setCol2((short) (clientAnchor.getCol1() + (preferredSize.getCol2() - preferredSize.getCol1())));
        clientAnchor.setDx2(preferredSize.getDx2());
        clientAnchor.setRow2(row1);
        clientAnchor.setDy2(preferredSize.getDy2());
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public HSSFClientAnchor getPreferredSize() {
        return getPreferredSize(1.0d);
    }

    public HSSFClientAnchor getPreferredSize(double d) {
        return getPreferredSize(d, d);
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public HSSFClientAnchor getPreferredSize(double d, double d2) {
        ImageUtils.setPreferredSize(this, d, d2);
        return getClientAnchor();
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public Dimension getImageDimension() {
        EscherBSERecord bSERecord = getPatriarch().getSheet().getWorkbook().getWorkbook().getBSERecord(getPictureIndex());
        byte[] picturedata = bSERecord.getBlipRecord().getPicturedata();
        return ImageUtils.getImageDimension(new ByteArrayInputStream(picturedata), bSERecord.getBlipTypeWin32());
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public HSSFPictureData getPictureData() {
        return new HSSFPictureData(getPatriarch().getSheet().getWorkbook().getWorkbook().getBSERecord(getPictureIndex()).getBlipRecord());
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape, org.apache.poi.hssf.usermodel.HSSFShape
    void afterInsert(HSSFPatriarch hSSFPatriarch) {
        hSSFPatriarch._getBoundAggregate().associateShapeToObjRecord(getEscherContainer().getChildById(EscherClientDataRecord.RECORD_ID), getObjRecord());
        EscherBSERecord bSERecord = hSSFPatriarch.getSheet().getWorkbook().getWorkbook().getBSERecord(getPictureIndex());
        bSERecord.setRef(bSERecord.getRef() + 1);
    }

    public String getFileName() {
        EscherComplexProperty escherComplexProperty = (EscherComplexProperty) getOptRecord().lookup(261);
        return escherComplexProperty == null ? "" : StringUtil.getFromUnicodeLE(escherComplexProperty.getComplexData()).trim();
    }

    public void setFileName(String str) {
        setPropertyValue(new EscherComplexProperty((short) 261, true, StringUtil.getToUnicodeLE(str)));
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape
    public void setShapeType(int i) {
        throw new IllegalStateException("Shape type can not be changed in " + getClass().getSimpleName());
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape, org.apache.poi.hssf.usermodel.HSSFShape
    protected HSSFShape cloneShape() {
        EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
        escherContainerRecord.fillFields(getEscherContainer().serialize(), 0, new DefaultEscherRecordFactory());
        return new HSSFPicture(escherContainerRecord, (ObjRecord) getObjRecord().cloneViaReserialise());
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public HSSFClientAnchor getClientAnchor() {
        HSSFAnchor anchor = getAnchor();
        if (anchor instanceof HSSFClientAnchor) {
            return (HSSFClientAnchor) anchor;
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public HSSFSheet getSheet() {
        return getPatriarch().getSheet();
    }
}
