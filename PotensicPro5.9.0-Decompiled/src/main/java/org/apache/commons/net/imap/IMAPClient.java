package org.apache.commons.net.imap;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.imap.IMAP;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes4.dex */
public class IMAPClient extends IMAP {
    private static final char DQUOTE = '\"';
    private static final String DQUOTE_S = "\"";

    public enum FETCH_ITEM_NAMES {
        ALL,
        FAST,
        FULL,
        BODY,
        BODYSTRUCTURE,
        ENVELOPE,
        FLAGS,
        INTERNALDATE,
        RFC822,
        UID
    }

    public enum SEARCH_CRITERIA {
        ALL,
        ANSWERED,
        BCC,
        BEFORE,
        BODY,
        CC,
        DELETED,
        DRAFT,
        FLAGGED,
        FROM,
        HEADER,
        KEYWORD,
        LARGER,
        NEW,
        NOT,
        OLD,
        ON,
        OR,
        RECENT,
        SEEN,
        SENTBEFORE,
        SENTON,
        SENTSINCE,
        SINCE,
        SMALLER,
        SUBJECT,
        TEXT,
        TO,
        UID,
        UNANSWERED,
        UNDELETED,
        UNDRAFT,
        UNFLAGGED,
        UNKEYWORD,
        UNSEEN
    }

    public enum STATUS_DATA_ITEMS {
        MESSAGES,
        RECENT,
        UIDNEXT,
        UIDVALIDITY,
        UNSEEN
    }

    public boolean capability() throws IOException {
        return doCommand(IMAPCommand.CAPABILITY);
    }

    public boolean noop() throws IOException {
        return doCommand(IMAPCommand.NOOP);
    }

    public boolean logout() throws IOException {
        return doCommand(IMAPCommand.LOGOUT);
    }

    public boolean login(String str, String str2) throws IOException {
        if (getState() != IMAP.IMAPState.NOT_AUTH_STATE || !doCommand(IMAPCommand.LOGIN, str + StringUtils.SPACE + str2)) {
            return false;
        }
        setState(IMAP.IMAPState.AUTH_STATE);
        return true;
    }

    public boolean select(String str) throws IOException {
        return doCommand(IMAPCommand.SELECT, str);
    }

    public boolean examine(String str) throws IOException {
        return doCommand(IMAPCommand.EXAMINE, str);
    }

    public boolean create(String str) throws IOException {
        return doCommand(IMAPCommand.CREATE, str);
    }

    public boolean delete(String str) throws IOException {
        return doCommand(IMAPCommand.DELETE, str);
    }

    public boolean rename(String str, String str2) throws IOException {
        return doCommand(IMAPCommand.RENAME, str + StringUtils.SPACE + str2);
    }

    public boolean subscribe(String str) throws IOException {
        return doCommand(IMAPCommand.SUBSCRIBE, str);
    }

    public boolean unsubscribe(String str) throws IOException {
        return doCommand(IMAPCommand.UNSUBSCRIBE, str);
    }

    public boolean list(String str, String str2) throws IOException {
        return doCommand(IMAPCommand.LIST, str + StringUtils.SPACE + str2);
    }

    public boolean lsub(String str, String str2) throws IOException {
        return doCommand(IMAPCommand.LSUB, str + StringUtils.SPACE + str2);
    }

    public boolean status(String str, String[] strArr) throws IOException {
        if (strArr == null || strArr.length < 1) {
            throw new IllegalArgumentException("STATUS command requires at least one data item name");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" (");
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                sb.append(StringUtils.SPACE);
            }
            sb.append(strArr[i]);
        }
        sb.append(")");
        return doCommand(IMAPCommand.STATUS, sb.toString());
    }

    public boolean append(String str, String str2, String str3, String str4) throws IOException {
        StringBuilder sb = new StringBuilder(str);
        if (str2 != null) {
            sb.append(StringUtils.SPACE).append(str2);
        }
        if (str3 != null) {
            sb.append(StringUtils.SPACE);
            if (str3.charAt(0) == '\"') {
                sb.append(str3);
            } else {
                sb.append('\"').append(str3).append('\"');
            }
        }
        sb.append(StringUtils.SPACE);
        if (str4.startsWith(DQUOTE_S) && str4.endsWith(DQUOTE_S)) {
            sb.append(str4);
            return doCommand(IMAPCommand.APPEND, sb.toString());
        }
        sb.append('{').append(str4.length()).append('}');
        return IMAPReply.isContinuation(sendCommand(IMAPCommand.APPEND, sb.toString())) && IMAPReply.isSuccess(sendData(str4));
    }

    @Deprecated
    public boolean append(String str, String str2, String str3) throws IOException {
        if (str2 != null) {
            str = str + StringUtils.SPACE + str2;
        }
        if (str3 != null) {
            if (str3.charAt(0) == '{') {
                str = str + StringUtils.SPACE + str3;
            } else {
                str = str + " {" + str3 + StringSubstitutor.DEFAULT_VAR_END;
            }
        }
        return doCommand(IMAPCommand.APPEND, str);
    }

    @Deprecated
    public boolean append(String str) throws IOException {
        return append(str, null, null);
    }

    public boolean check() throws IOException {
        return doCommand(IMAPCommand.CHECK);
    }

    public boolean close() throws IOException {
        return doCommand(IMAPCommand.CLOSE);
    }

    public boolean expunge() throws IOException {
        return doCommand(IMAPCommand.EXPUNGE);
    }

    public boolean search(String str, String str2) throws IOException {
        return doCommand(IMAPCommand.SEARCH, (str != null ? "CHARSET " + str : "") + str2);
    }

    public boolean search(String str) throws IOException {
        return search(null, str);
    }

    public boolean fetch(String str, String str2) throws IOException {
        return doCommand(IMAPCommand.FETCH, str + StringUtils.SPACE + str2);
    }

    public boolean store(String str, String str2, String str3) throws IOException {
        return doCommand(IMAPCommand.STORE, str + StringUtils.SPACE + str2 + StringUtils.SPACE + str3);
    }

    public boolean copy(String str, String str2) throws IOException {
        return doCommand(IMAPCommand.COPY, str + StringUtils.SPACE + str2);
    }

    public boolean uid(String str, String str2) throws IOException {
        return doCommand(IMAPCommand.UID, str + StringUtils.SPACE + str2);
    }
}
