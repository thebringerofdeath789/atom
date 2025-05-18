package com.opencsv;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/* loaded from: classes3.dex */
public interface ICSVWriter extends Closeable, Flushable {
    public static final char DEFAULT_ESCAPE_CHARACTER = '\"';
    public static final String DEFAULT_LINE_END = "\n";
    public static final char DEFAULT_QUOTE_CHARACTER = '\"';
    public static final char DEFAULT_SEPARATOR = ',';
    public static final int INITIAL_STRING_SIZE = 1024;
    public static final char NO_ESCAPE_CHARACTER = 0;
    public static final char NO_QUOTE_CHARACTER = 0;
    public static final String RFC4180_LINE_END = "\r\n";

    boolean checkError();

    IOException getException();

    void resetError();

    void setResultService(ResultSetHelper resultSetHelper);

    int writeAll(ResultSet resultSet, boolean z, boolean z2, boolean z3) throws SQLException, IOException;

    void writeAll(Iterable<String[]> iterable, boolean z);

    void writeNext(String[] strArr, boolean z);

    default void writeAll(List<String[]> list, boolean z) {
        writeAll((Iterable<String[]>) list, z);
    }

    default void writeAll(Iterable<String[]> iterable) {
        writeAll(iterable, true);
    }

    default void writeAll(List<String[]> list) {
        writeAll((Iterable<String[]>) list);
    }

    default int writeAll(ResultSet resultSet, boolean z) throws SQLException, IOException {
        return writeAll(resultSet, z, false, true);
    }

    default int writeAll(ResultSet resultSet, boolean z, boolean z2) throws SQLException, IOException {
        return writeAll(resultSet, z, z2, true);
    }

    default void writeNext(String[] strArr) {
        writeNext(strArr, true);
    }

    default void flushQuietly() {
        try {
            flush();
        } catch (IOException unused) {
        }
    }
}