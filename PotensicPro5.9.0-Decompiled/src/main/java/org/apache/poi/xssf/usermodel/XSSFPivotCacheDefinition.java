package org.apache.poi.xssf.usermodel;

import aavax.xml.namespace.QName;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheFields;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition;

/* loaded from: classes5.dex */
public class XSSFPivotCacheDefinition extends POIXMLDocumentPart {
    private CTPivotCacheDefinition ctPivotCacheDefinition;

    public XSSFPivotCacheDefinition() {
        this.ctPivotCacheDefinition = CTPivotCacheDefinition.Factory.newInstance();
        createDefaultValues();
    }

    protected XSSFPivotCacheDefinition(PackagePart packagePart, PackageRelationship packageRelationship) throws IOException {
        super(packagePart, packageRelationship);
        readFrom(packagePart.getInputStream());
    }

    public void readFrom(InputStream inputStream) throws IOException {
        try {
            XmlOptions xmlOptions = new XmlOptions(DEFAULT_XML_OPTIONS);
            xmlOptions.setLoadReplaceDocumentElement(null);
            this.ctPivotCacheDefinition = CTPivotCacheDefinition.Factory.parse(inputStream, xmlOptions);
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    @Internal
    public CTPivotCacheDefinition getCTPivotCacheDefinition() {
        return this.ctPivotCacheDefinition;
    }

    private void createDefaultValues() {
        this.ctPivotCacheDefinition.setCreatedVersion((short) 3);
        this.ctPivotCacheDefinition.setMinRefreshableVersion((short) 3);
        this.ctPivotCacheDefinition.setRefreshedVersion((short) 3);
        this.ctPivotCacheDefinition.setRefreshedBy(POIXMLDocument.DOCUMENT_CREATOR);
        this.ctPivotCacheDefinition.setRefreshedDate(new Date().getTime());
        this.ctPivotCacheDefinition.setRefreshOnLoad(true);
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        XmlOptions xmlOptions = new XmlOptions(DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTPivotCacheDefinition.type.getName().getNamespaceURI(), "pivotCacheDefinition"));
        this.ctPivotCacheDefinition.save(outputStream, xmlOptions);
        outputStream.close();
    }

    protected void createCacheFields(Sheet sheet) {
        CTCacheFields addNewCacheFields;
        AreaReference areaReference = new AreaReference(this.ctPivotCacheDefinition.getCacheSource().getWorksheetSource().getRef());
        CellReference firstCell = areaReference.getFirstCell();
        CellReference lastCell = areaReference.getLastCell();
        short col = lastCell.getCol();
        Row row = sheet.getRow(firstCell.getRow());
        if (this.ctPivotCacheDefinition.getCacheFields() != null) {
            addNewCacheFields = this.ctPivotCacheDefinition.getCacheFields();
        } else {
            addNewCacheFields = this.ctPivotCacheDefinition.addNewCacheFields();
        }
        for (int col2 = firstCell.getCol(); col2 <= col; col2++) {
            CTCacheField addNewCacheField = addNewCacheFields.addNewCacheField();
            if (col2 == col) {
                addNewCacheFields.setCount(addNewCacheFields.sizeOfCacheFieldArray());
            }
            addNewCacheField.setNumFmtId(0L);
            row.getCell(col2).setCellType(1);
            addNewCacheField.setName(row.getCell(col2).getStringCellValue());
            addNewCacheField.addNewSharedItems();
        }
    }
}
