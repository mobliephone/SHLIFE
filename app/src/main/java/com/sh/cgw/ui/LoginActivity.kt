package com.sh.cgw.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import com.sh.cgw.R
import com.sh.cgw.http.Constants
import com.sh.cgw.http.RetrofitApi
import com.sh.cgw.ui.bean.LoginBean
import com.sh.cgw.utils.SharePref
import com.sh.cgw.utils.ToolShow
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.act_login.*

/**
 * 作者：created by cgw on 2019/6/18 22:36
 * 类注释：
 */
class LoginActivity: AppCompatActivity() {

    var userName: String = ""
    var password: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_login)
        initData()
    }


    private fun initData(){

        val isLogin = SharePref.get(this,"isLogin",false)
        if (isLogin as Boolean){
            val intent = Intent()
            intent.setClass(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            userName = SharePref.get(this,"userName","").toString()
            password = SharePref.get(this,"password","").toString()
            if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(password)){
                et_name.setText(userName)
                et_password.setText(password)
            }

            btn_login.setOnClickListener(object :View.OnClickListener{
                override fun onClick(v: View?) {
                    if (!verify()) return
                    requestData()
                }
            })
        }


    }


    @SuppressLint("CheckResult")
    private fun requestData(){
        RetrofitApi.retrofitService
                .loginService(Constants.USER_KEY,userName,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            result -> toJson(result)
//                            val intent = Intent()
//                            intent.setClass(this, MainActivity::class.java)
//                            startActivity(intent)
                        },
                        {
                            error -> ToolShow.show(error.message.toString(),this)
//                            val intent = Intent()
//                            intent.setClass(this, MainActivity::class.java)
//                            startActivity(intent)
//                            finish()
                        }
                )
    }

    private fun toJson(bean: LoginBean) {
        val code = bean.code
        val msg = bean.msg
        if (code == 200){
            ToolShow.show(msg, this)

            val intent = Intent()
            intent.setClass(this, MainActivity::class.java)
            startActivity(intent)

            val sharePre = SharePref
            sharePre.put(this,"userName",userName)
            sharePre.put(this,"password",password)

            sharePre.put(this,"isLogin", true)

            finish()
        } else{
            ToolShow.show(msg, this)
        }
    }

    private fun verify():Boolean{
        userName = et_name.text.toString()
        password = et_password.text.toString()

        //18408613853
        if (TextUtils.isEmpty(userName)){
            ToolShow.show("请输入手机号", this)
            return false
        }

        //123654
        if (TextUtils.isEmpty(password)){
            ToolShow.show("请输入密码", this)
            return false
        }

        return true
    }
}

