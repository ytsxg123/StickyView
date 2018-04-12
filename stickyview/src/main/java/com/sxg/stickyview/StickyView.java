package com.sxg.stickyview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 描述：吸附View
 * Created by sxg on 2018/4/10.
 */

public interface StickyView {

    /**
     * 是否是吸附的View
     */
    boolean isStickyView(View view);

    /**
     * 获取吸附View的Type
     */
    int getStickViewType();

    /**
     * 获取吸附View
     */
    View getStickView(RecyclerView.ViewHolder vh);

}
