package jxl.biff.formula;

import common.Assert;
import common.Logger;
import jxl.biff.CellReferenceHelper;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes4.dex */
class ColumnRange3d extends Area3d {
    static /* synthetic */ Class class$jxl$biff$formula$ColumnRange3d;
    private static Logger logger;
    private int sheet;
    private ExternalSheet workbook;

    static {
        Class cls = class$jxl$biff$formula$ColumnRange3d;
        if (cls == null) {
            cls = class$("jxl.biff.formula.ColumnRange3d");
            class$jxl$biff$formula$ColumnRange3d = cls;
        }
        logger = Logger.getLogger(cls);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    ColumnRange3d(ExternalSheet externalSheet) {
        super(externalSheet);
        this.workbook = externalSheet;
    }

    ColumnRange3d(String str, ExternalSheet externalSheet) throws FormulaException {
        super(externalSheet);
        this.workbook = externalSheet;
        int lastIndexOf = str.lastIndexOf(":");
        Assert.verify(lastIndexOf != -1);
        str.substring(0, lastIndexOf);
        String substring = str.substring(lastIndexOf + 1);
        int indexOf = str.indexOf(33);
        int column = CellReferenceHelper.getColumn(str.substring(indexOf + 1, lastIndexOf));
        String substring2 = str.substring(0, indexOf);
        substring2.lastIndexOf(93);
        if (substring2.charAt(0) == '\'' && substring2.charAt(substring2.length() - 1) == '\'') {
            substring2 = substring2.substring(1, substring2.length() - 1);
        }
        int externalSheetIndex = externalSheet.getExternalSheetIndex(substring2);
        this.sheet = externalSheetIndex;
        if (externalSheetIndex < 0) {
            throw new FormulaException(FormulaException.SHEET_REF_NOT_FOUND, substring2);
        }
        setRangeData(this.sheet, column, CellReferenceHelper.getColumn(substring), 0, 65535, true, true, true, true);
    }

    @Override // jxl.biff.formula.Area3d, jxl.biff.formula.ParseItem
    public void getString(StringBuffer stringBuffer) {
        stringBuffer.append('\'');
        stringBuffer.append(this.workbook.getExternalSheetName(this.sheet));
        stringBuffer.append('\'');
        stringBuffer.append('!');
        CellReferenceHelper.getColumnReference(getFirstColumn(), stringBuffer);
        stringBuffer.append(NameUtil.COLON);
        CellReferenceHelper.getColumnReference(getLastColumn(), stringBuffer);
    }
}
