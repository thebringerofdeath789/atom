package com.mapbox.auto.value.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface GenerateTypeAdapter {
    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() { // from class: com.mapbox.auto.value.gson.GenerateTypeAdapter.1
        private final Class<?> typeArrayClass = Array.newInstance((Class<?>) Type.class, 0).getClass();
        private final Map<Class<?>, Constructor<? extends TypeAdapter>> adapters = Collections.synchronizedMap(new LinkedHashMap());

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (!rawType.isAnnotationPresent(GenerateTypeAdapter.class)) {
                return null;
            }
            Class<? super Object> superclass = rawType.getSuperclass();
            if (superclass.isAnnotationPresent(GenerateTypeAdapter.class)) {
                return gson.getAdapter(superclass);
            }
            Constructor<? extends TypeAdapter> findConstructorForClass = findConstructorForClass(rawType);
            if (findConstructorForClass == null) {
                return null;
            }
            try {
                return findConstructorForClass.getParameterTypes().length == 1 ? findConstructorForClass.newInstance(gson) : findConstructorForClass.newInstance(gson, ((ParameterizedType) typeToken.getType()).getActualTypeArguments());
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Unable to invoke " + findConstructorForClass, e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Unable to invoke " + findConstructorForClass, e2);
            } catch (InvocationTargetException e3) {
                Throwable cause = e3.getCause();
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Could not create generated TypeAdapter instance for type " + rawType, cause);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Constructor<? extends TypeAdapter> findConstructorForClass(Class<?> cls) {
            Constructor<? extends TypeAdapter> findConstructorForClass;
            Constructor<? extends TypeAdapter> constructor = this.adapters.get(cls);
            if (constructor != null) {
                return constructor;
            }
            String name = cls.getName();
            if (name.startsWith("android.") || name.startsWith("java.") || name.startsWith("kotlin.")) {
                return null;
            }
            try {
                try {
                    Class<?> loadClass = cls.getClassLoader().loadClass(cls.getName().replace("$", "_") + "_GsonTypeAdapter");
                    try {
                        findConstructorForClass = loadClass.getDeclaredConstructor(Gson.class);
                        findConstructorForClass.setAccessible(true);
                    } catch (NoSuchMethodException unused) {
                        findConstructorForClass = loadClass.getDeclaredConstructor(Gson.class, this.typeArrayClass);
                        findConstructorForClass.setAccessible(true);
                    }
                } catch (ClassNotFoundException unused2) {
                    findConstructorForClass = findConstructorForClass(cls.getSuperclass());
                    if (findConstructorForClass != null) {
                        findConstructorForClass.setAccessible(true);
                    }
                }
                this.adapters.put(cls, findConstructorForClass);
                return findConstructorForClass;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Unable to find binding constructor for " + name, e);
            }
        }
    };
}