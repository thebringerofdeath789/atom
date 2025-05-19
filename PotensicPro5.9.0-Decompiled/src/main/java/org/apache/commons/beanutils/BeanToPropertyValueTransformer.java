package org.apache.commons.beanutils;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.collections.Transformer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes4.dex */
public class BeanToPropertyValueTransformer implements Transformer {
    private boolean ignoreNull;
    private final Log log;
    private String propertyName;

    public BeanToPropertyValueTransformer(String str) {
        this(str, false);
    }

    public BeanToPropertyValueTransformer(String str, boolean z) {
        this.log = LogFactory.getLog(getClass());
        if (str != null && str.length() > 0) {
            this.propertyName = str;
            this.ignoreNull = z;
            return;
        }
        throw new IllegalArgumentException("propertyName cannot be null or empty");
    }

    @Override // org.apache.commons.collections.Transformer
    public Object transform(Object obj) {
        try {
            return PropertyUtils.getProperty(obj, this.propertyName);
        } catch (IllegalAccessException e) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unable to access the property provided.");
            if (!BeanUtils.initCause(illegalArgumentException, e)) {
                this.log.error("Unable to access the property provided.", e);
                throw illegalArgumentException;
            }
            throw illegalArgumentException;
        } catch (IllegalArgumentException e2) {
            if (this.ignoreNull) {
                this.log.warn("WARNING: Problem during transformation. Null value encountered in property path..." + e2);
                return null;
            }
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Problem during transformation. Null value encountered in property path...");
            if (!BeanUtils.initCause(illegalArgumentException2, e2)) {
                this.log.error("Problem during transformation. Null value encountered in property path...", e2);
                throw illegalArgumentException2;
            }
            throw illegalArgumentException2;
        } catch (NoSuchMethodException e3) {
            String str = "No property found for name [" + this.propertyName + "]";
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(str);
            if (!BeanUtils.initCause(illegalArgumentException3, e3)) {
                this.log.error(str, e3);
                throw illegalArgumentException3;
            }
            throw illegalArgumentException3;
        } catch (InvocationTargetException e4) {
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("Exception occurred in property's getter");
            if (!BeanUtils.initCause(illegalArgumentException4, e4)) {
                this.log.error("Exception occurred in property's getter", e4);
                throw illegalArgumentException4;
            }
            throw illegalArgumentException4;
        }
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    public boolean isIgnoreNull() {
        return this.ignoreNull;
    }
}
