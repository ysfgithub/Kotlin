package com.example.yashuan.mykotlin.activitys

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.yashuan.mykotlin.R
import com.example.yashuan.mykotlin.interfaces.ILoginAcvt
import com.example.yashuan.mykotlin.modles.User
import com.example.yashuan.mykotlin.presenters.ILoginPresenter
import com.example.yashuan.mykotlin.presenters.ILoginPresenterImpl

import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

class MainActivity : Activity(), ILoginAcvt, View.OnClickListener {


    private lateinit var et: TextView
    private lateinit var clickMe: View
    private lateinit var iLoginPresenter: ILoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et = findViewById(R.id.et);
        clickMe = findViewById(R.id.tv)
        clickMe.setOnClickListener(this)
        iLoginPresenter = ILoginPresenterImpl(this)

        AppCenter.start(application, "59ad5e45-3e64-41f9-8b00-9a00654902b5",
                Analytics::class.java, Crashes::class.java)
        AppCenter.setLogLevel(Log.VERBOSE);

        Log.v("app_center","App Center SDK configured in acmeworkspace  successfully")
    }

    override fun login() {
        var user = User()
        user.account = "kotlin";
        Log.i("acme", user.account);
        var intent = Intent(this, SecondAct::class.java)
        intent.putExtra("acount", "xiaoming_"
                + user.account + et.text.toString())
        startActivity(intent);
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv -> iLoginPresenter.doLogin()
            else -> {
                Toast.makeText(this, "no touch", Toast.LENGTH_LONG).show()
            }
        }
    }
}
