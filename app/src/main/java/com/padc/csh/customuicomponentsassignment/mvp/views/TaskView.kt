package com.padc.csh.customuicomponentsassignment.mvp.views

import com.padc.csh.customuicomponentsassignment.data.vos.ProfileVO

interface TaskView:BaseView {

    fun setUpAssignee(profileList: List<ProfileVO>)
}