package com.wutka.dtd;

import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.io.File;
import java.net.URL;
import java.util.Enumeration;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
class Tokenize {
    Tokenize() {
    }

    public static void main(String[] strArr) {
        DTDParser dTDParser;
        try {
            if (strArr[0].indexOf("://") > 0) {
                dTDParser = new DTDParser(new URL(strArr[0]), true);
            } else {
                dTDParser = new DTDParser(new File(strArr[0]), true);
            }
            DTD parse = dTDParser.parse(true);
            if (parse.rootElement != null) {
                System.out.println(new StringBuffer().append("Root element is probably: ").append(parse.rootElement.name).toString());
            }
            Enumeration elements = parse.elements.elements();
            while (elements.hasMoreElements()) {
                DTDElement dTDElement = (DTDElement) elements.nextElement();
                System.out.println(new StringBuffer().append("Element: ").append(dTDElement.name).toString());
                System.out.print("   Content: ");
                dumpDTDItem(dTDElement.content);
                System.out.println();
                if (dTDElement.attributes.size() > 0) {
                    System.out.println("   Attributes: ");
                    Enumeration elements2 = dTDElement.attributes.elements();
                    while (elements2.hasMoreElements()) {
                        System.out.print("        ");
                        dumpAttribute((DTDAttribute) elements2.nextElement());
                    }
                    System.out.println();
                }
            }
            Enumeration elements3 = parse.entities.elements();
            while (elements3.hasMoreElements()) {
                DTDEntity dTDEntity = (DTDEntity) elements3.nextElement();
                if (dTDEntity.isParsed) {
                    System.out.print("Parsed ");
                }
                System.out.println(new StringBuffer().append("Entity: ").append(dTDEntity.name).toString());
                if (dTDEntity.value != null) {
                    System.out.println(new StringBuffer().append("    Value: ").append(dTDEntity.value).toString());
                }
                if (dTDEntity.externalID != null) {
                    if (dTDEntity.externalID instanceof DTDSystem) {
                        System.out.println(new StringBuffer().append("    System: ").append(dTDEntity.externalID.system).toString());
                    } else {
                        DTDPublic dTDPublic = (DTDPublic) dTDEntity.externalID;
                        System.out.println(new StringBuffer().append("    Public: ").append(dTDPublic.pub).append(StringUtils.SPACE).append(dTDPublic.system).toString());
                    }
                }
                if (dTDEntity.ndata != null) {
                    System.out.println(new StringBuffer().append("    NDATA ").append(dTDEntity.ndata).toString());
                }
            }
            Enumeration elements4 = parse.notations.elements();
            while (elements4.hasMoreElements()) {
                DTDNotation dTDNotation = (DTDNotation) elements4.nextElement();
                System.out.println(new StringBuffer().append("Notation: ").append(dTDNotation.name).toString());
                if (dTDNotation.externalID != null) {
                    if (dTDNotation.externalID instanceof DTDSystem) {
                        System.out.println(new StringBuffer().append("    System: ").append(dTDNotation.externalID.system).toString());
                    } else {
                        DTDPublic dTDPublic2 = (DTDPublic) dTDNotation.externalID;
                        System.out.print(new StringBuffer().append("    Public: ").append(dTDPublic2.pub).append(StringUtils.SPACE).toString());
                        if (dTDPublic2.system != null) {
                            System.out.println(dTDPublic2.system);
                        } else {
                            System.out.println();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public static void dumpDTDItem(DTDItem dTDItem) {
        if (dTDItem == null) {
            return;
        }
        if (dTDItem instanceof DTDAny) {
            System.out.print("Any");
        } else if (dTDItem instanceof DTDEmpty) {
            System.out.print("Empty");
        } else if (dTDItem instanceof DTDName) {
            System.out.print(((DTDName) dTDItem).value);
        } else {
            int i = 0;
            if (dTDItem instanceof DTDChoice) {
                System.out.print("(");
                DTDItem[] items = ((DTDChoice) dTDItem).getItems();
                while (i < items.length) {
                    if (i > 0) {
                        System.out.print("|");
                    }
                    dumpDTDItem(items[i]);
                    i++;
                }
                System.out.print(")");
            } else if (dTDItem instanceof DTDSequence) {
                System.out.print("(");
                DTDItem[] items2 = ((DTDSequence) dTDItem).getItems();
                while (i < items2.length) {
                    if (i > 0) {
                        System.out.print(",");
                    }
                    dumpDTDItem(items2[i]);
                    i++;
                }
                System.out.print(")");
            } else if (dTDItem instanceof DTDMixed) {
                System.out.print("(");
                DTDItem[] items3 = ((DTDMixed) dTDItem).getItems();
                while (i < items3.length) {
                    if (i > 0) {
                        System.out.print(",");
                    }
                    dumpDTDItem(items3[i]);
                    i++;
                }
                System.out.print(")");
            } else if (dTDItem instanceof DTDPCData) {
                System.out.print("#PCDATA");
            }
        }
        if (dTDItem.cardinal == DTDCardinal.OPTIONAL) {
            System.out.print("?");
        } else if (dTDItem.cardinal == DTDCardinal.ZEROMANY) {
            System.out.print(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD);
        } else if (dTDItem.cardinal == DTDCardinal.ONEMANY) {
            System.out.print("+");
        }
    }

    public static void dumpAttribute(DTDAttribute dTDAttribute) {
        System.out.print(new StringBuffer().append(dTDAttribute.name).append(StringUtils.SPACE).toString());
        if (dTDAttribute.type instanceof String) {
            System.out.print(dTDAttribute.type);
        } else {
            int i = 0;
            if (dTDAttribute.type instanceof DTDEnumeration) {
                System.out.print("(");
                String[] items = ((DTDEnumeration) dTDAttribute.type).getItems();
                while (i < items.length) {
                    if (i > 0) {
                        System.out.print(",");
                    }
                    System.out.print(items[i]);
                    i++;
                }
                System.out.print(")");
            } else if (dTDAttribute.type instanceof DTDNotationList) {
                System.out.print("Notation (");
                String[] items2 = ((DTDNotationList) dTDAttribute.type).getItems();
                while (i < items2.length) {
                    if (i > 0) {
                        System.out.print(",");
                    }
                    System.out.print(items2[i]);
                    i++;
                }
                System.out.print(")");
            }
        }
        if (dTDAttribute.decl != null) {
            System.out.print(new StringBuffer().append(StringUtils.SPACE).append(dTDAttribute.decl.name).toString());
        }
        if (dTDAttribute.defaultValue != null) {
            System.out.print(new StringBuffer().append(StringUtils.SPACE).append(dTDAttribute.defaultValue).toString());
        }
        System.out.println();
    }
}
