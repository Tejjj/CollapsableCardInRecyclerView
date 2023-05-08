package com.example.collapsablecardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.collapsablecardview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var lBinding: ActivityMainBinding

    private lateinit var parentList: ArrayList<ParentItem>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        lBinding.parentRecyclerView.setHasFixedSize(true)
        lBinding.parentRecyclerView.layoutManager = LinearLayoutManager(this)

        initData()

        lBinding.parentRecyclerView.adapter = ParentRecyclerViewAdapter(parentList)


    }

    private fun initData() {
        parentList = ArrayList()
        parentList.add(
            ParentItem(
                "Tej", arrayListOf(
                    ChildItem("1", "Petrol"),
                    ChildItem("2", "Petrol"), ChildItem("3", "Petrol"), ChildItem("4", "Petrol")
                )
            )
        )

        parentList.add(
            ParentItem(
                "Ramesh", arrayListOf(
                    ChildItem("1", "Petrol"),
                    ChildItem("2", "Petrol"), ChildItem("3", "Petrol"), ChildItem("4", "Petrol")
                )
            )
        )

        parentList.add(
            ParentItem(
                "Reeya", arrayListOf(
                    ChildItem("1", "Petrol"),
                    ChildItem("2", "Petrol"), ChildItem("3", "Petrol"), ChildItem("4", "Petrol")
                )
            )
        )
    }

}