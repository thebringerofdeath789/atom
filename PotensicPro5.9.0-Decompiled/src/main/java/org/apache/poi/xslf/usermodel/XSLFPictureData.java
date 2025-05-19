package org.apache.poi.xslf.usermodel;

import java.io.IOException;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLRelation;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.util.IOUtils;

/* loaded from: classes5.dex */
public final class XSLFPictureData extends POIXMLDocumentPart {
    public static final int PICTURE_TYPE_BMP = 11;
    public static final int PICTURE_TYPE_DIB = 7;
    public static final int PICTURE_TYPE_EMF = 2;
    public static final int PICTURE_TYPE_EPS = 10;
    public static final int PICTURE_TYPE_GIF = 8;
    public static final int PICTURE_TYPE_JPEG = 5;
    public static final int PICTURE_TYPE_PICT = 4;
    public static final int PICTURE_TYPE_PNG = 6;
    public static final int PICTURE_TYPE_TIFF = 9;
    public static final int PICTURE_TYPE_WDP = 13;
    public static final int PICTURE_TYPE_WMF = 3;
    public static final int PICTURE_TYPE_WPG = 12;
    protected static final POIXMLRelation[] RELATIONS;
    private Long checksum;

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void prepareForCommit() {
    }

    static {
        POIXMLRelation[] pOIXMLRelationArr = new POIXMLRelation[14];
        RELATIONS = pOIXMLRelationArr;
        pOIXMLRelationArr[2] = XSLFRelation.IMAGE_EMF;
        pOIXMLRelationArr[3] = XSLFRelation.IMAGE_WMF;
        pOIXMLRelationArr[4] = XSLFRelation.IMAGE_PICT;
        pOIXMLRelationArr[5] = XSLFRelation.IMAGE_JPEG;
        pOIXMLRelationArr[6] = XSLFRelation.IMAGE_PNG;
        pOIXMLRelationArr[7] = XSLFRelation.IMAGE_DIB;
        pOIXMLRelationArr[8] = XSLFRelation.IMAGE_GIF;
        pOIXMLRelationArr[9] = XSLFRelation.IMAGE_TIFF;
        pOIXMLRelationArr[10] = XSLFRelation.IMAGE_EPS;
        pOIXMLRelationArr[11] = XSLFRelation.IMAGE_BMP;
        pOIXMLRelationArr[12] = XSLFRelation.IMAGE_WPG;
        pOIXMLRelationArr[13] = XSLFRelation.IMAGE_WDP;
    }

    protected XSLFPictureData() {
        this.checksum = null;
    }

    public XSLFPictureData(PackagePart packagePart, PackageRelationship packageRelationship) {
        super(packagePart, packageRelationship);
        this.checksum = null;
    }

    public byte[] getData() {
        try {
            return IOUtils.toByteArray(getPackagePart().getInputStream());
        } catch (IOException e) {
            throw new POIXMLException(e);
        }
    }

    public String getFileName() {
        String name = getPackagePart().getPartName().getName();
        if (name == null) {
            return null;
        }
        return name.substring(name.lastIndexOf(47) + 1);
    }

    public String suggestFileExtension() {
        return getPackagePart().getPartName().getExtension();
    }

    public int getPictureType() {
        String contentType = getPackagePart().getContentType();
        int i = 0;
        while (true) {
            POIXMLRelation[] pOIXMLRelationArr = RELATIONS;
            if (i >= pOIXMLRelationArr.length) {
                return 0;
            }
            if (pOIXMLRelationArr[i] != null && pOIXMLRelationArr[i].getContentType().equals(contentType)) {
                return i;
            }
            i++;
        }
    }

    long getChecksum() {
        if (this.checksum == null) {
            this.checksum = Long.valueOf(IOUtils.calculateChecksum(getData()));
        }
        return this.checksum.longValue();
    }
}
