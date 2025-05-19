package org.apache.commons.csv;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes4.dex */
public final class CSVPrinter implements Flushable, Closeable {
    private final Appendable appendable;
    private final CSVFormat format;
    private boolean newRecord = true;

    public CSVPrinter(Appendable appendable, CSVFormat cSVFormat) throws IOException {
        Objects.requireNonNull(appendable, "appendable");
        Objects.requireNonNull(cSVFormat, IjkMediaMeta.IJKM_KEY_FORMAT);
        this.appendable = appendable;
        this.format = cSVFormat.copy();
        if (cSVFormat.getHeaderComments() != null) {
            for (String str : cSVFormat.getHeaderComments()) {
                printComment(str);
            }
        }
        if (cSVFormat.getHeader() == null || cSVFormat.getSkipHeaderRecord()) {
            return;
        }
        printRecord(cSVFormat.getHeader());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        close(false);
    }

    public void close(boolean z) throws IOException {
        if (z || this.format.getAutoFlush()) {
            flush();
        }
        Appendable appendable = this.appendable;
        if (appendable instanceof Closeable) {
            ((Closeable) appendable).close();
        }
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        Appendable appendable = this.appendable;
        if (appendable instanceof Flushable) {
            ((Flushable) appendable).flush();
        }
    }

    public Appendable getOut() {
        return this.appendable;
    }

    public void print(Object obj) throws IOException {
        this.format.print(obj, this.appendable, this.newRecord);
        this.newRecord = false;
    }

    public void printComment(String str) throws IOException {
        if (str == null || !this.format.isCommentMarkerSet()) {
            return;
        }
        if (!this.newRecord) {
            println();
        }
        this.appendable.append(this.format.getCommentMarker().charValue());
        this.appendable.append(' ');
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt != '\n') {
                if (charAt == '\r') {
                    int i2 = i + 1;
                    if (i2 < str.length() && str.charAt(i2) == '\n') {
                        i = i2;
                    }
                } else {
                    this.appendable.append(charAt);
                    i++;
                }
            }
            println();
            this.appendable.append(this.format.getCommentMarker().charValue());
            this.appendable.append(' ');
            i++;
        }
        println();
    }

    public void printHeaders(ResultSet resultSet) throws IOException, SQLException {
        printRecord(this.format.builder().setHeader(resultSet).build().getHeader());
    }

    public void println() throws IOException {
        this.format.println(this.appendable);
        this.newRecord = true;
    }

    public void printRecord(Iterable<?> iterable) throws IOException {
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            print(it.next());
        }
        println();
    }

    public void printRecord(Object... objArr) throws IOException {
        printRecord(Arrays.asList(objArr));
    }

    public void printRecords(Iterable<?> iterable) throws IOException {
        for (Object obj : iterable) {
            if (obj instanceof Object[]) {
                printRecord((Object[]) obj);
            } else if (obj instanceof Iterable) {
                printRecord((Iterable<?>) obj);
            } else {
                printRecord(obj);
            }
        }
    }

    public void printRecords(Object... objArr) throws IOException {
        printRecords(Arrays.asList(objArr));
    }

    public void printRecords(ResultSet resultSet) throws SQLException, IOException {
        int columnCount = resultSet.getMetaData().getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                Object object = resultSet.getObject(i);
                if (object instanceof Clob) {
                    object = ((Clob) object).getCharacterStream();
                }
                print(object);
            }
            println();
        }
    }

    public void printRecords(ResultSet resultSet, boolean z) throws SQLException, IOException {
        if (z) {
            printHeaders(resultSet);
        }
        printRecords(resultSet);
    }
}
