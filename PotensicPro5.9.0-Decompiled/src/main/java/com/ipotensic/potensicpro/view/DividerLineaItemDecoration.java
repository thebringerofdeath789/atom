package com.ipotensic.potensicpro.view;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public class DividerLineaItemDecoration extends RecyclerView.ItemDecoration {
    private int topBottom;

    public DividerLineaItemDecoration(int i) {
        this.topBottom = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        rect.top = this.topBottom;
        if (childAdapterPosition == 0) {
            rect.top = 0;
        }
        if (childAdapterPosition == linearLayoutManager.getItemCount() - 1) {
            rect.bottom = this.topBottom;
        }
    }
}
