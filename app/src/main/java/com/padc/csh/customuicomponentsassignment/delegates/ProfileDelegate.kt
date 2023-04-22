package com.padc.csh.customuicomponentsassignment.delegates

import com.padc.csh.customuicomponentsassignment.data.vos.ProfileVO

interface ProfileDelegate {
    fun onTapProfile(profileVO: ProfileVO)
    fun onCreateTask()
}