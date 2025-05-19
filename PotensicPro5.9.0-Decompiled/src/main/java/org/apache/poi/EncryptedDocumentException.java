package org.apache.poi;

/* loaded from: classes.dex */
public class EncryptedDocumentException extends IllegalStateException {
    private static final long serialVersionUID = 7276950444540469193L;

    public EncryptedDocumentException(String str) {
        super(str);
    }

    public EncryptedDocumentException(String str, Throwable th) {
        super(str, th);
    }

    public EncryptedDocumentException(Throwable th) {
        super(th);
    }
}
