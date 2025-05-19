package org.apache.commons.beanutils;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.collections.Predicate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes4.dex */
public class BeanPropertyValueEqualsPredicate implements Predicate {
    private boolean ignoreNull;
    private final Log log;
    private String propertyName;
    private Object propertyValue;

    public BeanPropertyValueEqualsPredicate(String str, Object obj) {
        this(str, obj, false);
    }

    public BeanPropertyValueEqualsPredicate(String str, Object obj, boolean z) {
        this.log = LogFactory.getLog(getClass());
        if (str != null && str.length() > 0) {
            this.propertyName = str;
            this.propertyValue = obj;
            this.ignoreNull = z;
            return;
        }
        throw new IllegalArgumentException("propertyName cannot be null or empty");
    }

    @Override // org.apache.commons.collections.Predicate
    public boolean evaluate(Object obj) {
        try {
            return evaluateValue(this.propertyValue, PropertyUtils.getProperty(obj, this.propertyName));
        } catch (IllegalAccessException e) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unable to access the property provided.");
            if (!BeanUtils.initCause(illegalArgumentException, e)) {
                this.log.error("Unable to access the property provided.", e);
                throw illegalArgumentException;
            }
            throw illegalArgumentException;
        } catch (IllegalArgumentException e2) {
            if (this.ignoreNull) {
                this.log.warn("WARNING: Problem during evaluation. Null value encountered in property path..." + e2);
                return false;
            }
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Problem during evaluation. Null value encountered in property path...");
            if (!BeanUtils.initCause(illegalArgumentException2, e2)) {
                this.log.error("Problem during evaluation. Null value encountered in property path...", e2);
                throw illegalArgumentException2;
            }
            throw illegalArgumentException2;
        } catch (NoSuchMethodException e3) {
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Property not found.");
            if (!BeanUtils.initCause(illegalArgumentException3, e3)) {
                this.log.error("Property not found.", e3);
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

    protected boolean evaluateValue(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    public Object getPropertyValue() {
        return this.propertyValue;
    }

    public boolean isIgnoreNull() {
        return this.ignoreNull;
    }
}
