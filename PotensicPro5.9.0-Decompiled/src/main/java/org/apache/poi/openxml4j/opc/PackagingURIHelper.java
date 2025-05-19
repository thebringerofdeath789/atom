package org.apache.poi.openxml4j.opc;

import com.opencsv.ICSVParser;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* loaded from: classes5.dex */
public final class PackagingURIHelper {
    public static final PackagePartName CORE_PROPERTIES_PART_NAME;
    public static final URI CORE_PROPERTIES_URI;
    public static final PackagePartName PACKAGE_RELATIONSHIPS_ROOT_PART_NAME;
    public static final URI PACKAGE_RELATIONSHIPS_ROOT_URI;
    public static final PackagePartName PACKAGE_ROOT_PART_NAME;
    public static final URI PACKAGE_ROOT_URI;
    private static final char[] hexDigits;
    private static final Pattern missingAuthPattern;
    private static URI packageRootUri;
    private static final POILogger _logger = POILogFactory.getLogger((Class<?>) PackagingURIHelper.class);
    public static final String RELATIONSHIP_PART_SEGMENT_NAME = "_rels";
    public static final String RELATIONSHIP_PART_EXTENSION_NAME = ".rels";
    public static final char FORWARD_SLASH_CHAR = '/';
    public static final String FORWARD_SLASH_STRING = InternalZipConstants.ZIP_FILE_SEPARATOR;
    public static final String PACKAGE_PROPERTIES_SEGMENT_NAME = "docProps";
    public static final String PACKAGE_CORE_PROPERTIES_NAME = "core.xml";

    static {
        URI uri;
        URI uri2;
        URI uri3;
        PackagePartName packagePartName;
        PackagePartName packagePartName2;
        PackagePartName packagePartName3 = null;
        try {
            uri = new URI(InternalZipConstants.ZIP_FILE_SEPARATOR);
            try {
                uri2 = new URI("/_rels/.rels");
            } catch (URISyntaxException unused) {
                uri2 = null;
            }
            try {
                packageRootUri = new URI(InternalZipConstants.ZIP_FILE_SEPARATOR);
                uri3 = new URI("/docProps/core.xml");
            } catch (URISyntaxException unused2) {
                uri3 = null;
                PACKAGE_ROOT_URI = uri;
                PACKAGE_RELATIONSHIPS_ROOT_URI = uri2;
                CORE_PROPERTIES_URI = uri3;
                packagePartName2 = createPartName(uri2);
                try {
                    packagePartName = createPartName(uri3);
                    packagePartName3 = new PackagePartName(uri, false);
                } catch (InvalidFormatException unused3) {
                    packagePartName = null;
                }
                PACKAGE_RELATIONSHIPS_ROOT_PART_NAME = packagePartName2;
                CORE_PROPERTIES_PART_NAME = packagePartName;
                PACKAGE_ROOT_PART_NAME = packagePartName3;
                missingAuthPattern = Pattern.compile("\\w+://");
                hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            }
        } catch (URISyntaxException unused4) {
            uri = null;
            uri2 = null;
        }
        PACKAGE_ROOT_URI = uri;
        PACKAGE_RELATIONSHIPS_ROOT_URI = uri2;
        CORE_PROPERTIES_URI = uri3;
        try {
            packagePartName2 = createPartName(uri2);
            packagePartName = createPartName(uri3);
            try {
                packagePartName3 = new PackagePartName(uri, false);
            } catch (InvalidFormatException unused5) {
            }
        } catch (InvalidFormatException unused6) {
            packagePartName = null;
            packagePartName2 = null;
        }
        PACKAGE_RELATIONSHIPS_ROOT_PART_NAME = packagePartName2;
        CORE_PROPERTIES_PART_NAME = packagePartName;
        PACKAGE_ROOT_PART_NAME = packagePartName3;
        missingAuthPattern = Pattern.compile("\\w+://");
        hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static URI getPackageRootUri() {
        return packageRootUri;
    }

    public static boolean isRelationshipPartURI(URI uri) {
        if (uri == null) {
            throw new IllegalArgumentException("partUri");
        }
        return uri.getPath().matches(".*" + RELATIONSHIP_PART_SEGMENT_NAME + ".*" + RELATIONSHIP_PART_EXTENSION_NAME + "$");
    }

    public static String getFilename(URI uri) {
        if (uri == null) {
            return "";
        }
        String path = uri.getPath();
        int length = path.length();
        int i = length;
        do {
            i--;
            if (i < 0) {
                return "";
            }
        } while (path.charAt(i) != FORWARD_SLASH_CHAR);
        return path.substring(i + 1, length);
    }

    public static String getFilenameWithoutExtension(URI uri) {
        String filename = getFilename(uri);
        int lastIndexOf = filename.lastIndexOf(".");
        return lastIndexOf == -1 ? filename : filename.substring(0, lastIndexOf);
    }

    public static URI getPath(URI uri) {
        if (uri != null) {
            String path = uri.getPath();
            int length = path.length();
            while (true) {
                length--;
                if (length < 0) {
                    break;
                }
                if (path.charAt(length) == FORWARD_SLASH_CHAR) {
                    try {
                        return new URI(path.substring(0, length));
                    } catch (URISyntaxException unused) {
                    }
                }
            }
        }
        return null;
    }

    public static URI combine(URI uri, URI uri2) {
        try {
            return new URI(combine(uri.getPath(), uri2.getPath()));
        } catch (URISyntaxException unused) {
            throw new IllegalArgumentException("Prefix and suffix can't be combine !");
        }
    }

    public static String combine(String str, String str2) {
        StringBuilder append = new StringBuilder().append("");
        char c = FORWARD_SLASH_CHAR;
        if (str.endsWith(append.append(c).toString()) || str2.startsWith("" + c)) {
            return ((str.endsWith(new StringBuilder().append("").append(c).toString()) || !str2.startsWith(new StringBuilder().append("").append(c).toString())) && (!str.endsWith(new StringBuilder().append("").append(c).toString()) || str2.startsWith(new StringBuilder().append("").append(c).toString()))) ? "" : str + str2;
        }
        return str + c + str2;
    }

    public static URI relativizeURI(URI uri, URI uri2, boolean z) {
        StringBuilder sb = new StringBuilder();
        String[] split = uri.getPath().split(InternalZipConstants.ZIP_FILE_SEPARATOR, -1);
        String[] split2 = uri2.getPath().split(InternalZipConstants.ZIP_FILE_SEPARATOR, -1);
        if (split.length == 0) {
            throw new IllegalArgumentException("Can't relativize an empty source URI !");
        }
        if (split2.length == 0) {
            throw new IllegalArgumentException("Can't relativize an empty target URI !");
        }
        if (uri.toString().equals(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            String path = uri2.getPath();
            if (!z || path.length() <= 0 || path.charAt(0) != '/') {
                return uri2;
            }
            try {
                return new URI(path.substring(1));
            } catch (Exception e) {
                _logger.log(5, (Throwable) e);
                return null;
            }
        }
        int i = 0;
        for (int i2 = 0; i2 < split.length && i2 < split2.length && split[i2].equals(split2[i2]); i2++) {
            i++;
        }
        if ((i == 0 || i == 1) && split[0].equals("") && split2[0].equals("")) {
            for (int i3 = 0; i3 < split.length - 2; i3++) {
                sb.append("../");
            }
            for (int i4 = 0; i4 < split2.length; i4++) {
                if (!split2[i4].equals("")) {
                    sb.append(split2[i4]);
                    if (i4 != split2.length - 1) {
                        sb.append(InternalZipConstants.ZIP_FILE_SEPARATOR);
                    }
                }
            }
            try {
                return new URI(sb.toString());
            } catch (Exception e2) {
                _logger.log(5, (Throwable) e2);
                return null;
            }
        }
        if (i == split.length && i == split2.length) {
            if (uri.equals(uri2)) {
                sb.append(split[split.length - 1]);
            } else {
                sb.append("");
            }
        } else {
            if (i == 1) {
                sb.append(InternalZipConstants.ZIP_FILE_SEPARATOR);
            } else {
                for (int i5 = i; i5 < split.length - 1; i5++) {
                    sb.append("../");
                }
            }
            while (i < split2.length) {
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) != '/') {
                    sb.append(InternalZipConstants.ZIP_FILE_SEPARATOR);
                }
                sb.append(split2[i]);
                i++;
            }
        }
        String rawFragment = uri2.getRawFragment();
        if (rawFragment != null) {
            sb.append("#").append(rawFragment);
        }
        try {
            return new URI(sb.toString());
        } catch (Exception e3) {
            _logger.log(5, (Throwable) e3);
            return null;
        }
    }

    public static URI relativizeURI(URI uri, URI uri2) {
        return relativizeURI(uri, uri2, false);
    }

    public static URI resolvePartUri(URI uri, URI uri2) {
        if (uri == null || uri.isAbsolute()) {
            throw new IllegalArgumentException("sourcePartUri invalid - " + uri);
        }
        if (uri2 == null || uri2.isAbsolute()) {
            throw new IllegalArgumentException("targetUri invalid - " + uri2);
        }
        return uri.resolve(uri2);
    }

    public static URI getURIFromPath(String str) {
        try {
            return toURI(str);
        } catch (URISyntaxException unused) {
            throw new IllegalArgumentException("path");
        }
    }

    public static URI getSourcePartUriFromRelationshipPartUri(URI uri) {
        if (uri == null) {
            throw new IllegalArgumentException("Must not be null");
        }
        if (!isRelationshipPartURI(uri)) {
            throw new IllegalArgumentException("Must be a relationship part");
        }
        if (uri.compareTo(PACKAGE_RELATIONSHIPS_ROOT_URI) == 0) {
            return PACKAGE_ROOT_URI;
        }
        String path = uri.getPath();
        String filenameWithoutExtension = getFilenameWithoutExtension(uri);
        return getURIFromPath(combine(path.substring(0, (path.length() - filenameWithoutExtension.length()) - RELATIONSHIP_PART_EXTENSION_NAME.length()).substring(0, (r0.length() - RELATIONSHIP_PART_SEGMENT_NAME.length()) - 1), filenameWithoutExtension));
    }

    public static PackagePartName createPartName(URI uri) throws InvalidFormatException {
        if (uri == null) {
            throw new IllegalArgumentException("partName");
        }
        return new PackagePartName(uri, true);
    }

    public static PackagePartName createPartName(String str) throws InvalidFormatException {
        try {
            return createPartName(toURI(str));
        } catch (URISyntaxException e) {
            throw new InvalidFormatException(e.getMessage());
        }
    }

    public static PackagePartName createPartName(String str, PackagePart packagePart) throws InvalidFormatException {
        try {
            return createPartName(resolvePartUri(packagePart.getPartName().getURI(), new URI(str)));
        } catch (URISyntaxException e) {
            throw new InvalidFormatException(e.getMessage());
        }
    }

    public static PackagePartName createPartName(URI uri, PackagePart packagePart) throws InvalidFormatException {
        return createPartName(resolvePartUri(packagePart.getPartName().getURI(), uri));
    }

    public static boolean isValidPartName(URI uri) {
        if (uri == null) {
            throw new IllegalArgumentException("partUri");
        }
        try {
            createPartName(uri);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String decodeURI(URI uri) {
        StringBuffer stringBuffer = new StringBuffer();
        String aSCIIString = uri.toASCIIString();
        int i = 0;
        while (i < aSCIIString.length()) {
            char charAt = aSCIIString.charAt(i);
            if (charAt == '%') {
                if (aSCIIString.length() - i < 2) {
                    throw new IllegalArgumentException("The uri " + aSCIIString + " contain invalid encoded character !");
                }
                stringBuffer.append((char) Integer.parseInt(aSCIIString.substring(i + 1, i + 3), 16));
                i += 2;
            } else {
                stringBuffer.append(charAt);
            }
            i++;
        }
        return stringBuffer.toString();
    }

    public static PackagePartName getRelationshipPartName(PackagePartName packagePartName) {
        if (packagePartName == null) {
            throw new IllegalArgumentException("partName");
        }
        if (PACKAGE_ROOT_URI.getPath().equals(packagePartName.getURI().getPath())) {
            return PACKAGE_RELATIONSHIPS_ROOT_PART_NAME;
        }
        if (packagePartName.isRelationshipPartURI()) {
            throw new InvalidOperationException("Can't be a relationship part");
        }
        String path = packagePartName.getURI().getPath();
        String filename = getFilename(packagePartName.getURI());
        try {
            return createPartName(combine(combine(path.substring(0, path.length() - filename.length()), RELATIONSHIP_PART_SEGMENT_NAME), filename) + RELATIONSHIP_PART_EXTENSION_NAME);
        } catch (InvalidFormatException unused) {
            return null;
        }
    }

    public static URI toURI(String str) throws URISyntaxException {
        if (str.indexOf("\\") != -1) {
            str = str.replace(ICSVParser.DEFAULT_ESCAPE_CHARACTER, '/');
        }
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            str = str.substring(0, indexOf) + "#" + encode(str.substring(indexOf + 1));
        }
        if (str.length() > 0) {
            StringBuilder sb = new StringBuilder();
            int length = str.length() - 1;
            while (length >= 0) {
                char charAt = str.charAt(length);
                if (!Character.isWhitespace(charAt) && charAt != 160) {
                    break;
                }
                sb.append(charAt);
                length--;
            }
            if (sb.length() > 0) {
                str = str.substring(0, length + 1) + encode(sb.reverse().toString());
            }
        }
        if (missingAuthPattern.matcher(str).matches()) {
            str = str + InternalZipConstants.ZIP_FILE_SEPARATOR;
        }
        return new URI(str);
    }

    public static String encode(String str) {
        if (str.length() == 0) {
            return str;
        }
        ByteBuffer wrap = ByteBuffer.wrap(str.getBytes(Charset.forName("UTF-8")));
        StringBuilder sb = new StringBuilder();
        while (wrap.hasRemaining()) {
            int i = wrap.get() & 255;
            if (isUnsafe(i)) {
                sb.append('%');
                char[] cArr = hexDigits;
                sb.append(cArr[(i >> 4) & 15]);
                sb.append(cArr[(i >> 0) & 15]);
            } else {
                sb.append((char) i);
            }
        }
        return sb.toString();
    }

    private static boolean isUnsafe(int i) {
        return i > 128 || Character.isWhitespace(i) || i == 160;
    }
}
