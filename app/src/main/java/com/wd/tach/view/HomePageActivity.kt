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

class HomePageActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

    }


}
