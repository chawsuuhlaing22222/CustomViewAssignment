package com.padc.csh.customuicomponentsassignment.mvp.presenters

import androidx.lifecycle.ViewModel
import com.padc.csh.customuicomponentsassignment.delegates.ProfileDelegate
import com.padc.csh.customuicomponentsassignment.mvp.views.DialogFragmentView
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.presenters.AbstractBasePresenter
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.presenters.BasePresenter

interface DialogFragmentPresenter:  BasePresenter<DialogFragmentView>,ProfileDelegate {
    fun onUiReady()
    fun onClose()
}