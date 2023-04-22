package com.padc.csh.customuicomponentsassignment.mvp.presenters

import com.padc.csh.customuicomponentsassignment.delegates.ProfileDelegate
import com.padc.csh.customuicomponentsassignment.mvp.views.BaseView
import com.padc.csh.customuicomponentsassignment.mvp.views.MainView
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.presenters.AbstractBasePresenter
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.presenters.BasePresenter

interface MainPresenter:BasePresenter<MainView>,ProfileDelegate{
    fun onUiReaday()
}