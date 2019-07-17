package com.sh.cgw.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * 作者：created by cgw on 2019/6/25 21:33
 * 类注释：
 */
class VpAdapter(private var titles: List<String>, private var fragments:List<Fragment>, fm: FragmentManager?)
    : FragmentStatePagerAdapter(fm) {

    override fun getItem(p0: Int): Fragment {
        return fragments[p0]
    }

    override fun getCount(): Int {
        return titles.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return this.titles[position]
    }
}