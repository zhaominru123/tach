package com.wd.tach.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import com.wd.health.kotlinlogin.presenter.LoginPresenter
import com.wd.tach.R
import com.wd.tach.model.LoginBean
import com.wd.tach.model.RsaCoder
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() ,Constract.ILoginView{
    lateinit var loginPresenter: LoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginPresenter = LoginPresenter()
        loginPresenter.attachView(this)
        //点击登录
        login.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                var phone = phone.text.toString().trim()
                var pwd = pwd.text.toString().trim()
                if (TextUtils.isEmpty(phone)){
                    "手机号不能为空".toast(this@MainActivity,Toast.LENGTH_SHORT)
                    return
                }
                if (TextUtils.isEmpty(pwd)){
                    "密码不能为空".toast(this@MainActivity,Toast.LENGTH_SHORT)
                    return
                }
                try {
                    var encryptPwd = RsaCoder.encryptByPublicKey(pwd)
                    Log.i("encryptPwd",encryptPwd)
                    loginPresenter.login(phone,encryptPwd)
                }catch (e : Exception){
                    e.printStackTrace()
                }
            }
        })

        //点击注册
        reigst.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                activityTiaozhuan(this@MainActivity,ReigstActivity().javaClass);
            }
        })
    }

    override fun loginSuccess(loginBean: LoginBean) {
        if (loginBean.getStatus().equals("0000")){
            loginBean.getMessage()!!.toast(this, Toast.LENGTH_SHORT)
            //跳转首页
            activityTiaozhuan(this,HomePageActivity().javaClass);
        }else{
            loginBean.getMessage()!!.toast(this, Toast.LENGTH_SHORT)
        }
    }

    //intent跳转封装
    fun activityTiaozhuan(ctx: Context,clazz:Class<Any>){
        var intent = Intent()
    intent.setClass(ctx,clazz)
    startActivity(intent)
}

    fun Any.toast(context: Context, duration: Int = Toast.LENGTH_SHORT): Toast {
        return Toast.makeText(context, this.toString(), duration).apply { show() }
    }

    override fun onDestroy() {
        super.onDestroy()
        loginPresenter.detachView()
    }
}
