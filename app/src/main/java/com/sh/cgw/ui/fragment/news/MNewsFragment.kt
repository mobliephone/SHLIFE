package com.sh.cgw.ui.fragment.news

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sh.cgw.R
import com.sh.cgw.ui.adapter.VpAdapter
import kotlinx.android.synthetic.main.fragment_mnews.*

/**
 * 作者：created by cgw on 2019/7/1 22:16
 * 类注释：
 */
class MNewsFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_mnews,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initData()
    }

    private fun initData() {
        val titles = mutableListOf<String>()
        titles.add("头条")
        titles.add("社会")
        titles.add("国内")
        titles.add("国际")
        titles.add("娱乐")
        titles.add("体育")
        titles.add("军事")
        titles.add("科技")
        titles.add("财经")
        titles.add("时尚")
        val fragments = mutableListOf<Fragment>()

        val topFragment = NewsFragment()
        val bundleTop = Bundle()
        bundleTop.putString("type","")
        topFragment.arguments = bundleTop
        fragments.add(topFragment)

        val sheFragment = NewsFragment()
        val bundleShe = Bundle()
        bundleShe.putString("type","shehui")
        sheFragment.arguments = bundleShe
        fragments.add(sheFragment)

        val guoNFragment = NewsFragment()
        val bundleGuoN = Bundle()
        bundleGuoN.putString("type","guonei")
        guoNFragment.arguments = bundleGuoN
        fragments.add(guoNFragment)

        val guoFragment = NewsFragment()
        val bundleGuo = Bundle()
        bundleGuo.putString("type","guoji")
        guoFragment.arguments = bundleGuo
        fragments.add(guoFragment)

        val yuFragment = NewsFragment()
        val bundleYu = Bundle()
        bundleYu.putString("type","yule")
        yuFragment.arguments = bundleYu
        fragments.add(yuFragment)

        val tiFragment = NewsFragment()
        val bundleTi = Bundle()
        bundleTi.putString("type","tiyu")
        tiFragment.arguments = bundleTi
        fragments.add(tiFragment)

        val junFragment = NewsFragment()
        val bundleJun = Bundle()
        bundleJun.putString("type","junshi")
        junFragment.arguments = bundleJun
        fragments.add(junFragment)

        val keFragment = NewsFragment()
        val bundleKe = Bundle()
        bundleKe.putString("type","keji")
        keFragment.arguments = bundleKe
        fragments.add(keFragment)

        val caiFragment = NewsFragment()
        val bundleCai = Bundle()
        bundleCai.putString("type","caijing")
        caiFragment.arguments = bundleCai
        fragments.add(caiFragment)

        val shiFragment = NewsFragment()
        val bundleShi = Bundle()
        bundleShi.putString("type","shishang")
        shiFragment.arguments = bundleShi
        fragments.add(shiFragment)

        val vpAdapter = VpAdapter(titles, fragments, childFragmentManager)
        viewPager.adapter = vpAdapter
        tabLayout.setViewPager(viewPager)
        viewPager.offscreenPageLimit = titles.size
    }
}