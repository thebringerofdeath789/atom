package org.apache.commons.net.nntp;

/* loaded from: classes4.dex */
public final class NNTPReply {
    public static final int ARTICLE_LIST_BY_MESSAGE_ID_FOLLOWS = 230;
    public static final int ARTICLE_NOT_WANTED = 435;
    public static final int ARTICLE_POSTED_OK = 240;
    public static final int ARTICLE_REJECTED = 437;
    public static final int ARTICLE_RETRIEVED_BODY_FOLLOWS = 222;
    public static final int ARTICLE_RETRIEVED_HEAD_AND_BODY_FOLLOW = 220;
    public static final int ARTICLE_RETRIEVED_HEAD_FOLLOWS = 221;
    public static final int ARTICLE_RETRIEVED_REQUEST_TEXT_SEPARATELY = 223;
    public static final int ARTICLE_TRANSFERRED_OK = 235;
    public static final int AUTHENTICATION_ACCEPTED = 281;
    public static final int AUTHENTICATION_REJECTED = 482;
    public static final int AUTHENTICATION_REQUIRED = 480;
    public static final int CLOSING_CONNECTION = 205;
    public static final int COMMAND_NOT_RECOGNIZED = 500;
    public static final int COMMAND_SYNTAX_ERROR = 501;
    public static final int DEBUG_OUTPUT = 199;
    public static final int GROUP_SELECTED = 211;
    public static final int HELP_TEXT_FOLLOWS = 100;
    public static final int MORE_AUTH_INFO_REQUIRED = 381;
    public static final int NEW_NEWSGROUP_LIST_FOLLOWS = 231;
    public static final int NO_CURRENT_ARTICLE_SELECTED = 420;
    public static final int NO_NEWSGROUP_SELECTED = 412;
    public static final int NO_NEXT_ARTICLE = 421;
    public static final int NO_PREVIOUS_ARTICLE = 422;
    public static final int NO_SUCH_ARTICLE_FOUND = 430;
    public static final int NO_SUCH_ARTICLE_NUMBER = 423;
    public static final int NO_SUCH_NEWSGROUP = 411;
    public static final int PERMISSION_DENIED = 502;
    public static final int POSTING_FAILED = 441;
    public static final int POSTING_NOT_ALLOWED = 440;
    public static final int PROGRAM_FAULT = 503;
    public static final int SEND_ARTICLE_TO_POST = 340;
    public static final int SEND_ARTICLE_TO_TRANSFER = 335;
    public static final int SERVER_READY_POSTING_ALLOWED = 200;
    public static final int SERVER_READY_POSTING_NOT_ALLOWED = 201;
    public static final int SERVICE_DISCONTINUED = 400;
    public static final int SLAVE_STATUS_NOTED = 202;
    public static final int TRANSFER_FAILED = 436;

    public static boolean isInformational(int i) {
        return i >= 100 && i < 200;
    }

    public static boolean isNegativePermanent(int i) {
        return i >= 500 && i < 600;
    }

    public static boolean isNegativeTransient(int i) {
        return i >= 400 && i < 500;
    }

    public static boolean isPositiveCompletion(int i) {
        return i >= 200 && i < 300;
    }

    public static boolean isPositiveIntermediate(int i) {
        return i >= 300 && i < 400;
    }

    private NNTPReply() {
    }
}
