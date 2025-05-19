package javax.xml.transform;

/* loaded from: classes4.dex */
public class TransformerFactoryConfigurationError extends Error {
    private Exception exception;

    public TransformerFactoryConfigurationError() {
        this.exception = null;
    }

    public TransformerFactoryConfigurationError(Exception exc) {
        super(exc.toString());
        this.exception = exc;
    }

    public TransformerFactoryConfigurationError(Exception exc, String str) {
        super(str);
        this.exception = exc;
    }

    public TransformerFactoryConfigurationError(String str) {
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
