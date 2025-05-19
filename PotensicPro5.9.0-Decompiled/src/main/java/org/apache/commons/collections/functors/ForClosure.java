package org.apache.commons.collections.functors;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.commons.collections.Closure;

/* loaded from: classes4.dex */
public class ForClosure implements Closure, Serializable {
    static /* synthetic */ Class class$org$apache$commons$collections$functors$ForClosure = null;
    private static final long serialVersionUID = -1190120533393621674L;
    private final Closure iClosure;
    private final int iCount;

    public static Closure getInstance(int i, Closure closure) {
        if (i <= 0 || closure == null) {
            return NOPClosure.INSTANCE;
        }
        return i == 1 ? closure : new ForClosure(i, closure);
    }

    public ForClosure(int i, Closure closure) {
        this.iCount = i;
        this.iClosure = closure;
    }

    @Override // org.apache.commons.collections.Closure
    public void execute(Object obj) {
        for (int i = 0; i < this.iCount; i++) {
            this.iClosure.execute(obj);
        }
    }

    public Closure getClosure() {
        return this.iClosure;
    }

    public int getCount() {
        return this.iCount;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Class cls = class$org$apache$commons$collections$functors$ForClosure;
        if (cls == null) {
            cls = class$("org.apache.commons.collections.functors.ForClosure");
            class$org$apache$commons$collections$functors$ForClosure = cls;
        }
        FunctorUtils.checkUnsafeSerialization(cls);
        objectOutputStream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        Class cls = class$org$apache$commons$collections$functors$ForClosure;
        if (cls == null) {
            cls = class$("org.apache.commons.collections.functors.ForClosure");
            class$org$apache$commons$collections$functors$ForClosure = cls;
        }
        FunctorUtils.checkUnsafeSerialization(cls);
        objectInputStream.defaultReadObject();
    }
}
