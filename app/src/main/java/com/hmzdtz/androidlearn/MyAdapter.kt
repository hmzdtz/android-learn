package com.hmzdtz.androidlearn

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    companion object {
        const val VIEW_TYPE_NORMAL = 0
        const val VIEW_TYPE_SELECTED = 1
    }

    val dataList = mutableListOf<ItemData>()

    var selectedIndex = 0
        set(value) {
            if (value == field) {
                return
            }

            lastSelectedIndex = field

            dataList[field].selected = false
            dataList[value].selected = true
            notifyItemChanged(field)
            notifyItemChanged(value)
            field = value
        }

    var lastSelectedIndex = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            when (viewType) {
                VIEW_TYPE_SELECTED -> {
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_selected, parent, false)
                }

                else -> {
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_normal, parent, false)
                }
            }
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            if (selectedIndex == position) {
                return@setOnClickListener
            }
            selectedIndex = position
        }

        holder.bindData(dataList[position])

        if (selectedIndex != lastSelectedIndex) {
            if (position == lastSelectedIndex) {
                holder.startUncheckAnim()
            } else if (position == selectedIndex) {
                holder.startCheckAnim()
            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (dataList[position].selected) {
            VIEW_TYPE_SELECTED
        } else {
            VIEW_TYPE_NORMAL
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView = itemView.findViewById<TextView>(R.id.title)
        private val contentTextView = itemView.findViewById<TextView>(R.id.content)

        fun bindData(itemData: ItemData) {
            titleTextView.text = itemData.title
            contentTextView.text = itemData.title
        }

        fun startCheckAnim() {
            val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 0.8f, 1.0f)
            val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 0.8f, 1.0f)
            val scaleAnimator: ObjectAnimator =
                ObjectAnimator.ofPropertyValuesHolder(itemView, scaleX, scaleY)
            scaleAnimator.interpolator = DecelerateInterpolator()
            scaleAnimator.setDuration(200)
            scaleAnimator.start()
        }

        fun startUncheckAnim() {
            val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 1.2f, 1.0f)
            val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.2f, 1.0f)
            val scaleAnimator: ObjectAnimator =
                ObjectAnimator.ofPropertyValuesHolder(itemView, scaleX, scaleY)
            scaleAnimator.interpolator = AccelerateInterpolator()
            scaleAnimator.setDuration(200)
            scaleAnimator.start()
        }
    }

    data class ItemData(
        var title: String = "",
        var content: String = "",
        var selected: Boolean = false
    )
}