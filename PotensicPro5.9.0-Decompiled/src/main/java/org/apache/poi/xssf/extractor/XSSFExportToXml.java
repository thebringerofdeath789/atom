package org.apache.poi.xssf.extractor;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.utils.DateUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.SchemaFactory;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.DocumentHelper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFMap;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.helpers.XSSFSingleXmlCell;
import org.apache.poi.xssf.usermodel.helpers.XSSFXmlColumnPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXmlDataType;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* loaded from: classes5.dex */
public class XSSFExportToXml implements Comparator<String> {
    private XSSFMap map;

    public XSSFExportToXml(XSSFMap xSSFMap) {
        this.map = xSSFMap;
    }

    public void exportToXML(OutputStream outputStream, boolean z) throws SAXException, ParserConfigurationException, TransformerException {
        exportToXML(outputStream, "UTF-8", z);
    }

    public void exportToXML(OutputStream outputStream, String str, boolean z) throws SAXException, ParserConfigurationException, TransformerException {
        Element createElementNS;
        List<XSSFXmlColumnPr> list;
        HashMap hashMap;
        boolean z2;
        XSSFCell referencedCell;
        List<XSSFSingleXmlCell> relatedSingleXMLCell = this.map.getRelatedSingleXMLCell();
        List<XSSFTable> relatedTables = this.map.getRelatedTables();
        String rootElement = this.map.getCtMap().getRootElement();
        Document createDocument = DocumentHelper.createDocument();
        if (isNamespaceDeclared()) {
            createElementNS = createDocument.createElementNS(getNamespace(), rootElement);
        } else {
            createElementNS = createDocument.createElementNS("", rootElement);
        }
        createDocument.appendChild(createElementNS);
        Vector vector = new Vector();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        for (XSSFSingleXmlCell xSSFSingleXmlCell : relatedSingleXMLCell) {
            vector.add(xSSFSingleXmlCell.getXpath());
            hashMap2.put(xSSFSingleXmlCell.getXpath(), xSSFSingleXmlCell);
        }
        for (XSSFTable xSSFTable : relatedTables) {
            String commonXpath = xSSFTable.getCommonXpath();
            vector.add(commonXpath);
            hashMap3.put(commonXpath, xSSFTable);
        }
        Collections.sort(vector, this);
        Iterator it = vector.iterator();
        while (true) {
            boolean z3 = true;
            if (!it.hasNext()) {
                break;
            }
            String str2 = (String) it.next();
            XSSFSingleXmlCell xSSFSingleXmlCell2 = (XSSFSingleXmlCell) hashMap2.get(str2);
            XSSFTable xSSFTable2 = (XSSFTable) hashMap3.get(str2);
            if (!str2.matches(".*\\[.*")) {
                if (xSSFSingleXmlCell2 != null && (referencedCell = xSSFSingleXmlCell2.getReferencedCell()) != null) {
                    Node nodeByXPath = getNodeByXPath(str2, createDocument.getFirstChild(), createDocument, false);
                    mapCellOnNode(referencedCell, nodeByXPath, xSSFSingleXmlCell2.getXmlDataType());
                    if ("".equals(nodeByXPath.getTextContent()) && nodeByXPath.getParentNode() != null) {
                        nodeByXPath.getParentNode().removeChild(nodeByXPath);
                    }
                }
                if (xSSFTable2 != null) {
                    List<XSSFXmlColumnPr> xmlColumnPrs = xSSFTable2.getXmlColumnPrs();
                    XSSFSheet xSSFSheet = xSSFTable2.getXSSFSheet();
                    int row = xSSFTable2.getStartCellReference().getRow() + 1;
                    int row2 = xSSFTable2.getEndCellReference().getRow();
                    while (row <= row2) {
                        XSSFRow row3 = xSSFSheet.getRow(row);
                        Node nodeByXPath2 = getNodeByXPath(xSSFTable2.getCommonXpath(), createDocument.getFirstChild(), createDocument, z3);
                        short col = xSSFTable2.getStartCellReference().getCol();
                        int i = col;
                        while (i <= xSSFTable2.getEndCellReference().getCol()) {
                            XSSFCell cell = row3.getCell(i);
                            Iterator it2 = it;
                            if (cell != null) {
                                XSSFXmlColumnPr xSSFXmlColumnPr = xmlColumnPrs.get(i - col);
                                list = xmlColumnPrs;
                                hashMap = hashMap2;
                                z2 = false;
                                mapCellOnNode(cell, getNodeByXPath(xSSFXmlColumnPr.getLocalXPath(), nodeByXPath2, createDocument, false), xSSFXmlColumnPr.getXmlDataType());
                            } else {
                                list = xmlColumnPrs;
                                hashMap = hashMap2;
                                z2 = false;
                            }
                            i++;
                            it = it2;
                            xmlColumnPrs = list;
                            hashMap2 = hashMap;
                        }
                        row++;
                        hashMap2 = hashMap2;
                        z3 = true;
                    }
                }
            }
            it = it;
            hashMap2 = hashMap2;
        }
        if (z ? isValid(createDocument) : true) {
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, BooleanUtils.YES);
            newTransformer.setOutputProperty(OutputKeys.INDENT, BooleanUtils.YES);
            newTransformer.setOutputProperty(OutputKeys.ENCODING, str);
            newTransformer.transform(new DOMSource(createDocument), new StreamResult(outputStream));
        }
    }

    private boolean isValid(Document document) throws SAXException {
        try {
            SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema").newSchema(new DOMSource(this.map.getSchema())).newValidator().validate(new DOMSource(document));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void mapCellOnNode(XSSFCell xSSFCell, Node node, STXmlDataType.Enum r6) {
        int cellType = xSSFCell.getCellType();
        String str = "";
        if (cellType != 0) {
            if (cellType == 1) {
                str = xSSFCell.getStringCellValue();
            } else if (cellType != 2) {
                if (cellType == 4) {
                    str = "" + xSSFCell.getBooleanCellValue();
                } else if (cellType == 5) {
                    str = xSSFCell.getErrorCellString();
                }
            } else if (xSSFCell.getCachedFormulaResultType() == 1) {
                str = xSSFCell.getStringCellValue();
            } else if (DateUtil.isCellDateFormatted(xSSFCell)) {
                str = getFormattedDate(xSSFCell);
            } else {
                str = "" + xSSFCell.getNumericCellValue();
            }
        } else if (DateUtil.isCellDateFormatted(xSSFCell)) {
            str = getFormattedDate(xSSFCell);
        } else {
            str = "" + xSSFCell.getRawValue();
        }
        if (node instanceof Element) {
            ((Element) node).setTextContent(str);
        } else {
            node.setNodeValue(str);
        }
    }

    private String removeNamespace(String str) {
        return str.matches(".*:.*") ? str.split(":")[1] : str;
    }

    private String getFormattedDate(XSSFCell xSSFCell) {
        return new SimpleDateFormat(DateUtils.YMDHMS2).format(xSSFCell.getDateCellValue());
    }

    private Node getNodeByXPath(String str, Node node, Document document, boolean z) {
        String[] split = str.split(InternalZipConstants.ZIP_FILE_SEPARATOR);
        int i = 2;
        while (i < split.length) {
            String removeNamespace = removeNamespace(split[i]);
            if (!removeNamespace.startsWith("@")) {
                Node selectNode = (z && i == split.length + (-1)) ? null : selectNode(removeNamespace, node.getChildNodes());
                if (selectNode == null) {
                    selectNode = createElement(document, node, removeNamespace);
                }
                node = selectNode;
            } else {
                node = createAttribute(document, node, removeNamespace);
            }
            i++;
        }
        return node;
    }

    private Node createAttribute(Document document, Node node, String str) {
        String substring = str.substring(1);
        NamedNodeMap attributes = node.getAttributes();
        Node namedItem = attributes.getNamedItem(substring);
        if (namedItem != null) {
            return namedItem;
        }
        Attr createAttributeNS = document.createAttributeNS("", substring);
        attributes.setNamedItem(createAttributeNS);
        return createAttributeNS;
    }

    private Node createElement(Document document, Node node, String str) {
        Element createElementNS;
        if (isNamespaceDeclared()) {
            createElementNS = document.createElementNS(getNamespace(), str);
        } else {
            createElementNS = document.createElementNS("", str);
        }
        node.appendChild(createElementNS);
        return createElementNS;
    }

    private Node selectNode(String str, NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node item = nodeList.item(i);
            if (item.getNodeName().equals(str)) {
                return item;
            }
        }
        return null;
    }

    private boolean isNamespaceDeclared() {
        String namespace = getNamespace();
        return (namespace == null || namespace.equals("")) ? false : true;
    }

    private String getNamespace() {
        return this.map.getCTSchema().getNamespace();
    }

    @Override // java.util.Comparator
    public int compare(String str, String str2) {
        Node schema = this.map.getSchema();
        String[] split = str.split(InternalZipConstants.ZIP_FILE_SEPARATOR);
        String[] split2 = str2.split(InternalZipConstants.ZIP_FILE_SEPARATOR);
        int length = split.length < split2.length ? split.length : split2.length;
        Node node = schema;
        for (int i = 1; i < length; i++) {
            String str3 = split[i];
            String str4 = split2[i];
            if (str3.equals(str4)) {
                node = getComplexTypeForElement(str3, schema, node);
            } else {
                int indexOfElementInComplexType = indexOfElementInComplexType(str3, node);
                int indexOfElementInComplexType2 = indexOfElementInComplexType(str4, node);
                if (indexOfElementInComplexType != -1 && indexOfElementInComplexType2 != -1) {
                    if (indexOfElementInComplexType < indexOfElementInComplexType2) {
                        return -1;
                    }
                    if (indexOfElementInComplexType > indexOfElementInComplexType2) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    private int indexOfElementInComplexType(String str, Node node) {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if ((item instanceof Element) && item.getLocalName().equals("element") && getNameOrRefElement(item).getNodeValue().equals(removeNamespace(str))) {
                return i;
            }
        }
        return -1;
    }

    private Node getNameOrRefElement(Node node) {
        Node namedItem = node.getAttributes().getNamedItem("name");
        return namedItem != null ? namedItem : node.getAttributes().getNamedItem("ref");
    }

    private Node getComplexTypeForElement(String str, Node node, Node node2) {
        String complexTypeNameFromChildren = getComplexTypeNameFromChildren(node2, removeNamespace(str));
        if ("".equals(complexTypeNameFromChildren)) {
            return null;
        }
        return getComplexTypeNodeFromSchemaChildren(node, null, complexTypeNameFromChildren);
    }

    private String getComplexTypeNameFromChildren(Node node, String str) {
        Node namedItem;
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if ((item instanceof Element) && item.getLocalName().equals("element") && getNameOrRefElement(item).getNodeValue().equals(str) && (namedItem = item.getAttributes().getNamedItem("type")) != null) {
                return namedItem.getNodeValue();
            }
        }
        return "";
    }

    private Node getComplexTypeNodeFromSchemaChildren(Node node, Node node2, String str) {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if ((item instanceof Element) && item.getLocalName().equals("complexType") && getNameOrRefElement(item).getNodeValue().equals(str)) {
                NodeList childNodes2 = item.getChildNodes();
                for (int i2 = 0; i2 < childNodes2.getLength(); i2++) {
                    Node item2 = childNodes2.item(i2);
                    if ((item2 instanceof Element) && (item2.getLocalName().equals("sequence") || item2.getLocalName().equals(TtmlNode.COMBINE_ALL))) {
                        node2 = item2;
                        break;
                    }
                }
                if (node2 != null) {
                    break;
                }
            }
        }
        return node2;
    }
}
