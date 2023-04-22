package com.padc.csh.customuicomponentsassignment.activities

import android.app.DatePickerDialog
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.text.format.DateFormat
import android.view.View
import android.widget.AdapterView
import android.widget.DatePicker
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.chip.Chip
import com.padc.csh.customuicomponentsassignment.R
import com.padc.csh.customuicomponentsassignment.adapters.ProfileViewAdater
import com.padc.csh.customuicomponentsassignment.data.vos.ProfileVO
import com.padc.csh.customuicomponentsassignment.mvp.presenters.TaskPresenter
import com.padc.csh.customuicomponentsassignment.mvp.presenters.TaskPresenterImpl
import com.padc.csh.customuicomponentsassignment.mvp.views.TaskView
import kotlinx.android.synthetic.main.activity_create_task.*
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
class CreateTaskActivity : AppCompatActivity(),TaskView {

    private lateinit var mPresenter: TaskPresenter
    private lateinit var mProfileAdapter:ProfileViewAdater
    private var selectedDate=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task)
        //this.window.statusBarColor = resources.getColor(R.color.colorPrimaryDark,null)

        setUpPresenter()
        setUpListener()
        setUpRecycler()
        mPresenter.onUiReady()

    }


    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[TaskPresenterImpl::class.java]
        mPresenter.initPresenter(this)
    }

    private fun setUpRecycler() {
        mProfileAdapter = ProfileViewAdater(mPresenter)
        rvAssignee.addItemDecoration(MyItemDecoration())
        rvAssignee.adapter = mProfileAdapter
        rvAssignee.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setUpListener() {
        //spinner of country code
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                (parent?.getChildAt(0) as TextView).setTextColor(
                    resources.getColor(
                        R.color.white,
                        theme
                    )
                )
                (parent?.getChildAt(0) as TextView).setPadding(0,0,0,20)

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        chipBackend.setOnClickListener {

            setCheckTrue(chipBackend)
            setUnCheck(chipDesign)
            setUnCheck(chipFrontend)
        }

        chipDesign.setOnClickListener {

            setCheckTrue(chipDesign)
            setUnCheck(chipBackend)
            setUnCheck(chipFrontend)
        }

        chipFrontend.setOnClickListener {

            setCheckTrue(chipFrontend)
            setUnCheck(chipBackend)
            setUnCheck(chipDesign)
        }

        tvStartDate.setOnClickListener {
            showDatePicker(tvStartDate)

        }

        tvEndDate.setOnClickListener {
            showDatePicker(tvEndDate)

        }

        ivBackTask.setOnClickListener{
            finish()
        }


    }

    private fun setDate(view:TextView) {
        //selectedDate= changeDateFormat(selectedDate)
        view.text=selectedDate.toString()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun showDatePicker(textView: TextView){
        val calendar= Calendar.getInstance()
        val day=calendar.get(Calendar.DAY_OF_MONTH)
        val month=calendar.get(Calendar.MONTH)
        val year=calendar.get(Calendar.YEAR)

        object : DatePickerDialog(this, null, year, month, day) {
            override fun onDateChanged(
                view: DatePicker,
                newYear: Int,
                newMonth: Int,
                dayOfMonth: Int
            ) {
                selectedDate="$newYear-${newMonth+1}-$dayOfMonth"
                selectedDate= changeDateFormat(selectedDate)
                setDate(textView)
                dismiss()
            }


        }.show()
    }


    override fun setUpAssignee(profileList: List<ProfileVO>) {
        mProfileAdapter.setItemList(profileList)
    }

    fun setCheckTrue(chip: Chip){
        chip.setChipBackgroundColorResource(R.color.colorAccent)
        chip.setTextColor(resources.getColor(R.color.white,null))
        chip.setChipIconTintResource(R.color.white)
    }

    fun setUnCheck(chip: Chip){
        chip.setChipBackgroundColorResource(R.color.colorPrimary)
        chip.setTextColor(resources.getColor(R.color.black,null))
       // chip.setChipIconTintResource(R.color.white)
        chip.isCheckable=false
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun changeDateFormat(date: String): String {

        val formattedDate = SimpleDateFormat("yyyy-M-d", Locale.US)
        val date = formattedDate.parse(date)
        return DateFormat.getMediumDateFormat(this).format(date)
    }

}