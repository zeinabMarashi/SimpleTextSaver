package com.example.simpletextsaver

import android.R
import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator


abstract class SwipeToDeleteCallBack(val context: Context) :
    ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
    val deleteColor = ContextCompat.getColor(context, R.color.background_light)
    val dalateIcon = R.drawable.ic_delete
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }


    open fun onSwipeChildDraw(c: Canvas?, recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
        RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            .addSwipeLeftBackgroundColor(deleteColor)
            .addSwipeLeftActionIcon(dalateIcon)
            .create()
            .decorate()
        super.onChildDraw(c!!, recyclerView!!, viewHolder!!, dX, dY, actionState, isCurrentlyActive)
    }
}


//package com.example.simpletextsaver
//
//import android.text.method.MovementMethod
//import androidx.recyclerview.widget.ItemTouchHelper
//import androidx.recyclerview.widget.RecyclerView
//
// abstract class SwipeToDeleteCallBack:ItemTouchHelper.Callback() {
//    override fun getMovementFlags(
//        recyclerView: RecyclerView,
//        viewHolder: RecyclerView.ViewHolder
//    ): Int {
//        val swipeFlags = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
//        return makeMovementFlags(0, swipeFlags)
//    }
//
//    override fun onMove(
//        recyclerView: RecyclerView,
//        viewHolder: RecyclerView.ViewHolder,
//        target: RecyclerView.ViewHolder
//    ): Boolean {
//        return false
//    }
//
//}