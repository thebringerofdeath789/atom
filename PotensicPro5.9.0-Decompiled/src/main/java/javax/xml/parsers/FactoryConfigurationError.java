package javax.xml.parsers;

/* loaded from: classes4.dex */
public class FactoryConfigurationError extends Error {
    private Exception exception;

    public FactoryConfigurationError() {
        this.exception = null;
    }

    public FactoryConfigurationError(Exception exc) {
        super(exc.toString());
        this.exception = exc;
    }

    public FactoryConfigurationError(Exception exc, String str) {
        super(str);
        this.exception = exc;
    }

    public FactoryConfigurationError(String str) {
        super(str);
        this.exception = null;
    }

    public Exception getException() {
        return this.exception;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        Exception exc;
        String message = super.getMessage();
        return (message != null || (exc = this.exception) == null) ? message : exc.getMessage();
    }
}
