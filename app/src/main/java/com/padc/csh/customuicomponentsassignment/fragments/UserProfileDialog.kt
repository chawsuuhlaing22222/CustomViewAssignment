package com.padc.csh.customuicomponentsassignment.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.padc.csh.customuicomponentsassignment.R
import com.padc.csh.customuicomponentsassignment.adapters.TaskListAdatper
import com.padc.csh.customuicomponentsassignment.data.vos.ProfileVO
import com.padc.csh.customuicomponentsassignment.data.vos.TaskVO
import com.padc.csh.customuicomponentsassignment.dummy.tabNames
import com.padc.csh.customuicomponentsassignment.mvp.presenters.DialogFragmentPresenter
import com.padc.csh.customuicomponentsassignment.mvp.presenters.DialogFragmentPresenterImpl
import com.padc.csh.customuicomponentsassignment.mvp.views.DialogFragmentView
import kotlinx.android.synthetic.main.dialog_frament_profile.*

class UserProfileDialog:DialogFragment(),DialogFragmentView {

    private lateinit var mPresenter : DialogFragmentPresenter
    private  lateinit var mtaskAdapter : TaskListAdatper

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view=LayoutInflater.from(context).inflate(R.layout.dialog_frament_profile,container,false)
        return view
    }

    override fun getTheme(): Int {
        return R.style.DialogTheme
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        tabNames.forEach {

            tabLayout.newTab().apply {
                text=it
                tabLayout.addTab(this)
            }
        }

        setUpPresenter()
        setUpRecycler()
        mPresenter.onUiReady()


        flClose.setOnClickListener {
           mPresenter.onClose()
        }
    }

    private fun setUpRecycler() {
       mtaskAdapter = TaskListAdatper(mPresenter)
        rvProjectTasks.adapter= mtaskAdapter
        rvProjectTasks.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[DialogFragmentPresenterImpl::class.java]
        mPresenter.initPresenter(this)
    }

    override fun onShowProjectTasks(taskList: List<TaskVO>) {
      mtaskAdapter.setItemList(taskList)
    }

    override fun onTapProfile(profileVO: ProfileVO) {

    }

    override fun onClose() {
        this.dismiss()
       // activity?.setTheme(R.style.Theme_CustomUiComponentsAssignment)
        activity?.window?.statusBarColor = resources.getColor(R.color.colorPrimary,null)
    }
/*    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if (dialog != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            dialog.window?.setLayout(width, height)
        }
    }*/



}