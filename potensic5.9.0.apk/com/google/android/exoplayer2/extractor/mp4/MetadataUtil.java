package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.C0858C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.openxml4j.opc.ContentTypes;

/* loaded from: classes.dex */
final class MetadataUtil {
    private static final int PICTURE_TYPE_FRONT_COVER = 3;
    private static final int SHORT_TYPE_ALBUM = 6384738;
    private static final int SHORT_TYPE_ARTIST = 4280916;
    private static final int SHORT_TYPE_COMMENT = 6516084;
    private static final int SHORT_TYPE_COMPOSER_1 = 6516589;
    private static final int SHORT_TYPE_COMPOSER_2 = 7828084;
    private static final int SHORT_TYPE_ENCODER = 7630703;
    private static final int SHORT_TYPE_GENRE = 6776174;
    private static final int SHORT_TYPE_LYRICS = 7108978;
    private static final int SHORT_TYPE_NAME_1 = 7233901;
    private static final int SHORT_TYPE_NAME_2 = 7631467;
    private static final int SHORT_TYPE_YEAR = 6578553;
    static final String[] STANDARD_GENRES = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};
    private static final String TAG = "MetadataUtil";
    private static final int TYPE_ALBUM_ARTIST = 1631670868;
    private static final int TYPE_COMPILATION = 1668311404;
    private static final int TYPE_COVER_ART = 1668249202;
    private static final int TYPE_DISK_NUMBER = 1684632427;
    private static final int TYPE_GAPLESS_ALBUM = 1885823344;
    private static final int TYPE_GENRE = 1735291493;
    private static final int TYPE_GROUPING = 6779504;
    private static final int TYPE_INTERNAL = 757935405;
    private static final int TYPE_RATING = 1920233063;
    private static final int TYPE_SORT_ALBUM = 1936679276;
    private static final int TYPE_SORT_ALBUM_ARTIST = 1936679265;
    private static final int TYPE_SORT_ARTIST = 1936679282;
    private static final int TYPE_SORT_COMPOSER = 1936679791;
    private static final int TYPE_SORT_TRACK_NAME = 1936682605;
    private static final int TYPE_TEMPO = 1953329263;
    private static final int TYPE_TOP_BYTE_COPYRIGHT = 169;
    private static final int TYPE_TOP_BYTE_REPLACEMENT = 253;
    private static final int TYPE_TRACK_NUMBER = 1953655662;
    private static final int TYPE_TV_SHOW = 1953919848;
    private static final int TYPE_TV_SORT_SHOW = 1936683886;

    private MetadataUtil() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000b, code lost:
    
        if (r6 != null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void setFormatMetadata(int r5, com.google.android.exoplayer2.metadata.Metadata r6, com.google.android.exoplayer2.metadata.Metadata r7, com.google.android.exoplayer2.Format.Builder r8, com.google.android.exoplayer2.metadata.Metadata... r9) {
        /*
            com.google.android.exoplayer2.metadata.Metadata r0 = new com.google.android.exoplayer2.metadata.Metadata
            r1 = 0
            com.google.android.exoplayer2.metadata.Metadata$Entry[] r2 = new com.google.android.exoplayer2.metadata.Metadata.Entry[r1]
            r0.<init>(r2)
            r2 = 1
            if (r5 != r2) goto Le
            if (r6 == 0) goto L3c
            goto L3d
        Le:
            r6 = 2
            if (r5 != r6) goto L3c
            if (r7 == 0) goto L3c
            r5 = r1
        L14:
            int r6 = r7.length()
            if (r5 >= r6) goto L3c
            com.google.android.exoplayer2.metadata.Metadata$Entry r6 = r7.get(r5)
            boolean r3 = r6 instanceof com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry
            if (r3 == 0) goto L39
            com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry r6 = (com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry) r6
            java.lang.String r3 = r6.key
            java.lang.String r4 = "com.android.capture.fps"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L39
            com.google.android.exoplayer2.metadata.Metadata r5 = new com.google.android.exoplayer2.metadata.Metadata
            com.google.android.exoplayer2.metadata.Metadata$Entry[] r7 = new com.google.android.exoplayer2.metadata.Metadata.Entry[r2]
            r7[r1] = r6
            r5.<init>(r7)
            r6 = r5
            goto L3d
        L39:
            int r5 = r5 + 1
            goto L14
        L3c:
            r6 = r0
        L3d:
            int r5 = r9.length
        L3e:
            if (r1 >= r5) goto L49
            r7 = r9[r1]
            com.google.android.exoplayer2.metadata.Metadata r6 = r6.copyWithAppendedEntriesFrom(r7)
            int r1 = r1 + 1
            goto L3e
        L49:
            int r5 = r6.length()
            if (r5 <= 0) goto L52
            r8.setMetadata(r6)
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.MetadataUtil.setFormatMetadata(int, com.google.android.exoplayer2.metadata.Metadata, com.google.android.exoplayer2.metadata.Metadata, com.google.android.exoplayer2.Format$Builder, com.google.android.exoplayer2.metadata.Metadata[]):void");
    }

    public static void setFormatGaplessInfo(int i, GaplessInfoHolder gaplessInfoHolder, Format.Builder builder) {
        if (i == 1 && gaplessInfoHolder.hasGaplessInfo()) {
            builder.setEncoderDelay(gaplessInfoHolder.encoderDelay).setEncoderPadding(gaplessInfoHolder.encoderPadding);
        }
    }

    public static Metadata.Entry parseIlstElement(ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition() + parsableByteArray.readInt();
        int readInt = parsableByteArray.readInt();
        int i = (readInt >> 24) & 255;
        try {
            if (i == 169 || i == 253) {
                int i2 = 16777215 & readInt;
                if (i2 == SHORT_TYPE_COMMENT) {
                    return parseCommentAttribute(readInt, parsableByteArray);
                }
                if (i2 == SHORT_TYPE_NAME_1 || i2 == SHORT_TYPE_NAME_2) {
                    return parseTextAttribute(readInt, "TIT2", parsableByteArray);
                }
                if (i2 == SHORT_TYPE_COMPOSER_1 || i2 == SHORT_TYPE_COMPOSER_2) {
                    return parseTextAttribute(readInt, "TCOM", parsableByteArray);
                }
                if (i2 == SHORT_TYPE_YEAR) {
                    return parseTextAttribute(readInt, "TDRC", parsableByteArray);
                }
                if (i2 == SHORT_TYPE_ARTIST) {
                    return parseTextAttribute(readInt, "TPE1", parsableByteArray);
                }
                if (i2 == SHORT_TYPE_ENCODER) {
                    return parseTextAttribute(readInt, "TSSE", parsableByteArray);
                }
                if (i2 == SHORT_TYPE_ALBUM) {
                    return parseTextAttribute(readInt, "TALB", parsableByteArray);
                }
                if (i2 == SHORT_TYPE_LYRICS) {
                    return parseTextAttribute(readInt, "USLT", parsableByteArray);
                }
                if (i2 == SHORT_TYPE_GENRE) {
                    return parseTextAttribute(readInt, "TCON", parsableByteArray);
                }
                if (i2 == TYPE_GROUPING) {
                    return parseTextAttribute(readInt, "TIT1", parsableByteArray);
                }
            } else {
                if (readInt == TYPE_GENRE) {
                    return parseStandardGenreAttribute(parsableByteArray);
                }
                if (readInt == TYPE_DISK_NUMBER) {
                    return parseIndexAndCountAttribute(readInt, "TPOS", parsableByteArray);
                }
                if (readInt == TYPE_TRACK_NUMBER) {
                    return parseIndexAndCountAttribute(readInt, "TRCK", parsableByteArray);
                }
                if (readInt == TYPE_TEMPO) {
                    return parseUint8Attribute(readInt, "TBPM", parsableByteArray, true, false);
                }
                if (readInt == TYPE_COMPILATION) {
                    return parseUint8Attribute(readInt, "TCMP", parsableByteArray, true, true);
                }
                if (readInt == TYPE_COVER_ART) {
                    return parseCoverArt(parsableByteArray);
                }
                if (readInt == TYPE_ALBUM_ARTIST) {
                    return parseTextAttribute(readInt, "TPE2", parsableByteArray);
                }
                if (readInt == TYPE_SORT_TRACK_NAME) {
                    return parseTextAttribute(readInt, "TSOT", parsableByteArray);
                }
                if (readInt == TYPE_SORT_ALBUM) {
                    return parseTextAttribute(readInt, "TSO2", parsableByteArray);
                }
                if (readInt == TYPE_SORT_ARTIST) {
                    return parseTextAttribute(readInt, "TSOA", parsableByteArray);
                }
                if (readInt == TYPE_SORT_ALBUM_ARTIST) {
                    return parseTextAttribute(readInt, "TSOP", parsableByteArray);
                }
                if (readInt == TYPE_SORT_COMPOSER) {
                    return parseTextAttribute(readInt, "TSOC", parsableByteArray);
                }
                if (readInt == TYPE_RATING) {
                    return parseUint8Attribute(readInt, "ITUNESADVISORY", parsableByteArray, false, false);
                }
                if (readInt == TYPE_GAPLESS_ALBUM) {
                    return parseUint8Attribute(readInt, "ITUNESGAPLESS", parsableByteArray, false, true);
                }
                if (readInt == TYPE_TV_SORT_SHOW) {
                    return parseTextAttribute(readInt, "TVSHOWSORT", parsableByteArray);
                }
                if (readInt == TYPE_TV_SHOW) {
                    return parseTextAttribute(readInt, "TVSHOW", parsableByteArray);
                }
                if (readInt == TYPE_INTERNAL) {
                    return parseInternalAttribute(parsableByteArray, position);
                }
            }
            String valueOf = String.valueOf(Atom.getAtomTypeString(readInt));
            Log.m1495d(TAG, valueOf.length() != 0 ? "Skipped unknown metadata entry: ".concat(valueOf) : new String("Skipped unknown metadata entry: "));
            return null;
        } finally {
            parsableByteArray.setPosition(position);
        }
    }

    public static MdtaMetadataEntry parseMdtaMetadataEntryFromIlst(ParsableByteArray parsableByteArray, int i, String str) {
        while (true) {
            int position = parsableByteArray.getPosition();
            if (position >= i) {
                return null;
            }
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1684108385) {
                int readInt2 = parsableByteArray.readInt();
                int readInt3 = parsableByteArray.readInt();
                int i2 = readInt - 16;
                byte[] bArr = new byte[i2];
                parsableByteArray.readBytes(bArr, 0, i2);
                return new MdtaMetadataEntry(str, bArr, readInt3, readInt2);
            }
            parsableByteArray.setPosition(position + readInt);
        }
    }

    private static TextInformationFrame parseTextAttribute(int i, String str, ParsableByteArray parsableByteArray) {
        int readInt = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385) {
            parsableByteArray.skipBytes(8);
            return new TextInformationFrame(str, null, parsableByteArray.readNullTerminatedString(readInt - 16));
        }
        String valueOf = String.valueOf(Atom.getAtomTypeString(i));
        Log.m1501w(TAG, valueOf.length() != 0 ? "Failed to parse text attribute: ".concat(valueOf) : new String("Failed to parse text attribute: "));
        return null;
    }

    private static CommentFrame parseCommentAttribute(int i, ParsableByteArray parsableByteArray) {
        int readInt = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385) {
            parsableByteArray.skipBytes(8);
            String readNullTerminatedString = parsableByteArray.readNullTerminatedString(readInt - 16);
            return new CommentFrame(C0858C.LANGUAGE_UNDETERMINED, readNullTerminatedString, readNullTerminatedString);
        }
        String valueOf = String.valueOf(Atom.getAtomTypeString(i));
        Log.m1501w(TAG, valueOf.length() != 0 ? "Failed to parse comment attribute: ".concat(valueOf) : new String("Failed to parse comment attribute: "));
        return null;
    }

    private static Id3Frame parseUint8Attribute(int i, String str, ParsableByteArray parsableByteArray, boolean z, boolean z2) {
        int parseUint8AttributeValue = parseUint8AttributeValue(parsableByteArray);
        if (z2) {
            parseUint8AttributeValue = Math.min(1, parseUint8AttributeValue);
        }
        if (parseUint8AttributeValue >= 0) {
            if (z) {
                return new TextInformationFrame(str, null, Integer.toString(parseUint8AttributeValue));
            }
            return new CommentFrame(C0858C.LANGUAGE_UNDETERMINED, str, Integer.toString(parseUint8AttributeValue));
        }
        String valueOf = String.valueOf(Atom.getAtomTypeString(i));
        Log.m1501w(TAG, valueOf.length() != 0 ? "Failed to parse uint8 attribute: ".concat(valueOf) : new String("Failed to parse uint8 attribute: "));
        return null;
    }

    private static TextInformationFrame parseIndexAndCountAttribute(int i, String str, ParsableByteArray parsableByteArray) {
        int readInt = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385 && readInt >= 22) {
            parsableByteArray.skipBytes(10);
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            if (readUnsignedShort > 0) {
                String sb = new StringBuilder(11).append(readUnsignedShort).toString();
                int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
                if (readUnsignedShort2 > 0) {
                    String valueOf = String.valueOf(sb);
                    sb = new StringBuilder(String.valueOf(valueOf).length() + 12).append(valueOf).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(readUnsignedShort2).toString();
                }
                return new TextInformationFrame(str, null, sb);
            }
        }
        String valueOf2 = String.valueOf(Atom.getAtomTypeString(i));
        Log.m1501w(TAG, valueOf2.length() != 0 ? "Failed to parse index/count attribute: ".concat(valueOf2) : new String("Failed to parse index/count attribute: "));
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.android.exoplayer2.metadata.id3.TextInformationFrame parseStandardGenreAttribute(com.google.android.exoplayer2.util.ParsableByteArray r3) {
        /*
            int r3 = parseUint8AttributeValue(r3)
            r0 = 0
            if (r3 <= 0) goto L11
            java.lang.String[] r1 = com.google.android.exoplayer2.extractor.mp4.MetadataUtil.STANDARD_GENRES
            int r2 = r1.length
            if (r3 > r2) goto L11
            int r3 = r3 + (-1)
            r3 = r1[r3]
            goto L12
        L11:
            r3 = r0
        L12:
            if (r3 == 0) goto L1c
            com.google.android.exoplayer2.metadata.id3.TextInformationFrame r1 = new com.google.android.exoplayer2.metadata.id3.TextInformationFrame
            java.lang.String r2 = "TCON"
            r1.<init>(r2, r0, r3)
            return r1
        L1c:
            java.lang.String r3 = "MetadataUtil"
            java.lang.String r1 = "Failed to parse standard genre code"
            com.google.android.exoplayer2.util.Log.m1501w(r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.MetadataUtil.parseStandardGenreAttribute(com.google.android.exoplayer2.util.ParsableByteArray):com.google.android.exoplayer2.metadata.id3.TextInformationFrame");
    }

    private static ApicFrame parseCoverArt(ParsableByteArray parsableByteArray) {
        int readInt = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385) {
            int parseFullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray.readInt());
            String str = parseFullAtomFlags == 13 ? "image/jpeg" : parseFullAtomFlags == 14 ? ContentTypes.IMAGE_PNG : null;
            if (str == null) {
                Log.m1501w(TAG, new StringBuilder(41).append("Unrecognized cover art flags: ").append(parseFullAtomFlags).toString());
                return null;
            }
            parsableByteArray.skipBytes(4);
            int i = readInt - 16;
            byte[] bArr = new byte[i];
            parsableByteArray.readBytes(bArr, 0, i);
            return new ApicFrame(str, null, 3, bArr);
        }
        Log.m1501w(TAG, "Failed to parse cover art attribute");
        return null;
    }

    private static Id3Frame parseInternalAttribute(ParsableByteArray parsableByteArray, int i) {
        int i2 = -1;
        int i3 = -1;
        String str = null;
        String str2 = null;
        while (parsableByteArray.getPosition() < i) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            int readInt2 = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            if (readInt2 == 1835360622) {
                str = parsableByteArray.readNullTerminatedString(readInt - 12);
            } else if (readInt2 == 1851878757) {
                str2 = parsableByteArray.readNullTerminatedString(readInt - 12);
            } else {
                if (readInt2 == 1684108385) {
                    i2 = position;
                    i3 = readInt;
                }
                parsableByteArray.skipBytes(readInt - 12);
            }
        }
        if (str == null || str2 == null || i2 == -1) {
            return null;
        }
        parsableByteArray.setPosition(i2);
        parsableByteArray.skipBytes(16);
        return new InternalFrame(str, str2, parsableByteArray.readNullTerminatedString(i3 - 16));
    }

    private static int parseUint8AttributeValue(ParsableByteArray parsableByteArray) {
        parsableByteArray.skipBytes(4);
        if (parsableByteArray.readInt() == 1684108385) {
            parsableByteArray.skipBytes(8);
            return parsableByteArray.readUnsignedByte();
        }
        Log.m1501w(TAG, "Failed to parse uint8 attribute value");
        return -1;
    }
}