package org.apache.poi;

/* loaded from: classes.dex */
public class EmptyFileException extends IllegalArgumentException {
    private static final long serialVersionUID = 1536449292174360166L;

    public EmptyFileException() {
        super("The supplied file was empty (zero bytes long)");
    }
}
