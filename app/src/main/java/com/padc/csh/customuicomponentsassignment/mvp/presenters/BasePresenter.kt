package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padc.csh.customuicomponentsassignment.mvp.views.BaseView


interface BasePresenter<T : BaseView> {

    fun initPresenter(view: T)

}