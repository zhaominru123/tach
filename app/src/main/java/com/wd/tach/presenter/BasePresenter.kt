package com.wd.health.kotlinlogin.presenter
import com.wd.tach.view.IBaseView


/*
 *@Auther:赵敏如
 *@Date: 2019年
 *@Time:
 *@Description:
 * */open class BasePresenter<V : IBaseView> {
    private var mView: V? = null

    fun attachView(v: V) {
        this.mView = v
    }

    fun detachView() {
        this.mView = null
    }

    fun getView(): V? {
        return mView
    }
}