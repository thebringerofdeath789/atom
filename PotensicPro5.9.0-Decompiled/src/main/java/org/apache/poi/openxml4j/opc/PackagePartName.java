package org.apache.poi.openxml4j.opc;

import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JRuntimeException;

/* loaded from: classes5.dex */
public final class PackagePartName implements Comparable<PackagePartName> {
    private boolean isRelationship;
    private URI partNameURI;
    private static String[] RFC3986_PCHAR_SUB_DELIMS = {"!", "$", "&", "'", "(", ")", WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD, "+", ",", ";", "="};
    private static String[] RFC3986_PCHAR_UNRESERVED_SUP = {"-", ".", "_", "~"};
    private static String[] RFC3986_PCHAR_AUTHORIZED_SUP = {":", "@"};

    PackagePartName(URI uri, boolean z) throws InvalidFormatException {
        if (z) {
            throwExceptionIfInvalidPartUri(uri);
        } else if (!PackagingURIHelper.PACKAGE_ROOT_URI.equals(uri)) {
            throw new OpenXML4JRuntimeException("OCP conformance must be check for ALL part name except special cases : ['/']");
        }
        this.partNameURI = uri;
        this.isRelationship = isRelationshipPartURI(uri);
    }

    PackagePartName(String str, boolean z) throws InvalidFormatException {
        try {
            URI uri = new URI(str);
            if (z) {
                throwExceptionIfInvalidPartUri(uri);
            } else if (!PackagingURIHelper.PACKAGE_ROOT_URI.equals(uri)) {
                throw new OpenXML4JRuntimeException("OCP conformance must be check for ALL part name except special cases : ['/']");
            }
            this.partNameURI = uri;
            this.isRelationship = isRelationshipPartURI(uri);
        } catch (URISyntaxException unused) {
            throw new IllegalArgumentException("partName argmument is not a valid OPC part name !");
        }
    }

    private boolean isRelationshipPartURI(URI uri) {
        if (uri == null) {
            throw new IllegalArgumentException("partUri");
        }
        return uri.getPath().matches("^.*/" + PackagingURIHelper.RELATIONSHIP_PART_SEGMENT_NAME + "/.*\\" + PackagingURIHelper.RELATIONSHIP_PART_EXTENSION_NAME + "$");
    }

    public boolean isRelationshipPartURI() {
        return this.isRelationship;
    }

    private static void throwExceptionIfInvalidPartUri(URI uri) throws InvalidFormatException {
        if (uri == null) {
            throw new IllegalArgumentException("partUri");
        }
        throwExceptionIfEmptyURI(uri);
        throwExceptionIfAbsoluteUri(uri);
        throwExceptionIfPartNameNotStartsWithForwardSlashChar(uri);
        throwExceptionIfPartNameEndsWithForwardSlashChar(uri);
        throwExceptionIfPartNameHaveInvalidSegments(uri);
    }

    private static void throwExceptionIfEmptyURI(URI uri) throws InvalidFormatException {
        if (uri == null) {
            throw new IllegalArgumentException("partURI");
        }
        String path = uri.getPath();
        if (path.length() == 0 || (path.length() == 1 && path.charAt(0) == PackagingURIHelper.FORWARD_SLASH_CHAR)) {
            throw new InvalidFormatException("A part name shall not be empty [M1.1]: " + uri.getPath());
        }
    }

    private static void throwExceptionIfPartNameHaveInvalidSegments(URI uri) throws InvalidFormatException {
        if (uri == null) {
            throw new IllegalArgumentException("partUri");
        }
        String[] split = uri.toASCIIString().split(InternalZipConstants.ZIP_FILE_SEPARATOR);
        if (split.length <= 1 || !split[0].equals("")) {
            throw new InvalidFormatException("A part name shall not have empty segments [M1.3]: " + uri.getPath());
        }
        for (int i = 1; i < split.length; i++) {
            String str = split[i];
            if (str == null || "".equals(str)) {
                throw new InvalidFormatException("A part name shall not have empty segments [M1.3]: " + uri.getPath());
            }
            if (str.endsWith(".")) {
                throw new InvalidFormatException("A segment shall not end with a dot ('.') character [M1.9]: " + uri.getPath());
            }
            if ("".equals(str.replaceAll("\\\\.", ""))) {
                throw new InvalidFormatException("A segment shall include at least one non-dot character. [M1.10]: " + uri.getPath());
            }
            checkPCharCompliance(str);
        }
    }

    private static void checkPCharCompliance(String str) throws InvalidFormatException {
        boolean z;
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if ((charAt < 'A' || charAt > 'Z') && ((charAt < 'a' || charAt > 'z') && (charAt < '0' || charAt > '9'))) {
                int i2 = 0;
                while (true) {
                    String[] strArr = RFC3986_PCHAR_UNRESERVED_SUP;
                    if (i2 >= strArr.length) {
                        z = true;
                        break;
                    } else {
                        if (charAt == strArr[i2].charAt(0)) {
                            z = false;
                            break;
                        }
                        i2++;
                    }
                }
                int i3 = 0;
                while (z) {
                    String[] strArr2 = RFC3986_PCHAR_AUTHORIZED_SUP;
                    if (i3 >= strArr2.length) {
                        break;
                    }
                    if (charAt == strArr2[i3].charAt(0)) {
                        z = false;
                    }
                    i3++;
                }
                int i4 = 0;
                while (z) {
                    String[] strArr3 = RFC3986_PCHAR_SUB_DELIMS;
                    if (i4 >= strArr3.length) {
                        break;
                    }
                    if (charAt == strArr3[i4].charAt(0)) {
                        z = false;
                    }
                    i4++;
                }
            } else {
                z = false;
            }
            if (z && charAt == '%') {
                if (str.length() - i < 2) {
                    throw new InvalidFormatException("The segment " + str + " contain invalid encoded character !");
                }
                char parseInt = (char) Integer.parseInt(str.substring(i + 1, i + 3), 16);
                i += 2;
                if (parseInt == '/' || parseInt == '\\') {
                    throw new InvalidFormatException("A segment shall not contain percent-encoded forward slash ('/'), or backward slash ('') characters. [M1.7]");
                }
                boolean z2 = (parseInt >= 'A' && parseInt <= 'Z') || (parseInt >= 'a' && parseInt <= 'z') || (parseInt >= '0' && parseInt <= '9');
                int i5 = 0;
                while (!z2) {
                    String[] strArr4 = RFC3986_PCHAR_UNRESERVED_SUP;
                    if (i5 >= strArr4.length) {
                        break;
                    }
                    if (charAt == strArr4[i5].charAt(0)) {
                        z = true;
                        break;
                    }
                    i5++;
                }
                z = z2;
                if (z) {
                    throw new InvalidFormatException("A segment shall not contain percent-encoded unreserved characters. [M1.8]");
                }
            }
            if (z) {
                throw new InvalidFormatException("A segment shall not hold any characters other than pchar characters. [M1.6]");
            }
            i++;
        }
    }

    private static void throwExceptionIfPartNameNotStartsWithForwardSlashChar(URI uri) throws InvalidFormatException {
        String path = uri.getPath();
        if (path.length() > 0 && path.charAt(0) != PackagingURIHelper.FORWARD_SLASH_CHAR) {
            throw new InvalidFormatException("A part name shall start with a forward slash ('/') character [M1.4]: " + uri.getPath());
        }
    }

    private static void throwExceptionIfPartNameEndsWithForwardSlashChar(URI uri) throws InvalidFormatException {
        String path = uri.getPath();
        if (path.length() > 0 && path.charAt(path.length() - 1) == PackagingURIHelper.FORWARD_SLASH_CHAR) {
            throw new InvalidFormatException("A part name shall not have a forward slash as the last character [M1.5]: " + uri.getPath());
        }
    }

    private static void throwExceptionIfAbsoluteUri(URI uri) throws InvalidFormatException {
        if (uri.isAbsolute()) {
            throw new InvalidFormatException("Absolute URI forbidden: " + uri);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(PackagePartName packagePartName) {
        return compare(this, packagePartName);
    }

    public String getExtension() {
        int lastIndexOf;
        String path = this.partNameURI.getPath();
        return (path.length() <= 0 || (lastIndexOf = path.lastIndexOf(".")) <= -1) ? "" : path.substring(lastIndexOf + 1);
    }

    public String getName() {
        return this.partNameURI.toASCIIString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof PackagePartName) {
            return this.partNameURI.toASCIIString().toLowerCase().equals(((PackagePartName) obj).partNameURI.toASCIIString().toLowerCase());
        }
        return false;
    }

    public int hashCode() {
        return this.partNameURI.toASCIIString().toLowerCase().hashCode();
    }

    public String toString() {
        return getName();
    }

    public URI getURI() {
        return this.partNameURI;
    }

    public static int compare(PackagePartName packagePartName, PackagePartName packagePartName2) {
        if (packagePartName == null) {
            return packagePartName2 == null ? 0 : -1;
        }
        if (packagePartName2 == null) {
            return 1;
        }
        return compare(packagePartName.getURI().toASCIIString().toLowerCase(), packagePartName2.getURI().toASCIIString().toLowerCase());
    }

    public static int compare(String str, String str2) {
        int i = 0;
        if (str == null) {
            return str2 == null ? 0 : -1;
        }
        if (str2 == null) {
            return 1;
        }
        int length = str.length();
        int length2 = str2.length();
        int i2 = 0;
        while (i < length && i2 < length2) {
            int i3 = i + 1;
            char charAt = str.charAt(i);
            int i4 = i2 + 1;
            char charAt2 = str2.charAt(i2);
            if (Character.isDigit(charAt) && Character.isDigit(charAt2)) {
                int i5 = i3 - 1;
                while (i3 < length && Character.isDigit(str.charAt(i3))) {
                    i3++;
                }
                int i6 = i4 - 1;
                while (i4 < length2 && Character.isDigit(str2.charAt(i4))) {
                    i4++;
                }
                int compareTo = new BigInteger(str.substring(i5, i3)).compareTo(new BigInteger(str2.substring(i6, i4)));
                if (compareTo != 0) {
                    return compareTo;
                }
            } else if (charAt != charAt2) {
                return charAt - charAt2;
            }
            i = i3;
            i2 = i4;
        }
        return length - length2;
    }
}
