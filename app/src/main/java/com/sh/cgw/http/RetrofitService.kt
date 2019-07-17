package com.sh.cgw.http

import com.sh.cgw.ui.bean.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import java.time.Month

/**
 * 作者：created by cgw on 2019/6/19 22:08
 * 类注释：
 */
interface RetrofitService {

    /**
     * 登陆
     */
    @GET("/login")
    fun loginService(
            @Query("key") key: String,
            @Query("phone") phone: String,
            @Query("passwd") passwd: String
    ):Observable<LoginBean>

    /**
     * 新闻
     */
    @GET("index")
    fun newsService(
            @Query("type") type: String,
            @Query("key") key: String
    ):Observable<NewsBean>

    /**
     * 历史上的今天
     */
    @GET("toh")
    fun todayHistory(
            @Query("key") key: String,
            @Query("v") v:String,
            @Query("month") month: Int,
            @Query("day") day:Int
    ):Observable<TodayBean>

    /**
     * 星座
     */
    @GET("constellation/getAll")
    fun constellation(
            @Query("consName") consName: String,
            @Query("type") type: String,
            @Query("key") key: String
    ): Observable<ConstellationBean>

    /**
     * 成语
     */
    @GET("chengyu/query")
    fun idiom(
            @Query("word") word: String,
            @Query("key") key: String
    ):Observable<IdiomBean>

}