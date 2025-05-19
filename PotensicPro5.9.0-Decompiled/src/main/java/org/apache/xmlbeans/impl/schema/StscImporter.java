package org.apache.xmlbeans.impl.schema;

import com.opencsv.ICSVParser;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.IOUtil;
import org.apache.xmlbeans.impl.common.XmlEncodingSniffer;
import org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* loaded from: classes5.dex */
public class StscImporter {
    private static final String PROJECT_URL_PREFIX = "project://local";

    public static SchemaToProcess[] resolveImportsAndIncludes(SchemaDocument.Schema[] schemaArr, boolean z) {
        return new DownloadTable(schemaArr).resolveImportsAndIncludes(z);
    }

    public static class SchemaToProcess {
        private String chameleonNamespace;
        private List includes;
        private Set indirectIncludedBy;
        private Set indirectIncludes;
        private List redefineObjects;
        private List redefines;
        private SchemaDocument.Schema schema;

        public SchemaToProcess(SchemaDocument.Schema schema, String str) {
            this.schema = schema;
            this.chameleonNamespace = str;
        }

        public SchemaDocument.Schema getSchema() {
            return this.schema;
        }

        public String getSourceName() {
            return this.schema.documentProperties().getSourceName();
        }

        public String getChameleonNamespace() {
            return this.chameleonNamespace;
        }

        public List getRedefines() {
            return this.redefines;
        }

        public List getRedefineObjects() {
            return this.redefineObjects;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addInclude(SchemaToProcess schemaToProcess) {
            if (this.includes == null) {
                this.includes = new ArrayList();
            }
            this.includes.add(schemaToProcess);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addRedefine(SchemaToProcess schemaToProcess, RedefineDocument.Redefine redefine) {
            if (this.redefines == null || this.redefineObjects == null) {
                this.redefines = new ArrayList();
                this.redefineObjects = new ArrayList();
            }
            this.redefines.add(schemaToProcess);
            this.redefineObjects.add(redefine);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void buildIndirectReferences() {
            if (this.includes != null) {
                for (int i = 0; i < this.includes.size(); i++) {
                    addIndirectIncludes((SchemaToProcess) this.includes.get(i));
                }
            }
            if (this.redefines != null) {
                for (int i2 = 0; i2 < this.redefines.size(); i2++) {
                    addIndirectIncludes((SchemaToProcess) this.redefines.get(i2));
                }
            }
        }

        private void addIndirectIncludes(SchemaToProcess schemaToProcess) {
            if (this.indirectIncludes == null) {
                this.indirectIncludes = new HashSet();
            }
            this.indirectIncludes.add(schemaToProcess);
            if (schemaToProcess.indirectIncludedBy == null) {
                schemaToProcess.indirectIncludedBy = new HashSet();
            }
            schemaToProcess.indirectIncludedBy.add(this);
            addIndirectIncludesHelper(this, schemaToProcess);
            Set<SchemaToProcess> set = this.indirectIncludedBy;
            if (set != null) {
                for (SchemaToProcess schemaToProcess2 : set) {
                    schemaToProcess2.indirectIncludes.add(schemaToProcess);
                    schemaToProcess.indirectIncludedBy.add(schemaToProcess2);
                    addIndirectIncludesHelper(schemaToProcess2, schemaToProcess);
                }
            }
        }

        private static void addIndirectIncludesHelper(SchemaToProcess schemaToProcess, SchemaToProcess schemaToProcess2) {
            Set<SchemaToProcess> set = schemaToProcess2.indirectIncludes;
            if (set != null) {
                for (SchemaToProcess schemaToProcess3 : set) {
                    schemaToProcess.indirectIncludes.add(schemaToProcess3);
                    schemaToProcess3.indirectIncludedBy.add(schemaToProcess);
                }
            }
        }

        public boolean indirectIncludes(SchemaToProcess schemaToProcess) {
            Set set = this.indirectIncludes;
            return set != null && set.contains(schemaToProcess);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SchemaToProcess)) {
                return false;
            }
            SchemaToProcess schemaToProcess = (SchemaToProcess) obj;
            String str = this.chameleonNamespace;
            if (str == null ? schemaToProcess.chameleonNamespace == null : str.equals(schemaToProcess.chameleonNamespace)) {
                return this.schema == schemaToProcess.schema;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.schema.hashCode() * 29;
            String str = this.chameleonNamespace;
            return hashCode + (str != null ? str.hashCode() : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String baseURLForDoc(XmlObject xmlObject) {
        String sourceName = xmlObject.documentProperties().getSourceName();
        if (sourceName == null) {
            return null;
        }
        if (sourceName.startsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            return new StringBuffer().append(PROJECT_URL_PREFIX).append(sourceName.replace(ICSVParser.DEFAULT_ESCAPE_CHARACTER, '/')).toString();
        }
        int indexOf = sourceName.indexOf(58);
        return (indexOf <= 1 || !sourceName.substring(0, indexOf).matches("^\\w+$")) ? new StringBuffer().append("project://local/").append(sourceName.replace(ICSVParser.DEFAULT_ESCAPE_CHARACTER, '/')).toString() : sourceName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static URI parseURI(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new URI(str);
        } catch (URISyntaxException unused) {
            return null;
        }
    }

    public static URI resolve(URI uri, String str) throws URISyntaxException {
        URI uri2 = new URI(str);
        URI resolve = uri.resolve(uri2);
        if (uri2.equals(resolve) && !uri2.isAbsolute() && (uri.getScheme().equals("jar") || uri.getScheme().equals("zip"))) {
            String uri3 = uri.toString();
            String stringBuffer = new StringBuffer().append(uri3.substring(0, uri3.lastIndexOf(47))).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(uri2).toString();
            int lastIndexOf = stringBuffer.lastIndexOf("!/");
            if (lastIndexOf > 0) {
                for (int indexOf = stringBuffer.indexOf("/..", lastIndexOf); indexOf > 0; indexOf = stringBuffer.indexOf("/..", lastIndexOf)) {
                    int lastIndexOf2 = stringBuffer.lastIndexOf(InternalZipConstants.ZIP_FILE_SEPARATOR, indexOf - 1);
                    if (lastIndexOf2 >= lastIndexOf) {
                        stringBuffer = stringBuffer.substring(0, lastIndexOf2).concat(stringBuffer.substring(indexOf + 3));
                    }
                }
            }
            return URI.create(stringBuffer);
        }
        if (!StringLookupFactory.KEY_FILE.equals(resolve.getScheme()) || str.equals(resolve) || !uri.getPath().startsWith("//") || resolve.getPath().startsWith("//")) {
            return resolve;
        }
        try {
            return new URI(StringLookupFactory.KEY_FILE, null, "///".concat(resolve.getPath()), resolve.getQuery(), resolve.getFragment());
        } catch (URISyntaxException unused) {
            return resolve;
        }
    }

    public static class DownloadTable {
        private Map schemaByNsLocPair = new HashMap();
        private Map schemaByDigestKey = new HashMap();
        private LinkedList scanNeeded = new LinkedList();
        private Set emptyNamespaceSchemas = new HashSet();
        private Map scannedAlready = new HashMap();
        private Set failedDownloads = new HashSet();

        private static String emptyStringIfNull(String str) {
            return str == null ? "" : str;
        }

        private static class NsLocPair {
            private String locationURL;
            private String namespaceURI;

            public NsLocPair(String str, String str2) {
                this.namespaceURI = str;
                this.locationURL = str2;
            }

            public String getNamespaceURI() {
                return this.namespaceURI;
            }

            public String getLocationURL() {
                return this.locationURL;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof NsLocPair)) {
                    return false;
                }
                NsLocPair nsLocPair = (NsLocPair) obj;
                String str = this.locationURL;
                if (str == null ? nsLocPair.locationURL != null : !str.equals(nsLocPair.locationURL)) {
                    return false;
                }
                String str2 = this.namespaceURI;
                String str3 = nsLocPair.namespaceURI;
                return str2 == null ? str3 == null : str2.equals(str3);
            }

            public int hashCode() {
                String str = this.namespaceURI;
                int hashCode = (str != null ? str.hashCode() : 0) * 29;
                String str2 = this.locationURL;
                return hashCode + (str2 != null ? str2.hashCode() : 0);
            }
        }

        private static class DigestKey {
            byte[] _digest;
            int _hashCode;

            DigestKey(byte[] bArr) {
                this._digest = bArr;
                for (int i = 0; i < 4 && i < bArr.length; i++) {
                    int i2 = this._hashCode << 8;
                    this._hashCode = i2;
                    this._hashCode = i2 + bArr[i];
                }
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof DigestKey) {
                    return Arrays.equals(this._digest, ((DigestKey) obj)._digest);
                }
                return false;
            }

            public int hashCode() {
                return this._hashCode;
            }
        }

        private SchemaDocument.Schema downloadSchema(XmlObject xmlObject, String str, String str2) {
            XmlObject downloadDocument;
            SchemaDocument.Schema findMatchByDigest;
            String relativize;
            SchemaDocument.Schema schema;
            SchemaDocument.Schema schema2;
            SchemaDocument.Schema schema3;
            if (str2 == null) {
                return null;
            }
            StscState stscState = StscState.get();
            URI parseURI = StscImporter.parseURI(StscImporter.baseURLForDoc(xmlObject));
            if (parseURI != null) {
                try {
                    str2 = StscImporter.resolve(parseURI, str2).toString();
                } catch (URISyntaxException e) {
                    stscState.error(new StringBuffer().append("Could not find resource - invalid location URL: ").append(e.getMessage()).toString(), 56, xmlObject);
                    return null;
                }
            }
            if (stscState.isFileProcessed(str2)) {
                return null;
            }
            if (str2 != null && str != null && (schema3 = (SchemaDocument.Schema) this.schemaByNsLocPair.get(new NsLocPair(str, str2))) != null) {
                return schema3;
            }
            if (str != null && !str.equals("")) {
                if (!stscState.shouldDownloadURI(str2) && (schema2 = (SchemaDocument.Schema) this.schemaByNsLocPair.get(new NsLocPair(str, null))) != null) {
                    return schema2;
                }
                if (stscState.linkerDefinesNamespace(str)) {
                    return null;
                }
            }
            if (str2 != null && (schema = (SchemaDocument.Schema) this.schemaByNsLocPair.get(new NsLocPair(null, str2))) != null) {
                return schema;
            }
            if (str2 == null) {
                stscState.error("Could not find resource - no valid location URL.", 56, xmlObject);
                return null;
            }
            if (previouslyFailedToDownload(str2)) {
                return null;
            }
            if (!stscState.shouldDownloadURI(str2)) {
                stscState.error(new StringBuffer().append("Could not load resource \"").append(str2).append("\" (network downloads disabled).").toString(), 56, xmlObject);
                addFailedDownload(str2);
                return null;
            }
            try {
                downloadDocument = downloadDocument(stscState.getS4SLoader(), str, str2);
                findMatchByDigest = findMatchByDigest(downloadDocument);
                relativize = stscState.relativize(str2);
            } catch (MalformedURLException unused) {
                stscState.error(new StringBuffer().append("URL \"").append(str2).append("\" is not well-formed").toString(), 56, xmlObject);
            } catch (IOException e2) {
                stscState.error(e2.toString(), 56, xmlObject);
            } catch (XmlException e3) {
                stscState.error(new StringBuffer().append("Problem parsing referenced XML resource - ").append(e3.getMessage()).toString(), 56, xmlObject);
            }
            if (findMatchByDigest != null) {
                String relativize2 = stscState.relativize(findMatchByDigest.documentProperties().getSourceName());
                if (relativize2 != null) {
                    stscState.info(new StringBuffer().append(relativize).append(" is the same as ").append(relativize2).append(" (ignoring the duplicate file)").toString());
                } else {
                    stscState.info(new StringBuffer().append(relativize).append(" is the same as another schema").toString());
                }
            } else {
                XmlOptions xmlOptions = new XmlOptions();
                xmlOptions.setErrorListener(stscState.getErrorListener());
                if ((downloadDocument instanceof SchemaDocument) && downloadDocument.validate(xmlOptions)) {
                    findMatchByDigest = ((SchemaDocument) downloadDocument).getSchema();
                    stscState.info(new StringBuffer().append("Loading referenced file ").append(relativize).toString());
                }
                stscState.error("Referenced document is not a valid schema", 56, xmlObject);
                addFailedDownload(str2);
                return null;
            }
            addSuccessfulDownload(new NsLocPair(emptyStringIfNull(findMatchByDigest.getTargetNamespace()), str2), findMatchByDigest);
            return findMatchByDigest;
        }

        static XmlObject downloadDocument(SchemaTypeLoader schemaTypeLoader, String str, String str2) throws MalformedURLException, IOException, XmlException {
            StscState stscState = StscState.get();
            EntityResolver entityResolver = stscState.getEntityResolver();
            if (entityResolver != null) {
                try {
                    InputSource resolveEntity = entityResolver.resolveEntity(str, str2);
                    if (resolveEntity != null) {
                        stscState.addSourceUri(str2, null);
                        Reader characterStream = resolveEntity.getCharacterStream();
                        if (characterStream != null) {
                            Reader copySchemaSource = copySchemaSource(str2, characterStream, stscState);
                            XmlOptions xmlOptions = new XmlOptions();
                            xmlOptions.setLoadLineNumbers();
                            xmlOptions.setDocumentSourceName(str2);
                            return schemaTypeLoader.parse(copySchemaSource, (SchemaType) null, xmlOptions);
                        }
                        InputStream byteStream = resolveEntity.getByteStream();
                        if (byteStream != null) {
                            InputStream copySchemaSource2 = copySchemaSource(str2, byteStream, stscState);
                            String encoding = resolveEntity.getEncoding();
                            XmlOptions xmlOptions2 = new XmlOptions();
                            xmlOptions2.setLoadLineNumbers();
                            xmlOptions2.setLoadMessageDigest();
                            xmlOptions2.setDocumentSourceName(str2);
                            if (encoding != null) {
                                xmlOptions2.setCharacterEncoding(encoding);
                            }
                            return schemaTypeLoader.parse(copySchemaSource2, (SchemaType) null, xmlOptions2);
                        }
                        String systemId = resolveEntity.getSystemId();
                        if (systemId == null) {
                            throw new IOException(new StringBuffer().append("EntityResolver unable to resolve ").append(str2).append(" (for namespace ").append(str).append(")").toString());
                        }
                        copySchemaSource(str2, stscState, false);
                        XmlOptions xmlOptions3 = new XmlOptions();
                        xmlOptions3.setLoadLineNumbers();
                        xmlOptions3.setLoadMessageDigest();
                        xmlOptions3.setDocumentSourceName(str2);
                        return schemaTypeLoader.parse(new URL(systemId), (SchemaType) null, xmlOptions3);
                    }
                } catch (SAXException e) {
                    throw new XmlException(e);
                }
            }
            stscState.addSourceUri(str2, null);
            copySchemaSource(str2, stscState, false);
            XmlOptions xmlOptions4 = new XmlOptions();
            xmlOptions4.setLoadLineNumbers();
            xmlOptions4.setLoadMessageDigest();
            return schemaTypeLoader.parse(new URL(str2), (SchemaType) null, xmlOptions4);
        }

        private void addSuccessfulDownload(NsLocPair nsLocPair, SchemaDocument.Schema schema) {
            byte[] messageDigest = schema.documentProperties().getMessageDigest();
            if (messageDigest == null) {
                StscState.get().addSchemaDigest(null);
            } else {
                if (!this.schemaByDigestKey.containsKey(new DigestKey(messageDigest))) {
                    this.schemaByDigestKey.put(new DigestKey(messageDigest), schema);
                    StscState.get().addSchemaDigest(messageDigest);
                }
            }
            this.schemaByNsLocPair.put(nsLocPair, schema);
            NsLocPair nsLocPair2 = new NsLocPair(nsLocPair.getNamespaceURI(), null);
            if (!this.schemaByNsLocPair.containsKey(nsLocPair2)) {
                this.schemaByNsLocPair.put(nsLocPair2, schema);
            }
            NsLocPair nsLocPair3 = new NsLocPair(null, nsLocPair.getLocationURL());
            if (this.schemaByNsLocPair.containsKey(nsLocPair3)) {
                return;
            }
            this.schemaByNsLocPair.put(nsLocPair3, schema);
        }

        private SchemaDocument.Schema findMatchByDigest(XmlObject xmlObject) {
            byte[] messageDigest = xmlObject.documentProperties().getMessageDigest();
            if (messageDigest == null) {
                return null;
            }
            return (SchemaDocument.Schema) this.schemaByDigestKey.get(new DigestKey(messageDigest));
        }

        private void addFailedDownload(String str) {
            this.failedDownloads.add(str);
        }

        private boolean previouslyFailedToDownload(String str) {
            return this.failedDownloads.contains(str);
        }

        private static boolean nullableStringsMatch(String str, String str2) {
            if (str == null && str2 == null) {
                return true;
            }
            if (str == null || str2 == null) {
                return false;
            }
            return str.equals(str2);
        }

        private SchemaToProcess addScanNeeded(SchemaToProcess schemaToProcess) {
            if (!this.scannedAlready.containsKey(schemaToProcess)) {
                this.scannedAlready.put(schemaToProcess, schemaToProcess);
                this.scanNeeded.add(schemaToProcess);
                return schemaToProcess;
            }
            return (SchemaToProcess) this.scannedAlready.get(schemaToProcess);
        }

        private void addEmptyNamespaceSchema(SchemaDocument.Schema schema) {
            this.emptyNamespaceSchemas.add(schema);
        }

        private void usedEmptyNamespaceSchema(SchemaDocument.Schema schema) {
            this.emptyNamespaceSchemas.remove(schema);
        }

        private boolean fetchRemainingEmptyNamespaceSchemas() {
            if (this.emptyNamespaceSchemas.isEmpty()) {
                return false;
            }
            Iterator it = this.emptyNamespaceSchemas.iterator();
            while (it.hasNext()) {
                addScanNeeded(new SchemaToProcess((SchemaDocument.Schema) it.next(), null));
            }
            this.emptyNamespaceSchemas.clear();
            return true;
        }

        private boolean hasNextToScan() {
            return !this.scanNeeded.isEmpty();
        }

        private SchemaToProcess nextToScan() {
            return (SchemaToProcess) this.scanNeeded.removeFirst();
        }

        public DownloadTable(SchemaDocument.Schema[] schemaArr) {
            for (int i = 0; i < schemaArr.length; i++) {
                String targetNamespace = schemaArr[i].getTargetNamespace();
                addSuccessfulDownload(new NsLocPair(targetNamespace, StscImporter.baseURLForDoc(schemaArr[i])), schemaArr[i]);
                if (targetNamespace != null) {
                    addScanNeeded(new SchemaToProcess(schemaArr[i], null));
                } else {
                    addEmptyNamespaceSchema(schemaArr[i]);
                }
            }
        }

        public SchemaToProcess[] resolveImportsAndIncludes(boolean z) {
            StscState stscState = StscState.get();
            ArrayList arrayList = new ArrayList();
            boolean z2 = false;
            while (true) {
                if (hasNextToScan()) {
                    SchemaToProcess nextToScan = nextToScan();
                    String sourceName = nextToScan.getSourceName();
                    String str = null;
                    stscState.addSourceUri(sourceName, null);
                    arrayList.add(nextToScan);
                    copySchemaSource(sourceName, stscState, z);
                    ImportDocument.Import[] importArray = nextToScan.getSchema().getImportArray();
                    for (int i = 0; i < importArray.length; i++) {
                        SchemaDocument.Schema downloadSchema = downloadSchema(importArray[i], emptyStringIfNull(importArray[i].getNamespace()), importArray[i].getSchemaLocation());
                        if (downloadSchema != null) {
                            if (!nullableStringsMatch(downloadSchema.getTargetNamespace(), importArray[i].getNamespace())) {
                                StscState.get().error(new StringBuffer().append("Imported schema has a target namespace \"").append(downloadSchema.getTargetNamespace()).append("\" that does not match the specified \"").append(importArray[i].getNamespace()).append("\"").toString(), 4, importArray[i]);
                            } else {
                                addScanNeeded(new SchemaToProcess(downloadSchema, null));
                            }
                        }
                    }
                    IncludeDocument.Include[] includeArray = nextToScan.getSchema().getIncludeArray();
                    String chameleonNamespace = nextToScan.getChameleonNamespace();
                    if (chameleonNamespace == null) {
                        chameleonNamespace = emptyStringIfNull(nextToScan.getSchema().getTargetNamespace());
                    }
                    int i2 = 0;
                    while (i2 < includeArray.length) {
                        SchemaDocument.Schema downloadSchema2 = downloadSchema(includeArray[i2], str, includeArray[i2].getSchemaLocation());
                        if (downloadSchema2 != null) {
                            if (emptyStringIfNull(downloadSchema2.getTargetNamespace()).equals(chameleonNamespace)) {
                                nextToScan.addInclude(addScanNeeded(new SchemaToProcess(downloadSchema2, str)));
                            } else if (downloadSchema2.getTargetNamespace() == null) {
                                nextToScan.addInclude(addScanNeeded(new SchemaToProcess(downloadSchema2, chameleonNamespace)));
                                usedEmptyNamespaceSchema(downloadSchema2);
                            } else {
                                StscState.get().error(new StringBuffer().append("Included schema has a target namespace \"").append(downloadSchema2.getTargetNamespace()).append("\" that does not match the source namespace \"").append(chameleonNamespace).append("\"").toString(), 4, includeArray[i2]);
                            }
                        }
                        i2++;
                        str = null;
                    }
                    RedefineDocument.Redefine[] redefineArray = nextToScan.getSchema().getRedefineArray();
                    String chameleonNamespace2 = nextToScan.getChameleonNamespace();
                    if (chameleonNamespace2 == null) {
                        chameleonNamespace2 = emptyStringIfNull(nextToScan.getSchema().getTargetNamespace());
                    }
                    for (int i3 = 0; i3 < redefineArray.length; i3++) {
                        SchemaDocument.Schema downloadSchema3 = downloadSchema(redefineArray[i3], null, redefineArray[i3].getSchemaLocation());
                        if (downloadSchema3 != null) {
                            if (emptyStringIfNull(downloadSchema3.getTargetNamespace()).equals(chameleonNamespace2)) {
                                nextToScan.addRedefine(addScanNeeded(new SchemaToProcess(downloadSchema3, null)), redefineArray[i3]);
                            } else if (downloadSchema3.getTargetNamespace() == null) {
                                nextToScan.addRedefine(addScanNeeded(new SchemaToProcess(downloadSchema3, chameleonNamespace2)), redefineArray[i3]);
                                usedEmptyNamespaceSchema(downloadSchema3);
                            } else {
                                StscState.get().error(new StringBuffer().append("Redefined schema has a target namespace \"").append(downloadSchema3.getTargetNamespace()).append("\" that does not match the source namespace \"").append(chameleonNamespace2).append("\"").toString(), 4, redefineArray[i3]);
                            }
                            z2 = true;
                        }
                    }
                } else if (!fetchRemainingEmptyNamespaceSchemas()) {
                    break;
                }
            }
            if (z2) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    ((SchemaToProcess) arrayList.get(i4)).buildIndirectReferences();
                }
            }
            return (SchemaToProcess[]) arrayList.toArray(new SchemaToProcess[arrayList.size()]);
        }

        private static Reader copySchemaSource(String str, Reader reader, StscState stscState) {
            if (stscState.getSchemasDir() == null) {
                return reader;
            }
            File file = new File(stscState.getSchemasDir(), stscState.sourceNameForUri(str));
            if (file.exists()) {
                return reader;
            }
            try {
                IOUtil.createDir(new File(file.getParent()), null);
                CharArrayReader copy = copy(reader);
                IOUtil.copyCompletely(copy, new OutputStreamWriter(new FileOutputStream(file), new XmlEncodingSniffer(copy, (String) null).getXmlEncoding()));
                copy.reset();
                return copy;
            } catch (IOException e) {
                System.err.println(new StringBuffer().append("IO Error ").append(e).toString());
                return reader;
            }
        }

        private static InputStream copySchemaSource(String str, InputStream inputStream, StscState stscState) {
            if (stscState.getSchemasDir() == null) {
                return inputStream;
            }
            File file = new File(stscState.getSchemasDir(), stscState.sourceNameForUri(str));
            if (file.exists()) {
                return inputStream;
            }
            try {
                IOUtil.createDir(new File(file.getParent()), null);
                ByteArrayInputStream copy = copy(inputStream);
                IOUtil.copyCompletely(copy, new FileOutputStream(file));
                copy.reset();
                return copy;
            } catch (IOException e) {
                System.err.println(new StringBuffer().append("IO Error ").append(e).toString());
                return inputStream;
            }
        }

        private static void copySchemaSource(String str, StscState stscState, boolean z) {
            if (stscState.getSchemasDir() != null) {
                File file = new File(stscState.getSchemasDir(), stscState.sourceNameForUri(str));
                if (z || !file.exists()) {
                    try {
                        InputStream inputStream = null;
                        IOUtil.createDir(new File(file.getParent()), null);
                        try {
                            inputStream = new URL(str).openStream();
                        } catch (FileNotFoundException e) {
                            if (z && file.exists()) {
                                file.delete();
                            } else {
                                throw e;
                            }
                        }
                        if (inputStream != null) {
                            IOUtil.copyCompletely(inputStream, new FileOutputStream(file));
                        }
                    } catch (IOException e2) {
                        System.err.println(new StringBuffer().append("IO Error ").append(e2).toString());
                    }
                }
            }
        }

        private static ByteArrayInputStream copy(InputStream inputStream) throws IOException {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = inputStream.read(bArr, 0, 1024);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                }
            }
        }

        private static CharArrayReader copy(Reader reader) throws IOException {
            char[] cArr = new char[1024];
            CharArrayWriter charArrayWriter = new CharArrayWriter();
            while (true) {
                int read = reader.read(cArr, 0, 1024);
                if (read > 0) {
                    charArrayWriter.write(cArr, 0, read);
                } else {
                    return new CharArrayReader(charArrayWriter.toCharArray());
                }
            }
        }
    }
}
