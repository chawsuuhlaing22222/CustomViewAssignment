package com.padc.csh.customuicomponentsassignment.mvp.views

import com.padc.csh.customuicomponentsassignment.data.vos.ProfileVO
import com.padc.csh.customuicomponentsassignment.data.vos.TaskVO

interface MainView:BaseView {
    fun displayProfileLists(profileList: List<ProfileVO>)
    fun displayTaskList(taskList:List<TaskVO>)
    fun onTapProfile(profileVO: ProfileVO)
    fun onCreateTast()
}