package com.hmzdtz.androidlearn

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.constraintlayout.widget.ConstraintLayout

class FeedView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, @AttrRes defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    val myAdapter: MyAdapter = MyAdapter()

    init {

    }

    fun bindData() {
        val dataList = mutableListOf(
            MyAdapter.ItemData("背景介绍", "这个是用来介绍背景的", true),
            MyAdapter.ItemData("背景介绍", "这个是用来介绍背景的", false),
            MyAdapter.ItemData("背景介绍", "这个是用来介绍背景的", false),
        )

        myAdapter.dataList.addAll(dataList)
    }
}