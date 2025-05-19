package org.apache.poi.xssf.eventusermodel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.poi.POIXMLException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.xssf.model.CommentsTable;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.model.ThemesTable;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorkbookDocument;

/* loaded from: classes5.dex */
public class XSSFReader {
    private OPCPackage pkg;
    private PackagePart workbookPart;

    public XSSFReader(OPCPackage oPCPackage) throws IOException, OpenXML4JException {
        this.pkg = oPCPackage;
        this.workbookPart = this.pkg.getPart(oPCPackage.getRelationshipsByType("http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument").getRelationship(0));
    }

    public SharedStringsTable getSharedStringsTable() throws IOException, InvalidFormatException {
        ArrayList<PackagePart> partsByContentType = this.pkg.getPartsByContentType(XSSFRelation.SHARED_STRINGS.getContentType());
        if (partsByContentType.size() == 0) {
            return null;
        }
        return new SharedStringsTable(partsByContentType.get(0), null);
    }

    public StylesTable getStylesTable() throws IOException, InvalidFormatException {
        ArrayList<PackagePart> partsByContentType = this.pkg.getPartsByContentType(XSSFRelation.STYLES.getContentType());
        if (partsByContentType.size() == 0) {
            return null;
        }
        StylesTable stylesTable = new StylesTable(partsByContentType.get(0), null);
        ArrayList<PackagePart> partsByContentType2 = this.pkg.getPartsByContentType(XSSFRelation.THEME.getContentType());
        if (partsByContentType2.size() != 0) {
            stylesTable.setTheme(new ThemesTable(partsByContentType2.get(0), null));
        }
        return stylesTable;
    }

    public InputStream getSharedStringsData() throws IOException, InvalidFormatException {
        return XSSFRelation.SHARED_STRINGS.getContents(this.workbookPart);
    }

    public InputStream getStylesData() throws IOException, InvalidFormatException {
        return XSSFRelation.STYLES.getContents(this.workbookPart);
    }

    public InputStream getThemesData() throws IOException, InvalidFormatException {
        return XSSFRelation.THEME.getContents(this.workbookPart);
    }

    public InputStream getWorkbookData() throws IOException, InvalidFormatException {
        return this.workbookPart.getInputStream();
    }

    public InputStream getSheet(String str) throws IOException, InvalidFormatException {
        PackageRelationship relationship = this.workbookPart.getRelationship(str);
        if (relationship == null) {
            throw new IllegalArgumentException("No Sheet found with r:id " + str);
        }
        PackagePart part = this.pkg.getPart(PackagingURIHelper.createPartName(relationship.getTargetURI()));
        if (part == null) {
            throw new IllegalArgumentException("No data found for Sheet with r:id " + str);
        }
        return part.getInputStream();
    }

    public Iterator<InputStream> getSheetsData() throws IOException, InvalidFormatException {
        return new SheetIterator(this.workbookPart);
    }

    public static class SheetIterator implements Iterator<InputStream> {
        private CTSheet ctSheet;
        private Iterator<CTSheet> sheetIterator;
        private Map<String, PackagePart> sheetMap;

        private SheetIterator(PackagePart packagePart) throws IOException {
            try {
                this.sheetMap = new HashMap();
                Iterator<PackageRelationship> it = packagePart.getRelationships().iterator();
                while (it.hasNext()) {
                    PackageRelationship next = it.next();
                    if (next.getRelationshipType().equals(XSSFRelation.WORKSHEET.getRelation()) || next.getRelationshipType().equals(XSSFRelation.CHARTSHEET.getRelation())) {
                        this.sheetMap.put(next.getId(), packagePart.getPackage().getPart(PackagingURIHelper.createPartName(next.getTargetURI())));
                    }
                }
                this.sheetIterator = WorkbookDocument.Factory.parse(packagePart.getInputStream()).getWorkbook().getSheets().getSheetList().iterator();
            } catch (InvalidFormatException e) {
                throw new POIXMLException(e);
            } catch (XmlException e2) {
                throw new POIXMLException(e2);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.sheetIterator.hasNext();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public InputStream next() {
            CTSheet next = this.sheetIterator.next();
            this.ctSheet = next;
            try {
                return this.sheetMap.get(next.getId()).getInputStream();
            } catch (IOException e) {
                throw new POIXMLException(e);
            }
        }

        public String getSheetName() {
            return this.ctSheet.getName();
        }

        public CommentsTable getSheetComments() {
            PackagePart sheetPart = getSheetPart();
            try {
                PackageRelationshipCollection relationshipsByType = sheetPart.getRelationshipsByType(XSSFRelation.SHEET_COMMENTS.getRelation());
                if (relationshipsByType.size() > 0) {
                    PackageRelationship relationship = relationshipsByType.getRelationship(0);
                    return new CommentsTable(sheetPart.getPackage().getPart(PackagingURIHelper.createPartName(relationship.getTargetURI())), relationship);
                }
            } catch (IOException | InvalidFormatException unused) {
            }
            return null;
        }

        public List<XSSFShape> getShapes() {
            PackagePart sheetPart = getSheetPart();
            LinkedList linkedList = new LinkedList();
            try {
                PackageRelationshipCollection relationshipsByType = sheetPart.getRelationshipsByType(XSSFRelation.DRAWINGS.getRelation());
                for (int i = 0; i < relationshipsByType.size(); i++) {
                    PackageRelationship relationship = relationshipsByType.getRelationship(i);
                    Iterator<XSSFShape> it = new XSSFDrawing(sheetPart.getPackage().getPart(PackagingURIHelper.createPartName(relationship.getTargetURI())), relationship).getShapes().iterator();
                    while (it.hasNext()) {
                        linkedList.add(it.next());
                    }
                }
                return linkedList;
            } catch (IOException | InvalidFormatException | XmlException unused) {
                return null;
            }
        }

        public PackagePart getSheetPart() {
            return this.sheetMap.get(this.ctSheet.getId());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException("Not supported");
        }
    }
}
