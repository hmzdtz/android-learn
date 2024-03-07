package com.hmzdtz.androidlearn

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.hmzdtz.libandroidlearn.recyclerview.CenteredLinearLayoutManager

class MainActivity : AppCompatActivity() {
    val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val myAdapter = MyAdapter()
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = CenteredLinearLayoutManager(this, RecyclerView.HORIZONTAL)

        myAdapter.dataList.addAll(
            mutableListOf(
                MyAdapter.ItemData("背景介绍", "这个是用来介绍背景的", true),
                MyAdapter.ItemData("内容介绍1", "这个是用来介绍背景的", false),
                MyAdapter.ItemData("内容介绍2", "这个是用来介绍背景的", false),
                // MyAdapter.ItemData("内容介绍3", "这个是用来介绍背景的", false),
                // MyAdapter.ItemData("内容介绍4", "这个是用来介绍背景的", false),
            )
        )
    }
}