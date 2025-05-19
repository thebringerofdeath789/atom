package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class SerializeFilterable {
    protected List<BeforeFilter> beforeFilters = null;
    protected List<AfterFilter> afterFilters = null;
    protected List<PropertyFilter> propertyFilters = null;
    protected List<ValueFilter> valueFilters = null;
    protected List<NameFilter> nameFilters = null;
    protected List<PropertyPreFilter> propertyPreFilters = null;
    protected List<LabelFilter> labelFilters = null;
    protected List<ContextValueFilter> contextValueFilters = null;
    protected boolean writeDirect = true;

    public List<BeforeFilter> getBeforeFilters() {
        if (this.beforeFilters == null) {
            this.beforeFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.beforeFilters;
    }

    public List<AfterFilter> getAfterFilters() {
        if (this.afterFilters == null) {
            this.afterFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.afterFilters;
    }

    public List<NameFilter> getNameFilters() {
        if (this.nameFilters == null) {
            this.nameFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.nameFilters;
    }

    public List<PropertyPreFilter> getPropertyPreFilters() {
        if (this.propertyPreFilters == null) {
            this.propertyPreFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.propertyPreFilters;
    }

    public List<LabelFilter> getLabelFilters() {
        if (this.labelFilters == null) {
            this.labelFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.labelFilters;
    }

    public List<PropertyFilter> getPropertyFilters() {
        if (this.propertyFilters == null) {
            this.propertyFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.propertyFilters;
    }

    public List<ContextValueFilter> getContextValueFilters() {
        if (this.contextValueFilters == null) {
            this.contextValueFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.contextValueFilters;
    }

    public List<ValueFilter> getValueFilters() {
        if (this.valueFilters == null) {
            this.valueFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.valueFilters;
    }

    public void addFilter(SerializeFilter serializeFilter) {
        if (serializeFilter == null) {
            return;
        }
        if (serializeFilter instanceof PropertyPreFilter) {
            getPropertyPreFilters().add((PropertyPreFilter) serializeFilter);
        }
        if (serializeFilter instanceof NameFilter) {
            getNameFilters().add((NameFilter) serializeFilter);
        }
        if (serializeFilter instanceof ValueFilter) {
            getValueFilters().add((ValueFilter) serializeFilter);
        }
        if (serializeFilter instanceof ContextValueFilter) {
            getContextValueFilters().add((ContextValueFilter) serializeFilter);
        }
        if (serializeFilter instanceof PropertyFilter) {
            getPropertyFilters().add((PropertyFilter) serializeFilter);
        }
        if (serializeFilter instanceof BeforeFilter) {
            getBeforeFilters().add((BeforeFilter) serializeFilter);
        }
        if (serializeFilter instanceof AfterFilter) {
            getAfterFilters().add((AfterFilter) serializeFilter);
        }
        if (serializeFilter instanceof LabelFilter) {
            getLabelFilters().add((LabelFilter) serializeFilter);
        }
    }

    public boolean applyName(JSONSerializer jSONSerializer, Object obj, String str) {
        if (jSONSerializer.propertyPreFilters != null) {
            Iterator<PropertyPreFilter> it = jSONSerializer.propertyPreFilters.iterator();
            while (it.hasNext()) {
                if (!it.next().apply(jSONSerializer, obj, str)) {
                    return false;
                }
            }
        }
        List<PropertyPreFilter> list = this.propertyPreFilters;
        if (list == null) {
            return true;
        }
        Iterator<PropertyPreFilter> it2 = list.iterator();
        while (it2.hasNext()) {
            if (!it2.next().apply(jSONSerializer, obj, str)) {
                return false;
            }
        }
        return true;
    }

    public boolean apply(JSONSerializer jSONSerializer, Object obj, String str, Object obj2) {
        if (jSONSerializer.propertyFilters != null) {
            Iterator<PropertyFilter> it = jSONSerializer.propertyFilters.iterator();
            while (it.hasNext()) {
                if (!it.next().apply(obj, str, obj2)) {
                    return false;
                }
            }
        }
        List<PropertyFilter> list = this.propertyFilters;
        if (list == null) {
            return true;
        }
        Iterator<PropertyFilter> it2 = list.iterator();
        while (it2.hasNext()) {
            if (!it2.next().apply(obj, str, obj2)) {
                return false;
            }
        }
        return true;
    }

    protected String processKey(JSONSerializer jSONSerializer, Object obj, String str, Object obj2) {
        if (jSONSerializer.nameFilters != null) {
            Iterator<NameFilter> it = jSONSerializer.nameFilters.iterator();
            while (it.hasNext()) {
                str = it.next().process(obj, str, obj2);
            }
        }
        List<NameFilter> list = this.nameFilters;
        if (list != null) {
            Iterator<NameFilter> it2 = list.iterator();
            while (it2.hasNext()) {
                str = it2.next().process(obj, str, obj2);
            }
        }
        return str;
    }

    protected Object processValue(JSONSerializer jSONSerializer, BeanContext beanContext, Object obj, String str, Object obj2) {
        boolean z;
        if (obj2 != null) {
            if ((jSONSerializer.out.writeNonStringValueAsString || !(beanContext == null || (beanContext.getFeatures() & SerializerFeature.WriteNonStringValueAsString.mask) == 0)) && (((z = obj2 instanceof Number)) || (obj2 instanceof Boolean))) {
                String str2 = null;
                if (z && beanContext != null) {
                    str2 = beanContext.getFormat();
                }
                if (str2 != null) {
                    obj2 = new DecimalFormat(str2).format(obj2);
                } else {
                    obj2 = obj2.toString();
                }
            } else if (beanContext != null && beanContext.isJsonDirect()) {
                obj2 = JSON.parse((String) obj2);
            }
        }
        if (jSONSerializer.valueFilters != null) {
            Iterator<ValueFilter> it = jSONSerializer.valueFilters.iterator();
            while (it.hasNext()) {
                obj2 = it.next().process(obj, str, obj2);
            }
        }
        List<ValueFilter> list = this.valueFilters;
        if (list != null) {
            Iterator<ValueFilter> it2 = list.iterator();
            while (it2.hasNext()) {
                obj2 = it2.next().process(obj, str, obj2);
            }
        }
        if (jSONSerializer.contextValueFilters != null) {
            Iterator<ContextValueFilter> it3 = jSONSerializer.contextValueFilters.iterator();
            while (it3.hasNext()) {
                obj2 = it3.next().process(beanContext, obj, str, obj2);
            }
        }
        List<ContextValueFilter> list2 = this.contextValueFilters;
        if (list2 != null) {
            Iterator<ContextValueFilter> it4 = list2.iterator();
            while (it4.hasNext()) {
                obj2 = it4.next().process(beanContext, obj, str, obj2);
            }
        }
        return obj2;
    }

    protected boolean writeDirect(JSONSerializer jSONSerializer) {
        return jSONSerializer.out.writeDirect && this.writeDirect && jSONSerializer.writeDirect;
    }
}
