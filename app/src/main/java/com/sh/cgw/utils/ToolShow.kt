package com.sh.cgw.utils

import android.content.Context
import android.widget.Toast

/**
 * 作者：created by cgw on 2019/6/19 22:59
 * 类注释：
 */
class ToolShow {

    companion object{

        fun show(msg:String, context: Context){
            Toast.makeText(context,msg,Toast.LENGTH_LONG).show()
        }
    }
}