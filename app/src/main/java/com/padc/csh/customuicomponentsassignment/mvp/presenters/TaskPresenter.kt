package com.padc.csh.customuicomponentsassignment.mvp.presenters

import com.padc.csh.customuicomponentsassignment.delegates.ProfileDelegate
import com.padc.csh.customuicomponentsassignment.mvp.views.TaskView
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.presenters.BasePresenter

interface TaskPresenter :BasePresenter<TaskView>,ProfileDelegate{
    fun onUiReady()
}