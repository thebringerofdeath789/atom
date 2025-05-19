package org.apache.xmlbeans.impl.jam;

/* loaded from: classes5.dex */
public interface JAnnotationValue {
    JAnnotation asAnnotation();

    JAnnotation[] asAnnotationArray();

    boolean asBoolean() throws IllegalArgumentException;

    boolean[] asBooleanArray() throws IllegalArgumentException;

    byte asByte() throws NumberFormatException;

    byte[] asByteArray() throws NumberFormatException;

    char asChar() throws IllegalArgumentException;

    char[] asCharArray() throws IllegalArgumentException;

    JClass asClass();

    JClass[] asClassArray();

    double asDouble() throws NumberFormatException;

    double[] asDoubleArray() throws NumberFormatException;

    float asFloat() throws NumberFormatException;

    float[] asFloatArray() throws NumberFormatException;

    int asInt() throws NumberFormatException;

    int[] asIntArray() throws NumberFormatException;

    long asLong() throws NumberFormatException;

    long[] asLongArray() throws NumberFormatException;

    short asShort() throws NumberFormatException;

    short[] asShortArray() throws NumberFormatException;

    String asString();

    String[] asStringArray();

    String getName();

    JClass getType();

    Object getValue();

    boolean isDefaultValueUsed();
}
