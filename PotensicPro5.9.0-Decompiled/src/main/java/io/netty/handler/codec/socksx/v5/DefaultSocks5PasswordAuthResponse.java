package io.netty.handler.codec.socksx.v5;

import androidx.core.app.NotificationCompat;
import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.StringUtil;
import java.util.Objects;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public class DefaultSocks5PasswordAuthResponse extends AbstractSocks5Message implements Socks5PasswordAuthResponse {
    private final Socks5PasswordAuthStatus status;

    public DefaultSocks5PasswordAuthResponse(Socks5PasswordAuthStatus socks5PasswordAuthStatus) {
        Objects.requireNonNull(socks5PasswordAuthStatus, NotificationCompat.CATEGORY_STATUS);
        this.status = socks5PasswordAuthStatus;
    }

    @Override // io.netty.handler.codec.socksx.v5.Socks5PasswordAuthResponse
    public Socks5PasswordAuthStatus status() {
        return this.status;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(StringUtil.simpleClassName(this));
        DecoderResult decoderResult = decoderResult();
        if (!decoderResult.isSuccess()) {
            sb.append("(decoderResult: ");
            sb.append(decoderResult);
            sb.append(", status: ");
        } else {
            sb.append("(status: ");
        }
        sb.append(status());
        sb.append(PropertyUtils.MAPPED_DELIM2);
        return sb.toString();
    }
}
