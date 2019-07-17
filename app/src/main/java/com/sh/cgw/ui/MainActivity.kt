package com.sh.cgw.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.chaychan.library.BottomBarItem
import com.chaychan.library.BottomBarLayout
import com.sh.cgw.R
import com.sh.cgw.ui.fragment.ConstellationFragment
import com.sh.cgw.ui.fragment.IdiomFragment
import com.sh.cgw.ui.fragment.TodayFragment
import com.sh.cgw.ui.fragment.news.MNewsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var currentFragment = Fragment()
    private val news = MNewsFragment()
    private val today = TodayFragment()
    private val constell = ConstellationFragment()
    private val idiom = IdiomFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
    }

    private fun initData(){
        switchFragment(news).commit()

        bottomBar.setOnItemSelectedListener(object : BottomBarLayout.OnItemSelectedListener{
            override fun onItemSelected(item: BottomBarItem?, mCurrentItem: Int, currentIndex: Int) {
                when(item!!.id){
                    R.id.bottomBar_news -> switchFragment(news).commit()
                    R.id.bottomBar_today -> switchFragment(today).commit()
                    R.id.bottomBar_constell -> switchFragment(constell).commit()
                    R.id.bottomBar_idiom -> switchFragment(idiom).commit()
                }
            }
        })
    }


    fun switchFragment(targetFragment: Fragment):FragmentTransaction{
        val beginTransaction = supportFragmentManager.beginTransaction()
        if (!targetFragment.isAdded){
            beginTransaction.add(R.id.main_fragment, targetFragment,
                    targetFragment.javaClass.name).hide(currentFragment)
        } else {
            beginTransaction.hide(currentFragment).show(targetFragment)
        }

        currentFragment = targetFragment
        return beginTransaction
    }

}




