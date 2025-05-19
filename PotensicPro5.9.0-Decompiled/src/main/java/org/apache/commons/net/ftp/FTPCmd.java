package org.apache.commons.net.ftp;

/* loaded from: classes4.dex */
public enum FTPCmd {
    ABOR,
    ACCT,
    ALLO,
    APPE,
    CDUP,
    CWD,
    DELE,
    EPRT,
    EPSV,
    FEAT,
    HELP,
    LIST,
    MDTM,
    MFMT,
    MKD,
    MLSD,
    MLST,
    MODE,
    NLST,
    NOOP,
    PASS,
    PASV,
    PORT,
    PWD,
    QUIT,
    REIN,
    REST,
    RETR,
    RMD,
    RNFR,
    RNTO,
    SITE,
    SMNT,
    STAT,
    STOR,
    STOU,
    STRU,
    SYST,
    TYPE,
    USER;

    public static final FTPCmd ABORT;
    public static final FTPCmd ACCOUNT;
    public static final FTPCmd ALLOCATE;
    public static final FTPCmd APPEND;
    public static final FTPCmd CHANGE_TO_PARENT_DIRECTORY;
    public static final FTPCmd CHANGE_WORKING_DIRECTORY;
    public static final FTPCmd DATA_PORT;
    public static final FTPCmd DELETE;
    public static final FTPCmd FEATURES;
    public static final FTPCmd FILE_STRUCTURE;
    public static final FTPCmd GET_MOD_TIME;
    public static final FTPCmd LOGOUT;
    public static final FTPCmd MAKE_DIRECTORY;
    public static final FTPCmd MOD_TIME;
    public static final FTPCmd NAME_LIST;
    public static final FTPCmd PASSIVE;
    public static final FTPCmd PASSWORD;
    public static final FTPCmd PRINT_WORKING_DIRECTORY;
    public static final FTPCmd REINITIALIZE;
    public static final FTPCmd REMOVE_DIRECTORY;
    public static final FTPCmd RENAME_FROM;
    public static final FTPCmd RENAME_TO;
    public static final FTPCmd REPRESENTATION_TYPE;
    public static final FTPCmd RESTART;
    public static final FTPCmd RETRIEVE;
    public static final FTPCmd SET_MOD_TIME;
    public static final FTPCmd SITE_PARAMETERS;
    public static final FTPCmd STATUS;
    public static final FTPCmd STORE;
    public static final FTPCmd STORE_UNIQUE;
    public static final FTPCmd STRUCTURE_MOUNT;
    public static final FTPCmd SYSTEM;
    public static final FTPCmd TRANSFER_MODE;
    public static final FTPCmd USERNAME;

    static {
        FTPCmd fTPCmd = ABOR;
        FTPCmd fTPCmd2 = ACCT;
        FTPCmd fTPCmd3 = ALLO;
        FTPCmd fTPCmd4 = APPE;
        FTPCmd fTPCmd5 = CDUP;
        FTPCmd fTPCmd6 = CWD;
        FTPCmd fTPCmd7 = DELE;
        FTPCmd fTPCmd8 = FEAT;
        FTPCmd fTPCmd9 = MDTM;
        FTPCmd fTPCmd10 = MKD;
        FTPCmd fTPCmd11 = NLST;
        FTPCmd fTPCmd12 = PASS;
        FTPCmd fTPCmd13 = PASV;
        FTPCmd fTPCmd14 = PORT;
        FTPCmd fTPCmd15 = PWD;
        FTPCmd fTPCmd16 = QUIT;
        FTPCmd fTPCmd17 = REIN;
        FTPCmd fTPCmd18 = REST;
        FTPCmd fTPCmd19 = RETR;
        FTPCmd fTPCmd20 = RMD;
        FTPCmd fTPCmd21 = RNFR;
        FTPCmd fTPCmd22 = RNTO;
        FTPCmd fTPCmd23 = SITE;
        FTPCmd fTPCmd24 = SMNT;
        FTPCmd fTPCmd25 = STAT;
        FTPCmd fTPCmd26 = STOR;
        FTPCmd fTPCmd27 = STOU;
        FTPCmd fTPCmd28 = STRU;
        FTPCmd fTPCmd29 = SYST;
        FTPCmd fTPCmd30 = TYPE;
        FTPCmd fTPCmd31 = USER;
        ABORT = fTPCmd;
        ACCOUNT = fTPCmd2;
        ALLOCATE = fTPCmd3;
        APPEND = fTPCmd4;
        CHANGE_TO_PARENT_DIRECTORY = fTPCmd5;
        CHANGE_WORKING_DIRECTORY = fTPCmd6;
        DATA_PORT = fTPCmd14;
        DELETE = fTPCmd7;
        FEATURES = fTPCmd8;
        FILE_STRUCTURE = fTPCmd28;
        GET_MOD_TIME = fTPCmd9;
        LOGOUT = fTPCmd16;
        MAKE_DIRECTORY = fTPCmd10;
        MOD_TIME = fTPCmd9;
        NAME_LIST = fTPCmd11;
        PASSIVE = fTPCmd13;
        PASSWORD = fTPCmd12;
        PRINT_WORKING_DIRECTORY = fTPCmd15;
        REINITIALIZE = fTPCmd17;
        REMOVE_DIRECTORY = fTPCmd20;
        RENAME_FROM = fTPCmd21;
        RENAME_TO = fTPCmd22;
        REPRESENTATION_TYPE = fTPCmd30;
        RESTART = fTPCmd18;
        RETRIEVE = fTPCmd19;
        SET_MOD_TIME = MFMT;
        SITE_PARAMETERS = fTPCmd23;
        STATUS = fTPCmd25;
        STORE = fTPCmd26;
        STORE_UNIQUE = fTPCmd27;
        STRUCTURE_MOUNT = fTPCmd24;
        SYSTEM = fTPCmd29;
        TRANSFER_MODE = MODE;
        USERNAME = fTPCmd31;
    }

    public final String getCommand() {
        return name();
    }
}
