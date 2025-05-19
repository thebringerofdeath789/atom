package schemaorg_apache_xmlbeans.system.sXMLLANG;

import java.lang.reflect.Constructor;
import org.apache.xmlbeans.SchemaTypeSystem;

/* loaded from: classes6.dex */
public class TypeSystemHolder {
    static /* synthetic */ Class class$java$lang$Class;
    static /* synthetic */ Class class$schemaorg_apache_xmlbeans$system$sXMLLANG$TypeSystemHolder;
    public static final SchemaTypeSystem typeSystem = loadTypeSystem();

    private TypeSystemHolder() {
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private static final SchemaTypeSystem loadTypeSystem() {
        try {
            Class cls = class$schemaorg_apache_xmlbeans$system$sXMLLANG$TypeSystemHolder;
            if (cls == null) {
                cls = class$("schemaorg_apache_xmlbeans.system.sXMLLANG.TypeSystemHolder");
                class$schemaorg_apache_xmlbeans$system$sXMLLANG$TypeSystemHolder = cls;
            }
            Class<?> cls2 = Class.forName("org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl", true, cls.getClassLoader());
            Class<?>[] clsArr = new Class[1];
            Class<?> cls3 = class$java$lang$Class;
            if (cls3 == null) {
                cls3 = class$("java.lang.Class");
                class$java$lang$Class = cls3;
            }
            clsArr[0] = cls3;
            Constructor<?> constructor = cls2.getConstructor(clsArr);
            Object[] objArr = new Object[1];
            Class cls4 = class$schemaorg_apache_xmlbeans$system$sXMLLANG$TypeSystemHolder;
            if (cls4 == null) {
                cls4 = class$("schemaorg_apache_xmlbeans.system.sXMLLANG.TypeSystemHolder");
                class$schemaorg_apache_xmlbeans$system$sXMLLANG$TypeSystemHolder = cls4;
            }
            objArr[0] = cls4;
            return (SchemaTypeSystem) constructor.newInstance(objArr);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot load org.apache.xmlbeans.impl.SchemaTypeSystemImpl: make sure xbean.jar is on the classpath.", e);
        } catch (Exception e2) {
            throw new RuntimeException(new StringBuffer().append("Could not instantiate SchemaTypeSystemImpl (").append(e2.toString()).append("): is the version of xbean.jar correct?").toString(), e2);
        }
    }
}
