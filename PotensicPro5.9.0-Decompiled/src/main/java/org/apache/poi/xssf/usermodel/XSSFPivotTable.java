package org.apache.poi.xssf.usermodel;

import aavax.xml.namespace.QName;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.ss.usermodel.DataConsolidateFunction;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColFields;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataFields;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTLocation;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotFields;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotTableDefinition;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotTableStyle;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRowFields;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheetSource;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STAxis;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataConsolidateFunction;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STItemType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSourceType;

/* loaded from: classes5.dex */
public class XSSFPivotTable extends POIXMLDocumentPart {
    protected static final short CREATED_VERSION = 3;
    protected static final short MIN_REFRESHABLE_VERSION = 3;
    protected static final short UPDATED_VERSION = 3;
    private Sheet dataSheet;
    private Sheet parentSheet;
    private XSSFPivotCache pivotCache;
    private XSSFPivotCacheDefinition pivotCacheDefinition;
    private XSSFPivotCacheRecords pivotCacheRecords;
    private CTPivotTableDefinition pivotTableDefinition;

    protected XSSFPivotTable() {
        this.pivotTableDefinition = CTPivotTableDefinition.Factory.newInstance();
        this.pivotCache = new XSSFPivotCache();
        this.pivotCacheDefinition = new XSSFPivotCacheDefinition();
        this.pivotCacheRecords = new XSSFPivotCacheRecords();
    }

    protected XSSFPivotTable(PackagePart packagePart, PackageRelationship packageRelationship) throws IOException {
        super(packagePart, packageRelationship);
        readFrom(packagePart.getInputStream());
    }

    public void readFrom(InputStream inputStream) throws IOException {
        try {
            XmlOptions xmlOptions = new XmlOptions(DEFAULT_XML_OPTIONS);
            xmlOptions.setLoadReplaceDocumentElement(null);
            this.pivotTableDefinition = CTPivotTableDefinition.Factory.parse(inputStream, xmlOptions);
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    public void setPivotCache(XSSFPivotCache xSSFPivotCache) {
        this.pivotCache = xSSFPivotCache;
    }

    public XSSFPivotCache getPivotCache() {
        return this.pivotCache;
    }

    public Sheet getParentSheet() {
        return this.parentSheet;
    }

    public void setParentSheet(XSSFSheet xSSFSheet) {
        this.parentSheet = xSSFSheet;
    }

    @Internal
    public CTPivotTableDefinition getCTPivotTableDefinition() {
        return this.pivotTableDefinition;
    }

    @Internal
    public void setCTPivotTableDefinition(CTPivotTableDefinition cTPivotTableDefinition) {
        this.pivotTableDefinition = cTPivotTableDefinition;
    }

    public XSSFPivotCacheDefinition getPivotCacheDefinition() {
        return this.pivotCacheDefinition;
    }

    public void setPivotCacheDefinition(XSSFPivotCacheDefinition xSSFPivotCacheDefinition) {
        this.pivotCacheDefinition = xSSFPivotCacheDefinition;
    }

    public XSSFPivotCacheRecords getPivotCacheRecords() {
        return this.pivotCacheRecords;
    }

    public void setPivotCacheRecords(XSSFPivotCacheRecords xSSFPivotCacheRecords) {
        this.pivotCacheRecords = xSSFPivotCacheRecords;
    }

    public Sheet getDataSheet() {
        return this.dataSheet;
    }

    private void setDataSheet(Sheet sheet) {
        this.dataSheet = sheet;
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTPivotTableDefinition.type.getName().getNamespaceURI(), "pivotTableDefinition"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        this.pivotTableDefinition.save(outputStream, xmlOptions);
        outputStream.close();
    }

    protected void setDefaultPivotTableDefinition() {
        this.pivotTableDefinition.setMultipleFieldFilters(false);
        this.pivotTableDefinition.setIndent(0L);
        this.pivotTableDefinition.setCreatedVersion((short) 3);
        this.pivotTableDefinition.setMinRefreshableVersion((short) 3);
        this.pivotTableDefinition.setUpdatedVersion((short) 3);
        this.pivotTableDefinition.setItemPrintTitles(true);
        this.pivotTableDefinition.setUseAutoFormatting(true);
        this.pivotTableDefinition.setApplyNumberFormats(false);
        this.pivotTableDefinition.setApplyWidthHeightFormats(true);
        this.pivotTableDefinition.setApplyAlignmentFormats(false);
        this.pivotTableDefinition.setApplyPatternFormats(false);
        this.pivotTableDefinition.setApplyFontFormats(false);
        this.pivotTableDefinition.setApplyBorderFormats(false);
        this.pivotTableDefinition.setCacheId(this.pivotCache.getCTPivotCache().getCacheId());
        this.pivotTableDefinition.setName("PivotTable" + this.pivotTableDefinition.getCacheId());
        this.pivotTableDefinition.setDataCaption("Values");
        CTPivotTableStyle addNewPivotTableStyleInfo = this.pivotTableDefinition.addNewPivotTableStyleInfo();
        addNewPivotTableStyleInfo.setName("PivotStyleLight16");
        addNewPivotTableStyleInfo.setShowLastColumn(true);
        addNewPivotTableStyleInfo.setShowColStripes(false);
        addNewPivotTableStyleInfo.setShowRowStripes(false);
        addNewPivotTableStyleInfo.setShowColHeaders(true);
        addNewPivotTableStyleInfo.setShowRowHeaders(true);
    }

    protected AreaReference getPivotArea() {
        return new AreaReference(getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheSource().getWorksheetSource().getRef());
    }

    public void addRowLabel(int i) {
        CTRowFields addNewRowFields;
        AreaReference pivotArea = getPivotArea();
        int row = pivotArea.getLastCell().getRow() - pivotArea.getFirstCell().getRow();
        if (i > pivotArea.getLastCell().getCol() - pivotArea.getFirstCell().getCol()) {
            throw new IndexOutOfBoundsException();
        }
        CTPivotFields pivotFields = this.pivotTableDefinition.getPivotFields();
        CTPivotField newInstance = CTPivotField.Factory.newInstance();
        CTItems addNewItems = newInstance.addNewItems();
        newInstance.setAxis(STAxis.AXIS_ROW);
        newInstance.setShowAll(false);
        for (int i2 = 0; i2 <= row; i2++) {
            addNewItems.addNewItem().setT(STItemType.DEFAULT);
        }
        addNewItems.setCount(addNewItems.sizeOfItemArray());
        pivotFields.setPivotFieldArray(i, newInstance);
        if (this.pivotTableDefinition.getRowFields() != null) {
            addNewRowFields = this.pivotTableDefinition.getRowFields();
        } else {
            addNewRowFields = this.pivotTableDefinition.addNewRowFields();
        }
        addNewRowFields.addNewField().setX(i);
        addNewRowFields.setCount(addNewRowFields.sizeOfFieldArray());
    }

    public List<Integer> getRowLabelColumns() {
        if (this.pivotTableDefinition.getRowFields() != null) {
            ArrayList arrayList = new ArrayList();
            for (CTField cTField : this.pivotTableDefinition.getRowFields().getFieldArray()) {
                arrayList.add(Integer.valueOf(cTField.getX()));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public void addColumnLabel(DataConsolidateFunction dataConsolidateFunction, int i, String str) {
        CTColFields addNewColFields;
        AreaReference pivotArea = getPivotArea();
        if (i > pivotArea.getLastCell().getCol() - pivotArea.getFirstCell().getCol() && i < 0) {
            throw new IndexOutOfBoundsException();
        }
        addDataColumn(i, true);
        addDataField(dataConsolidateFunction, i, str);
        if (this.pivotTableDefinition.getDataFields().getCount() == 2) {
            if (this.pivotTableDefinition.getColFields() != null) {
                addNewColFields = this.pivotTableDefinition.getColFields();
            } else {
                addNewColFields = this.pivotTableDefinition.addNewColFields();
            }
            addNewColFields.addNewField().setX(-2);
            addNewColFields.setCount(addNewColFields.sizeOfFieldArray());
        }
    }

    public void addColumnLabel(DataConsolidateFunction dataConsolidateFunction, int i) {
        addColumnLabel(dataConsolidateFunction, i, dataConsolidateFunction.getName());
    }

    private void addDataField(DataConsolidateFunction dataConsolidateFunction, int i, String str) {
        CTDataFields addNewDataFields;
        AreaReference pivotArea = getPivotArea();
        if (i > pivotArea.getLastCell().getCol() - pivotArea.getFirstCell().getCol() && i < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (this.pivotTableDefinition.getDataFields() != null) {
            addNewDataFields = this.pivotTableDefinition.getDataFields();
        } else {
            addNewDataFields = this.pivotTableDefinition.addNewDataFields();
        }
        CTDataField addNewDataField = addNewDataFields.addNewDataField();
        addNewDataField.setSubtotal(STDataConsolidateFunction.Enum.forInt(dataConsolidateFunction.getValue()));
        getDataSheet().getRow(pivotArea.getFirstCell().getRow()).getCell(i).setCellType(1);
        addNewDataField.setName(str);
        addNewDataField.setFld(i);
        addNewDataFields.setCount(addNewDataFields.sizeOfDataFieldArray());
    }

    public void addDataColumn(int i, boolean z) {
        AreaReference pivotArea = getPivotArea();
        if (i > pivotArea.getLastCell().getCol() - pivotArea.getFirstCell().getCol() && i < 0) {
            throw new IndexOutOfBoundsException();
        }
        CTPivotFields pivotFields = this.pivotTableDefinition.getPivotFields();
        CTPivotField newInstance = CTPivotField.Factory.newInstance();
        newInstance.setDataField(z);
        newInstance.setShowAll(false);
        pivotFields.setPivotFieldArray(i, newInstance);
    }

    public void addReportFilter(int i) {
        CTPageFields addNewPageFields;
        AreaReference pivotArea = getPivotArea();
        int col = pivotArea.getLastCell().getCol() - pivotArea.getFirstCell().getCol();
        int row = pivotArea.getLastCell().getRow() - pivotArea.getFirstCell().getRow();
        if (i > col && i < 0) {
            throw new IndexOutOfBoundsException();
        }
        CTPivotFields pivotFields = this.pivotTableDefinition.getPivotFields();
        CTPivotField newInstance = CTPivotField.Factory.newInstance();
        CTItems addNewItems = newInstance.addNewItems();
        newInstance.setAxis(STAxis.AXIS_PAGE);
        newInstance.setShowAll(false);
        for (int i2 = 0; i2 <= row; i2++) {
            addNewItems.addNewItem().setT(STItemType.DEFAULT);
        }
        addNewItems.setCount(addNewItems.sizeOfItemArray());
        pivotFields.setPivotFieldArray(i, newInstance);
        if (this.pivotTableDefinition.getPageFields() != null) {
            addNewPageFields = this.pivotTableDefinition.getPageFields();
            this.pivotTableDefinition.setMultipleFieldFilters(true);
        } else {
            addNewPageFields = this.pivotTableDefinition.addNewPageFields();
        }
        CTPageField addNewPageField = addNewPageFields.addNewPageField();
        addNewPageField.setHier(-1);
        addNewPageField.setFld(i);
        addNewPageFields.setCount(addNewPageFields.sizeOfPageFieldArray());
        this.pivotTableDefinition.getLocation().setColPageCount(addNewPageFields.getCount());
    }

    protected void createSourceReferences(AreaReference areaReference, CellReference cellReference, Sheet sheet) {
        CTLocation location;
        AreaReference areaReference2 = new AreaReference(cellReference, new CellReference(cellReference.getRow() + 1, cellReference.getCol() + 1));
        if (this.pivotTableDefinition.getLocation() == null) {
            location = this.pivotTableDefinition.addNewLocation();
            location.setFirstDataCol(1L);
            location.setFirstDataRow(1L);
            location.setFirstHeaderRow(1L);
        } else {
            location = this.pivotTableDefinition.getLocation();
        }
        location.setRef(areaReference2.formatAsString());
        this.pivotTableDefinition.setLocation(location);
        CTCacheSource addNewCacheSource = getPivotCacheDefinition().getCTPivotCacheDefinition().addNewCacheSource();
        addNewCacheSource.setType(STSourceType.WORKSHEET);
        CTWorksheetSource addNewWorksheetSource = addNewCacheSource.addNewWorksheetSource();
        addNewWorksheetSource.setSheet(sheet.getSheetName());
        setDataSheet(sheet);
        String[] cellRefParts = areaReference.getFirstCell().getCellRefParts();
        String[] cellRefParts2 = areaReference.getLastCell().getCellRefParts();
        addNewWorksheetSource.setRef(cellRefParts[2] + cellRefParts[1] + NameUtil.COLON + cellRefParts2[2] + cellRefParts2[1]);
    }

    protected void createDefaultDataColumns() {
        CTPivotFields addNewPivotFields;
        if (this.pivotTableDefinition.getPivotFields() != null) {
            addNewPivotFields = this.pivotTableDefinition.getPivotFields();
        } else {
            addNewPivotFields = this.pivotTableDefinition.addNewPivotFields();
        }
        AreaReference pivotArea = getPivotArea();
        short col = pivotArea.getFirstCell().getCol();
        short col2 = pivotArea.getLastCell().getCol();
        for (int i = 0; i <= col2 - col; i++) {
            CTPivotField addNewPivotField = addNewPivotFields.addNewPivotField();
            addNewPivotField.setDataField(false);
            addNewPivotField.setShowAll(false);
        }
        addNewPivotFields.setCount(addNewPivotFields.sizeOfPivotFieldArray());
    }
}
