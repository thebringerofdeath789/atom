package org.apache.xmlbeans.impl.tool;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.IOUtil;
import org.apache.xmlbeans.impl.tool.SchemaImportResolver;
import org.apache.xmlbeans.impl.util.HexBin;
import org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry;
import org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemasDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;

/* loaded from: classes5.dex */
public abstract class BaseSchemaResourceManager extends SchemaImportResolver {
    private static final String USER_AGENT = new StringBuffer().append("XMLBeans/").append(XmlBeans.getVersion()).append(" (").append(XmlBeans.getTitle()).append(")").toString();
    private String _defaultCopyDirectory;
    private DownloadedSchemasDocument _importsDoc;
    private Map _resourceForFilename = new HashMap();
    private Map _resourceForURL = new HashMap();
    private Map _resourceForNamespace = new HashMap();
    private Map _resourceForDigest = new HashMap();
    private Map _resourceForCacheEntry = new HashMap();
    private Set _redownloadSet = new HashSet();

    protected abstract void deleteFile(String str);

    protected abstract boolean fileExists(String str);

    protected abstract String[] getAllXSDFilenames();

    protected String getDefaultSchemaDir() {
        return "./schema";
    }

    protected String getIndexFilename() {
        return "./xsdownload.xml";
    }

    protected abstract InputStream inputStreamForFile(String str) throws IOException;

    protected abstract void warning(String str);

    protected abstract void writeInputStreamToFile(InputStream inputStream, String str) throws IOException;

    protected BaseSchemaResourceManager() {
    }

    protected final void init() {
        if (fileExists(getIndexFilename())) {
            try {
                this._importsDoc = DownloadedSchemasDocument.Factory.parse(inputStreamForFile(getIndexFilename()));
            } catch (IOException unused) {
                this._importsDoc = null;
            } catch (Exception e) {
                throw ((IllegalStateException) new IllegalStateException("Problem reading xsdownload.xml: please fix or delete this file").initCause(e));
            }
        }
        if (this._importsDoc == null) {
            try {
                this._importsDoc = DownloadedSchemasDocument.Factory.parse(new StringBuffer().append("<dls:downloaded-schemas xmlns:dls='http://www.bea.com/2003/01/xmlbean/xsdownload' defaultDirectory='").append(getDefaultSchemaDir()).append("'/>").toString());
            } catch (Exception e2) {
                throw ((IllegalStateException) new IllegalStateException().initCause(e2));
            }
        }
        String defaultDirectory = this._importsDoc.getDownloadedSchemas().getDefaultDirectory();
        if (defaultDirectory == null) {
            defaultDirectory = getDefaultSchemaDir();
        }
        this._defaultCopyDirectory = defaultDirectory;
        for (DownloadedSchemaEntry downloadedSchemaEntry : this._importsDoc.getDownloadedSchemas().getEntryArray()) {
            updateResource(downloadedSchemaEntry);
        }
    }

    public final void writeCache() throws IOException {
        writeInputStreamToFile(this._importsDoc.newInputStream(new XmlOptions().setSavePrettyPrint()), getIndexFilename());
    }

    public final void processAll(boolean z, boolean z2, boolean z3) {
        if (z2) {
            this._redownloadSet = new HashSet();
        } else {
            this._redownloadSet = null;
        }
        String[] allXSDFilenames = getAllXSDFilenames();
        if (z) {
            syncCacheWithLocalXsdFiles(allXSDFilenames, false);
        }
        SchemaResource[] schemaResourceArr = (SchemaResource[]) this._resourceForFilename.values().toArray(new SchemaResource[0]);
        if (z2) {
            redownloadEntries(schemaResourceArr);
        }
        if (z3) {
            resolveImports(schemaResourceArr);
        }
        this._redownloadSet = null;
    }

    public final void process(String[] strArr, String[] strArr2, boolean z, boolean z2, boolean z3) {
        if (z2) {
            this._redownloadSet = new HashSet();
        } else {
            this._redownloadSet = null;
        }
        if (strArr2.length > 0) {
            syncCacheWithLocalXsdFiles(strArr2, true);
        } else if (z) {
            syncCacheWithLocalXsdFiles(getAllXSDFilenames(), false);
        }
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            SchemaResource schemaResource = (SchemaResource) lookupResource(null, str);
            if (schemaResource != null) {
                hashSet.add(schemaResource);
            }
        }
        for (int i = 0; i < strArr2.length; i++) {
            SchemaResource schemaResource2 = (SchemaResource) this._resourceForFilename.get(strArr2);
            if (schemaResource2 != null) {
                hashSet.add(schemaResource2);
            }
        }
        SchemaResource[] schemaResourceArr = (SchemaResource[]) hashSet.toArray(new SchemaResource[0]);
        if (z2) {
            redownloadEntries(schemaResourceArr);
        }
        if (z3) {
            resolveImports(schemaResourceArr);
        }
        this._redownloadSet = null;
    }

    public final void syncCacheWithLocalXsdFiles(String[] strArr, boolean z) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (String str : strArr) {
            SchemaResource schemaResource = (SchemaResource) this._resourceForFilename.get(str);
            if (schemaResource != null) {
                if (fileExists(str)) {
                    hashSet.add(schemaResource);
                } else {
                    hashSet2.add(schemaResource);
                }
            } else {
                String str2 = null;
                try {
                    str2 = shaDigestForFile(str);
                    SchemaResource schemaResource2 = (SchemaResource) this._resourceForDigest.get(str2);
                    if (schemaResource2 != null) {
                        String filename = schemaResource2.getFilename();
                        if (!fileExists(filename)) {
                            warning(new StringBuffer().append("File ").append(str).append(" is a rename of ").append(filename).toString());
                            schemaResource2.setFilename(str);
                            hashSet.add(schemaResource2);
                            if (this._resourceForFilename.get(filename) == schemaResource2) {
                                this._resourceForFilename.remove(filename);
                            }
                            if (this._resourceForFilename.containsKey(str)) {
                                this._resourceForFilename.put(str, schemaResource2);
                            }
                        }
                    }
                } catch (IOException unused) {
                }
                DownloadedSchemaEntry addNewEntry = addNewEntry();
                addNewEntry.setFilename(str);
                warning(new StringBuffer().append("Caching information on new local file ").append(str).toString());
                if (str2 != null) {
                    addNewEntry.setSha1(str2);
                }
                hashSet.add(updateResource(addNewEntry));
            }
        }
        if (z) {
            deleteResourcesInSet(hashSet2, true);
        } else {
            deleteResourcesInSet(hashSet, false);
        }
    }

    private void redownloadEntries(SchemaResource[] schemaResourceArr) {
        for (SchemaResource schemaResource : schemaResourceArr) {
            redownloadResource(schemaResource);
        }
    }

    private void deleteResourcesInSet(Set set, boolean z) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(((SchemaResource) it.next())._cacheEntry);
        }
        DownloadedSchemasDocument.DownloadedSchemas downloadedSchemas = this._importsDoc.getDownloadedSchemas();
        int i = 0;
        while (i < downloadedSchemas.sizeOfEntryArray()) {
            DownloadedSchemaEntry entryArray = downloadedSchemas.getEntryArray(i);
            if (hashSet.contains(entryArray) == z) {
                SchemaResource schemaResource = (SchemaResource) this._resourceForCacheEntry.get(entryArray);
                warning(new StringBuffer().append("Removing obsolete cache entry for ").append(schemaResource.getFilename()).toString());
                if (schemaResource != null) {
                    this._resourceForCacheEntry.remove(entryArray);
                    if (schemaResource == this._resourceForFilename.get(schemaResource.getFilename())) {
                        this._resourceForFilename.remove(schemaResource.getFilename());
                    }
                    if (schemaResource == this._resourceForDigest.get(schemaResource.getSha1())) {
                        this._resourceForDigest.remove(schemaResource.getSha1());
                    }
                    if (schemaResource == this._resourceForNamespace.get(schemaResource.getNamespace())) {
                        this._resourceForNamespace.remove(schemaResource.getNamespace());
                    }
                    String[] schemaLocationArray = schemaResource.getSchemaLocationArray();
                    for (int i2 = 0; i2 < schemaLocationArray.length; i2++) {
                        if (schemaResource == this._resourceForURL.get(schemaLocationArray[i2])) {
                            this._resourceForURL.remove(schemaLocationArray[i2]);
                        }
                    }
                }
                downloadedSchemas.removeEntry(i);
                i--;
            }
            i++;
        }
    }

    private SchemaResource updateResource(DownloadedSchemaEntry downloadedSchemaEntry) {
        String filename = downloadedSchemaEntry.getFilename();
        if (filename == null) {
            return null;
        }
        SchemaResource schemaResource = new SchemaResource(downloadedSchemaEntry);
        this._resourceForCacheEntry.put(downloadedSchemaEntry, schemaResource);
        if (!this._resourceForFilename.containsKey(filename)) {
            this._resourceForFilename.put(filename, schemaResource);
        }
        String sha1 = schemaResource.getSha1();
        if (sha1 != null && !this._resourceForDigest.containsKey(sha1)) {
            this._resourceForDigest.put(sha1, schemaResource);
        }
        String namespace = schemaResource.getNamespace();
        if (namespace != null && !this._resourceForNamespace.containsKey(namespace)) {
            this._resourceForNamespace.put(namespace, schemaResource);
        }
        String[] schemaLocationArray = schemaResource.getSchemaLocationArray();
        for (int i = 0; i < schemaLocationArray.length; i++) {
            if (!this._resourceForURL.containsKey(schemaLocationArray[i])) {
                this._resourceForURL.put(schemaLocationArray[i], schemaResource);
            }
        }
        return schemaResource;
    }

    private static DigestInputStream digestInputStream(InputStream inputStream) {
        try {
            return new DigestInputStream(inputStream, MessageDigest.getInstance("SHA"));
        } catch (NoSuchAlgorithmException e) {
            throw ((IllegalStateException) new IllegalStateException().initCause(e));
        }
    }

    private DownloadedSchemaEntry addNewEntry() {
        return this._importsDoc.getDownloadedSchemas().addNewEntry();
    }

    private class SchemaResource implements SchemaImportResolver.SchemaResource {
        DownloadedSchemaEntry _cacheEntry;

        SchemaResource(DownloadedSchemaEntry downloadedSchemaEntry) {
            this._cacheEntry = downloadedSchemaEntry;
        }

        public void setFilename(String str) {
            this._cacheEntry.setFilename(str);
        }

        public String getFilename() {
            return this._cacheEntry.getFilename();
        }

        @Override // org.apache.xmlbeans.impl.tool.SchemaImportResolver.SchemaResource
        public SchemaDocument.Schema getSchema() {
            if (!BaseSchemaResourceManager.this.fileExists(getFilename())) {
                BaseSchemaResourceManager.this.redownloadResource(this);
            }
            try {
                return SchemaDocument.Factory.parse(BaseSchemaResourceManager.this.inputStreamForFile(getFilename())).getSchema();
            } catch (Exception unused) {
                return null;
            }
        }

        public String getSha1() {
            return this._cacheEntry.getSha1();
        }

        @Override // org.apache.xmlbeans.impl.tool.SchemaImportResolver.SchemaResource
        public String getNamespace() {
            return this._cacheEntry.getNamespace();
        }

        public void setNamespace(String str) {
            this._cacheEntry.setNamespace(str);
        }

        @Override // org.apache.xmlbeans.impl.tool.SchemaImportResolver.SchemaResource
        public String getSchemaLocation() {
            if (this._cacheEntry.sizeOfSchemaLocationArray() > 0) {
                return this._cacheEntry.getSchemaLocationArray(0);
            }
            return null;
        }

        public String[] getSchemaLocationArray() {
            return this._cacheEntry.getSchemaLocationArray();
        }

        public int hashCode() {
            return getFilename().hashCode();
        }

        public boolean equals(Object obj) {
            return this == obj || getFilename().equals(((SchemaResource) obj).getFilename());
        }

        public void addSchemaLocation(String str) {
            this._cacheEntry.addSchemaLocation(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.tool.SchemaImportResolver
    public SchemaImportResolver.SchemaResource lookupResource(String str, String str2) {
        SchemaResource fetchFromCache = fetchFromCache(str, str2);
        if (fetchFromCache != null) {
            if (this._redownloadSet != null) {
                redownloadResource(fetchFromCache);
            }
            return fetchFromCache;
        }
        if (str2 == null) {
            warning(new StringBuffer().append("No cached schema for namespace '").append(str).append("', and no url specified").toString());
            return null;
        }
        SchemaResource copyOrIdentifyDuplicateURL = copyOrIdentifyDuplicateURL(str2, str);
        Set set = this._redownloadSet;
        if (set != null) {
            set.add(copyOrIdentifyDuplicateURL);
        }
        return copyOrIdentifyDuplicateURL;
    }

    private SchemaResource fetchFromCache(String str, String str2) {
        SchemaResource schemaResource;
        SchemaResource schemaResource2;
        if (str2 != null && (schemaResource2 = (SchemaResource) this._resourceForURL.get(str2)) != null) {
            return schemaResource2;
        }
        if (str == null || (schemaResource = (SchemaResource) this._resourceForNamespace.get(str)) == null) {
            return null;
        }
        return schemaResource;
    }

    private String uniqueFilenameForURI(String str) throws IOException, URISyntaxException {
        String rawPath = new URI(str).getRawPath();
        int lastIndexOf = rawPath.lastIndexOf(47);
        int i = 1;
        if (lastIndexOf >= 0) {
            rawPath = rawPath.substring(lastIndexOf + 1);
        }
        if (rawPath.endsWith(".xsd")) {
            rawPath = rawPath.substring(0, rawPath.length() - 4);
        }
        if (rawPath.length() == 0) {
            rawPath = "schema";
        }
        String str2 = rawPath;
        while (i < 1000) {
            String stringBuffer = new StringBuffer().append(this._defaultCopyDirectory).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(str2).append(".xsd").toString();
            if (!fileExists(stringBuffer)) {
                return stringBuffer;
            }
            i++;
            str2 = new StringBuffer().append(rawPath).append(i).toString();
        }
        throw new IOException(new StringBuffer().append("Problem with filename ").append(rawPath).append(".xsd").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void redownloadResource(SchemaResource schemaResource) {
        Set set = this._redownloadSet;
        if (set != null) {
            if (set.contains(schemaResource)) {
                return;
            } else {
                this._redownloadSet.add(schemaResource);
            }
        }
        String filename = schemaResource.getFilename();
        String schemaLocation = schemaResource.getSchemaLocation();
        if (schemaLocation == null || filename == null) {
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            URLConnection openConnection = new URL(schemaLocation).openConnection();
            openConnection.addRequestProperty("User-Agent", USER_AGENT);
            openConnection.addRequestProperty("Accept", "application/xml, text/xml, */*");
            DigestInputStream digestInputStream = digestInputStream(openConnection.getInputStream());
            IOUtil.copyCompletely(digestInputStream, byteArrayOutputStream);
            if (HexBin.bytesToString(digestInputStream.getMessageDigest().digest()).equals(schemaResource.getSha1()) && fileExists(filename)) {
                warning(new StringBuffer().append("Resource ").append(filename).append(" is unchanged from ").append(schemaLocation).append(".").toString());
                return;
            }
            try {
                writeInputStreamToFile(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), filename);
                warning(new StringBuffer().append("Refreshed ").append(filename).append(" from ").append(schemaLocation).toString());
            } catch (IOException e) {
                warning(new StringBuffer().append("Could not write to file ").append(filename).append(" for ").append(schemaLocation).append(":").append(e.getMessage()).toString());
            }
        } catch (Exception e2) {
            warning(new StringBuffer().append("Could not copy remote resource ").append(schemaLocation).append(":").append(e2.getMessage()).toString());
        }
    }

    private SchemaResource copyOrIdentifyDuplicateURL(String str, String str2) {
        try {
            String uniqueFilenameForURI = uniqueFilenameForURI(str);
            try {
                DigestInputStream digestInputStream = digestInputStream(new URL(str).openStream());
                writeInputStreamToFile(digestInputStream, uniqueFilenameForURI);
                String bytesToString = HexBin.bytesToString(digestInputStream.getMessageDigest().digest());
                SchemaResource schemaResource = (SchemaResource) this._resourceForDigest.get(bytesToString);
                if (schemaResource != null) {
                    deleteFile(uniqueFilenameForURI);
                    schemaResource.addSchemaLocation(str);
                    if (!this._resourceForURL.containsKey(str)) {
                        this._resourceForURL.put(str, schemaResource);
                    }
                    return schemaResource;
                }
                warning(new StringBuffer().append("Downloaded ").append(str).append(" to ").append(uniqueFilenameForURI).toString());
                DownloadedSchemaEntry addNewEntry = addNewEntry();
                addNewEntry.setFilename(uniqueFilenameForURI);
                addNewEntry.setSha1(bytesToString);
                if (str2 != null) {
                    addNewEntry.setNamespace(str2);
                }
                addNewEntry.addSchemaLocation(str);
                return updateResource(addNewEntry);
            } catch (Exception e) {
                warning(new StringBuffer().append("Could not copy remote resource ").append(str).append(":").append(e.getMessage()).toString());
                return null;
            }
        } catch (IOException e2) {
            warning(new StringBuffer().append("Could not create local file for ").append(str).append(":").append(e2.getMessage()).toString());
            return null;
        } catch (URISyntaxException e3) {
            warning(new StringBuffer().append("Invalid URI '").append(str).append("':").append(e3.getMessage()).toString());
            return null;
        }
    }

    @Override // org.apache.xmlbeans.impl.tool.SchemaImportResolver
    public void reportActualNamespace(SchemaImportResolver.SchemaResource schemaResource, String str) {
        SchemaResource schemaResource2 = (SchemaResource) schemaResource;
        String namespace = schemaResource2.getNamespace();
        if (namespace != null && this._resourceForNamespace.get(namespace) == schemaResource2) {
            this._resourceForNamespace.remove(namespace);
        }
        if (!this._resourceForNamespace.containsKey(str)) {
            this._resourceForNamespace.put(str, schemaResource2);
        }
        schemaResource2.setNamespace(str);
    }

    private String shaDigestForFile(String str) throws IOException {
        DigestInputStream digestInputStream = digestInputStream(inputStreamForFile(str));
        byte[] bArr = new byte[4096];
        for (int i = 1; i > 0; i = digestInputStream.read(bArr)) {
        }
        digestInputStream.close();
        return HexBin.bytesToString(digestInputStream.getMessageDigest().digest());
    }
}
