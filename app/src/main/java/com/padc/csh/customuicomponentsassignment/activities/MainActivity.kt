package com.padc.csh.customuicomponentsassignment.activities

import android.content.Intent
import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.padc.csh.customuicomponentsassignment.R
import com.padc.csh.customuicomponentsassignment.adapters.ProfileViewAdater
import com.padc.csh.customuicomponentsassignment.adapters.TaskListAdatper
import com.padc.csh.customuicomponentsassignment.data.vos.ProfileVO
import com.padc.csh.customuicomponentsassignment.data.vos.TaskVO
import com.padc.csh.customuicomponentsassignment.fragments.UserProfileDialog
import com.padc.csh.customuicomponentsassignment.mvp.presenters.MainPresenter
import com.padc.csh.customuicomponentsassignment.mvp.presenters.MainPresenterImpl
import com.padc.csh.customuicomponentsassignment.mvp.views.MainView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),MainView {

    private lateinit var mPresenter:MainPresenter

    private lateinit var mProfileViewAdater: ProfileViewAdater
    private lateinit var mTaskAdapter:TaskListAdatper
    var dialog= UserProfileDialog()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.window.statusBarColor = resources.getColor(R.color.colorPrimary,null)

       /* window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)*/

        setUpPresenter()
        setUpRecycler()
        setUpListener()
        mPresenter.onUiReaday()

    }

    private fun setUpListener() {
        ivPlus.setOnClickListener {
            mPresenter.onCreateTask()
        }
    }

    private fun setUpPresenter() {
        mPresenter =ViewModelProvider(this)[MainPresenterImpl::class.java]
        mPresenter.initPresenter(this)

    }

    private fun setUpRecycler() {
        mProfileViewAdater= ProfileViewAdater(mPresenter)
        mTaskAdapter = TaskListAdatper(mPresenter)

        rvProfiles.addItemDecoration(MyItemDecoration())
        rvProfiles.adapter = mProfileViewAdater
        rvProfiles.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        rvTasks.adapter = mTaskAdapter
        rvTasks.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }

    override fun displayProfileLists(profileList: List<ProfileVO>) {
        mProfileViewAdater.setItemList(profileList)
    }

    override fun displayTaskList(taskList: List<TaskVO>) {
       mTaskAdapter.setItemList(taskList)
    }

    override fun onTapProfile(profileVO: ProfileVO) {
        window.statusBarColor = resources.getColor(R.color.colorPrimaryDark,null)
        dialog.show(supportFragmentManager,"MyFragment")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateTast() {
       startActivity(Intent(this,CreateTaskActivity::class.java))
    }

}

class MyItemDecoration : RecyclerView.ItemDecoration() {

    private val overlapValue = -20

    override fun getItemOffsets(outRect : Rect, view : View, parent : RecyclerView, state : RecyclerView.State) {

        val itemPosition: Int =parent.getChildAdapterPosition(view)
        if (itemPosition != 0) {
            outRect.set(overlapValue, 0, 0, 0)  // args is : left,top,right,bottom
        }

    }
}