package me.yokeyword.indexablerv.countrys;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes4.dex */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int leftRight;
    private int topBottom;

    public SpaceItemDecoration(int i, int i2) {
        this.leftRight = i;
        this.topBottom = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if (linearLayoutManager.getOrientation() == 1) {
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.bottom = this.topBottom;
            }
            rect.top = this.topBottom;
            rect.left = this.leftRight;
            rect.right = this.leftRight;
            return;
        }
        if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
            rect.right = this.leftRight;
        }
        rect.top = this.topBottom;
        rect.left = this.leftRight;
        rect.bottom = this.topBottom;
    }
}
