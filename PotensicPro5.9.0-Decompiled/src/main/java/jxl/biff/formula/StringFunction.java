package jxl.biff.formula;

import common.Logger;
import jxl.WorkbookSettings;

/* loaded from: classes4.dex */
class StringFunction extends StringParseItem {
    static /* synthetic */ Class class$jxl$biff$formula$StringFunction;
    private static Logger logger;
    private Function function;
    private String functionString;

    static {
        Class cls = class$jxl$biff$formula$StringFunction;
        if (cls == null) {
            cls = class$("jxl.biff.formula.StringFunction");
            class$jxl$biff$formula$StringFunction = cls;
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

    StringFunction(String str) {
        this.functionString = str.substring(0, str.length() - 1);
    }

    Function getFunction(WorkbookSettings workbookSettings) {
        if (this.function == null) {
            this.function = Function.getFunction(this.functionString, workbookSettings);
        }
        return this.function;
    }
}
