package com.sh.cgw.ui.adapter

import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.sh.cgw.base.BaseRecyclerAdapter
import com.sh.cgw.base.BaseViewHolder
import com.sh.cgw.ui.bean.SelectConBean
import kotlinx.android.synthetic.main.item_constell.view.*

/**
 * 作者：created by cgw on 2019/6/25 23:44
 * 类注释：
 */
class ConstellAdapter(ctx: Context, datas: MutableList<SelectConBean>, layoutId: Int) :
        BaseRecyclerAdapter<SelectConBean>(ctx, layoutId, datas) {

    private var onTvClickListener: OnTvClickListener? = null

    override fun BaseViewHolder(view: View, type: Int): BaseViewHolder {
        return BaseViewHolder(view)
    }


    override fun showData(holder: BaseViewHolder, position: Int, datas: List<SelectConBean>) {
        val bean: SelectConBean = datas.get(position)

        holder.itemView.tv_constell.text = bean.name
        holder.itemView.setOnClickListener {
            onTvClickListener!!.onTvClick(holder.itemView,position)
        }
    }

    fun setOnTvItemClickListener(onTvClickListener: OnTvClickListener){
        this.onTvClickListener = onTvClickListener
    }


    interface OnTvClickListener{
        fun onTvClick(view: View, position: Int)
    }
}