package com.wutka.dtd;

/* loaded from: classes3.dex */
class Token {
    public TokenType type;
    public String value;

    public Token(TokenType tokenType) {
        this.type = tokenType;
        this.value = null;
    }

    public Token(TokenType tokenType, String str) {
        this.type = tokenType;
        this.value = str;
    }
}
