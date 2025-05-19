package jxl.biff.formula;

import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;

/* loaded from: classes4.dex */
class Multiply extends BinaryOperator implements ParsedThing {
    @Override // jxl.biff.formula.Operator
    int getPrecedence() {
        return 3;
    }

    @Override // jxl.biff.formula.BinaryOperator
    public String getSymbol() {
        return WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD;
    }

    @Override // jxl.biff.formula.BinaryOperator
    Token getToken() {
        return Token.MULTIPLY;
    }
}
