package com.opencsv;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

/* loaded from: classes3.dex */
public abstract class AbstractCSVWriter implements ICSVWriter {
    protected volatile IOException exception;
    protected String lineEnd;
    protected ResultSetHelper resultService;
    protected final Writer writer;

    protected abstract void writeNext(String[] strArr, boolean z, Appendable appendable) throws IOException;

    protected AbstractCSVWriter(Writer writer, String str) {
        this.writer = writer;
        this.lineEnd = str;
    }

    @Override // com.opencsv.ICSVWriter
    public void writeAll(Iterable<String[]> iterable, boolean z) {
        StringBuilder sb = new StringBuilder(1024);
        try {
            Iterator<String[]> it = iterable.iterator();
            while (it.hasNext()) {
                writeNext(it.next(), z, sb);
                sb.setLength(0);
            }
        } catch (IOException e) {
            this.exception = e;
        }
    }

    protected void writeColumnNames(ResultSet resultSet, boolean z) throws SQLException {
        writeNext(resultService().getColumnNames(resultSet), z);
    }

    @Override // com.opencsv.ICSVWriter
    public int writeAll(ResultSet resultSet, boolean z, boolean z2, boolean z3) throws SQLException, IOException {
        int i;
        if (z) {
            writeColumnNames(resultSet, z3);
            i = 1;
        } else {
            i = 0;
        }
        while (resultSet.next()) {
            writeNext(resultService().getColumnValues(resultSet, z2), z3);
            i++;
        }
        return i;
    }

    @Override // com.opencsv.ICSVWriter
    public void writeNext(String[] strArr, boolean z) {
        try {
            writeNext(strArr, z, new StringBuilder(1024));
        } catch (IOException e) {
            this.exception = e;
        }
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.writer.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
        this.writer.close();
    }

    @Override // com.opencsv.ICSVWriter
    public boolean checkError() {
        Writer writer = this.writer;
        if (writer instanceof PrintWriter) {
            return ((PrintWriter) writer).checkError();
        }
        if (this.exception != null) {
            flushQuietly();
        } else {
            try {
                flush();
            } catch (IOException e) {
                this.exception = e;
            }
        }
        return this.exception != null;
    }

    @Override // com.opencsv.ICSVWriter
    public IOException getException() {
        return this.exception;
    }

    @Override // com.opencsv.ICSVWriter
    public void resetError() {
        this.exception = null;
    }

    @Override // com.opencsv.ICSVWriter
    public void setResultService(ResultSetHelper resultSetHelper) {
        this.resultService = resultSetHelper;
    }

    protected ResultSetHelper resultService() {
        if (this.resultService == null) {
            this.resultService = new ResultSetHelperService();
        }
        return this.resultService;
    }
}
