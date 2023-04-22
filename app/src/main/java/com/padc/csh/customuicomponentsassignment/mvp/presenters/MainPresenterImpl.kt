package com.padc.csh.customuicomponentsassignment.mvp.presenters

import android.graphics.Color
import com.padc.csh.customuicomponentsassignment.R
import com.padc.csh.customuicomponentsassignment.data.vos.ProfileVO
import com.padc.csh.customuicomponentsassignment.data.vos.TaskVO
import com.padc.csh.customuicomponentsassignment.dummy.reviewProfileList
import com.padc.csh.customuicomponentsassignment.dummy.taskList
import com.padc.csh.customuicomponentsassignment.mvp.views.BaseView
import com.padc.csh.customuicomponentsassignment.mvp.views.MainView
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.presenters.AbstractBasePresenter

class MainPresenterImpl:MainPresenter, AbstractBasePresenter<MainView>() {


    override fun onUiReaday() {
      mView?.displayTaskList(taskList)
      mView?.displayProfileLists(reviewProfileList)
    }


    override fun onTapProfile(profileVO: ProfileVO) {
       mView?.onTapProfile(profileVO = profileVO)
    }

    override fun onCreateTask() {
        mView?.onCreateTast()
    }
}