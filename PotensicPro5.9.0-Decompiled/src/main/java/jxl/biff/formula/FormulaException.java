package jxl.biff.formula;

import jxl.JXLException;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public class FormulaException extends JXLException {
    static final FormulaMessage UNRECOGNIZED_TOKEN = new FormulaMessage("Unrecognized token");
    static final FormulaMessage UNRECOGNIZED_FUNCTION = new FormulaMessage("Unrecognized function");
    public static final FormulaMessage BIFF8_SUPPORTED = new FormulaMessage("Only biff8 formulas are supported");
    static final FormulaMessage LEXICAL_ERROR = new FormulaMessage("Lexical error:  ");
    static final FormulaMessage INCORRECT_ARGUMENTS = new FormulaMessage("Incorrect arguments supplied to function");
    static final FormulaMessage SHEET_REF_NOT_FOUND = new FormulaMessage("Could not find sheet");
    static final FormulaMessage CELL_NAME_NOT_FOUND = new FormulaMessage("Could not find named cell");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Access modifiers changed from: private */
    public static class FormulaMessage {
        private String message;

        FormulaMessage(String str) {
            this.message = str;
        }

        public String getMessage() {
            return this.message;
        }
    }

    public FormulaException(FormulaMessage formulaMessage) {
        super(formulaMessage.message);
    }

    public FormulaException(FormulaMessage formulaMessage, int i) {
        super(new StringBuffer().append(formulaMessage.message).append(StringUtils.SPACE).append(i).toString());
    }

    public FormulaException(FormulaMessage formulaMessage, String str) {
        super(new StringBuffer().append(formulaMessage.message).append(StringUtils.SPACE).append(str).toString());
    }
}
