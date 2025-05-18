package com.logan.server.jhttp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class HttpResponse {
    private int code;
    private FileInputStream fileInput;
    private String statusMsg;
    private StringBuilder headerBuilder = new StringBuilder();
    private List<byte[]> bodyFrames = new ArrayList();
    private long contentLength = 0;
    private boolean bodyIsFile = false;
    private List<String> headerLines = new ArrayList();

    public HttpResponse() {
        setStatus(200);
    }

    public HttpResponse(int i) {
        setStatus(i);
    }

    public void setStatus(int i) {
        if (!HttpStatus.statusSupported(i)) {
            i = 500;
        }
        this.code = i;
        this.statusMsg = HttpStatus.getStatusMsg(i);
    }

    public int getStatus() {
        return this.code;
    }

    public List<byte[]> getBodyFrames() {
        return this.bodyFrames;
    }

    public String getHeader() {
        this.headerBuilder.append(String.format("HTTP/1.1 %d %s\r\n", Integer.valueOf(this.code), this.statusMsg));
        long j = this.contentLength;
        if (j != 0) {
            header("Content-Length", Long.toString(j));
        }
        header("Connection: keep-alive");
        if (!isFile()) {
            header("Transfer-Encoding: chunked");
        }
        header("Server", "JHttp/0.0.2");
        for (int i = 0; i < this.headerLines.size(); i++) {
            this.headerBuilder.append(this.headerLines.get(i));
        }
        this.headerBuilder.append("\r\n");
        return this.headerBuilder.toString();
    }

    public void header(String str, String str2) {
        this.headerLines.add(str + ": " + str2 + "\r\n");
    }

    public void header(String str) {
        if (str.endsWith("\r\n")) {
            this.headerLines.add(str);
        } else {
            this.headerLines.add(str + "\r\n");
        }
    }

    public void contentType(String str) {
        header("Content-Type", str);
    }

    public HttpResponse append(String str) {
        return append(str.getBytes());
    }

    public HttpResponse append(byte[] bArr) {
        this.bodyFrames.add(bArr);
        this.contentLength += bArr.length;
        return this;
    }

    public void file(String str) throws IOException {
        file(new File(str));
    }

    public void file(File file) throws IOException {
        file(new FileInputStream(file));
    }

    public void file(FileInputStream fileInputStream) throws IOException {
        this.bodyIsFile = true;
        this.contentLength = fileInputStream.getChannel().size();
        this.fileInput = fileInputStream;
    }

    public boolean isFile() {
        return this.bodyIsFile;
    }

    public void setIsFile(boolean z) {
        this.bodyIsFile = z;
    }

    public InputStream getFileInput() {
        return this.fileInput;
    }

    public long getContentLength() {
        return this.contentLength;
    }
}