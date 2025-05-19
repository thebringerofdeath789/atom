package org.apache.poi.util;

import aavax.xml.namespace.QName;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;

/* loaded from: classes5.dex */
public final class XmlSort {
    public static void main(String[] strArr) {
        if (strArr.length < 1 || strArr.length > 2) {
            System.out.println("    java XmlSort <XML_File> [<XPath>]");
            return;
        }
        try {
            XmlObject parse = XmlObject.Factory.parse(new File(strArr[0]));
            XmlObject xmlObject = null;
            if (strArr.length > 1) {
                String str = strArr[1];
                XmlObject[] selectPath = parse.selectPath(str);
                if (selectPath.length == 0) {
                    System.out.println("ERROR: XPath \"" + str + "\" did not return any results");
                } else if (selectPath.length > 1) {
                    System.out.println("ERROR: XPath \"" + str + "\" returned more than one node (" + selectPath.length + ")");
                } else {
                    xmlObject = selectPath[0];
                }
            } else {
                XmlCursor newCursor = parse.newCursor();
                newCursor.toFirstChild();
                XmlObject object = newCursor.getObject();
                newCursor.dispose();
                xmlObject = object;
            }
            if (xmlObject != null) {
                sort(xmlObject, new QNameComparator(1));
            }
            System.out.println(parse.xmlText());
        } catch (IOException e) {
            System.out.println("ERROR: Could not open file: \"" + strArr[0] + "\": " + e.getMessage());
        } catch (XmlException e2) {
            System.out.println("ERROR: Could not parse file: \"" + strArr[0] + "\": " + e2.getMessage());
        }
    }

    public static void sort(XmlObject xmlObject, Comparator<XmlCursor> comparator) {
        XmlCursor newCursor = xmlObject.newCursor();
        if (!newCursor.isStart()) {
            throw new IllegalStateException("The element parameter must point to a STARTDOC");
        }
        if (newCursor.toFirstChild()) {
            XmlCursor newCursor2 = newCursor.newCursor();
            boolean nextSibling = newCursor2.toNextSibling();
            while (nextSibling) {
                boolean z = false;
                while (true) {
                    if (newCursor.comparePosition(newCursor2) >= 0) {
                        break;
                    }
                    if (comparator.compare(newCursor, newCursor2) > 0) {
                        newCursor2.moveXml(newCursor);
                        while (!newCursor2.isStart() && !newCursor2.isEnd()) {
                            newCursor2.moveXml(newCursor);
                        }
                        nextSibling = newCursor2.isStart();
                        z = true;
                    } else {
                        newCursor.toNextSibling();
                    }
                }
                if (!z) {
                    nextSibling = newCursor2.toNextSibling();
                }
                newCursor.toParent();
                newCursor.toFirstChild();
            }
        }
    }

    public static final class QNameComparator implements Comparator {
        public static final int ASCENDING = 1;
        public static final int DESCENDING = 2;
        private int order;

        public QNameComparator(int i) {
            this.order = i;
            if (i != 1 && i != 2) {
                throw new IllegalArgumentException("Please specify one of ASCENDING or DESCENDING comparison orders");
            }
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            QName name = ((XmlCursor) obj).getName();
            QName name2 = ((XmlCursor) obj2).getName();
            int compareTo = name.getNamespaceURI().compareTo(name2.getNamespaceURI());
            if (compareTo != 0) {
                return this.order == 1 ? compareTo : -compareTo;
            }
            int i = this.order;
            int compareTo2 = name.getLocalPart().compareTo(name2.getLocalPart());
            return i == 1 ? compareTo2 : -compareTo2;
        }
    }
}
