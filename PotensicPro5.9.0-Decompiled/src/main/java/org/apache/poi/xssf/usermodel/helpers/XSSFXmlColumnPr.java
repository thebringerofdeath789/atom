package org.apache.poi.xssf.usermodel.helpers;

import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXmlColumnPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXmlDataType;

/* loaded from: classes5.dex */
public class XSSFXmlColumnPr {
    private CTTableColumn ctTableColumn;
    private CTXmlColumnPr ctXmlColumnPr;
    private XSSFTable table;

    public XSSFXmlColumnPr(XSSFTable xSSFTable, CTTableColumn cTTableColumn, CTXmlColumnPr cTXmlColumnPr) {
        this.table = xSSFTable;
        this.ctTableColumn = cTTableColumn;
        this.ctXmlColumnPr = cTXmlColumnPr;
    }

    public long getMapId() {
        return this.ctXmlColumnPr.getMapId();
    }

    public String getXPath() {
        return this.ctXmlColumnPr.getXpath();
    }

    public long getId() {
        return this.ctTableColumn.getId();
    }

    public String getLocalXPath() {
        String[] split = this.ctXmlColumnPr.getXpath().split(InternalZipConstants.ZIP_FILE_SEPARATOR);
        String str = "";
        for (int length = this.table.getCommonXpath().split(InternalZipConstants.ZIP_FILE_SEPARATOR).length - 1; length < split.length; length++) {
            str = str + InternalZipConstants.ZIP_FILE_SEPARATOR + split[length];
        }
        return str;
    }

    public STXmlDataType.Enum getXmlDataType() {
        return this.ctXmlColumnPr.getXmlDataType();
    }
}
