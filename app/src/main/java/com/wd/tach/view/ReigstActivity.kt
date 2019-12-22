package com.wd.tach.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import com.wd.health.kotlinlogin.presenter.RegisterPresenter
import com.wd.tach.R
import com.wd.tach.model.RegisterBean
import com.wd.tach.model.RsaCoder
import kotlinx.android.synthetic.main.activity_reigst.*
import java.lang.Exception

class ReigstActivity : AppCompatActivity(),Constract.IRegisterView {
    lateinit var registerPresenter: RegisterPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reigst)
        registerPresenter = RegisterPresenter()
        registerPresenter.attachView(this)
        //点击注册
        btn_register.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                var phone = phone_register.text.toString().trim()
                var pwd = pwd_register.text.toString().trim()
                var nickName = nickName.text.toString().trim()
                if (TextUtils.isEmpty(nickName)) {
                    "用户姓名不能为空".toast(this@ReigstActivity, Toast.LENGTH_SHORT)
                    return
                }
                if (TextUtils.isEmpty(phone)) {
                    "手机号不能为空".toast(this@ReigstActivity, Toast.LENGTH_SHORT)
                    return
                }
                if (TextUtils.isEmpty(pwd)) {
                    "密码不能为空".toast(this@ReigstActivity, Toast.LENGTH_SHORT)
                    return
                }
                try {
                    var encryptPwd = RsaCoder.encryptByPublicKey(pwd)
                    Log.i("encryptPwd", encryptPwd)
                    registerPresenter.register(phone, nickName, encryptPwd)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        })
    }
    override fun registerSuccess(registerBean: RegisterBean) {
        if (registerBean.getStatus().equals("0000")){
            registerBean.getMessage()!!.toast(this, Toast.LENGTH_SHORT)
            finish()
        }else{
            registerBean.getMessage()!!.toast(this, Toast.LENGTH_SHORT)
            return
        }
    }
    fun Any.toast(context: Context, duration: Int = Toast.LENGTH_SHORT): Toast {
        return Toast.makeText(context, this.toString(), duration).apply { show() }
    }

    override fun onDestroy() {
        super.onDestroy()
        registerPresenter.detachView()
    }
}
