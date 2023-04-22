package com.padc.csh.customuicomponentsassignment.mvp.views

import com.padc.csh.customuicomponentsassignment.data.vos.ProfileVO
import com.padc.csh.customuicomponentsassignment.data.vos.TaskVO

interface DialogFragmentView:BaseView {

    fun onShowProjectTasks(taskList: List<TaskVO>)
    fun onTapProfile(profileVO: ProfileVO)
    fun onClose()
}