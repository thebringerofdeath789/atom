package org.apache.commons.beanutils;

import java.beans.IndexedPropertyDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes4.dex */
public class DefaultBeanIntrospector implements BeanIntrospector {
    private final Log log = LogFactory.getLog(getClass());
    public static final BeanIntrospector INSTANCE = new DefaultBeanIntrospector();
    private static final Class<?>[] EMPTY_CLASS_PARAMETERS = new Class[0];
    private static final Class<?>[] LIST_CLASS_PARAMETER = {List.class};

    private DefaultBeanIntrospector() {
    }

    @Override // org.apache.commons.beanutils.BeanIntrospector
    public void introspect(IntrospectionContext introspectionContext) {
        try {
            PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(introspectionContext.getTargetClass()).getPropertyDescriptors();
            if (propertyDescriptors == null) {
                propertyDescriptors = new PropertyDescriptor[0];
            }
            handleIndexedPropertyDescriptors(introspectionContext.getTargetClass(), propertyDescriptors);
            introspectionContext.addPropertyDescriptors(propertyDescriptors);
        } catch (IntrospectionException e) {
            this.log.error("Error when inspecting class " + introspectionContext.getTargetClass(), e);
        }
    }

    private void handleIndexedPropertyDescriptors(Class<?> cls, PropertyDescriptor[] propertyDescriptorArr) {
        for (PropertyDescriptor propertyDescriptor : propertyDescriptorArr) {
            if (propertyDescriptor instanceof IndexedPropertyDescriptor) {
                IndexedPropertyDescriptor indexedPropertyDescriptor = (IndexedPropertyDescriptor) propertyDescriptor;
                String str = indexedPropertyDescriptor.getName().substring(0, 1).toUpperCase() + indexedPropertyDescriptor.getName().substring(1);
                if (indexedPropertyDescriptor.getReadMethod() == null) {
                    Method matchingAccessibleMethod = MethodUtils.getMatchingAccessibleMethod(cls, indexedPropertyDescriptor.getIndexedReadMethod() != null ? indexedPropertyDescriptor.getIndexedReadMethod().getName() : "get" + str, EMPTY_CLASS_PARAMETERS);
                    if (matchingAccessibleMethod != null) {
                        try {
                            indexedPropertyDescriptor.setReadMethod(matchingAccessibleMethod);
                        } catch (Exception e) {
                            this.log.error("Error setting indexed property read method", e);
                        }
                    }
                }
                if (indexedPropertyDescriptor.getWriteMethod() == null) {
                    String name = indexedPropertyDescriptor.getIndexedWriteMethod() != null ? indexedPropertyDescriptor.getIndexedWriteMethod().getName() : FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX + str;
                    Method matchingAccessibleMethod2 = MethodUtils.getMatchingAccessibleMethod(cls, name, LIST_CLASS_PARAMETER);
                    if (matchingAccessibleMethod2 == null) {
                        Method[] methods = cls.getMethods();
                        int length = methods.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                break;
                            }
                            Method method = methods[i];
                            if (method.getName().equals(name)) {
                                Class<?>[] parameterTypes = method.getParameterTypes();
                                if (parameterTypes.length == 1 && List.class.isAssignableFrom(parameterTypes[0])) {
                                    matchingAccessibleMethod2 = method;
                                    break;
                                }
                            }
                            i++;
                        }
                    }
                    if (matchingAccessibleMethod2 != null) {
                        try {
                            indexedPropertyDescriptor.setWriteMethod(matchingAccessibleMethod2);
                        } catch (Exception e2) {
                            this.log.error("Error setting indexed property write method", e2);
                        }
                    }
                }
            }
        }
    }
}
