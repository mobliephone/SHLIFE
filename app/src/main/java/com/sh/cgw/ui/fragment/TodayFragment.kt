package com.sh.cgw.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sh.cgw.R
import com.sh.cgw.http.Constants
import com.sh.cgw.http.RetrofitApi
import com.sh.cgw.ui.adapter.TodayAdapter
import com.sh.cgw.ui.bean.TodayBean
import com.sh.cgw.utils.DateUtils
import com.sh.cgw.utils.ToolShow
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_today.*

/**
 * 作者：created by cgw on 2019/7/2 22:29
 * 类注释：历史的今天
 */
class TodayFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_today,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requestData()
    }

    private fun requestData() {
        RetrofitApi
                .todayRetrofit
                .todayHistory(Constants.TODAY_KEY,"1.0", DateUtils.getMonth(),DateUtils.getDay())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (
                        {
                            result-> initData(result)
                        },
                        {

                            error-> ToolShow.show(error.message.toString(), activity!!.applicationContext)
                        }
                )

    }

    private fun initData(bean: TodayBean) {

        val todayAdapter = TodayAdapter(activity!!.applicationContext,R.layout.item_today,bean.result)
        recycler_today.adapter = todayAdapter
        recycler_today.layoutManager = LinearLayoutManager(context
                , LinearLayoutManager.VERTICAL,false)

        todayAdapter.addData(bean.result)
        todayAdapter.notifyDataSetChanged()
    }
}