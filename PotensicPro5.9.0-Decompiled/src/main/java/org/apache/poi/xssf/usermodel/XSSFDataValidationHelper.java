package org.apache.poi.xssf.usermodel;

import java.util.ArrayList;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationErrorStyle;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationOperator;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationType;

/* loaded from: classes5.dex */
public class XSSFDataValidationHelper implements DataValidationHelper {
    private XSSFSheet xssfSheet;

    public XSSFDataValidationHelper(XSSFSheet xSSFSheet) {
        this.xssfSheet = xSSFSheet;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidationConstraint createDateConstraint(int i, String str, String str2, String str3) {
        return new XSSFDataValidationConstraint(4, i, str, str2);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidationConstraint createDecimalConstraint(int i, String str, String str2) {
        return new XSSFDataValidationConstraint(2, i, str, str2);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidationConstraint createExplicitListConstraint(String[] strArr) {
        return new XSSFDataValidationConstraint(strArr);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidationConstraint createFormulaListConstraint(String str) {
        return new XSSFDataValidationConstraint(3, str);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidationConstraint createNumericConstraint(int i, int i2, String str, String str2) {
        if (i == 1) {
            return createIntegerConstraint(i2, str, str2);
        }
        if (i == 2) {
            return createDecimalConstraint(i2, str, str2);
        }
        if (i == 6) {
            return createTextLengthConstraint(i2, str, str2);
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidationConstraint createIntegerConstraint(int i, String str, String str2) {
        return new XSSFDataValidationConstraint(1, i, str, str2);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidationConstraint createTextLengthConstraint(int i, String str, String str2) {
        return new XSSFDataValidationConstraint(6, i, str, str2);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidationConstraint createTimeConstraint(int i, String str, String str2) {
        return new XSSFDataValidationConstraint(5, i, str, str2);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidationConstraint createCustomConstraint(String str) {
        return new XSSFDataValidationConstraint(7, str);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidation createValidation(DataValidationConstraint dataValidationConstraint, CellRangeAddressList cellRangeAddressList) {
        XSSFDataValidationConstraint xSSFDataValidationConstraint = (XSSFDataValidationConstraint) dataValidationConstraint;
        CTDataValidation newInstance = CTDataValidation.Factory.newInstance();
        int validationType = dataValidationConstraint.getValidationType();
        switch (validationType) {
            case 0:
                newInstance.setType(STDataValidationType.NONE);
                break;
            case 1:
                newInstance.setType(STDataValidationType.WHOLE);
                break;
            case 2:
                newInstance.setType(STDataValidationType.DECIMAL);
                break;
            case 3:
                newInstance.setType(STDataValidationType.LIST);
                newInstance.setFormula1(dataValidationConstraint.getFormula1());
                break;
            case 4:
                newInstance.setType(STDataValidationType.DATE);
                break;
            case 5:
                newInstance.setType(STDataValidationType.TIME);
                break;
            case 6:
                newInstance.setType(STDataValidationType.TEXT_LENGTH);
                break;
            case 7:
                newInstance.setType(STDataValidationType.CUSTOM);
                break;
            default:
                newInstance.setType(STDataValidationType.NONE);
                break;
        }
        if (validationType != 0 && validationType != 3) {
            STDataValidationOperator.Enum r2 = XSSFDataValidation.operatorTypeMappings.get(Integer.valueOf(dataValidationConstraint.getOperator()));
            if (r2 != null) {
                newInstance.setOperator(r2);
            }
            if (dataValidationConstraint.getFormula1() != null) {
                newInstance.setFormula1(dataValidationConstraint.getFormula1());
            }
            if (dataValidationConstraint.getFormula2() != null) {
                newInstance.setFormula2(dataValidationConstraint.getFormula2());
            }
        }
        CellRangeAddress[] cellRangeAddresses = cellRangeAddressList.getCellRangeAddresses();
        ArrayList arrayList = new ArrayList();
        for (CellRangeAddress cellRangeAddress : cellRangeAddresses) {
            arrayList.add(cellRangeAddress.formatAsString());
        }
        newInstance.setSqref(arrayList);
        newInstance.setAllowBlank(true);
        newInstance.setErrorStyle(STDataValidationErrorStyle.STOP);
        return new XSSFDataValidation(xSSFDataValidationConstraint, cellRangeAddressList, newInstance);
    }
}
