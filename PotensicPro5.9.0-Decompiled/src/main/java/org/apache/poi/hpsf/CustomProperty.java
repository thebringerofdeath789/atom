package org.apache.poi.hpsf;

/* loaded from: classes4.dex */
public class CustomProperty extends MutableProperty {
    private String name;

    public CustomProperty() {
        this.name = null;
    }

    public CustomProperty(Property property) {
        this(property, null);
    }

    public CustomProperty(Property property, String str) {
        super(property);
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public boolean equalsContents(Object obj) {
        boolean equals;
        CustomProperty customProperty = (CustomProperty) obj;
        String name = customProperty.getName();
        String name2 = getName();
        if (name == null) {
            equals = name2 == null;
        } else {
            equals = name.equals(name2);
        }
        return equals && customProperty.getID() == getID() && customProperty.getType() == getType() && customProperty.getValue().equals(getValue());
    }

    @Override // org.apache.poi.hpsf.Property
    public int hashCode() {
        return (int) getID();
    }

    @Override // org.apache.poi.hpsf.Property
    public boolean equals(Object obj) {
        if (obj instanceof CustomProperty) {
            return equalsContents(obj);
        }
        return false;
    }
}
