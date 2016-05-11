package com.example.snoretrain.gaggle.itemdecoration;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Snore Train on 4/20/2016.
 */
public class VerticalItemDecoration extends RecyclerView.ItemDecoration {

    private final int mVerticalHeight;

    public VerticalItemDecoration(int mVerticalHeight){
        this.mVerticalHeight = mVerticalHeight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state){
        outRect.bottom = mVerticalHeight;
    }
}
