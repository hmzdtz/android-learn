package com.hmzdtz.libandroidlearn.recyclerview

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CenteredLinearLayoutManager @JvmOverloads constructor(
    context: Context,
    @RecyclerView.Orientation orientation: Int = RecyclerView.VERTICAL,
    reverseLayout: Boolean = false
) : LinearLayoutManager(context, orientation, reverseLayout) {
    override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
        super.onLayoutChildren(recycler, state)
        calculateAndApplyItemOffsets()
    }

    private fun calculateAndApplyItemOffsets() {
        val parentSize = if (orientation == HORIZONTAL) {
            width
        } else {
            height
        }

        val totalItemSize = getTotalItemSize()

        // 如果RecyclerView的宽度大于一屏中出现的item的宽度总和，计算偏移量使item居中
        if (parentSize > totalItemSize) {
            val extraSpace = parentSize - totalItemSize
            val horizontalPadding = extraSpace / 2
            offsetChildrenHorizontal(horizontalPadding)
        }
    }

    private fun getTotalItemSize(): Int {
        var result = 0

        for (i in 0 until childCount) {
            val view = getChildAt(i)

            if (view != null) {
                result += if (orientation == HORIZONTAL) {
                    getDecoratedMeasuredWidth(view)
                } else {
                    getDecoratedMeasuredHeight(view)
                }
            }
        }

        return result
    }
}