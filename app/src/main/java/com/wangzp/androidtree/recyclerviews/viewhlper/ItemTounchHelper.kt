package com.wangzp.androidtree.recyclerviews.viewhlper

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.wangzp.androidtree.recyclerviews.ObjectData
import com.wangzp.androidtree.recyclerviews.WAdapter
import java.util.*
import kotlin.collections.ArrayList


/**
 * drag and move item of RecyclerView
 */
class ItemTounchHelper(val mData:ArrayList<ObjectData>,val mAdapter:WAdapter) : ItemTouchHelper.Callback() {

    //设置属性

    override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
        //设置flag
        var dragFlag = ItemTouchHelper.UP or  ItemTouchHelper.DOWN
        var  swipFlag = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        return makeMovementFlags(dragFlag,swipFlag)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder): Boolean {
      //更新adapter
        var from = viewHolder.getAdapterPosition();
        var to = target.getAdapterPosition();
        Collections.swap(mData, from, to);
        mAdapter.notifyItemMoved(from, to);
        return true;

    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        //更新agapter
        var pos = viewHolder.getAdapterPosition();
        mData.removeAt(pos)
        mAdapter.notifyItemRemoved(pos);
    }


//    override fun onSelectedChanged(viewHolder:RecyclerView.ViewHolder, actionState:Int) {
//        super.onSelectedChanged(viewHolder, actionState);
//        if(actionState != ItemTouchHelper.ACTION_STATE_IDLE){
//            NormalAdapter.VH holder = (NormalAdapter.VH)viewHolder;
//            holder.itemView.setBackgroundColor(0xffbcbcbc); //设置拖拽和侧滑时的背景色
//        }
//    }


    override fun clearView(recyclerView:RecyclerView , viewHolder:RecyclerView.ViewHolder ) {
        super.clearView(recyclerView, viewHolder);
//        NormalAdapter.VH holder = (NormalAdapter.VH)viewHolder;
//        holder.itemView.setBackgroundColor(0xffeeeeee); //背景色还原
    }

}