package com.mapbox.auto.value.gson.internal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import okhttp3.HttpUrl;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public final class Util {
    static final Type[] EMPTY_TYPE_ARRAY = new Type[0];

    private Util() {
    }

    public static Map<String, String> renameFields(Class<?> cls, List<String> list, FieldNamingStrategy fieldNamingStrategy) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : list) {
            if (fieldNamingStrategy instanceof FieldNamingPolicy) {
                int i = C31751.$SwitchMap$com$google$gson$FieldNamingPolicy[((FieldNamingPolicy) fieldNamingStrategy).ordinal()];
                if (i == 1) {
                    linkedHashMap.put(str, upperCaseFirstLetter(str));
                } else if (i == 2) {
                    linkedHashMap.put(str, upperCaseFirstLetter(separateCamelCase(str, StringUtils.SPACE)));
                } else if (i == 3) {
                    linkedHashMap.put(str, separateCamelCase(str, "_").toLowerCase(Locale.ENGLISH));
                } else if (i == 4) {
                    linkedHashMap.put(str, separateCamelCase(str, "-").toLowerCase(Locale.ENGLISH));
                } else if (i == 5) {
                    linkedHashMap.put(str, separateCamelCase(str, ".").toLowerCase(Locale.ENGLISH));
                } else {
                    linkedHashMap.put(str, str);
                }
            } else {
                try {
                    linkedHashMap.put(str, fieldNamingStrategy.translateName(cls.getDeclaredField(str)));
                } catch (NoSuchFieldException unused) {
                    linkedHashMap.put(str, str);
                }
            }
        }
        return linkedHashMap;
    }

    /* renamed from: com.mapbox.auto.value.gson.internal.Util$1 */
    static /* synthetic */ class C31751 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$FieldNamingPolicy;

        static {
            int[] iArr = new int[FieldNamingPolicy.values().length];
            $SwitchMap$com$google$gson$FieldNamingPolicy = iArr;
            try {
                iArr[FieldNamingPolicy.UPPER_CAMEL_CASE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$gson$FieldNamingPolicy[FieldNamingPolicy.UPPER_CAMEL_CASE_WITH_SPACES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$gson$FieldNamingPolicy[FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$gson$FieldNamingPolicy[FieldNamingPolicy.LOWER_CASE_WITH_DASHES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$gson$FieldNamingPolicy[FieldNamingPolicy.LOWER_CASE_WITH_DOTS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private static String separateCamelCase(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    private static String modifyString(char c, String str, int i) {
        return i < str.length() ? c + str.substring(i) : String.valueOf(c);
    }

    private static String upperCaseFirstLetter(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        char charAt = str.charAt(0);
        int length = str.length();
        while (i < length - 1 && !Character.isLetter(charAt)) {
            sb.append(charAt);
            i++;
            charAt = str.charAt(i);
        }
        return !Character.isUpperCase(charAt) ? sb.append(modifyString(Character.toUpperCase(charAt), str, i + 1)).toString() : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Type canonicalize(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new GenericArrayTypeImpl(canonicalize(cls.getComponentType())) : cls;
        }
        if (type instanceof ParameterizedType) {
            if (type instanceof ParameterizedTypeImpl) {
                return type;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new ParameterizedTypeImpl(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            return type instanceof GenericArrayTypeImpl ? type : new GenericArrayTypeImpl(((GenericArrayType) type).getGenericComponentType());
        }
        if (!(type instanceof WildcardType) || (type instanceof WildcardTypeImpl)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        return new WildcardTypeImpl(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int hashCodeOrZero(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String typeToString(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkNotPrimitive(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException("Unexpected primitive " + type + ". Use the boxed type.");
        }
    }

    public static final class ParameterizedTypeImpl implements ParameterizedType {
        private final Type ownerType;
        private final Type rawType;
        final Type[] typeArguments;

        ParameterizedTypeImpl(Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                Class<?> enclosingClass = ((Class) type2).getEnclosingClass();
                if (type != null) {
                    if (enclosingClass == null || WildcardUtil.getRawType(type) != enclosingClass) {
                        throw new IllegalArgumentException("unexpected owner type for " + type2 + ": " + type);
                    }
                } else if (enclosingClass != null) {
                    throw new IllegalArgumentException("unexpected owner type for " + type2 + ": null");
                }
            }
            this.ownerType = type == null ? null : Util.canonicalize(type);
            this.rawType = Util.canonicalize(type2);
            this.typeArguments = (Type[]) typeArr.clone();
            int i = 0;
            while (true) {
                Type[] typeArr2 = this.typeArguments;
                if (i >= typeArr2.length) {
                    return;
                }
                Objects.requireNonNull(typeArr2[i]);
                Util.checkNotPrimitive(typeArr2[i]);
                Type[] typeArr3 = this.typeArguments;
                typeArr3[i] = Util.canonicalize(typeArr3[i]);
                i++;
            }
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.typeArguments.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.rawType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.ownerType;
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && WildcardUtil.equals(this, (ParameterizedType) obj);
        }

        public int hashCode() {
            return (Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode()) ^ Util.hashCodeOrZero(this.ownerType);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((this.typeArguments.length + 1) * 30);
            sb.append(Util.typeToString(this.rawType));
            if (this.typeArguments.length != 0) {
                sb.append("<").append(Util.typeToString(this.typeArguments[0]));
                for (int i = 1; i < this.typeArguments.length; i++) {
                    sb.append(", ").append(Util.typeToString(this.typeArguments[i]));
                }
                return sb.append(">").toString();
            }
            return sb.toString();
        }
    }

    public static final class GenericArrayTypeImpl implements GenericArrayType {
        private final Type componentType;

        GenericArrayTypeImpl(Type type) {
            this.componentType = Util.canonicalize(type);
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && WildcardUtil.equals(this, (GenericArrayType) obj);
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return Util.typeToString(this.componentType) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    public static final class WildcardTypeImpl implements WildcardType {
        private final Type lowerBound;
        private final Type upperBound;

        WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length > 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr.length != 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr2.length == 1) {
                Objects.requireNonNull(typeArr2[0]);
                Util.checkNotPrimitive(typeArr2[0]);
                if (typeArr[0] == Object.class) {
                    this.lowerBound = Util.canonicalize(typeArr2[0]);
                    this.upperBound = Object.class;
                    return;
                }
                throw new IllegalArgumentException();
            }
            Objects.requireNonNull(typeArr[0]);
            Util.checkNotPrimitive(typeArr[0]);
            this.lowerBound = null;
            this.upperBound = Util.canonicalize(typeArr[0]);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.lowerBound;
            return type != null ? new Type[]{type} : Util.EMPTY_TYPE_ARRAY;
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && WildcardUtil.equals(this, (WildcardType) obj);
        }

        public int hashCode() {
            Type type = this.lowerBound;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.upperBound.hashCode() + 31);
        }

        public String toString() {
            if (this.lowerBound != null) {
                return "? super " + Util.typeToString(this.lowerBound);
            }
            return this.upperBound == Object.class ? "?" : "? extends " + Util.typeToString(this.upperBound);
        }
    }
}