package com.opencsv.bean;

import com.opencsv.bean.function.AccessorInvoker;
import com.opencsv.bean.function.AssignmentInvoker;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.apache.commons.lang3.reflect.FieldUtils;

/* loaded from: classes3.dex */
public class FieldAccess<T> {
    private final AccessorInvoker<Object, T> accessor = determineAccessorMethod();
    private final AssignmentInvoker<Object, T> assignment = determineAssignmentMethod();
    private final Field field;

    public FieldAccess(Field field) {
        this.field = field;
    }

    private AccessorInvoker<Object, T> determineAccessorMethod() {
        AccessorInvoker<Object, T> accessorInvoker;
        try {
            final Method method = this.field.getDeclaringClass().getMethod("get" + Character.toUpperCase(this.field.getName().charAt(0)) + this.field.getName().substring(1), new Class[0]);
            if (method.getReturnType().equals(Optional.class)) {
                accessorInvoker = new AccessorInvoker() { // from class: com.opencsv.bean.-$$Lambda$FieldAccess$hIbOp5UibjN5vXSB4Td4WNFb0ww
                    @Override // com.opencsv.bean.function.AccessorInvoker
                    public final Object invoke(Object obj) {
                        Object orElse;
                        orElse = ((Optional) method.invoke(obj, new Object[0])).orElse(null);
                        return orElse;
                    }
                };
            } else {
                accessorInvoker = new AccessorInvoker() { // from class: com.opencsv.bean.-$$Lambda$FieldAccess$lImX7KHKx_-c-ceTin3adgq2mng
                    @Override // com.opencsv.bean.function.AccessorInvoker
                    public final Object invoke(Object obj) {
                        Object invoke;
                        invoke = method.invoke(obj, new Object[0]);
                        return invoke;
                    }
                };
            }
            return accessorInvoker;
        } catch (NoSuchMethodException unused) {
            return new AccessorInvoker() { // from class: com.opencsv.bean.-$$Lambda$FieldAccess$iGxTOHgx-x7gY5n8YKIJvjZ1Dlc
                @Override // com.opencsv.bean.function.AccessorInvoker
                public final Object invoke(Object obj) {
                    return FieldAccess.this.lambda$determineAccessorMethod$2$FieldAccess(obj);
                }
            };
        }
    }

    public /* synthetic */ Object lambda$determineAccessorMethod$2$FieldAccess(Object obj) throws IllegalAccessException, InvocationTargetException {
        return FieldUtils.readField(this.field, obj, true);
    }

    private AssignmentInvoker<Object, T> determineAssignmentMethod() {
        String str = FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX + Character.toUpperCase(this.field.getName().charAt(0)) + this.field.getName().substring(1);
        try {
            try {
                final Method method = this.field.getDeclaringClass().getMethod(str, this.field.getType());
                method.getClass();
                return new AssignmentInvoker() { // from class: com.opencsv.bean.-$$Lambda$FieldAccess$ZUml-4x7QTDmDThp18eiNcFY-7c
                    @Override // com.opencsv.bean.function.AssignmentInvoker
                    public final void invoke(Object obj, Object obj2) {
                        method.invoke(obj, obj2);
                    }
                };
            } catch (NoSuchMethodException unused) {
                return new AssignmentInvoker() { // from class: com.opencsv.bean.-$$Lambda$FieldAccess$cYaQ0Wh673-RtIZFTbIPZoW6XfI
                    @Override // com.opencsv.bean.function.AssignmentInvoker
                    public final void invoke(Object obj, Object obj2) {
                        FieldAccess.this.lambda$determineAssignmentMethod$5$FieldAccess(obj, obj2);
                    }
                };
            }
        } catch (NoSuchMethodException unused2) {
            final Method method2 = this.field.getDeclaringClass().getMethod(str, Optional.class);
            return new AssignmentInvoker() { // from class: com.opencsv.bean.-$$Lambda$FieldAccess$5-G0shrD0lcynA_--5YE6PEO9Wc
                @Override // com.opencsv.bean.function.AssignmentInvoker
                public final void invoke(Object obj, Object obj2) {
                    method2.invoke(obj, Optional.ofNullable(obj2));
                }
            };
        }
    }

    public /* synthetic */ void lambda$determineAssignmentMethod$5$FieldAccess(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        FieldUtils.writeField(this.field, obj, obj2, true);
    }

    public T getField(Object obj) throws IllegalAccessException, InvocationTargetException {
        return this.accessor.invoke(obj);
    }

    public void setField(Object obj, T t) throws IllegalAccessException, InvocationTargetException {
        this.assignment.invoke(obj, t);
    }

    public int hashCode() {
        return this.field.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof FieldAccess) {
            return this.field.equals(((FieldAccess) obj).field);
        }
        return false;
    }

    public String toString() {
        return this.field.toString();
    }
}