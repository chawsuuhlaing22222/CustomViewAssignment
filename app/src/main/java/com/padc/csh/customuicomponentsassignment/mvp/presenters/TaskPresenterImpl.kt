package com.padc.csh.customuicomponentsassignment.mvp.presenters

import androidx.lifecycle.ViewModel
import com.padc.csh.customuicomponentsassignment.data.vos.ProfileVO
import com.padc.csh.customuicomponentsassignment.dummy.reviewProfileList
import com.padc.csh.customuicomponentsassignment.mvp.views.TaskView
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.presenters.AbstractBasePresenter
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.presenters.BasePresenter

class TaskPresenterImpl:TaskPresenter, AbstractBasePresenter<TaskView>() {
    override fun onUiReady() {
       mView?.setUpAssignee(reviewProfileList)
    }

    override fun onTapProfile(profileVO: ProfileVO) {

    }

    override fun onCreateTask() {

    }
}