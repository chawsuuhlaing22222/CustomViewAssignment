package com.padc.csh.customuicomponentsassignment.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.padc.csh.customuicomponentsassignment.R
import com.padc.csh.customuicomponentsassignment.activities.MyItemDecoration
import com.padc.csh.customuicomponentsassignment.data.vos.ProfileVO
import com.padc.csh.customuicomponentsassignment.data.vos.TaskVO
import com.padc.csh.customuicomponentsassignment.delegates.ProfileDelegate
import com.padc.csh.customuicomponentsassignment.viewholders.TaskListViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.view_holder_task.view.*

class TaskListAdatper(var profileDelegate: ProfileDelegate): RecyclerView.Adapter<TaskListViewHolder>() {
    private var taskList = listOf<TaskVO>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_task,parent,false)
        return TaskListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TaskListViewHolder, position: Int) {

        val task=taskList.get(position)
        holder.itemView.tvState.text = task.state.toString()
        task.color?.let { holder.itemView.tvState.setTextColor(holder.itemView.resources.getColor(it,null)) }
       // setUpRecycler(task.profileList)

        var mProfileViewAdater= ProfileViewAdater(profileDelegate)
        holder.itemView.rvProfileVH.addItemDecoration(MyItemDecoration())
        holder.itemView.rvProfileVH.adapter = mProfileViewAdater
        holder.itemView.rvProfileVH.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL,false)
        task.profileList?.let { mProfileViewAdater.setItemList(it) }
    }

    private fun setUpRecycler(profileList: List<ProfileVO>?) {

    }

    override fun getItemCount(): Int {

        return taskList.size
    }

    fun setItemList(taskList: List<TaskVO>) {
        this.taskList = taskList
    }
}