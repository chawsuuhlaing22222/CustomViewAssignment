package com.padc.csh.customuicomponentsassignment.viewpods

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.padc.csh.customuicomponentsassignment.data.vos.ProfileVO
import kotlinx.android.synthetic.main.view_holder_profile_item.view.*
import kotlinx.android.synthetic.main.view_pod_profile.view.*

class ProfileInfoViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun setUpData(profileVO: ProfileVO){
        vpProfile.setImageResource(profileVO.url)
    }
}