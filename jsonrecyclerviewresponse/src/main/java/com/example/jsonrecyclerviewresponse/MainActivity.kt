package com.example.jsonrecyclerviewresponse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jsonrecyclerviewresponse.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var lBinding: ActivityMainBinding

    private lateinit var parentList: ArrayList<String>

    lateinit var jsonAdapter: JsonResponseAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        lBinding.parentRecyclerView.setHasFixedSize(true)
        lBinding.parentRecyclerView.layoutManager = LinearLayoutManager(this)

        initData()

        jsonAdapter = JsonResponseAdapter()
        lBinding.parentRecyclerView.adapter = jsonAdapter
        jsonAdapter.submitList(parentList)
    }

    private fun initData() {
        parentList = ArrayList<String>()
        parentList.add("{\"name\":\"Jane Doe\",\"favorite-game\":\"Stardew Valley\",\"subscriber\":false}")
        parentList.add("{\"name\":\"tej\",\"favorite-game\":\"Stardew Valley\",\"subscriber\":false}")
        parentList.add("{\"name\":\"ramesh\",\"favorite-game\":\"Stardew Valley\",\"subscriber\":false}")
        parentList.add("{\"name\":\"reeya\",\"favorite-game\":\"Stardew Valley\",\"subscriber\":false}")
        parentList.add("{\"name\":\"reshmika\",\"favorite-game\":\"Stardew Valley\",\"subscriber\":false}")

        /*parentList.add(
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
        )*/
    }
}