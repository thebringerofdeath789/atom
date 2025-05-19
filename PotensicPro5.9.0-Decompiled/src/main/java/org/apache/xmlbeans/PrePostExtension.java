package org.apache.xmlbeans;

/* loaded from: classes5.dex */
public interface PrePostExtension {
    public static final int OPERATION_INSERT = 2;
    public static final int OPERATION_REMOVE = 3;
    public static final int OPERATION_SET = 1;

    String getStaticHandler();

    boolean hasPostCall();

    boolean hasPreCall();
}
