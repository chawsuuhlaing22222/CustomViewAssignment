package com.padc.csh.customuicomponentsassignment.mvp.presenters

import com.padc.csh.customuicomponentsassignment.data.vos.ProfileVO
import com.padc.csh.customuicomponentsassignment.dummy.taskList
import com.padc.csh.customuicomponentsassignment.mvp.views.DialogFragmentView
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.presenters.AbstractBasePresenter

class DialogFragmentPresenterImpl:DialogFragmentPresenter,
    AbstractBasePresenter<DialogFragmentView>() {
    override fun onUiReady() {
        mView?.onShowProjectTasks(taskList)
    }

    override fun onTapProfile(profileVO: ProfileVO) {
      mView?.onTapProfile(profileVO)
    }

    override fun onCreateTask() {

    }

   override fun onClose(){
        mView?.onClose()
    }
}