package org.apache.poi;

import java.math.BigDecimal;
import java.util.Date;
import org.apache.poi.openxml4j.opc.internal.PackagePropertiesPart;
import org.litepal.tablemanager.Creator;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty;
import org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties;

/* loaded from: classes.dex */
public class POIXMLPropertiesTextExtractor extends POIXMLTextExtractor {
    public POIXMLPropertiesTextExtractor(POIXMLDocument pOIXMLDocument) {
        super(pOIXMLDocument);
    }

    public POIXMLPropertiesTextExtractor(POIXMLTextExtractor pOIXMLTextExtractor) {
        super(pOIXMLTextExtractor.getDocument());
    }

    private void appendIfPresent(StringBuffer stringBuffer, String str, boolean z) {
        appendIfPresent(stringBuffer, str, Boolean.toString(z));
    }

    private void appendIfPresent(StringBuffer stringBuffer, String str, int i) {
        appendIfPresent(stringBuffer, str, Integer.toString(i));
    }

    private void appendIfPresent(StringBuffer stringBuffer, String str, Date date) {
        if (date == null) {
            return;
        }
        appendIfPresent(stringBuffer, str, date.toString());
    }

    private void appendIfPresent(StringBuffer stringBuffer, String str, String str2) {
        if (str2 == null) {
            return;
        }
        stringBuffer.append(str);
        stringBuffer.append(" = ");
        stringBuffer.append(str2);
        stringBuffer.append("\n");
    }

    public String getCorePropertiesText() {
        POIXMLDocument document = getDocument();
        if (document == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        PackagePropertiesPart underlyingProperties = document.getProperties().getCoreProperties().getUnderlyingProperties();
        appendIfPresent(stringBuffer, "Category", underlyingProperties.getCategoryProperty().getValue());
        appendIfPresent(stringBuffer, "Category", underlyingProperties.getCategoryProperty().getValue());
        appendIfPresent(stringBuffer, "ContentStatus", underlyingProperties.getContentStatusProperty().getValue());
        appendIfPresent(stringBuffer, "ContentType", underlyingProperties.getContentTypeProperty().getValue());
        appendIfPresent(stringBuffer, "Created", underlyingProperties.getCreatedProperty().getValue());
        appendIfPresent(stringBuffer, "CreatedString", underlyingProperties.getCreatedPropertyString());
        appendIfPresent(stringBuffer, Creator.TAG, underlyingProperties.getCreatorProperty().getValue());
        appendIfPresent(stringBuffer, "Description", underlyingProperties.getDescriptionProperty().getValue());
        appendIfPresent(stringBuffer, "Identifier", underlyingProperties.getIdentifierProperty().getValue());
        appendIfPresent(stringBuffer, "Keywords", underlyingProperties.getKeywordsProperty().getValue());
        appendIfPresent(stringBuffer, "Language", underlyingProperties.getLanguageProperty().getValue());
        appendIfPresent(stringBuffer, "LastModifiedBy", underlyingProperties.getLastModifiedByProperty().getValue());
        appendIfPresent(stringBuffer, "LastPrinted", underlyingProperties.getLastPrintedProperty().getValue());
        appendIfPresent(stringBuffer, "LastPrintedString", underlyingProperties.getLastPrintedPropertyString());
        appendIfPresent(stringBuffer, "Modified", underlyingProperties.getModifiedProperty().getValue());
        appendIfPresent(stringBuffer, "ModifiedString", underlyingProperties.getModifiedPropertyString());
        appendIfPresent(stringBuffer, "Revision", underlyingProperties.getRevisionProperty().getValue());
        appendIfPresent(stringBuffer, "Subject", underlyingProperties.getSubjectProperty().getValue());
        appendIfPresent(stringBuffer, "Title", underlyingProperties.getTitleProperty().getValue());
        appendIfPresent(stringBuffer, "Version", underlyingProperties.getVersionProperty().getValue());
        return stringBuffer.toString();
    }

    public String getExtendedPropertiesText() {
        POIXMLDocument document = getDocument();
        if (document == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        CTProperties underlyingProperties = document.getProperties().getExtendedProperties().getUnderlyingProperties();
        appendIfPresent(stringBuffer, "Application", underlyingProperties.getApplication());
        appendIfPresent(stringBuffer, "AppVersion", underlyingProperties.getAppVersion());
        appendIfPresent(stringBuffer, "Characters", underlyingProperties.getCharacters());
        appendIfPresent(stringBuffer, "CharactersWithSpaces", underlyingProperties.getCharactersWithSpaces());
        appendIfPresent(stringBuffer, "Company", underlyingProperties.getCompany());
        appendIfPresent(stringBuffer, "HyperlinkBase", underlyingProperties.getHyperlinkBase());
        appendIfPresent(stringBuffer, "HyperlinksChanged", underlyingProperties.getHyperlinksChanged());
        appendIfPresent(stringBuffer, "Lines", underlyingProperties.getLines());
        appendIfPresent(stringBuffer, "LinksUpToDate", underlyingProperties.getLinksUpToDate());
        appendIfPresent(stringBuffer, "Manager", underlyingProperties.getManager());
        appendIfPresent(stringBuffer, "Pages", underlyingProperties.getPages());
        appendIfPresent(stringBuffer, "Paragraphs", underlyingProperties.getParagraphs());
        appendIfPresent(stringBuffer, "PresentationFormat", underlyingProperties.getPresentationFormat());
        appendIfPresent(stringBuffer, "Template", underlyingProperties.getTemplate());
        appendIfPresent(stringBuffer, "TotalTime", underlyingProperties.getTotalTime());
        return stringBuffer.toString();
    }

    public String getCustomPropertiesText() {
        String str;
        POIXMLDocument document = getDocument();
        if (document == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (CTProperty cTProperty : document.getProperties().getCustomProperties().getUnderlyingProperties().getPropertyArray()) {
            if (cTProperty.isSetLpwstr()) {
                str = cTProperty.getLpwstr();
            } else if (cTProperty.isSetLpstr()) {
                str = cTProperty.getLpstr();
            } else if (cTProperty.isSetDate()) {
                str = cTProperty.getDate().toString();
            } else if (cTProperty.isSetFiletime()) {
                str = cTProperty.getFiletime().toString();
            } else if (cTProperty.isSetBool()) {
                str = Boolean.toString(cTProperty.getBool());
            } else if (cTProperty.isSetI1()) {
                str = Integer.toString(cTProperty.getI1());
            } else if (cTProperty.isSetI2()) {
                str = Integer.toString(cTProperty.getI2());
            } else if (cTProperty.isSetI4()) {
                str = Integer.toString(cTProperty.getI4());
            } else if (cTProperty.isSetI8()) {
                str = Long.toString(cTProperty.getI8());
            } else if (cTProperty.isSetInt()) {
                str = Integer.toString(cTProperty.getInt());
            } else if (cTProperty.isSetUi1()) {
                str = Integer.toString(cTProperty.getUi1());
            } else if (cTProperty.isSetUi2()) {
                str = Integer.toString(cTProperty.getUi2());
            } else if (cTProperty.isSetUi4()) {
                str = Long.toString(cTProperty.getUi4());
            } else if (cTProperty.isSetUi8()) {
                str = cTProperty.getUi8().toString();
            } else if (cTProperty.isSetUint()) {
                str = Long.toString(cTProperty.getUint());
            } else if (cTProperty.isSetR4()) {
                str = Float.toString(cTProperty.getR4());
            } else if (cTProperty.isSetR8()) {
                str = Double.toString(cTProperty.getR8());
            } else if (cTProperty.isSetDecimal()) {
                BigDecimal decimal = cTProperty.getDecimal();
                str = decimal == null ? null : decimal.toPlainString();
            } else {
                if (!cTProperty.isSetArray() && !cTProperty.isSetVector() && !cTProperty.isSetBlob() && !cTProperty.isSetOblob() && !cTProperty.isSetStream() && !cTProperty.isSetOstream() && !cTProperty.isSetVstream() && !cTProperty.isSetStorage()) {
                    cTProperty.isSetOstorage();
                }
                str = "(not implemented!)";
            }
            sb.append(cTProperty.getName() + " = " + str + "\n");
        }
        return sb.toString();
    }

    @Override // org.apache.poi.POITextExtractor
    public String getText() {
        try {
            return getCorePropertiesText() + getExtendedPropertiesText() + getCustomPropertiesText();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.apache.poi.POIXMLTextExtractor, org.apache.poi.POITextExtractor
    public POIXMLPropertiesTextExtractor getMetadataTextExtractor() {
        throw new IllegalStateException("You already have the Metadata Text Extractor, not recursing!");
    }
}
