package com.nguyenhoangthanhan.animationandroid.recycleview.dragdropitem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.ACTION_STATE_DRAG
import androidx.recyclerview.widget.ItemTouchHelper.DOWN
import androidx.recyclerview.widget.ItemTouchHelper.END
import androidx.recyclerview.widget.ItemTouchHelper.START
import androidx.recyclerview.widget.ItemTouchHelper.UP
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nguyenhoangthanhan.animationandroid.R
import com.nguyenhoangthanhan.animationandroid.databinding.ActivityDragDropItemRvactivityBinding

class DragDropItemRVActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDragDropItemRvactivityBinding

    private val items = (mutableListOf<String>()).also {
        it.add("Item 1")
        it.add("Item 2")
        it.add("Item 3")
        it.add("Item 4")
        it.add("Item 5")
        it.add("Item 6")
        it.add("Item 7")
        it.add("Item 8")
        it.add("Item 9")
        it.add("Item 10")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDragDropItemRvactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDemoDragDropItem.setHasFixedSize(true)
        binding.rvDemoDragDropItem.layoutManager = LinearLayoutManager(this)

        val adapter = StringItemAdapter(itemList = items)
        binding.rvDemoDragDropItem.adapter = adapter

        itemTouchHelper.attachToRecyclerView(binding.rvDemoDragDropItem)
    }

    private val itemTouchHelper by lazy {
        val simpleItemTouchCallBack =
            object : ItemTouchHelper.SimpleCallback(UP or DOWN or START or END, 0) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    val adapter = recyclerView.adapter as StringItemAdapter
                    val from = viewHolder.adapterPosition
                    val to = target.adapterPosition

                    adapter.notifyItemMoved(from, to)
                    return true
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                }

                override fun onSelectedChanged(
                    viewHolder: RecyclerView.ViewHolder?,
                    actionState: Int
                ) {
                    super.onSelectedChanged(viewHolder, actionState)

                    if (actionState == ACTION_STATE_DRAG){
                        viewHolder?.itemView?.alpha = 0.8f
                    }
                }

                override fun clearView(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder
                ) {
                    super.clearView(recyclerView, viewHolder)

                    viewHolder.itemView.alpha = 1f
                }

            }

        ItemTouchHelper(simpleItemTouchCallBack)
    }
}