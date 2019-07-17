package com.sh.cgw.utils

import android.content.Context
import android.content.SharedPreferences

import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

/**
 * 作者：created by cgw on 2019/7/1 23:07
 * 类注释：
 */
object SharePref {

    const val FILE_NAME = "share_data"
    /**
     *
     * @param context
     * @param key
     * @param object
     */
    fun put(context: Context, key: String, `object`: Any) {
        val sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        val edit = sp.edit()
        if (`object` is String) {
            edit.putString(key, `object`)
        } else if (`object` is Int) {
            edit.putInt(key, `object`)
        } else if (`object` is Boolean) {
            edit.putBoolean(key, `object`)
        } else if (`object` is Float) {
            edit.putFloat(key, `object`)
        } else if (`object` is Long) {
            edit.putLong(key, `object`)
        } else {
            edit.putString(key, `object`.toString())
        }
        edit.apply()
    }

    /**
     * 根据默认值得到类型
     * @param context
     * @param key
     * @param defaultObject
     */
    operator fun get(context: Context, key: String, defaultObject: Any): Any? {
        val sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        if (defaultObject is String) {
            return sharedPreferences.getString(key, defaultObject)
        } else if (defaultObject is Int) {
            return sharedPreferences.getInt(key, defaultObject)
        } else if (defaultObject is Boolean) {
            return sharedPreferences.getBoolean(key, defaultObject)
        } else if (defaultObject is Float) {
            return sharedPreferences.getFloat(key, defaultObject)
        } else if (defaultObject is Long) {
            return sharedPreferences.getLong(key, defaultObject)
        }
        return null
    }

    /**
     * 移除某个数据
     * @param context
     * @param key
     */
    fun remove(context: Context, key: String) {
        val sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.remove(key)
        editor.apply()
    }

    /**
     * 清除所有数据
     * @param context
     */
    fun clear(context: Context) {
        val sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.clear()
        editor.apply()
    }

    /**
     * 查询某条记录是否存在
     * @param context
     * @param key
     * @return
     */
    fun icContains(context: Context, key: String): Boolean {
        val sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        return sp.contains(key)
    }

    /**
     * 返回所有的键值对
     * @param context
     * @return
     */
    fun getAll(context: Context): Map<String, *> {
        val sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        return sp.all
    }

    private object SharePrefencesCompat {
        private var sApplyMethod: Method? = null

        init {
            try {
                sApplyMethod = findApplyMethod()
            } catch (e: NoSuchMethodException) {
                e.printStackTrace()
            }

        }

        @Throws(NoSuchMethodException::class)
        private fun findApplyMethod(): Method {
            val clz = SharedPreferences.Editor::class.java
            return clz.getMethod("apply")
        }

        @Throws(InvocationTargetException::class, IllegalAccessException::class)
        fun apply(editor: SharedPreferences.Editor) {
            if (sApplyMethod != null) {
                sApplyMethod!!.invoke(editor)//invoke通常用来执行一个方法
                return
            }
            editor.commit()
        }
    }
}
