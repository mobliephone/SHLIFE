package com.sh.cgw.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sh.cgw.R
import com.sh.cgw.http.Constants
import com.sh.cgw.http.RetrofitApi
import com.sh.cgw.ui.bean.IdiomBean
import com.sh.cgw.utils.ToolShow
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_idiom.*

/**
 * 作者：created by cgw on 2019/7/15 23:05
 * 类注释：成语
 */
class IdiomFragment: Fragment() {

    private var idiomName: String = "亡羊补牢"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_idiom, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requestData(idiomName)
        initData()
    }

    private fun initData() {

        btn_search.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                idiomName = et_idiom.text.toString()

                if (!TextUtils.isEmpty(idiomName)){

                    requestData(idiomName)
                } else {

                    ToolShow.show("请输入要查询的成语", activity!!.applicationContext )
                }
            }
        })
    }

    fun requestData(idiomName: String){
        RetrofitApi.odiomRetrofit.idiom(idiomName, Constants.IDIOM_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (
                        {
                            result -> verifyData(result)
                        },
                        {
                            error -> ToolShow.show(error.toString(), activity!!.applicationContext)
                        }
                )
    }

    private fun verifyData(bean: IdiomBean) {
        odiom.text = idiomName
        pinyin.text = bean.result.pinyin
        chengyujs.text = bean.result.chengyujs
        from.text = bean.result.from_
        example.text = bean.result.example
        yufa.text = bean.result.yufa
        yinzhengjs.text = bean.result.yinzhengjs
    }

}