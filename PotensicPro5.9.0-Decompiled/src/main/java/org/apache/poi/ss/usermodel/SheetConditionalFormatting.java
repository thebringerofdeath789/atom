package org.apache.poi.ss.usermodel;

import org.apache.poi.ss.util.CellRangeAddress;

/* loaded from: classes5.dex */
public interface SheetConditionalFormatting {
    int addConditionalFormatting(ConditionalFormatting conditionalFormatting);

    int addConditionalFormatting(CellRangeAddress[] cellRangeAddressArr, ConditionalFormattingRule conditionalFormattingRule);

    int addConditionalFormatting(CellRangeAddress[] cellRangeAddressArr, ConditionalFormattingRule conditionalFormattingRule, ConditionalFormattingRule conditionalFormattingRule2);

    int addConditionalFormatting(CellRangeAddress[] cellRangeAddressArr, ConditionalFormattingRule[] conditionalFormattingRuleArr);

    ConditionalFormattingRule createConditionalFormattingRule(byte b, String str);

    ConditionalFormattingRule createConditionalFormattingRule(byte b, String str, String str2);

    ConditionalFormattingRule createConditionalFormattingRule(String str);

    ConditionalFormatting getConditionalFormattingAt(int i);

    int getNumConditionalFormattings();

    void removeConditionalFormatting(int i);
}
