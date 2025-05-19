package common.log;

/* loaded from: classes3.dex */
public class LoggerName {
    public static final String NAME;
    static /* synthetic */ Class class$common$log$SimpleLogger;

    static {
        Class cls = class$common$log$SimpleLogger;
        if (cls == null) {
            cls = class$("common.log.SimpleLogger");
            class$common$log$SimpleLogger = cls;
        }
        NAME = cls.getName();
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }
}
