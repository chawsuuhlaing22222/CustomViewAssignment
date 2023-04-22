package com.padc.csh.customuicomponentsassignment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padc.csh.customuicomponentsassignment.R
import com.padc.csh.customuicomponentsassignment.data.vos.ProfileVO
import com.padc.csh.customuicomponentsassignment.delegates.ProfileDelegate
import com.padc.csh.customuicomponentsassignment.viewholders.ProfileViewHolder
import kotlinx.android.synthetic.main.view_holder_profile_item.view.*

class ProfileViewAdater(var profileDelegate: ProfileDelegate): RecyclerView.Adapter<ProfileViewHolder>() {

    private var itemList= listOf<ProfileVO>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.view_holder_profile_item,parent,false)
        return ProfileViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {

        //if(position != itemList.count()){
            var profileVO = itemList[position]
            holder.itemView.ivProfileVH.visibility = View.VISIBLE
            holder.itemView.ivPlus.visibility = View.GONE
            holder.itemView.ivProfileVH.setImageResource(profileVO.url)
      /*  }else{
            holder.itemView.ivProfileVH.visibility = View.GONE
            holder.itemView.ivPlus.visibility = View.VISIBLE
        }*/

        holder.itemView.ivProfileVH.setOnClickListener {
            profileVO?.let { it1 -> profileDelegate.onTapProfile(it1) }
        }

        holder.itemView.ivPlus.setOnClickListener {
           profileDelegate.onCreateTask()
        }


    }

    override fun getItemCount(): Int {
        return itemList.count()
    }

    fun setItemList(profileList: List<ProfileVO>) {
         itemList = profileList
    }
}