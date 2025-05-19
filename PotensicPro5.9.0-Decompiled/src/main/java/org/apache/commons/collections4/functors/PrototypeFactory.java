package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.FunctorException;

/* loaded from: classes4.dex */
public class PrototypeFactory {
    public static <T> Factory<T> prototypeFactory(T t) {
        if (t == null) {
            return ConstantFactory.constantFactory(null);
        }
        try {
            try {
                return new PrototypeCloneFactory(t, t.getClass().getMethod("clone", (Class[]) null));
            } catch (NoSuchMethodException unused) {
                if (t instanceof Serializable) {
                    return new PrototypeSerializationFactory((Serializable) t);
                }
                throw new IllegalArgumentException("The prototype must be cloneable via a public clone method");
            }
        } catch (NoSuchMethodException unused2) {
            t.getClass().getConstructor(t.getClass());
            return new InstantiateFactory(t.getClass(), new Class[]{t.getClass()}, new Object[]{t});
        }
    }

    private PrototypeFactory() {
    }

    static class PrototypeCloneFactory<T> implements Factory<T> {
        private transient Method iCloneMethod;
        private final T iPrototype;

        private PrototypeCloneFactory(T t, Method method) {
            this.iPrototype = t;
            this.iCloneMethod = method;
        }

        private void findCloneMethod() {
            try {
                this.iCloneMethod = this.iPrototype.getClass().getMethod("clone", (Class[]) null);
            } catch (NoSuchMethodException unused) {
                throw new IllegalArgumentException("PrototypeCloneFactory: The clone method must exist and be public ");
            }
        }

        @Override // org.apache.commons.collections4.Factory
        public T create() {
            if (this.iCloneMethod == null) {
                findCloneMethod();
            }
            try {
                return (T) this.iCloneMethod.invoke(this.iPrototype, (Object[]) null);
            } catch (IllegalAccessException e) {
                throw new FunctorException("PrototypeCloneFactory: Clone method must be public", e);
            } catch (InvocationTargetException e2) {
                throw new FunctorException("PrototypeCloneFactory: Clone method threw an exception", e2);
            }
        }
    }

    static class PrototypeSerializationFactory<T extends Serializable> implements Factory<T> {
        private final T iPrototype;

        private PrototypeSerializationFactory(T t) {
            this.iPrototype = t;
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // org.apache.commons.collections4.Factory
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public T create() {
            /*
                r5 = this;
                java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
                r1 = 512(0x200, float:7.17E-43)
                r0.<init>(r1)
                r1 = 0
                java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch: java.lang.Throwable -> L31 java.io.IOException -> L36 java.lang.ClassNotFoundException -> L40
                r2.<init>(r0)     // Catch: java.lang.Throwable -> L31 java.io.IOException -> L36 java.lang.ClassNotFoundException -> L40
                T extends java.io.Serializable r3 = r5.iPrototype     // Catch: java.lang.Throwable -> L31 java.io.IOException -> L36 java.lang.ClassNotFoundException -> L40
                r2.writeObject(r3)     // Catch: java.lang.Throwable -> L31 java.io.IOException -> L36 java.lang.ClassNotFoundException -> L40
                java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L31 java.io.IOException -> L36 java.lang.ClassNotFoundException -> L40
                byte[] r3 = r0.toByteArray()     // Catch: java.lang.Throwable -> L31 java.io.IOException -> L36 java.lang.ClassNotFoundException -> L40
                r2.<init>(r3)     // Catch: java.lang.Throwable -> L31 java.io.IOException -> L36 java.lang.ClassNotFoundException -> L40
                java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch: java.io.IOException -> L2d java.lang.ClassNotFoundException -> L2f java.lang.Throwable -> L4a
                r1.<init>(r2)     // Catch: java.io.IOException -> L2d java.lang.ClassNotFoundException -> L2f java.lang.Throwable -> L4a
                java.lang.Object r1 = r1.readObject()     // Catch: java.io.IOException -> L2d java.lang.ClassNotFoundException -> L2f java.lang.Throwable -> L4a
                java.io.Serializable r1 = (java.io.Serializable) r1     // Catch: java.io.IOException -> L2d java.lang.ClassNotFoundException -> L2f java.lang.Throwable -> L4a
                r2.close()     // Catch: java.io.IOException -> L29
            L29:
                r0.close()     // Catch: java.io.IOException -> L2c
            L2c:
                return r1
            L2d:
                r1 = move-exception
                goto L3a
            L2f:
                r1 = move-exception
                goto L44
            L31:
                r2 = move-exception
                r4 = r2
                r2 = r1
                r1 = r4
                goto L4b
            L36:
                r2 = move-exception
                r4 = r2
                r2 = r1
                r1 = r4
            L3a:
                org.apache.commons.collections4.FunctorException r3 = new org.apache.commons.collections4.FunctorException     // Catch: java.lang.Throwable -> L4a
                r3.<init>(r1)     // Catch: java.lang.Throwable -> L4a
                throw r3     // Catch: java.lang.Throwable -> L4a
            L40:
                r2 = move-exception
                r4 = r2
                r2 = r1
                r1 = r4
            L44:
                org.apache.commons.collections4.FunctorException r3 = new org.apache.commons.collections4.FunctorException     // Catch: java.lang.Throwable -> L4a
                r3.<init>(r1)     // Catch: java.lang.Throwable -> L4a
                throw r3     // Catch: java.lang.Throwable -> L4a
            L4a:
                r1 = move-exception
            L4b:
                if (r2 == 0) goto L50
                r2.close()     // Catch: java.io.IOException -> L50
            L50:
                r0.close()     // Catch: java.io.IOException -> L53
            L53:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections4.functors.PrototypeFactory.PrototypeSerializationFactory.create():java.io.Serializable");
        }
    }
}
