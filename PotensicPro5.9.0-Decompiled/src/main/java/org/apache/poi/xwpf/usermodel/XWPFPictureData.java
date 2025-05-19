package org.apache.poi.xwpf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLRelation;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.util.IOUtils;

/* loaded from: classes5.dex */
public class XWPFPictureData extends POIXMLDocumentPart {
    protected static final POIXMLRelation[] RELATIONS;
    private Long checksum;

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void prepareForCommit() {
    }

    static {
        POIXMLRelation[] pOIXMLRelationArr = new POIXMLRelation[13];
        RELATIONS = pOIXMLRelationArr;
        pOIXMLRelationArr[2] = XWPFRelation.IMAGE_EMF;
        pOIXMLRelationArr[3] = XWPFRelation.IMAGE_WMF;
        pOIXMLRelationArr[4] = XWPFRelation.IMAGE_PICT;
        pOIXMLRelationArr[5] = XWPFRelation.IMAGE_JPEG;
        pOIXMLRelationArr[6] = XWPFRelation.IMAGE_PNG;
        pOIXMLRelationArr[7] = XWPFRelation.IMAGE_DIB;
        pOIXMLRelationArr[8] = XWPFRelation.IMAGE_GIF;
        pOIXMLRelationArr[9] = XWPFRelation.IMAGE_TIFF;
        pOIXMLRelationArr[10] = XWPFRelation.IMAGE_EPS;
        pOIXMLRelationArr[11] = XWPFRelation.IMAGE_BMP;
        pOIXMLRelationArr[12] = XWPFRelation.IMAGE_WPG;
    }

    protected XWPFPictureData() {
        this.checksum = null;
    }

    public XWPFPictureData(PackagePart packagePart, PackageRelationship packageRelationship) {
        super(packagePart, packageRelationship);
        this.checksum = null;
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void onDocumentRead() throws IOException {
        super.onDocumentRead();
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

    public Long getChecksum() {
        if (this.checksum == null) {
            InputStream inputStream = null;
            try {
                try {
                    inputStream = getPackagePart().getInputStream();
                    byte[] byteArray = IOUtils.toByteArray(inputStream);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            throw new POIXMLException(e);
                        }
                    }
                    this.checksum = Long.valueOf(IOUtils.calculateChecksum(byteArray));
                } catch (IOException e2) {
                    throw new POIXMLException(e2);
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        throw new POIXMLException(e3);
                    }
                }
                throw th;
            }
        }
        return this.checksum;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof XWPFPictureData)) {
            return false;
        }
        XWPFPictureData xWPFPictureData = (XWPFPictureData) obj;
        PackagePart packagePart = xWPFPictureData.getPackagePart();
        PackagePart packagePart2 = getPackagePart();
        if ((packagePart != null && packagePart2 == null) || (packagePart == null && packagePart2 != null)) {
            return false;
        }
        if (packagePart2 != null) {
            OPCPackage oPCPackage = packagePart.getPackage();
            OPCPackage oPCPackage2 = packagePart2.getPackage();
            if ((oPCPackage != null && oPCPackage2 == null) || (oPCPackage == null && oPCPackage2 != null)) {
                return false;
            }
            if (oPCPackage2 != null && !oPCPackage2.equals(oPCPackage)) {
                return false;
            }
        }
        if (getChecksum().equals(xWPFPictureData.getChecksum())) {
            return Arrays.equals(getData(), xWPFPictureData.getData());
        }
        return false;
    }

    public int hashCode() {
        return getChecksum().hashCode();
    }
}
