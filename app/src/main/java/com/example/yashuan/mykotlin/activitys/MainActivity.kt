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
