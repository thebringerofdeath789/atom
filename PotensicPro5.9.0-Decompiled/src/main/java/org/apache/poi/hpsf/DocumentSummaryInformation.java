package org.apache.poi.hpsf;

import java.util.Iterator;
import java.util.Map;
import org.apache.poi.hpsf.wellknown.PropertyIDMap;
import org.apache.poi.hpsf.wellknown.SectionIDMap;

/* loaded from: classes4.dex */
public class DocumentSummaryInformation extends SpecialPropertySet {
    public static final String DEFAULT_STREAM_NAME = "\u0005DocumentSummaryInformation";

    @Override // org.apache.poi.hpsf.SpecialPropertySet
    public PropertyIDMap getPropertySetIDMap() {
        return PropertyIDMap.getDocumentSummaryInformationProperties();
    }

    public DocumentSummaryInformation(PropertySet propertySet) throws UnexpectedPropertySetTypeException {
        super(propertySet);
        if (!isDocumentSummaryInformation()) {
            throw new UnexpectedPropertySetTypeException("Not a " + getClass().getName());
        }
    }

    public String getCategory() {
        return getPropertyStringValue(2);
    }

    public void setCategory(String str) {
        ((MutableSection) getFirstSection()).setProperty(2, str);
    }

    public void removeCategory() {
        ((MutableSection) getFirstSection()).removeProperty(2L);
    }

    public String getPresentationFormat() {
        return getPropertyStringValue(3);
    }

    public void setPresentationFormat(String str) {
        ((MutableSection) getFirstSection()).setProperty(3, str);
    }

    public void removePresentationFormat() {
        ((MutableSection) getFirstSection()).removeProperty(3L);
    }

    public int getByteCount() {
        return getPropertyIntValue(4);
    }

    public void setByteCount(int i) {
        ((MutableSection) getFirstSection()).setProperty(4, i);
    }

    public void removeByteCount() {
        ((MutableSection) getFirstSection()).removeProperty(4L);
    }

    public int getLineCount() {
        return getPropertyIntValue(5);
    }

    public void setLineCount(int i) {
        ((MutableSection) getFirstSection()).setProperty(5, i);
    }

    public void removeLineCount() {
        ((MutableSection) getFirstSection()).removeProperty(5L);
    }

    public int getParCount() {
        return getPropertyIntValue(6);
    }

    public void setParCount(int i) {
        ((MutableSection) getFirstSection()).setProperty(6, i);
    }

    public void removeParCount() {
        ((MutableSection) getFirstSection()).removeProperty(6L);
    }

    public int getSlideCount() {
        return getPropertyIntValue(7);
    }

    public void setSlideCount(int i) {
        ((MutableSection) getFirstSection()).setProperty(7, i);
    }

    public void removeSlideCount() {
        ((MutableSection) getFirstSection()).removeProperty(7L);
    }

    public int getNoteCount() {
        return getPropertyIntValue(8);
    }

    public void setNoteCount(int i) {
        ((MutableSection) getFirstSection()).setProperty(8, i);
    }

    public void removeNoteCount() {
        ((MutableSection) getFirstSection()).removeProperty(8L);
    }

    public int getHiddenCount() {
        return getPropertyIntValue(9);
    }

    public void setHiddenCount(int i) {
        ((MutableSection) getSections().get(0)).setProperty(9, i);
    }

    public void removeHiddenCount() {
        ((MutableSection) getFirstSection()).removeProperty(9L);
    }

    public int getMMClipCount() {
        return getPropertyIntValue(10);
    }

    public void setMMClipCount(int i) {
        ((MutableSection) getFirstSection()).setProperty(10, i);
    }

    public void removeMMClipCount() {
        ((MutableSection) getFirstSection()).removeProperty(10L);
    }

    public boolean getScale() {
        return getPropertyBooleanValue(11);
    }

    public void setScale(boolean z) {
        ((MutableSection) getFirstSection()).setProperty(11, z);
    }

    public void removeScale() {
        ((MutableSection) getFirstSection()).removeProperty(11L);
    }

    public byte[] getHeadingPair() {
        notYetImplemented("Reading byte arrays ");
        return (byte[]) getProperty(12);
    }

    public void setHeadingPair(byte[] bArr) {
        notYetImplemented("Writing byte arrays ");
    }

    public void removeHeadingPair() {
        ((MutableSection) getFirstSection()).removeProperty(12L);
    }

    public byte[] getDocparts() {
        notYetImplemented("Reading byte arrays");
        return (byte[]) getProperty(13);
    }

    public void setDocparts(byte[] bArr) {
        notYetImplemented("Writing byte arrays");
    }

    public void removeDocparts() {
        ((MutableSection) getFirstSection()).removeProperty(13L);
    }

    public String getManager() {
        return getPropertyStringValue(14);
    }

    public void setManager(String str) {
        ((MutableSection) getFirstSection()).setProperty(14, str);
    }

    public void removeManager() {
        ((MutableSection) getFirstSection()).removeProperty(14L);
    }

    public String getCompany() {
        return getPropertyStringValue(15);
    }

    public void setCompany(String str) {
        ((MutableSection) getFirstSection()).setProperty(15, str);
    }

    public void removeCompany() {
        ((MutableSection) getFirstSection()).removeProperty(15L);
    }

    public boolean getLinksDirty() {
        return getPropertyBooleanValue(16);
    }

    public void setLinksDirty(boolean z) {
        ((MutableSection) getFirstSection()).setProperty(16, z);
    }

    public void removeLinksDirty() {
        ((MutableSection) getFirstSection()).removeProperty(16L);
    }

    public CustomProperties getCustomProperties() {
        if (getSectionCount() < 2) {
            return null;
        }
        CustomProperties customProperties = new CustomProperties();
        Section section = getSections().get(1);
        Map<Long, String> dictionary = section.getDictionary();
        int i = 0;
        for (Property property : section.getProperties()) {
            long id = property.getID();
            if (id != 0 && id != 1) {
                i++;
                CustomProperty customProperty = new CustomProperty(property, dictionary.get(Long.valueOf(id)));
                customProperties.put(customProperty.getName(), customProperty);
            }
        }
        if (customProperties.size() == i) {
            return customProperties;
        }
        customProperties.setPure(false);
        return customProperties;
    }

    public void setCustomProperties(CustomProperties customProperties) {
        ensureSection2();
        MutableSection mutableSection = (MutableSection) getSections().get(1);
        Map<Long, String> dictionary = customProperties.getDictionary();
        mutableSection.clear();
        int codepage = customProperties.getCodepage();
        if (codepage < 0) {
            codepage = mutableSection.getCodepage();
        }
        if (codepage < 0) {
            codepage = 1200;
        }
        customProperties.setCodepage(codepage);
        mutableSection.setCodepage(codepage);
        mutableSection.setDictionary(dictionary);
        Iterator<CustomProperty> it = customProperties.values().iterator();
        while (it.hasNext()) {
            mutableSection.setProperty(it.next());
        }
    }

    private void ensureSection2() {
        if (getSectionCount() < 2) {
            MutableSection mutableSection = new MutableSection();
            mutableSection.setFormatID(SectionIDMap.DOCUMENT_SUMMARY_INFORMATION_ID[1]);
            addSection(mutableSection);
        }
    }

    public void removeCustomProperties() {
        if (getSectionCount() >= 2) {
            getSections().remove(1);
            return;
        }
        throw new HPSFRuntimeException("Illegal internal format of Document SummaryInformation stream: second section is missing.");
    }

    private void notYetImplemented(String str) {
        throw new UnsupportedOperationException(str + " is not yet implemented.");
    }
}
