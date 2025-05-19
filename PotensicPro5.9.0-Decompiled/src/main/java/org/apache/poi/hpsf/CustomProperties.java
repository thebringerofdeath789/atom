package org.apache.poi.hpsf;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public class CustomProperties extends HashMap<Object, CustomProperty> {
    private Map<Long, String> dictionaryIDToName = new HashMap();
    private Map<String, Long> dictionaryNameToID = new HashMap();
    private boolean isPure = true;

    public CustomProperty put(String str, CustomProperty customProperty) {
        if (str == null) {
            this.isPure = false;
            return null;
        }
        if (!str.equals(customProperty.getName())) {
            throw new IllegalArgumentException("Parameter \"name\" (" + str + ") and custom property's name (" + customProperty.getName() + ") do not match.");
        }
        Long valueOf = Long.valueOf(customProperty.getID());
        Long l = this.dictionaryNameToID.get(str);
        this.dictionaryIDToName.remove(l);
        this.dictionaryNameToID.put(str, valueOf);
        this.dictionaryIDToName.put(valueOf, str);
        CustomProperty customProperty2 = (CustomProperty) super.remove(l);
        super.put((CustomProperties) valueOf, (Long) customProperty);
        return customProperty2;
    }

    private Object put(CustomProperty customProperty) throws ClassCastException {
        String name = customProperty.getName();
        Long l = this.dictionaryNameToID.get(name);
        if (l != null) {
            customProperty.setID(l.longValue());
        } else {
            Iterator<Long> it = this.dictionaryIDToName.keySet().iterator();
            long j = 1;
            while (it.hasNext()) {
                long longValue = it.next().longValue();
                if (longValue > j) {
                    j = longValue;
                }
            }
            customProperty.setID(j + 1);
        }
        return put(name, customProperty);
    }

    public Object remove(String str) {
        Long l = this.dictionaryNameToID.get(str);
        if (l == null) {
            return null;
        }
        this.dictionaryIDToName.remove(l);
        this.dictionaryNameToID.remove(str);
        return super.remove(l);
    }

    public Object put(String str, String str2) {
        MutableProperty mutableProperty = new MutableProperty();
        mutableProperty.setID(-1L);
        mutableProperty.setType(31L);
        mutableProperty.setValue(str2);
        return put(new CustomProperty(mutableProperty, str));
    }

    public Object put(String str, Long l) {
        MutableProperty mutableProperty = new MutableProperty();
        mutableProperty.setID(-1L);
        mutableProperty.setType(20L);
        mutableProperty.setValue(l);
        return put(new CustomProperty(mutableProperty, str));
    }

    public Object put(String str, Double d) {
        MutableProperty mutableProperty = new MutableProperty();
        mutableProperty.setID(-1L);
        mutableProperty.setType(5L);
        mutableProperty.setValue(d);
        return put(new CustomProperty(mutableProperty, str));
    }

    public Object put(String str, Integer num) {
        MutableProperty mutableProperty = new MutableProperty();
        mutableProperty.setID(-1L);
        mutableProperty.setType(3L);
        mutableProperty.setValue(num);
        return put(new CustomProperty(mutableProperty, str));
    }

    public Object put(String str, Boolean bool) {
        MutableProperty mutableProperty = new MutableProperty();
        mutableProperty.setID(-1L);
        mutableProperty.setType(11L);
        mutableProperty.setValue(bool);
        return put(new CustomProperty(mutableProperty, str));
    }

    public Object get(String str) {
        CustomProperty customProperty = (CustomProperty) super.get(this.dictionaryNameToID.get(str));
        if (customProperty != null) {
            return customProperty.getValue();
        }
        return null;
    }

    public Object put(String str, java.util.Date date) {
        MutableProperty mutableProperty = new MutableProperty();
        mutableProperty.setID(-1L);
        mutableProperty.setType(64L);
        mutableProperty.setValue(date);
        return put(new CustomProperty(mutableProperty, str));
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Set keySet() {
        return this.dictionaryNameToID.keySet();
    }

    public Set<String> nameSet() {
        return this.dictionaryNameToID.keySet();
    }

    public Set<String> idSet() {
        return this.dictionaryNameToID.keySet();
    }

    public void setCodepage(int i) {
        MutableProperty mutableProperty = new MutableProperty();
        mutableProperty.setID(1L);
        mutableProperty.setType(2L);
        mutableProperty.setValue(Integer.valueOf(i));
        put(new CustomProperty(mutableProperty));
    }

    Map<Long, String> getDictionary() {
        return this.dictionaryIDToName;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj instanceof Long) {
            return super.containsKey(obj);
        }
        if (obj instanceof String) {
            return super.containsKey(this.dictionaryNameToID.get(obj));
        }
        return false;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        if (obj instanceof CustomProperty) {
            return super.containsValue(obj);
        }
        Iterator it = super.values().iterator();
        while (it.hasNext()) {
            if (((CustomProperty) it.next()).getValue() == obj) {
                return true;
            }
        }
        return false;
    }

    public int getCodepage() {
        Iterator<CustomProperty> it = values().iterator();
        int i = -1;
        while (i == -1 && it.hasNext()) {
            CustomProperty next = it.next();
            if (next.getID() == 1) {
                i = ((Integer) next.getValue()).intValue();
            }
        }
        return i;
    }

    public boolean isPure() {
        return this.isPure;
    }

    public void setPure(boolean z) {
        this.isPure = z;
    }
}
