package org.apache.poi.xssf.extractor;

import aavax.xml.namespace.NamespaceContext;
import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.apache.poi.util.DocumentHelper;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFMap;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.helpers.XSSFSingleXmlCell;
import org.apache.poi.xssf.usermodel.helpers.XSSFXmlColumnPr;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* loaded from: classes5.dex */
public class XSSFImportFromXML {
    private static POILogger logger = POILogFactory.getLogger((Class<?>) XSSFImportFromXML.class);
    private final XSSFMap _map;

    public XSSFImportFromXML(XSSFMap xSSFMap) {
        this._map = xSSFMap;
    }

    public void importFromXML(String str) throws SAXException, XPathExpressionException, IOException {
        String str2;
        String str3;
        Document parse = DocumentHelper.newDocumentBuilder().parse(new InputSource(new StringReader(str.trim())));
        List<XSSFSingleXmlCell> relatedSingleXMLCell = this._map.getRelatedSingleXMLCell();
        List<XSSFTable> relatedTables = this._map.getRelatedTables();
        XPath newXPath = XPathFactory.newInstance().newXPath();
        newXPath.setNamespaceContext(new DefaultNamespaceContext(parse));
        Iterator<XSSFSingleXmlCell> it = relatedSingleXMLCell.iterator();
        while (true) {
            str2 = " in sheet ";
            str3 = "-";
            if (!it.hasNext()) {
                break;
            }
            XSSFSingleXmlCell next = it.next();
            String xpath = next.getXpath();
            Node node = (Node) newXPath.evaluate(xpath, parse, XPathConstants.NODE);
            if (node != null) {
                String textContent = node.getTextContent();
                logger.log(1, "Extracting with xpath " + xpath + " : value is '" + textContent + "'");
                XSSFCell referencedCell = next.getReferencedCell();
                logger.log(1, "Setting '" + textContent + "' to cell " + referencedCell.getColumnIndex() + "-" + referencedCell.getRowIndex() + " in sheet " + referencedCell.getSheet().getSheetName());
                referencedCell.setCellValue(textContent);
            }
        }
        Iterator<XSSFTable> it2 = relatedTables.iterator();
        while (it2.hasNext()) {
            XSSFTable next2 = it2.next();
            String commonXpath = next2.getCommonXpath();
            NodeList nodeList = (NodeList) newXPath.evaluate(commonXpath, parse, XPathConstants.NODESET);
            int row = next2.getStartCellReference().getRow() + 1;
            int col = next2.getStartCellReference().getCol() - 1;
            int i = 0;
            Iterator<XSSFTable> it3 = it2;
            while (i < nodeList.getLength()) {
                Iterator<XSSFXmlColumnPr> it4 = next2.getXmlColumnPrs().iterator();
                while (it4.hasNext()) {
                    XSSFXmlColumnPr next3 = it4.next();
                    Iterator<XSSFXmlColumnPr> it5 = it4;
                    Document document = parse;
                    int i2 = row + i;
                    int id = ((int) next3.getId()) + col;
                    int i3 = row;
                    String localXPath = next3.getLocalXPath();
                    String str4 = str2;
                    int i4 = col;
                    String str5 = str3;
                    String str6 = commonXpath + "[" + (i + 1) + "]" + localXPath.substring(localXPath.substring(1).indexOf(47) + 1);
                    String str7 = (String) newXPath.evaluate(str6, nodeList.item(i), XPathConstants.STRING);
                    logger.log(1, "Extracting with xpath " + str6 + " : value is '" + str7 + "'");
                    XSSFRow row2 = next2.getXSSFSheet().getRow(i2);
                    if (row2 == null) {
                        row2 = next2.getXSSFSheet().createRow(i2);
                    }
                    XSSFCell cell = row2.getCell(id);
                    if (cell == null) {
                        cell = row2.createCell(id);
                    }
                    logger.log(1, new StringBuilder().append("Setting '").append(str7).append("' to cell ").append(cell.getColumnIndex()).append(str5).append(cell.getRowIndex()).append(str4).append(next2.getXSSFSheet().getSheetName()).toString());
                    cell.setCellValue(str7.trim());
                    str3 = str5;
                    str2 = str4;
                    col = i4;
                    parse = document;
                    it4 = it5;
                    row = i3;
                    next2 = next2;
                }
                i++;
                str2 = str2;
                col = col;
                row = row;
            }
            it2 = it3;
        }
    }

    private static final class DefaultNamespaceContext implements NamespaceContext {
        private final Element _docElem;

        @Override // aavax.xml.namespace.NamespaceContext
        public String getPrefix(String str) {
            return null;
        }

        @Override // aavax.xml.namespace.NamespaceContext
        public Iterator getPrefixes(String str) {
            return null;
        }

        public DefaultNamespaceContext(Document document) {
            this._docElem = document.getDocumentElement();
        }

        @Override // aavax.xml.namespace.NamespaceContext
        public String getNamespaceURI(String str) {
            return getNamespaceForPrefix(str);
        }

        private String getNamespaceForPrefix(String str) {
            if (str.equals("xml")) {
                return "http://www.w3.org/XML/1998/namespace";
            }
            Node node = this._docElem;
            while (node != null) {
                short nodeType = node.getNodeType();
                if (nodeType == 1) {
                    if (node.getNodeName().startsWith(str + ":")) {
                        return node.getNamespaceURI();
                    }
                    NamedNodeMap attributes = node.getAttributes();
                    for (int i = 0; i < attributes.getLength(); i++) {
                        Node item = attributes.item(i);
                        String nodeName = item.getNodeName();
                        boolean startsWith = nodeName.startsWith(Sax2Dom.XMLNS_STRING);
                        if (startsWith || nodeName.equals("xmlns")) {
                            if ((startsWith ? nodeName.substring(nodeName.indexOf(58) + 1) : "").equals(str)) {
                                return item.getNodeValue();
                            }
                        }
                    }
                    node = node.getParentNode();
                } else if (nodeType != 5) {
                    return null;
                }
            }
            return null;
        }
    }
}
