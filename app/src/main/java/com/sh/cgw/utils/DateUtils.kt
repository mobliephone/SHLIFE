package com.sh.cgw.utils

import java.util.*

/**
 * 作者：created by cgw on 2019/7/4 21:34
 * 类注释：日期工具类
 */
class DateUtils {

    companion object{
        fun getYear(): Int{
            val calendar = Calendar.getInstance()
            return calendar.get(Calendar.YEAR)
        }

        fun getMonth(): Int{
            val calendar = Calendar.getInstance()
            return calendar.get(Calendar.MONTH)
        }

        fun getDay(): Int{
            val calendar = Calendar.getInstance()
            return calendar.get(Calendar.DATE)
        }
    }

}