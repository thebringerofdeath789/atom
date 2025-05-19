package org.apache.poi.xssf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.helpers.XSSFXmlColumnPr;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.TableDocument;

/* loaded from: classes5.dex */
public class XSSFTable extends POIXMLDocumentPart {
    private String commonXPath;
    private CTTable ctTable;
    private CellReference endCellReference;
    private CellReference startCellReference;
    private List<XSSFXmlColumnPr> xmlColumnPr;

    public XSSFTable() {
        this.ctTable = CTTable.Factory.newInstance();
    }

    public XSSFTable(PackagePart packagePart, PackageRelationship packageRelationship) throws IOException {
        super(packagePart, packageRelationship);
        readFrom(packagePart.getInputStream());
    }

    public void readFrom(InputStream inputStream) throws IOException {
        try {
            this.ctTable = TableDocument.Factory.parse(inputStream).getTable();
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    public XSSFSheet getXSSFSheet() {
        return (XSSFSheet) getParent();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        updateHeaders();
        TableDocument newInstance = TableDocument.Factory.newInstance();
        newInstance.setTable(this.ctTable);
        newInstance.save(outputStream, DEFAULT_XML_OPTIONS);
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        writeTo(outputStream);
        outputStream.close();
    }

    public CTTable getCTTable() {
        return this.ctTable;
    }

    public boolean mapsTo(long j) {
        Iterator<XSSFXmlColumnPr> it = getXmlColumnPrs().iterator();
        while (it.hasNext()) {
            if (it.next().getMapId() == j) {
                return true;
            }
        }
        return false;
    }

    public String getCommonXpath() {
        if (this.commonXPath == null) {
            String[] strArr = new String[0];
            for (CTTableColumn cTTableColumn : this.ctTable.getTableColumns().getTableColumnArray()) {
                if (cTTableColumn.getXmlColumnPr() != null) {
                    String[] split = cTTableColumn.getXmlColumnPr().getXpath().split(InternalZipConstants.ZIP_FILE_SEPARATOR);
                    if (strArr.length == 0) {
                        strArr = split;
                    } else {
                        int length = strArr.length > split.length ? split.length : strArr.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                break;
                            }
                            if (!strArr[i].equals(split[i])) {
                                strArr = (String[]) Arrays.asList(strArr).subList(0, i).toArray(new String[0]);
                                break;
                            }
                            i++;
                        }
                    }
                }
            }
            this.commonXPath = "";
            for (int i2 = 1; i2 < strArr.length; i2++) {
                this.commonXPath += InternalZipConstants.ZIP_FILE_SEPARATOR + strArr[i2];
            }
        }
        return this.commonXPath;
    }

    public List<XSSFXmlColumnPr> getXmlColumnPrs() {
        if (this.xmlColumnPr == null) {
            this.xmlColumnPr = new ArrayList();
            for (CTTableColumn cTTableColumn : this.ctTable.getTableColumns().getTableColumnArray()) {
                if (cTTableColumn.getXmlColumnPr() != null) {
                    this.xmlColumnPr.add(new XSSFXmlColumnPr(this, cTTableColumn, cTTableColumn.getXmlColumnPr()));
                }
            }
        }
        return this.xmlColumnPr;
    }

    public String getName() {
        return this.ctTable.getName();
    }

    public void setName(String str) {
        if (str == null) {
            this.ctTable.unsetName();
        } else {
            this.ctTable.setName(str);
        }
    }

    public String getDisplayName() {
        return this.ctTable.getDisplayName();
    }

    public void setDisplayName(String str) {
        this.ctTable.setDisplayName(str);
    }

    public long getNumerOfMappedColumns() {
        return this.ctTable.getTableColumns().getCount();
    }

    public CellReference getStartCellReference() {
        String ref;
        if (this.startCellReference == null && (ref = this.ctTable.getRef()) != null) {
            this.startCellReference = new CellReference(ref.split(":")[0]);
        }
        return this.startCellReference;
    }

    public CellReference getEndCellReference() {
        if (this.endCellReference == null) {
            this.endCellReference = new CellReference(this.ctTable.getRef().split(":")[1]);
        }
        return this.endCellReference;
    }

    public int getRowCount() {
        CellReference startCellReference = getStartCellReference();
        CellReference endCellReference = getEndCellReference();
        if (startCellReference == null || endCellReference == null) {
            return -1;
        }
        return endCellReference.getRow() - startCellReference.getRow();
    }

    public void updateHeaders() {
        XSSFSheet xSSFSheet = (XSSFSheet) getParent();
        CellReference startCellReference = getStartCellReference();
        if (startCellReference == null) {
            return;
        }
        int row = startCellReference.getRow();
        int col = startCellReference.getCol();
        XSSFRow row2 = xSSFSheet.getRow(row);
        if (row2 == null || !row2.getCTRow().validate()) {
            return;
        }
        for (CTTableColumn cTTableColumn : getCTTable().getTableColumns().getTableColumnArray()) {
            XSSFCell cell = row2.getCell(col);
            if (cell != null) {
                cTTableColumn.setName(cell.getStringCellValue());
            }
            col++;
        }
    }
}
