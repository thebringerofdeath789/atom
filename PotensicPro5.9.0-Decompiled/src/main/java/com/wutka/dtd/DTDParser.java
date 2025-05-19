package com.wutka.dtd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public class DTDParser implements EntityExpansion {
    protected Object defaultLocation;
    protected DTD dtd;
    protected Scanner scanner;

    public DTDParser(Reader reader) {
        this.scanner = new Scanner(reader, false, this);
        this.dtd = new DTD();
    }

    public DTDParser(Reader reader, boolean z) {
        this.scanner = new Scanner(reader, z, this);
        this.dtd = new DTD();
    }

    public DTDParser(File file) throws IOException {
        this.defaultLocation = file.getParentFile();
        this.scanner = new Scanner(new BufferedReader(new FileReader(file)), false, this);
        this.dtd = new DTD();
    }

    public DTDParser(File file, boolean z) throws IOException {
        this.defaultLocation = file.getParentFile();
        this.scanner = new Scanner(new BufferedReader(new FileReader(file)), z, this);
        this.dtd = new DTD();
    }

    public DTDParser(URL url) throws IOException {
        String file = url.getFile();
        this.defaultLocation = new URL(url.getProtocol(), url.getHost(), url.getPort(), file.substring(0, file.lastIndexOf(47) + 1));
        this.scanner = new Scanner(new BufferedReader(new InputStreamReader(url.openStream())), false, this);
        this.dtd = new DTD();
    }

    public DTDParser(URL url, boolean z) throws IOException {
        String file = url.getFile();
        this.defaultLocation = new URL(url.getProtocol(), url.getHost(), url.getPort(), file.substring(0, file.lastIndexOf(47) + 1));
        this.scanner = new Scanner(new BufferedReader(new InputStreamReader(url.openStream())), z, this);
        this.dtd = new DTD();
    }

    public DTD parse() throws IOException {
        return parse(false);
    }

    public DTD parse(boolean z) throws IOException {
        while (this.scanner.peek().type != Scanner.EOF) {
            parseTopLevelElement();
        }
        if (z) {
            Hashtable hashtable = new Hashtable();
            Enumeration elements = this.dtd.elements.elements();
            while (elements.hasMoreElements()) {
                DTDElement dTDElement = (DTDElement) elements.nextElement();
                hashtable.put(dTDElement.name, dTDElement);
            }
            Enumeration elements2 = this.dtd.elements.elements();
            while (elements2.hasMoreElements()) {
                DTDElement dTDElement2 = (DTDElement) elements2.nextElement();
                if (dTDElement2.content instanceof DTDContainer) {
                    Enumeration elements3 = ((DTDContainer) dTDElement2.content).getItemsVec().elements();
                    while (elements3.hasMoreElements()) {
                        removeElements(hashtable, this.dtd, (DTDItem) elements3.nextElement());
                    }
                }
            }
            if (hashtable.size() == 1) {
                Enumeration elements4 = hashtable.elements();
                this.dtd.rootElement = (DTDElement) elements4.nextElement();
            } else {
                this.dtd.rootElement = null;
            }
        } else {
            this.dtd.rootElement = null;
        }
        return this.dtd;
    }

    protected void removeElements(Hashtable hashtable, DTD dtd, DTDItem dTDItem) {
        if (dTDItem instanceof DTDName) {
            hashtable.remove(((DTDName) dTDItem).value);
        } else if (dTDItem instanceof DTDContainer) {
            Enumeration elements = ((DTDContainer) dTDItem).getItemsVec().elements();
            while (elements.hasMoreElements()) {
                removeElements(hashtable, dtd, (DTDItem) elements.nextElement());
            }
        }
    }

    protected void parseTopLevelElement() throws IOException {
        Token token = this.scanner.get();
        if (token.type == Scanner.LTQUES) {
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                stringBuffer.append(this.scanner.getUntil('?'));
                if (this.scanner.peek().type == Scanner.GT) {
                    this.scanner.get();
                    this.dtd.items.addElement(new DTDProcessingInstruction(stringBuffer.toString()));
                    return;
                }
                stringBuffer.append('?');
            }
        } else {
            if (token.type == Scanner.CONDITIONAL) {
                Token expect = expect(Scanner.IDENTIFIER);
                if (expect.value.equals("IGNORE")) {
                    this.scanner.skipConditional();
                    return;
                } else {
                    if (expect.value.equals("INCLUDE")) {
                        this.scanner.skipUntil(PropertyUtils.INDEXED_DELIM);
                        return;
                    }
                    throw new DTDParseException(this.scanner.getUriId(), new StringBuffer().append("Invalid token in conditional: ").append(expect.value).toString(), this.scanner.getLineNumber(), this.scanner.getColumn());
                }
            }
            if (token.type == Scanner.ENDCONDITIONAL) {
                return;
            }
            if (token.type == Scanner.COMMENT) {
                this.dtd.items.addElement(new DTDComment(token.value));
                return;
            }
            if (token.type == Scanner.LTBANG) {
                Token expect2 = expect(Scanner.IDENTIFIER);
                if (expect2.value.equals("ELEMENT")) {
                    parseElement();
                    return;
                }
                if (expect2.value.equals("ATTLIST")) {
                    parseAttlist();
                    return;
                }
                if (expect2.value.equals("ENTITY")) {
                    parseEntity();
                    return;
                } else if (expect2.value.equals("NOTATION")) {
                    parseNotation();
                    return;
                } else {
                    skipUntil(Scanner.GT);
                    return;
                }
            }
            throw new DTDParseException(this.scanner.getUriId(), new StringBuffer().append("Unexpected token: ").append(token.type.name).append("(").append(token.value).append(")").toString(), this.scanner.getLineNumber(), this.scanner.getColumn());
        }
    }

    protected void skipUntil(TokenType tokenType) throws IOException {
        Token token = this.scanner.get();
        while (token.type != tokenType) {
            token = this.scanner.get();
        }
    }

    protected Token expect(TokenType tokenType) throws IOException {
        Token token = this.scanner.get();
        if (token.type == tokenType) {
            return token;
        }
        if (token.value == null) {
            throw new DTDParseException(this.scanner.getUriId(), new StringBuffer().append("Expected ").append(tokenType.name).append(" instead of ").append(token.type.name).toString(), this.scanner.getLineNumber(), this.scanner.getColumn());
        }
        throw new DTDParseException(this.scanner.getUriId(), new StringBuffer().append("Expected ").append(tokenType.name).append(" instead of ").append(token.type.name).append("(").append(token.value).append(")").toString(), this.scanner.getLineNumber(), this.scanner.getColumn());
    }

    protected void parseElement() throws IOException {
        Token expect = expect(Scanner.IDENTIFIER);
        DTDElement dTDElement = (DTDElement) this.dtd.elements.get(expect.value);
        if (dTDElement == null) {
            dTDElement = new DTDElement(expect.value);
            this.dtd.elements.put(dTDElement.name, dTDElement);
        } else if (dTDElement.content != null) {
            throw new DTDParseException(this.scanner.getUriId(), new StringBuffer().append("Found second definition of element: ").append(expect.value).toString(), this.scanner.getLineNumber(), this.scanner.getColumn());
        }
        this.dtd.items.addElement(dTDElement);
        parseContentSpec(this.scanner, dTDElement);
        expect(Scanner.GT);
    }

    protected void parseContentSpec(Scanner scanner, DTDElement dTDElement) throws IOException {
        Token token = scanner.get();
        if (token.type == Scanner.IDENTIFIER) {
            if (token.value.equals("EMPTY")) {
                dTDElement.content = new DTDEmpty();
                return;
            } else {
                if (token.value.equals("ANY")) {
                    dTDElement.content = new DTDAny();
                    return;
                }
                throw new DTDParseException(scanner.getUriId(), new StringBuffer().append("Invalid token in entity content spec ").append(token.value).toString(), scanner.getLineNumber(), scanner.getColumn());
            }
        }
        if (token.type == Scanner.LPAREN) {
            Token peek = scanner.peek();
            if (peek.type == Scanner.IDENTIFIER) {
                if (peek.value.equals("#PCDATA")) {
                    parseMixed(dTDElement);
                    return;
                } else {
                    parseChildren(dTDElement);
                    return;
                }
            }
            if (peek.type == Scanner.LPAREN) {
                parseChildren(dTDElement);
            }
        }
    }

    protected void parseMixed(DTDElement dTDElement) throws IOException {
        DTDMixed dTDMixed = new DTDMixed();
        dTDMixed.add(new DTDPCData());
        this.scanner.get();
        dTDElement.content = dTDMixed;
        boolean z = true;
        while (true) {
            Token token = this.scanner.get();
            if (token.type == Scanner.RPAREN) {
                Token peek = this.scanner.peek();
                if (peek.type == Scanner.ASTERISK) {
                    this.scanner.get();
                    dTDMixed.cardinal = DTDCardinal.ZEROMANY;
                    return;
                } else {
                    if (!z) {
                        throw new DTDParseException(this.scanner.getUriId(), new StringBuffer().append("Invalid token in Mixed content type, '*' required after (#PCDATA|xx ...): ").append(peek.type.name).toString(), this.scanner.getLineNumber(), this.scanner.getColumn());
                    }
                    dTDMixed.cardinal = DTDCardinal.NONE;
                    return;
                }
            }
            if (token.type == Scanner.PIPE) {
                dTDMixed.add(new DTDName(this.scanner.get().value));
                z = false;
            } else {
                throw new DTDParseException(this.scanner.getUriId(), new StringBuffer().append("Invalid token in Mixed content type: ").append(token.type.name).toString(), this.scanner.getLineNumber(), this.scanner.getColumn());
            }
        }
    }

    protected void parseChildren(DTDElement dTDElement) throws IOException {
        DTDContainer parseChoiceSequence = parseChoiceSequence();
        Token peek = this.scanner.peek();
        parseChoiceSequence.cardinal = parseCardinality();
        if (peek.type == Scanner.QUES) {
            parseChoiceSequence.cardinal = DTDCardinal.OPTIONAL;
        } else if (peek.type == Scanner.ASTERISK) {
            parseChoiceSequence.cardinal = DTDCardinal.ZEROMANY;
        } else if (peek.type == Scanner.PLUS) {
            parseChoiceSequence.cardinal = DTDCardinal.ONEMANY;
        } else {
            parseChoiceSequence.cardinal = DTDCardinal.NONE;
        }
        dTDElement.content = parseChoiceSequence;
    }

    protected DTDContainer parseChoiceSequence() throws IOException {
        TokenType tokenType = null;
        DTDContainer dTDContainer = null;
        while (true) {
            DTDItem parseCP = parseCP();
            Token token = this.scanner.get();
            if (token.type == Scanner.PIPE || token.type == Scanner.COMMA) {
                if (tokenType != null && tokenType != token.type) {
                    throw new DTDParseException(this.scanner.getUriId(), "Can't mix separators in a choice/sequence", this.scanner.getLineNumber(), this.scanner.getColumn());
                }
                tokenType = token.type;
                if (dTDContainer == null) {
                    if (token.type == Scanner.PIPE) {
                        dTDContainer = new DTDChoice();
                    } else {
                        dTDContainer = new DTDSequence();
                    }
                }
                dTDContainer.add(parseCP);
            } else {
                if (token.type == Scanner.RPAREN) {
                    if (dTDContainer == null) {
                        dTDContainer = new DTDSequence();
                    }
                    dTDContainer.add(parseCP);
                    return dTDContainer;
                }
                throw new DTDParseException(this.scanner.getUriId(), new StringBuffer().append("Found invalid token in sequence: ").append(token.type.name).toString(), this.scanner.getLineNumber(), this.scanner.getColumn());
            }
        }
    }

    protected DTDItem parseCP() throws IOException {
        DTDItem parseChoiceSequence;
        Token token = this.scanner.get();
        if (token.type == Scanner.IDENTIFIER) {
            parseChoiceSequence = new DTDName(token.value);
        } else if (token.type == Scanner.LPAREN) {
            parseChoiceSequence = parseChoiceSequence();
        } else {
            throw new DTDParseException(this.scanner.getUriId(), new StringBuffer().append("Found invalid token in sequence: ").append(token.type.name).toString(), this.scanner.getLineNumber(), this.scanner.getColumn());
        }
        parseChoiceSequence.cardinal = parseCardinality();
        return parseChoiceSequence;
    }

    protected DTDCardinal parseCardinality() throws IOException {
        Token peek = this.scanner.peek();
        if (peek.type == Scanner.QUES) {
            this.scanner.get();
            return DTDCardinal.OPTIONAL;
        }
        if (peek.type == Scanner.ASTERISK) {
            this.scanner.get();
            return DTDCardinal.ZEROMANY;
        }
        if (peek.type == Scanner.PLUS) {
            this.scanner.get();
            return DTDCardinal.ONEMANY;
        }
        return DTDCardinal.NONE;
    }

    protected void parseAttlist() throws IOException {
        Token expect = expect(Scanner.IDENTIFIER);
        DTDElement dTDElement = (DTDElement) this.dtd.elements.get(expect.value);
        DTDAttlist dTDAttlist = new DTDAttlist(expect.value);
        this.dtd.items.addElement(dTDAttlist);
        if (dTDElement == null) {
            dTDElement = new DTDElement(expect.value);
            this.dtd.elements.put(expect.value, dTDElement);
        }
        Token peek = this.scanner.peek();
        while (peek.type != Scanner.GT) {
            parseAttdef(this.scanner, dTDElement, dTDAttlist);
            peek = this.scanner.peek();
        }
        expect(Scanner.GT);
    }

    protected void parseAttdef(Scanner scanner, DTDElement dTDElement, DTDAttlist dTDAttlist) throws IOException {
        Token expect = expect(Scanner.IDENTIFIER);
        DTDAttribute dTDAttribute = new DTDAttribute(expect.value);
        dTDAttlist.attributes.addElement(dTDAttribute);
        dTDElement.attributes.put(expect.value, dTDAttribute);
        Token token = scanner.get();
        if (token.type == Scanner.IDENTIFIER) {
            if (token.value.equals("NOTATION")) {
                dTDAttribute.type = parseNotationList();
            } else {
                dTDAttribute.type = token.value;
            }
        } else if (token.type == Scanner.LPAREN) {
            dTDAttribute.type = parseEnumeration();
        }
        Token peek = scanner.peek();
        if (peek.type == Scanner.IDENTIFIER) {
            scanner.get();
            if (peek.value.equals("#FIXED")) {
                dTDAttribute.decl = DTDDecl.FIXED;
                dTDAttribute.defaultValue = scanner.get().value;
                return;
            } else if (peek.value.equals("#REQUIRED")) {
                dTDAttribute.decl = DTDDecl.REQUIRED;
                return;
            } else {
                if (peek.value.equals("#IMPLIED")) {
                    dTDAttribute.decl = DTDDecl.IMPLIED;
                    return;
                }
                throw new DTDParseException(scanner.getUriId(), new StringBuffer().append("Invalid token in attribute declaration: ").append(peek.value).toString(), scanner.getLineNumber(), scanner.getColumn());
            }
        }
        if (peek.type == Scanner.STRING) {
            scanner.get();
            dTDAttribute.decl = DTDDecl.VALUE;
            dTDAttribute.defaultValue = peek.value;
        }
    }

    protected DTDNotationList parseNotationList() throws IOException {
        DTDNotationList dTDNotationList = new DTDNotationList();
        Token token = this.scanner.get();
        if (token.type != Scanner.LPAREN) {
            throw new DTDParseException(this.scanner.getUriId(), new StringBuffer().append("Invalid token in notation: ").append(token.type.name).toString(), this.scanner.getLineNumber(), this.scanner.getColumn());
        }
        while (true) {
            Token token2 = this.scanner.get();
            if (token2.type != Scanner.IDENTIFIER) {
                throw new DTDParseException(this.scanner.getUriId(), new StringBuffer().append("Invalid token in notation: ").append(token2.type.name).toString(), this.scanner.getLineNumber(), this.scanner.getColumn());
            }
            dTDNotationList.add(token2.value);
            Token peek = this.scanner.peek();
            if (peek.type == Scanner.RPAREN) {
                this.scanner.get();
                return dTDNotationList;
            }
            if (peek.type != Scanner.PIPE) {
                throw new DTDParseException(this.scanner.getUriId(), new StringBuffer().append("Invalid token in notation: ").append(peek.type.name).toString(), this.scanner.getLineNumber(), this.scanner.getColumn());
            }
            this.scanner.get();
        }
    }

    protected DTDEnumeration parseEnumeration() throws IOException {
        DTDEnumeration dTDEnumeration = new DTDEnumeration();
        while (true) {
            Token token = this.scanner.get();
            if (token.type != Scanner.IDENTIFIER && token.type != Scanner.NMTOKEN) {
                throw new DTDParseException(this.scanner.getUriId(), new StringBuffer().append("Invalid token in enumeration: ").append(token.type.name).toString(), this.scanner.getLineNumber(), this.scanner.getColumn());
            }
            dTDEnumeration.add(token.value);
            Token peek = this.scanner.peek();
            if (peek.type == Scanner.RPAREN) {
                this.scanner.get();
                return dTDEnumeration;
            }
            if (peek.type != Scanner.PIPE) {
                throw new DTDParseException(this.scanner.getUriId(), new StringBuffer().append("Invalid token in enumeration: ").append(peek.type.name).toString(), this.scanner.getLineNumber(), this.scanner.getColumn());
            }
            this.scanner.get();
        }
    }

    protected void parseEntity() throws IOException {
        boolean z;
        DTDEntity dTDEntity;
        Token token = this.scanner.get();
        boolean z2 = true;
        if (token.type == Scanner.PERCENT) {
            token = expect(Scanner.IDENTIFIER);
            z = true;
        } else {
            if (token.type != Scanner.IDENTIFIER) {
                throw new DTDParseException(this.scanner.getUriId(), "Invalid entity declaration", this.scanner.getLineNumber(), this.scanner.getColumn());
            }
            z = false;
        }
        if (((DTDEntity) this.dtd.entities.get(token.value)) == null) {
            dTDEntity = new DTDEntity(token.value, this.defaultLocation);
            this.dtd.entities.put(dTDEntity.name, dTDEntity);
            z2 = false;
        } else {
            dTDEntity = new DTDEntity(token.value, this.defaultLocation);
        }
        this.dtd.items.addElement(dTDEntity);
        dTDEntity.isParsed = z;
        parseEntityDef(dTDEntity);
        if (!dTDEntity.isParsed || dTDEntity.value == null || z2) {
            return;
        }
        this.scanner.addEntity(dTDEntity.name, dTDEntity.value);
    }

    protected void parseEntityDef(DTDEntity dTDEntity) throws IOException {
        Token token = this.scanner.get();
        if (token.type == Scanner.STRING) {
            if (dTDEntity.value == null) {
                dTDEntity.value = token.value;
            }
        } else if (token.type == Scanner.IDENTIFIER) {
            if (token.value.equals("SYSTEM")) {
                DTDSystem dTDSystem = new DTDSystem();
                dTDSystem.system = expect(Scanner.STRING).value;
                dTDEntity.externalID = dTDSystem;
            } else if (token.value.equals("PUBLIC")) {
                DTDPublic dTDPublic = new DTDPublic();
                dTDPublic.pub = expect(Scanner.STRING).value;
                dTDPublic.system = expect(Scanner.STRING).value;
                dTDEntity.externalID = dTDPublic;
            } else {
                throw new DTDParseException(this.scanner.getUriId(), "Invalid External ID specification", this.scanner.getLineNumber(), this.scanner.getColumn());
            }
            if (!dTDEntity.isParsed) {
                Token peek = this.scanner.peek();
                if (peek.type == Scanner.IDENTIFIER) {
                    if (!peek.value.equals("NDATA")) {
                        throw new DTDParseException(this.scanner.getUriId(), "Invalid NData declaration", this.scanner.getLineNumber(), this.scanner.getColumn());
                    }
                    this.scanner.get();
                    dTDEntity.ndata = expect(Scanner.IDENTIFIER).value;
                }
            }
        } else {
            throw new DTDParseException(this.scanner.getUriId(), "Invalid entity definition", this.scanner.getLineNumber(), this.scanner.getColumn());
        }
        expect(Scanner.GT);
    }

    protected void parseNotation() throws IOException {
        DTDNotation dTDNotation = new DTDNotation();
        dTDNotation.name = expect(Scanner.IDENTIFIER).value;
        this.dtd.notations.put(dTDNotation.name, dTDNotation);
        this.dtd.items.addElement(dTDNotation);
        Token expect = expect(Scanner.IDENTIFIER);
        if (expect.value.equals("SYSTEM")) {
            DTDSystem dTDSystem = new DTDSystem();
            dTDSystem.system = expect(Scanner.STRING).value;
            dTDNotation.externalID = dTDSystem;
        } else if (expect.value.equals("PUBLIC")) {
            DTDPublic dTDPublic = new DTDPublic();
            dTDPublic.pub = expect(Scanner.STRING).value;
            dTDPublic.system = null;
            if (this.scanner.peek().type == Scanner.STRING) {
                dTDPublic.system = this.scanner.get().value;
            }
            dTDNotation.externalID = dTDPublic;
        }
        expect(Scanner.GT);
    }

    @Override // com.wutka.dtd.EntityExpansion
    public DTDEntity expandEntity(String str) {
        return (DTDEntity) this.dtd.entities.get(str);
    }
}
