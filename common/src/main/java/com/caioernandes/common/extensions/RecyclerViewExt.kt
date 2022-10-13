package com.caioernandes.common.extensions

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.onLastItemScrollListener(onLoadMore: () -> Unit) {
    addOnScrollListener(object :
        RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val lastVisibleItemPosition =
                (recyclerView.layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition()
            val itemTotalCount = (recyclerView.adapter?.itemCount ?: 0) - 1
            if (lastVisibleItemPosition == itemTotalCount) {
                onLoadMore.invoke()
            }
        }
    })
}