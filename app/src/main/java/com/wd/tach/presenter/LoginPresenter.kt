package com.wd.health.kotlinlogin.presenter


import com.wd.tach.model.LoginBean
import com.wd.tach.model.OkHttpUtils
import com.wd.tach.view.Constract


/*
 *@Auther:赵敏如
 *@Date: 2019年
 *@Time:
 *@Description:
 * */class LoginPresenter:BasePresenter<Constract.ILoginView>() {

    fun login(phone:String,pwd:String){
        OkHttpUtils.instance.login(object : OkHttpUtils.IOkCallBack {
            override fun callSuccess(loginBean: LoginBean) {
                getView()!!.loginSuccess(loginBean)
            }
        },phone,pwd)
    }
}
