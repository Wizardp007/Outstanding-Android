package com.wangzp.androidtree.recyclerviews.viewhlper;



import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;


/**
 * 防止卡片在第一页和最后一页因无法"居中"而一直循环调用onScrollStateChanged-->SnapHelper.snapToTargetExistingView-->onScrollStateChanged
 * change snapHelper get different style
 */
public class CardLinearSnapHelper extends PagerSnapHelper {
    public boolean mNoNeedToScroll = false;

    @Override
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View targetView) {
        if (mNoNeedToScroll) {
            return new int[]{0, 0};
        } else {
            return super.calculateDistanceToFinalSnap(layoutManager, targetView);
        }
    }

}
