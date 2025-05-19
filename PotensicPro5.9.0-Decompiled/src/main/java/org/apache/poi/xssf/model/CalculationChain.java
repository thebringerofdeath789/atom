package org.apache.poi.xssf.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CalcChainDocument;

/* loaded from: classes5.dex */
public class CalculationChain extends POIXMLDocumentPart {
    private CTCalcChain chain;

    public CalculationChain() {
        this.chain = CTCalcChain.Factory.newInstance();
    }

    public CalculationChain(PackagePart packagePart, PackageRelationship packageRelationship) throws IOException {
        super(packagePart, packageRelationship);
        readFrom(packagePart.getInputStream());
    }

    public void readFrom(InputStream inputStream) throws IOException {
        try {
            this.chain = CalcChainDocument.Factory.parse(inputStream).getCalcChain();
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        CalcChainDocument newInstance = CalcChainDocument.Factory.newInstance();
        newInstance.setCalcChain(this.chain);
        newInstance.save(outputStream, DEFAULT_XML_OPTIONS);
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        writeTo(outputStream);
        outputStream.close();
    }

    public CTCalcChain getCTCalcChain() {
        return this.chain;
    }

    public void removeItem(int i, String str) {
        CTCalcCell[] cArray = this.chain.getCArray();
        int i2 = -1;
        for (int i3 = 0; i3 < cArray.length; i3++) {
            if (cArray[i3].isSetI()) {
                i2 = cArray[i3].getI();
            }
            if (i2 == i && cArray[i3].getR().equals(str)) {
                if (cArray[i3].isSetI() && i3 < cArray.length - 1) {
                    int i4 = i3 + 1;
                    if (!cArray[i4].isSetI()) {
                        cArray[i4].setI(i2);
                    }
                }
                this.chain.removeC(i3);
                return;
            }
        }
    }
}
