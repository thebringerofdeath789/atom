package org.apache.xmlbeans.impl.jam.visitor;

import java.util.HashMap;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JMethod;
import org.apache.xmlbeans.impl.jam.JProperty;
import org.apache.xmlbeans.impl.jam.internal.elements.PropertyImpl;
import org.apache.xmlbeans.impl.jam.mutable.MClass;

/* loaded from: classes5.dex */
public class PropertyInitializer extends MVisitor {
    @Override // org.apache.xmlbeans.impl.jam.visitor.MVisitor
    public void visit(MClass mClass) {
        addProperties(mClass, true);
        addProperties(mClass, false);
    }

    private void addProperties(MClass mClass, boolean z) {
        JMethod[] declaredMethods = z ? mClass.getDeclaredMethods() : mClass.getMethods();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < declaredMethods.length; i++) {
            String simpleName = declaredMethods[i].getSimpleName();
            if ((simpleName.startsWith("get") && simpleName.length() > 3) || (simpleName.startsWith("is") && simpleName.length() > 2)) {
                JClass returnType = declaredMethods[i].getReturnType();
                if (returnType != null && declaredMethods[i].getParameters().length <= 0) {
                    if (simpleName.startsWith("get")) {
                        simpleName = simpleName.substring(3);
                    } else {
                        simpleName = simpleName.substring(2);
                    }
                    JProperty jProperty = (JProperty) hashMap.get(simpleName);
                    if (jProperty == null) {
                        hashMap.put(simpleName, z ? mClass.addNewDeclaredProperty(simpleName, declaredMethods[i], null) : mClass.addNewProperty(simpleName, declaredMethods[i], null));
                    } else if (returnType.equals(jProperty.getType())) {
                        ((PropertyImpl) jProperty).setGetter(declaredMethods[i]);
                    }
                }
            }
            if (simpleName.startsWith(FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX) && simpleName.length() > 3 && declaredMethods[i].getParameters().length == 1) {
                JClass type = declaredMethods[i].getParameters()[0].getType();
                String substring = simpleName.substring(3);
                JProperty jProperty2 = (JProperty) hashMap.get(substring);
                if (jProperty2 == null) {
                    hashMap.put(substring, z ? mClass.addNewDeclaredProperty(substring, null, declaredMethods[i]) : mClass.addNewProperty(substring, null, declaredMethods[i]));
                } else if (type.equals(jProperty2.getType())) {
                    ((PropertyImpl) jProperty2).setSetter(declaredMethods[i]);
                }
            }
        }
    }
}
