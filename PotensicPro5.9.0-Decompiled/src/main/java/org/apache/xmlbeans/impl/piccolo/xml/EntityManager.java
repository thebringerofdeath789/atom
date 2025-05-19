package org.apache.xmlbeans.impl.piccolo.xml;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.apache.xmlbeans.impl.piccolo.util.RecursionException;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* loaded from: classes5.dex */
public class EntityManager {
    public static final int GENERAL = 0;
    public static final int PARAMETER = 1;
    private Map entitiesByURI;
    private Map[] entityMaps;
    private EntityResolver resolver;

    private final class Entry implements Entity {
        boolean isOpen;
        boolean isStandalone;
        String ndata;
        String pubID;
        XMLInputReader reader;
        String sysID;
        char[] value;

        Entry(String str) {
            this.isOpen = false;
            this.reader = null;
            this.isStandalone = false;
            this.ndata = null;
            this.sysID = null;
            this.pubID = null;
            this.value = str.toCharArray();
        }

        Entry(EntityManager entityManager, String str, String str2) {
            this(str, str2, null);
        }

        Entry(String str, String str2, String str3) {
            this.isOpen = false;
            this.reader = null;
            this.isStandalone = false;
            this.pubID = str;
            this.sysID = str2;
            this.ndata = str3;
        }

        @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
        public void open() throws RecursionException, SAXException, IOException {
            if (this.ndata != null) {
                throw new FatalParsingException(new StringBuffer().append("Cannot reference entity; unknown NDATA type '").append(this.ndata).append("'").toString());
            }
            if (this.isOpen) {
                throw new RecursionException();
            }
            if (!isInternal()) {
                if (EntityManager.this.resolver != null) {
                    InputSource resolveEntity = EntityManager.this.resolver.resolveEntity(this.pubID, this.sysID);
                    if (resolveEntity == null) {
                        this.reader = new XMLStreamReader(new URL(this.sysID).openStream(), true);
                    } else {
                        Reader characterStream = resolveEntity.getCharacterStream();
                        if (characterStream != null) {
                            this.reader = new XMLReaderReader(characterStream, true);
                        } else {
                            InputStream byteStream = resolveEntity.getByteStream();
                            if (byteStream != null) {
                                this.reader = new XMLStreamReader(byteStream, resolveEntity.getEncoding(), true);
                            } else {
                                this.reader = new XMLStreamReader(new URL(resolveEntity.getSystemId()).openStream(), resolveEntity.getEncoding(), true);
                            }
                        }
                    }
                } else {
                    this.reader = new XMLStreamReader(new URL(this.sysID).openStream(), true);
                }
                this.isStandalone = this.reader.isXMLStandalone();
            }
            this.isOpen = true;
        }

        @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
        public boolean isOpen() {
            return this.isOpen;
        }

        @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
        public void close() {
            this.isOpen = false;
            this.reader = null;
        }

        @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
        public String getSystemID() {
            return this.sysID;
        }

        @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
        public String getPublicID() {
            return this.pubID;
        }

        @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
        public boolean isStandalone() {
            return this.isStandalone;
        }

        @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
        public void setStandalone(boolean z) {
            this.isStandalone = z;
        }

        @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
        public boolean isInternal() {
            return this.sysID == null;
        }

        @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
        public boolean isParsed() {
            return this.ndata == null;
        }

        @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
        public String getDeclaredEncoding() {
            XMLInputReader xMLInputReader = this.reader;
            if (xMLInputReader != null) {
                return xMLInputReader.getXMLDeclaredEncoding();
            }
            return null;
        }

        @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
        public boolean isStandaloneDeclared() {
            XMLInputReader xMLInputReader = this.reader;
            if (xMLInputReader != null) {
                return xMLInputReader.isXMLStandaloneDeclared();
            }
            return false;
        }

        @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
        public String getXMLVersion() {
            XMLInputReader xMLInputReader = this.reader;
            if (xMLInputReader != null) {
                return xMLInputReader.getXMLVersion();
            }
            return null;
        }

        @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
        public Reader getReader() {
            if (isInternal()) {
                return new CharArrayReader(this.value);
            }
            return this.reader;
        }

        @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
        public String stringValue() {
            return new String(this.value);
        }

        @Override // org.apache.xmlbeans.impl.piccolo.xml.Entity
        public char[] charArrayValue() {
            return this.value;
        }
    }

    public EntityManager() {
        this(null);
    }

    public EntityManager(EntityResolver entityResolver) {
        this.entityMaps = new HashMap[]{new HashMap(), new HashMap()};
        this.entitiesByURI = new HashMap();
        setResolver(entityResolver);
    }

    public void setResolver(EntityResolver entityResolver) {
        this.resolver = entityResolver;
    }

    public EntityResolver getResolver() {
        return this.resolver;
    }

    public boolean putInternal(String str, String str2, int i) {
        if (this.entityMaps[i].get(str) != null) {
            return false;
        }
        this.entityMaps[i].put(str, new Entry(str2));
        return true;
    }

    public boolean putExternal(Entity entity, String str, String str2, String str3, int i) throws MalformedURLException {
        if (this.entityMaps[i].get(str) != null) {
            return false;
        }
        String resolveSystemID = resolveSystemID(entity.getSystemID(), str3);
        Entry entry = new Entry(this, str2, resolveSystemID);
        this.entityMaps[i].put(str, entry);
        if (str2 != null && str2.length() > 0) {
            this.entitiesByURI.put(str2, entry);
        }
        this.entitiesByURI.put(resolveSystemID, entry);
        return true;
    }

    public boolean putUnparsed(Entity entity, String str, String str2, String str3, String str4, int i) throws MalformedURLException {
        if (this.entityMaps[i].get(str) != null) {
            return false;
        }
        this.entityMaps[i].put(str, new Entry(str2, str3, str4));
        return true;
    }

    public void clear() {
        this.entityMaps[0].clear();
        this.entityMaps[1].clear();
        this.entitiesByURI.clear();
    }

    public Entity getByName(String str, int i) {
        return (Entry) this.entityMaps[i].get(str);
    }

    public Entity getByID(Entity entity, String str, String str2) throws MalformedURLException {
        Entity entity2;
        String resolveSystemID = resolveSystemID(entity.getSystemID(), str2);
        Entity entity3 = (Entity) this.entitiesByURI.get(resolveSystemID);
        if (entity3 != null) {
            return entity3;
        }
        if (str != null && str.length() > 0 && (entity2 = (Entity) this.entitiesByURI.get(str)) != null) {
            return entity2;
        }
        Entry entry = new Entry(this, str, resolveSystemID);
        if (str != null && str.length() > 0) {
            this.entitiesByURI.put(str, entry);
        }
        this.entitiesByURI.put(resolveSystemID, entry);
        return entry;
    }

    public static String resolveSystemID(String str, String str2) throws MalformedURLException {
        URL url;
        if (str != null) {
            url = new URL(new URL(str), str2);
        } else {
            url = new URL(str2);
        }
        return url.toString();
    }
}
