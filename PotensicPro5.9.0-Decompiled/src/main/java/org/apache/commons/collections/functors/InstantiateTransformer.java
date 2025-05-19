package org.apache.commons.collections.functors;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.collections.FunctorException;
import org.apache.commons.collections.Transformer;

/* loaded from: classes4.dex */
public class InstantiateTransformer implements Transformer, Serializable {
    public static final Transformer NO_ARG_INSTANCE = new InstantiateTransformer();
    static /* synthetic */ Class class$org$apache$commons$collections$functors$InstantiateTransformer = null;
    private static final long serialVersionUID = 3786388740793356347L;
    private final Object[] iArgs;
    private final Class[] iParamTypes;

    public static Transformer getInstance(Class[] clsArr, Object[] objArr) {
        if ((clsArr == null && objArr != null) || ((clsArr != null && objArr == null) || (clsArr != null && objArr != null && clsArr.length != objArr.length))) {
            throw new IllegalArgumentException("Parameter types must match the arguments");
        }
        if (clsArr == null || clsArr.length == 0) {
            return NO_ARG_INSTANCE;
        }
        return new InstantiateTransformer((Class[]) clsArr.clone(), (Object[]) objArr.clone());
    }

    private InstantiateTransformer() {
        this.iParamTypes = null;
        this.iArgs = null;
    }

    public InstantiateTransformer(Class[] clsArr, Object[] objArr) {
        this.iParamTypes = clsArr;
        this.iArgs = objArr;
    }

    @Override // org.apache.commons.collections.Transformer
    public Object transform(Object obj) {
        try {
            if (!(obj instanceof Class)) {
                throw new FunctorException(new StringBuffer().append("InstantiateTransformer: Input object was not an instanceof Class, it was a ").append(obj == null ? "null object" : obj.getClass().getName()).toString());
            }
            return ((Class) obj).getConstructor(this.iParamTypes).newInstance(this.iArgs);
        } catch (IllegalAccessException e) {
            throw new FunctorException("InstantiateTransformer: Constructor must be public", e);
        } catch (InstantiationException e2) {
            throw new FunctorException("InstantiateTransformer: InstantiationException", e2);
        } catch (NoSuchMethodException unused) {
            throw new FunctorException("InstantiateTransformer: The constructor must exist and be public ");
        } catch (InvocationTargetException e3) {
            throw new FunctorException("InstantiateTransformer: Constructor threw an exception", e3);
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Class cls = class$org$apache$commons$collections$functors$InstantiateTransformer;
        if (cls == null) {
            cls = class$("org.apache.commons.collections.functors.InstantiateTransformer");
            class$org$apache$commons$collections$functors$InstantiateTransformer = cls;
        }
        FunctorUtils.checkUnsafeSerialization(cls);
        objectOutputStream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        Class cls = class$org$apache$commons$collections$functors$InstantiateTransformer;
        if (cls == null) {
            cls = class$("org.apache.commons.collections.functors.InstantiateTransformer");
            class$org$apache$commons$collections$functors$InstantiateTransformer = cls;
        }
        FunctorUtils.checkUnsafeSerialization(cls);
        objectInputStream.defaultReadObject();
    }
}
