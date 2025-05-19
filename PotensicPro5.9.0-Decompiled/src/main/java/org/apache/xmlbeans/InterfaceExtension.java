package org.apache.xmlbeans;

/* loaded from: classes5.dex */
public interface InterfaceExtension {

    public interface MethodSignature {
        String[] getExceptionTypes();

        String getName();

        String[] getParameterTypes();

        String getReturnType();
    }

    String getInterface();

    MethodSignature[] getMethods();

    String getStaticHandler();
}
