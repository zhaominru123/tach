package com.wd.health.kotlinlogin.presenter


import com.wd.tach.model.OkHttpUtils
import com.wd.tach.model.RegisterBean
import com.wd.tach.view.Constract

/*
 *@Auther:赵敏如
 *@Date: 2019年
 *@Time:
 *@Description:
 * */class RegisterPresenter : BasePresenter<Constract.IRegisterView>() {

    fun register(phone:String, nickName:String,pwd:String){
        OkHttpUtils.instance.register(object : OkHttpUtils.IOkCallBackRegister {
            //注册
            override fun callRegisterSuccess(registerBean: RegisterBean) {
                getView()!!.registerSuccess(registerBean)
            }
        },phone,nickName,pwd)
    }

}