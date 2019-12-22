package com.wd.tach.view


import com.wd.tach.model.LoginBean
import com.wd.tach.model.RegisterBean


/*
 *@Auther:赵敏如
 *@Date: 2019年
 *@Time:
 *@Description:
 * */interface Constract {

    //登录
    interface ILoginView : IBaseView {
        fun loginSuccess(loginBean: LoginBean)
    }

    //注册
    interface IRegisterView : IBaseView {
        fun registerSuccess(registerBean: RegisterBean)
    }
}