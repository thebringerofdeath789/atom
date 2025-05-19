package org.apache.poi.hssf.record;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.util.BitField;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* loaded from: classes5.dex */
public final class DVRecord extends StandardRecord {
    public static final short sid = 446;
    private org.apache.poi.hssf.record.common.UnicodeString _errorText;
    private org.apache.poi.hssf.record.common.UnicodeString _errorTitle;
    private Formula _formula1;
    private Formula _formula2;
    private short _not_used_1;
    private short _not_used_2;
    private int _option_flags;
    private org.apache.poi.hssf.record.common.UnicodeString _promptText;
    private org.apache.poi.hssf.record.common.UnicodeString _promptTitle;
    private CellRangeAddressList _regions;
    private static final org.apache.poi.hssf.record.common.UnicodeString NULL_TEXT_STRING = new org.apache.poi.hssf.record.common.UnicodeString("\u0000");
    private static final BitField opt_data_type = new BitField(15);
    private static final BitField opt_error_style = new BitField(112);
    private static final BitField opt_string_list_formula = new BitField(128);
    private static final BitField opt_empty_cell_allowed = new BitField(256);
    private static final BitField opt_suppress_dropdown_arrow = new BitField(512);
    private static final BitField opt_show_prompt_on_cell_selected = new BitField(262144);
    private static final BitField opt_show_error_on_invalid_value = new BitField(524288);
    private static final BitField opt_condition_operator = new BitField(7340032);

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 446;
    }

    public DVRecord(int i, int i2, int i3, boolean z, boolean z2, boolean z3, boolean z4, String str, String str2, boolean z5, String str3, String str4, Ptg[] ptgArr, Ptg[] ptgArr2, CellRangeAddressList cellRangeAddressList) {
        this._not_used_1 = (short) 16352;
        this._not_used_2 = (short) 0;
        this._option_flags = opt_show_error_on_invalid_value.setBoolean(opt_show_prompt_on_cell_selected.setBoolean(opt_string_list_formula.setBoolean(opt_suppress_dropdown_arrow.setBoolean(opt_empty_cell_allowed.setBoolean(opt_error_style.setValue(opt_condition_operator.setValue(opt_data_type.setValue(0, i), i2), i3), z), z2), z3), z4), z5);
        this._promptTitle = resolveTitleText(str);
        this._promptText = resolveTitleText(str2);
        this._errorTitle = resolveTitleText(str3);
        this._errorText = resolveTitleText(str4);
        this._formula1 = Formula.create(ptgArr);
        this._formula2 = Formula.create(ptgArr2);
        this._regions = cellRangeAddressList;
    }

    public DVRecord(RecordInputStream recordInputStream) {
        this._not_used_1 = (short) 16352;
        this._not_used_2 = (short) 0;
        this._option_flags = recordInputStream.readInt();
        this._promptTitle = readUnicodeString(recordInputStream);
        this._errorTitle = readUnicodeString(recordInputStream);
        this._promptText = readUnicodeString(recordInputStream);
        this._errorText = readUnicodeString(recordInputStream);
        int readUShort = recordInputStream.readUShort();
        this._not_used_1 = recordInputStream.readShort();
        this._formula1 = Formula.read(readUShort, recordInputStream);
        int readUShort2 = recordInputStream.readUShort();
        this._not_used_2 = recordInputStream.readShort();
        this._formula2 = Formula.read(readUShort2, recordInputStream);
        this._regions = new CellRangeAddressList(recordInputStream);
    }

    public int getDataType() {
        return opt_data_type.getValue(this._option_flags);
    }

    public int getErrorStyle() {
        return opt_error_style.getValue(this._option_flags);
    }

    public boolean getListExplicitFormula() {
        return opt_string_list_formula.isSet(this._option_flags);
    }

    public boolean getEmptyCellAllowed() {
        return opt_empty_cell_allowed.isSet(this._option_flags);
    }

    public boolean getSuppressDropdownArrow() {
        return opt_suppress_dropdown_arrow.isSet(this._option_flags);
    }

    public boolean getShowPromptOnCellSelected() {
        return opt_show_prompt_on_cell_selected.isSet(this._option_flags);
    }

    public boolean getShowErrorOnInvalidValue() {
        return opt_show_error_on_invalid_value.isSet(this._option_flags);
    }

    public int getConditionOperator() {
        return opt_condition_operator.getValue(this._option_flags);
    }

    public String getPromptTitle() {
        return resolveTitleString(this._promptTitle);
    }

    public String getErrorTitle() {
        return resolveTitleString(this._errorTitle);
    }

    public String getPromptText() {
        return resolveTitleString(this._promptText);
    }

    public String getErrorText() {
        return resolveTitleString(this._errorText);
    }

    public Ptg[] getFormula1() {
        return Formula.getTokens(this._formula1);
    }

    public Ptg[] getFormula2() {
        return Formula.getTokens(this._formula2);
    }

    public CellRangeAddressList getCellRangeAddress() {
        return this._regions;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[DV]\n");
        stringBuffer.append(" options=").append(Integer.toHexString(this._option_flags));
        stringBuffer.append(" title-prompt=").append(formatTextTitle(this._promptTitle));
        stringBuffer.append(" title-error=").append(formatTextTitle(this._errorTitle));
        stringBuffer.append(" text-prompt=").append(formatTextTitle(this._promptText));
        stringBuffer.append(" text-error=").append(formatTextTitle(this._errorText));
        stringBuffer.append("\n");
        appendFormula(stringBuffer, "Formula 1:", this._formula1);
        appendFormula(stringBuffer, "Formula 2:", this._formula2);
        stringBuffer.append("Regions: ");
        int countRanges = this._regions.countRanges();
        for (int i = 0; i < countRanges; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            CellRangeAddress cellRangeAddress = this._regions.getCellRangeAddress(i);
            stringBuffer.append(PropertyUtils.MAPPED_DELIM).append(cellRangeAddress.getFirstRow()).append(',').append(cellRangeAddress.getLastRow());
            stringBuffer.append(',').append(cellRangeAddress.getFirstColumn()).append(',').append(cellRangeAddress.getLastColumn()).append(PropertyUtils.MAPPED_DELIM2);
        }
        stringBuffer.append("\n");
        stringBuffer.append("[/DV]");
        return stringBuffer.toString();
    }

    private static String formatTextTitle(org.apache.poi.hssf.record.common.UnicodeString unicodeString) {
        String string = unicodeString.getString();
        return (string.length() == 1 && string.charAt(0) == 0) ? "'\\0'" : string;
    }

    private static void appendFormula(StringBuffer stringBuffer, String str, Formula formula) {
        stringBuffer.append(str);
        if (formula == null) {
            stringBuffer.append("<empty>\n");
            return;
        }
        Ptg[] tokens = formula.getTokens();
        stringBuffer.append('\n');
        for (Ptg ptg : tokens) {
            stringBuffer.append('\t').append(ptg.toString()).append('\n');
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(this._option_flags);
        serializeUnicodeString(this._promptTitle, littleEndianOutput);
        serializeUnicodeString(this._errorTitle, littleEndianOutput);
        serializeUnicodeString(this._promptText, littleEndianOutput);
        serializeUnicodeString(this._errorText, littleEndianOutput);
        littleEndianOutput.writeShort(this._formula1.getEncodedTokenSize());
        littleEndianOutput.writeShort(this._not_used_1);
        this._formula1.serializeTokens(littleEndianOutput);
        littleEndianOutput.writeShort(this._formula2.getEncodedTokenSize());
        littleEndianOutput.writeShort(this._not_used_2);
        this._formula2.serializeTokens(littleEndianOutput);
        this._regions.serialize(littleEndianOutput);
    }

    private static org.apache.poi.hssf.record.common.UnicodeString resolveTitleText(String str) {
        if (str == null || str.length() < 1) {
            return NULL_TEXT_STRING;
        }
        return new org.apache.poi.hssf.record.common.UnicodeString(str);
    }

    private static String resolveTitleString(org.apache.poi.hssf.record.common.UnicodeString unicodeString) {
        if (unicodeString == null || unicodeString.equals(NULL_TEXT_STRING)) {
            return null;
        }
        return unicodeString.getString();
    }

    private static org.apache.poi.hssf.record.common.UnicodeString readUnicodeString(RecordInputStream recordInputStream) {
        return new org.apache.poi.hssf.record.common.UnicodeString(recordInputStream);
    }

    private static void serializeUnicodeString(org.apache.poi.hssf.record.common.UnicodeString unicodeString, LittleEndianOutput littleEndianOutput) {
        StringUtil.writeUnicodeString(littleEndianOutput, unicodeString.getString());
    }

    private static int getUnicodeStringSize(org.apache.poi.hssf.record.common.UnicodeString unicodeString) {
        String string = unicodeString.getString();
        return (string.length() * (StringUtil.hasMultibyte(string) ? 2 : 1)) + 3;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return getUnicodeStringSize(this._promptTitle) + 12 + getUnicodeStringSize(this._errorTitle) + getUnicodeStringSize(this._promptText) + getUnicodeStringSize(this._errorText) + this._formula1.getEncodedTokenSize() + this._formula2.getEncodedTokenSize() + this._regions.getSize();
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        return cloneViaReserialise();
    }
}
