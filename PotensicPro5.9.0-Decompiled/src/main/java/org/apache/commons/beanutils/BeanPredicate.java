package org.apache.commons.beanutils;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.collections.Predicate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes4.dex */
public class BeanPredicate implements Predicate {
    private final Log log = LogFactory.getLog(getClass());
    private Predicate predicate;
    private String propertyName;

    public BeanPredicate(String str, Predicate predicate) {
        this.propertyName = str;
        this.predicate = predicate;
    }

    @Override // org.apache.commons.collections.Predicate
    public boolean evaluate(Object obj) {
        try {
            return this.predicate.evaluate(PropertyUtils.getProperty(obj, this.propertyName));
        } catch (IllegalAccessException e) {
            this.log.error("Unable to access the property provided.", e);
            throw new IllegalArgumentException("Unable to access the property provided.");
        } catch (IllegalArgumentException e2) {
            this.log.error("ERROR: Problem during evaluation.", e2);
            throw e2;
        } catch (NoSuchMethodException e3) {
            this.log.error("Property not found.", e3);
            throw new IllegalArgumentException("Property not found.");
        } catch (InvocationTargetException e4) {
            this.log.error("Exception occurred in property's getter", e4);
            throw new IllegalArgumentException("Exception occurred in property's getter");
        }
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    public void setPropertyName(String str) {
        this.propertyName = str;
    }

    public Predicate getPredicate() {
        return this.predicate;
    }

    public void setPredicate(Predicate predicate) {
        this.predicate = predicate;
    }
}
