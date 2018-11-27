package com.example.yashuan.mykotlin.presenters

import com.example.yashuan.mykotlin.interfaces.ILoginAcvt

class ILoginPresenterImpl : ILoginPresenter {

    var iLoginAcvt: ILoginAcvt;

    constructor(iLoginAcvt: ILoginAcvt) {
        this.iLoginAcvt = iLoginAcvt;
    }

    override fun doLogin() {
        iLoginAcvt.login()
    }
}