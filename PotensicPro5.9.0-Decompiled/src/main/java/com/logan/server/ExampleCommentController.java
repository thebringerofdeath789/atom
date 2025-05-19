package com.logan.server;

import com.logan.server.jhttp.HttpController;

/* loaded from: classes3.dex */
public class ExampleCommentController extends HttpController {
    public void add() {
        this.response.append("Add a comment");
    }

    public void delete() {
        this.response.append("Delete a comment");
    }

    public void update() {
        this.response.append("Update a comment");
    }
}
