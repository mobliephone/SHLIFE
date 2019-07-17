package com.sh.cgw.utils

import android.app.AlertDialog
import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.sh.cgw.R
import com.sh.cgw.ui.adapter.ConstellAdapter


/**
 * 作者：created by cgw on 2019/6/20 22:09
 * 类注释：弹出框
 */
class DialogShow {

    companion object{
        private lateinit var alertDialog: AlertDialog
        private lateinit var builder:AlertDialog.Builder

        fun showConDialog(context: Context, layoutId:Int, adapter: ConstellAdapter){

            builder = AlertDialog.Builder(context, R.style.show_dialog)
            builder.setCancelable(false)
            val view = View.inflate(context, layoutId, null)
            builder.setView(view).create()
            alertDialog = builder.show()

            val conRecycler: RecyclerView = view.findViewById(R.id.constell_recycler)
            val closeTv:ImageView = view.findViewById(R.id.iv_close)

            conRecycler.adapter = adapter
            conRecycler.layoutManager = LinearLayoutManager(context) as RecyclerView.LayoutManager?

            closeTv.setOnClickListener(object : View.OnClickListener{
                override fun onClick(v: View?) {
                    if (alertDialog.isShowing){
                        alertDialog.dismiss()
                    }
                }
            })

            adapter.setOnTvItemClickListener(object : ConstellAdapter.OnTvClickListener{
                override fun onTvClick(view: View, position: Int) {
                    if (alertDialog.isShowing){
                        alertDialog.dismiss()
                    }

                    val bean = adapter.getItemData(position)
                    onTvSelectItemListener!!.onTvSelectItem(bean!!.name)
                }
            })
        }

        private var onTvSelectItemListener: OnTvSelectItemListener? = null

        fun setOnTvSelectItemListener(onTvSelectItemListener: OnTvSelectItemListener){
            this.onTvSelectItemListener = onTvSelectItemListener
        }

        interface OnTvSelectItemListener{
            fun onTvSelectItem(name: String)
        }
    }
}