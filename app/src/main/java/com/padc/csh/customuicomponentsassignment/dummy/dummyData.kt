package com.padc.csh.customuicomponentsassignment.dummy

import com.padc.csh.customuicomponentsassignment.R
import com.padc.csh.customuicomponentsassignment.data.vos.ProfileVO
import com.padc.csh.customuicomponentsassignment.data.vos.TaskVO


 var progressProfileList= listOf<ProfileVO>(
    ProfileVO("mg",R.drawable.ic_person1)
)

 var doneProfileList= listOf<ProfileVO>(
    ProfileVO("mg",R.drawable.ic_person1),
    ProfileVO("ko",R.drawable.ic_person2)
)

 var reviewProfileList= listOf<ProfileVO>(
    ProfileVO("mg",R.drawable.ic_person1),
    ProfileVO("ko",R.drawable.ic_person2),
    ProfileVO("ko",R.drawable.ic_person3)
)
 var taskList = listOf<TaskVO>(
    TaskVO("In progress",R.color.colorProgress,progressProfileList),
    TaskVO("Done",R.color.colorDone,doneProfileList),
    TaskVO("Review",R.color.colorReview,reviewProfileList)
)


val tabNames = listOf<String>("Project Tasks","Contacts","About you")

