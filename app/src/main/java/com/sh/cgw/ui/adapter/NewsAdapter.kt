package com.sh.cgw.ui.adapter

import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.sh.cgw.R
import com.sh.cgw.base.BaseRecyclerAdapter
import com.sh.cgw.base.BaseViewHolder
import com.sh.cgw.ui.bean.NewsBean
import kotlinx.android.synthetic.main.item_news.view.*

/**
 * 作者：created by cgw on 2019/6/25 23:44
 * 类注释：
 */
class NewsAdapter(ctx: Context, datas: MutableList<NewsBean.ResultBean.DataBean>, layoutId: Int) :
        BaseRecyclerAdapter<NewsBean.ResultBean.DataBean>(ctx, layoutId, datas) {

    override fun BaseViewHolder(view: View, type: Int): BaseViewHolder {
        return BaseViewHolder(view)
    }


    override fun showData(holder: BaseViewHolder, position: Int, datas: List<NewsBean.ResultBean.DataBean>) {
        val bean: NewsBean.ResultBean.DataBean = datas.get(position)

        holder.itemView.tv_title.text = bean.title
        holder.itemView.tv_author.text = bean.author_name
        holder.itemView.iv_time.text = bean.date
        Glide.with(holder.itemView.context)
                .load(bean.thumbnail_pic_s)
                .fitCenter()
                .error(R.mipmap.iv_error)
                .into(holder.itemView.iv_photo)
    }
}