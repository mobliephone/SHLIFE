package com.sh.cgw.ui.fragment.news

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sh.cgw.R
import com.sh.cgw.http.Constants
import com.sh.cgw.http.RetrofitApi
import com.sh.cgw.ui.adapter.NewsAdapter
import com.sh.cgw.ui.bean.NewsBean
import com.sh.cgw.utils.ToolShow
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_news.*

/**
 * 作者：created by cgw on 2019/6/25 21:27
 * 类注释：
 */
class NewsFragment: Fragment() {

    private var type: String = ""

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        type = arguments!!.getString("type")
        requestData(type)
    }

    private fun requestData(type: String) {
        RetrofitApi
                .newsRetrofit
                .newsService(type,Constants.NEWS_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            result-> initData(result)
                        },
                        {
                            error-> ToolShow.show(error.message.toString(), activity!!.applicationContext)
                        }
                )
    }

    private fun initData(bean: NewsBean) {

        val newsAdapter = NewsAdapter(activity!!.applicationContext,bean.result.data,R.layout.item_news)
        recycler_news.adapter = newsAdapter
        recycler_news.layoutManager = LinearLayoutManager(context
                ,LinearLayoutManager.VERTICAL,false)

        newsAdapter.addData(bean.result.data)
        newsAdapter.notifyDataSetChanged()
    }

}