package com.sh.cgw.ui.fragment

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sh.cgw.R
import com.sh.cgw.http.Constants
import com.sh.cgw.http.RetrofitApi
import com.sh.cgw.ui.adapter.ConstellAdapter
import com.sh.cgw.ui.bean.ConstellationBean
import com.sh.cgw.ui.bean.SelectConBean
import com.sh.cgw.utils.DialogShow
import com.sh.cgw.utils.ToolShow
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_constellation.*
import org.apache.commons.lang.StringUtils

/**
 * 作者：created by cgw on 2019/7/4 23:06
 * 类注释：星座
 */
class ConstellationFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_constellation,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requestData("白羊座")
        initListener()
    }


    private fun requestData(consName:String){
        RetrofitApi
                .constellationRetrofit
                .constellation(consName,
                        "today",
                        Constants.CONSTELLATION_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (
                        {
                           result -> initData(result)
                        },
                        {
                          error -> ToolShow.show(error.message.toString(), activity!!.applicationContext)
                        }
                )
    }

    private fun initData(bean: ConstellationBean) {

        name.text = bean.name
        datetime.text = bean.datetime
        color.text = "幸运色：${bean.color}"
        QFriend.text = "幸运星座：${bean.qFriend}"
        number.text = "幸运数字：${bean.number}"

        all.text = "综合 ${bean.all}"
        all_barView.setValue(strToFloat(bean.all))
        all_barView.setValueSignColor(Color.parseColor("#9932CC"))

        health.text = "健康 ${bean.health}"
        health_barView.setValue(strToFloat(bean.health))
        health_barView.setValueSignColor(Color.parseColor("#6495ED"))

        love.text = "爱情 ${bean.love}"
        love_barView.setValue(strToFloat(bean.love))
        love_barView.setValueSignColor(Color.parseColor("#00FFFF"))

        money.text = "财运 ${bean.money}"
        money_barView.setValue(strToFloat(bean.money))
        money_barView.setValueSignColor(Color.parseColor("#3CB371"))

        work.text = "工作 ${bean.work}"
        work_barView.setValue(strToFloat(bean.work))
        work_barView.setValueSignColor(Color.parseColor("#F0E68C"))

        summary.text = bean.summary
    }

    private fun strToFloat( str: String): Float{
        return  StringUtils.substringBeforeLast(str, "%").toFloat()
    }

    private fun initListener() {


        val constellAdapter = ConstellAdapter(activity!!.applicationContext,selectDatas(),R.layout.item_constell )

        fab_select.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                DialogShow.showConDialog(requireActivity(), R.layout.dialog_constell, constellAdapter)
            }
        })

        DialogShow.setOnTvSelectItemListener(object : DialogShow.Companion.OnTvSelectItemListener{

            override fun onTvSelectItem(name: String) {
                requestData(name)
            }
        })
    }

    private fun selectDatas():MutableList<SelectConBean>{
        val datas: MutableList<SelectConBean> = ArrayList()
        datas.add(SelectConBean(1,"白羊座"))
        datas.add(SelectConBean(1,"金牛座"))
        datas.add(SelectConBean(1,"双子座"))
        datas.add(SelectConBean(1,"巨蟹座"))
        datas.add(SelectConBean(1,"狮子座"))
        datas.add(SelectConBean(1,"处女座"))
        datas.add(SelectConBean(1,"天秤座"))
        datas.add(SelectConBean(1,"天蝎座"))
        datas.add(SelectConBean(1,"射手座"))
        datas.add(SelectConBean(1,"摩羯座"))
        datas.add(SelectConBean(1,"水瓶座"))
        datas.add(SelectConBean(1,"双鱼座"))
        return datas
    }
}