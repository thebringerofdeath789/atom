package org.apache.xmlbeans.impl.schema;

import java.lang.reflect.Constructor;
import org.apache.xmlbeans.SchemaTypeSystem;

/* loaded from: PotensicPro_V5.9.0_apkcombo.com.apk:org/apache/xmlbeans/impl/schema/TypeSystemHolder.template */
public class TypeSystemHolder {
    public static final SchemaTypeSystem typeSystem = loadTypeSystem();
    static Class class$org$apache$xmlbeans$impl$schema$TypeSystemHolder;
    static Class class$java$lang$Class;

    private TypeSystemHolder() {
    }

    private static final SchemaTypeSystem loadTypeSystem() {
        Class cls;
        Class<?> cls2;
        Class cls3;
        try {
            if (class$org$apache$xmlbeans$impl$schema$TypeSystemHolder == null) {
                cls = class$("org.apache.xmlbeans.impl.schema.TypeSystemHolder");
                class$org$apache$xmlbeans$impl$schema$TypeSystemHolder = cls;
            } else {
                cls = class$org$apache$xmlbeans$impl$schema$TypeSystemHolder;
            }
            Class<?> cls4 = Class.forName("org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl", true, cls.getClassLoader());
            Class<?>[] clsArr = new Class[1];
            if (class$java$lang$Class == null) {
                cls2 = class$("java.lang.Class");
                class$java$lang$Class = cls2;
            } else {
                cls2 = class$java$lang$Class;
            }
            clsArr[0] = cls2;
            Constructor<?> constructor = cls4.getConstructor(clsArr);
            Object[] objArr = new Object[1];
            if (class$org$apache$xmlbeans$impl$schema$TypeSystemHolder == null) {
                cls3 = class$("org.apache.xmlbeans.impl.schema.TypeSystemHolder");
                class$org$apache$xmlbeans$impl$schema$TypeSystemHolder = cls3;
            } else {
                cls3 = class$org$apache$xmlbeans$impl$schema$TypeSystemHolder;
            }
            objArr[0] = cls3;
            return (SchemaTypeSystem) constructor.newInstance(objArr);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot load org.apache.xmlbeans.impl.SchemaTypeSystemImpl: make sure xbean.jar is on the classpath.", e);
        } catch (Exception e2) {
            throw new RuntimeException(new StringBuffer().append("Could not instantiate SchemaTypeSystemImpl (").append(e2.toString()).append("): is the version of xbean.jar correct?").toString(), e2);
        }
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }
}
