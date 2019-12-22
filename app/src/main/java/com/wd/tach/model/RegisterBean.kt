package com.wd.tach.model

/*
 *@Auther:赵敏如
 *@Date: 2019年
 *@Time:
 *@Description:
 * */class RegisterBean {
    /**
     * message : 注册成功
     * status : 0000
     */

    private var message: String? = null
    private var status: String? = null

    fun getMessage(): String? {
        return message
    }

    fun setMessage(message: String) {
        this.message = message
    }

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String) {
        this.status = status
    }
}