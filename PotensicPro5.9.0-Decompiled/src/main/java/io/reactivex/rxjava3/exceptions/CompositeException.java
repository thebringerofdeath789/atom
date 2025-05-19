package io.reactivex.rxjava3.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes4.dex */
public final class CompositeException extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    public CompositeException(Throwable... exceptions) {
        this(exceptions == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(exceptions));
    }

    public CompositeException(Iterable<? extends Throwable> errors) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (errors != null) {
            for (Throwable th : errors) {
                if (th instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th).getExceptions());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (linkedHashSet.isEmpty()) {
            throw new IllegalArgumentException("errors is empty");
        }
        List<Throwable> unmodifiableList = Collections.unmodifiableList(new ArrayList(linkedHashSet));
        this.exceptions = unmodifiableList;
        this.message = unmodifiableList.size() + " exceptions occurred. ";
    }

    public List<Throwable> getExceptions() {
        return this.exceptions;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        int i;
        if (this.cause == null) {
            String property = System.getProperty("line.separator");
            if (this.exceptions.size() > 1) {
                IdentityHashMap identityHashMap = new IdentityHashMap();
                StringBuilder sb = new StringBuilder();
                sb.append("Multiple exceptions (").append(this.exceptions.size()).append(")").append(property);
                for (Throwable th : this.exceptions) {
                    int i2 = 0;
                    while (true) {
                        if (th != null) {
                            for (int i3 = 0; i3 < i2; i3++) {
                                sb.append("  ");
                            }
                            sb.append("|-- ");
                            sb.append(th.getClass().getCanonicalName()).append(": ");
                            String message = th.getMessage();
                            if (message != null && message.contains(property)) {
                                sb.append(property);
                                for (String str : message.split(property)) {
                                    for (int i4 = 0; i4 < i2 + 2; i4++) {
                                        sb.append("  ");
                                    }
                                    sb.append(str).append(property);
                                }
                            } else {
                                sb.append(message);
                                sb.append(property);
                            }
                            int i5 = 0;
                            while (true) {
                                i = i2 + 2;
                                if (i5 >= i) {
                                    break;
                                }
                                sb.append("  ");
                                i5++;
                            }
                            StackTraceElement[] stackTrace = th.getStackTrace();
                            if (stackTrace.length > 0) {
                                sb.append("at ").append(stackTrace[0]).append(property);
                            }
                            if (!identityHashMap.containsKey(th)) {
                                identityHashMap.put(th, true);
                                th = th.getCause();
                                i2++;
                            } else {
                                Throwable cause = th.getCause();
                                if (cause != null) {
                                    for (int i6 = 0; i6 < i; i6++) {
                                        sb.append("  ");
                                    }
                                    sb.append("|-- ");
                                    sb.append("(cause not expanded again) ");
                                    sb.append(cause.getClass().getCanonicalName()).append(": ");
                                    sb.append(cause.getMessage());
                                    sb.append(property);
                                }
                            }
                        }
                    }
                }
                this.cause = new ExceptionOverview(sb.toString().trim());
            } else {
                this.cause = this.exceptions.get(0);
            }
        }
        return this.cause;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream s) {
        printStackTrace(new WrappedPrintStream(s));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter s) {
        printStackTrace(new WrappedPrintWriter(s));
    }

    private void printStackTrace(PrintStreamOrWriter s) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(this).append('\n');
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb.append("\tat ").append(stackTraceElement).append('\n');
        }
        int i = 1;
        for (Throwable th : this.exceptions) {
            sb.append("  ComposedException ").append(i).append(" :\n");
            appendStackTrace(sb, th, "\t");
            i++;
        }
        s.println(sb.toString());
    }

    private void appendStackTrace(StringBuilder b, Throwable ex, String prefix) {
        b.append(prefix).append(ex).append('\n');
        for (StackTraceElement stackTraceElement : ex.getStackTrace()) {
            b.append("\t\tat ").append(stackTraceElement).append('\n');
        }
        if (ex.getCause() != null) {
            b.append("\tCaused by: ");
            appendStackTrace(b, ex.getCause(), "");
        }
    }

    static abstract class PrintStreamOrWriter {
        abstract void println(Object o);

        PrintStreamOrWriter() {
        }
    }

    static final class WrappedPrintStream extends PrintStreamOrWriter {
        private final PrintStream printStream;

        WrappedPrintStream(PrintStream printStream) {
            this.printStream = printStream;
        }

        @Override // io.reactivex.rxjava3.exceptions.CompositeException.PrintStreamOrWriter
        void println(Object o) {
            this.printStream.println(o);
        }
    }

    static final class WrappedPrintWriter extends PrintStreamOrWriter {
        private final PrintWriter printWriter;

        WrappedPrintWriter(PrintWriter printWriter) {
            this.printWriter = printWriter;
        }

        @Override // io.reactivex.rxjava3.exceptions.CompositeException.PrintStreamOrWriter
        void println(Object o) {
            this.printWriter.println(o);
        }
    }

    static final class ExceptionOverview extends RuntimeException {
        private static final long serialVersionUID = 3875212506787802066L;

        ExceptionOverview(String message) {
            super(message);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    public int size() {
        return this.exceptions.size();
    }
}
