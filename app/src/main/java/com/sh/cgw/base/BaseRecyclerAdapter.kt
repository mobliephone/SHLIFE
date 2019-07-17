package com.sh.cgw.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * 作者：created by cgw on 2019/6/25 22:32
 * 类注释：
 */
abstract class BaseRecyclerAdapter<T: Any>(
        private val context: Context,
        private val layoutId: Int,
        private val datas: MutableList<T>) : RecyclerView.Adapter<BaseViewHolder>() {

    fun addData(mDatas: List<T>){
        datas.addAll(mDatas)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): BaseViewHolder {
        val view = LayoutInflater.from(context).inflate(layoutId, parent, false)
        return BaseViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        showData(holder, position, datas)
    }

    fun getItemData(position: Int): T? {
        if (datas.size > position){
            return datas.get(position)
        }
        return null
    }

    abstract fun showData(holder:BaseViewHolder, position:Int, datas: List<T>)

    abstract fun BaseViewHolder(view:View,type: Int):BaseViewHolder
}