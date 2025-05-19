package org.apache.commons.collections.functors;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.commons.collections.Transformer;

/* loaded from: classes4.dex */
public class CloneTransformer implements Transformer, Serializable {
    public static final Transformer INSTANCE = new CloneTransformer();
    static /* synthetic */ Class class$org$apache$commons$collections$functors$CloneTransformer = null;
    private static final long serialVersionUID = -8188742709499652567L;

    public static Transformer getInstance() {
        return INSTANCE;
    }

    private CloneTransformer() {
    }

    @Override // org.apache.commons.collections.Transformer
    public Object transform(Object obj) {
        if (obj == null) {
            return null;
        }
        return PrototypeFactory.getInstance(obj).create();
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Class cls = class$org$apache$commons$collections$functors$CloneTransformer;
        if (cls == null) {
            cls = class$("org.apache.commons.collections.functors.CloneTransformer");
            class$org$apache$commons$collections$functors$CloneTransformer = cls;
        }
        FunctorUtils.checkUnsafeSerialization(cls);
        objectOutputStream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        Class cls = class$org$apache$commons$collections$functors$CloneTransformer;
        if (cls == null) {
            cls = class$("org.apache.commons.collections.functors.CloneTransformer");
            class$org$apache$commons$collections$functors$CloneTransformer = cls;
        }
        FunctorUtils.checkUnsafeSerialization(cls);
        objectInputStream.defaultReadObject();
    }
}
