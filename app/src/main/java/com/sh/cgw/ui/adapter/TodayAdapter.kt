package com.sh.cgw.ui.adapter

import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.sh.cgw.R
import com.sh.cgw.base.BaseRecyclerAdapter
import com.sh.cgw.base.BaseViewHolder
import com.sh.cgw.ui.bean.TodayBean
import kotlinx.android.synthetic.main.item_today.view.*
import kotlinx.android.synthetic.main.item_today.view.iv_photo
import kotlinx.android.synthetic.main.item_today.view.tv_title

/**
 * 作者：created by cgw on 2019/7/2 23:26
 * 类注释：
 */
class TodayAdapter(context: Context, layoutId: Int, datas: MutableList<TodayBean.ResultBean>)
    : BaseRecyclerAdapter<TodayBean.ResultBean>(context, layoutId, datas) {
    override fun showData(holder: BaseViewHolder, position: Int, datas: List<TodayBean.ResultBean>) {
        var bean = datas.get(position)

        holder.itemView.tv_title.text = bean.title
        holder.itemView.tv_des.text = bean.des
        holder.itemView.tv_lunar.text = bean.lunar
        Glide.with(holder.itemView.context)
                .load(bean.pic)
                .fitCenter()
                .error(R.mipmap.iv_error)
                .into(holder.itemView.iv_photo)
    }

    override fun BaseViewHolder(view: View, type: Int): BaseViewHolder {
        return BaseViewHolder(view,type)
    }
}