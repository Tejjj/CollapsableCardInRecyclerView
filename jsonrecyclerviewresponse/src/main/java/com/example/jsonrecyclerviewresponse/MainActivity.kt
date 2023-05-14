package com.example.jsonrecyclerviewresponse

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jsonrecyclerviewresponse.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var lBinding: ActivityMainBinding

    private lateinit var parentList: ArrayList<String>

    lateinit var jsonAdapter: JsonResponseAdapter

    private var jsonResponseList = MutableStateFlow<List<String>>(emptyList())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        lBinding.parentRecyclerView.setHasFixedSize(true)
        lBinding.parentRecyclerView.layoutManager = LinearLayoutManager(this)

        jsonResponseList.value = jsonResponseList.value.toMutableList().plus("{\"name\":\"Jane Doe\",\"favorite-game\":\"Stardew Valley\",\"subscriber\":false}")

        jsonAdapter = JsonResponseAdapter()
        lBinding.parentRecyclerView.adapter = jsonAdapter

        jsonAdapter.submitList(jsonResponseList.value)
        jsonAdapter.notifyDataSetChanged()

        lifecycleScope.launch {
            //repeatOnLifecycle(Lifecycle.State.STARTED) {
            jsonResponseList.collectLatest { updatedList ->
                Log.d("Tejaswini_Json", " collected the latest list as $updatedList")
                jsonAdapter.submitList(updatedList)
            }
            //}
        }
    }

    override fun onResume() {
        super.onResume()
    }

    private fun initData() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                delay(2000)
                Log.d("Tejaswini_Json", " Updated the jsonResponseList with tej name .... ")
                jsonResponseList.value = jsonResponseList.value.toMutableList()
                    .plus("{\"name\":\"Jane Doe\",\"favorite-game\":\"Stardew Valley\",\"subscriber\":false}")

                delay(2000)
                Log.d("Tejaswini_Json", " Updated the jsonResponseList with tej name .... ")
                jsonResponseList.value = jsonResponseList.value.toMutableList()
                    .plus("{\"name\":\"tej\",\"favorite-game\":\"Stardew Valley\",\"subscriber\":false}")


                delay(2000)
                Log.d("Tejaswini_Json", " Updated the jsonResponseList with Ramesh name .... ")
                jsonResponseList.value = jsonResponseList.value.toMutableList()
                    .plus("{\"name\":\"ramesh\",\"favorite-game\":\"Stardew Valley\",\"subscriber\":false}")


                delay(2000)
                Log.d("Tejaswini_Json", " Updated the jsonResponseList with Reeya name .... ")
                jsonResponseList.value = jsonResponseList.value.toMutableList()
                    .plus("{\"name\":\"reeya\",\"favorite-game\":\"Stardew Valley\",\"subscriber\":false}")


                delay(2000)
                Log.d("Tejaswini_Json", " Updated the jsonResponseList with reshmika name .... ")
                jsonResponseList.value = jsonResponseList.value.toMutableList()
                    .plus("{\"name\":\"reshmika\",\"favorite-game\":\"Stardew Valley\",\"subscriber\":false}")
            }
        }
    }

    sealed class UiState<out T> {
        object Empty : UiState<Nothing>()

        object Loading : UiState<Nothing>()

        data class Success<out T>(val data: T) : UiState<T>()

        data class Error(val data: String?) : UiState<Nothing>()
    }

    fun refreshList(view: View) {
        initData()
    }

    fun clear(view: View) {
        jsonResponseList.value = emptyList()
    }

    /* private fun prepopulateList() {
       //parentList = ArrayList<String>()
       //parentList.add("{\"name\":\"Jane Doe\",\"favorite-game\":\"Stardew Valley\",\"subscriber\":false}")
       //jsonResponseList.value = UiState.Success()


       *//* delay(2000)
           //parentList.add("{\"name\":\"tej\",\"favorite-game\":\"Stardew Valley\",\"subscriber\":false}")
           jsonResponseList.value.plus("{\"name\":\"tej\",\"favorite-game\":\"Stardew Valley\",\"subscriber\":false}")
           delay(2000)
           //parentList.add("{\"name\":\"ramesh\",\"favorite-game\":\"Stardew Valley\",\"subscriber\":false}")
           jsonResponseList.value.plus("{\"name\":\"ramesh\",\"favorite-game\":\"Stardew Valley\",\"subscriber\":false}")
           delay(2000)
          // parentList.add("{\"name\":\"reeya\",\"favorite-game\":\"Stardew Valley\",\"subscriber\":false}")
           jsonResponseList.value.plus("{\"name\":\"reeya\",\"favorite-game\":\"Stardew Valley\",\"subscriber\":false}")
           delay(2000)
           //parentList.add("{\"name\":\"reshmika\",\"favorite-game\":\"Stardew Valley\",\"subscriber\":false}")
           jsonResponseList.value.plus("{\"name\":\"reshmika\",\"favorite-game\":\"Stardew Valley\",\"subscriber\":false}")
           delay(2000)
       }*//*
    }

    private fun initWithThread() {
        *//*Toast.makeText(this, "Adding Jane Doe after 5seconds", Toast.LENGTH_SHORT).show()
        Thread.sleep(5000)
        Log.d("Tejaswini_Json", " Updated the jsonResponseList with tej name .... ")
        jsonResponseList.value = jsonResponseList.value.toMutableList().plus("{\"name\":\"Jane Doe\",\"favorite-game\":\"Stardew Valley\",\"subscriber\":false}")
        //jsonResponseList.value = UiState.Success()


        Toast.makeText(this, "Adding Tej after 5seconds", Toast.LENGTH_SHORT).show()
        Thread.sleep(5000)
        Log.d("Tejaswini_Json", " Updated the jsonResponseList with tej name .... ")
        jsonResponseList.value = jsonResponseList.value.toMutableList().plus("{\"name\":\"tej\",\"favorite-game\":\"Stardew Valley\",\"subscriber\":false}")


        Toast.makeText(this, "Adding ramesh after 5seconds", Toast.LENGTH_SHORT).show()
        Thread.sleep(5000)
        Log.d("Tejaswini_Json", " Updated the jsonResponseList with Ramesh name .... ")
        jsonResponseList.value = jsonResponseList.value.toMutableList().plus("{\"name\":\"ramesh\",\"favorite-game\":\"Stardew Valley\",\"subscriber\":false}")


        Toast.makeText(this, "Adding reeya after 5seconds", Toast.LENGTH_SHORT).show()
        Thread.sleep(5000)
        Log.d("Tejaswini_Json", " Updated the jsonResponseList with Reeya name .... ")
        // parentList.add("{\"name\":\"reeya\",\"favorite-game\":\"Stardew Valley\",\"subscriber\":false}")
        jsonResponseList.value = jsonResponseList.value.toMutableList().plus("{\"name\":\"reeya\",\"favorite-game\":\"Stardew Valley\",\"subscriber\":false}")


        Toast.makeText(this, "Adding reshmika after 5seconds", Toast.LENGTH_SHORT).show()
        Thread.sleep(5000)
        Log.d("Tejaswini_Json", " Updated the jsonResponseList with reshmika name .... ")
        //parentList.add("{\"name\":\"reshmika\",\"favorite-game\":\"Stardew Valley\",\"subscriber\":false}")
        jsonResponseList.value = jsonResponseList.value.toMutableList().plus("{\"name\":\"reshmika\",\"favorite-game\":\"Stardew Valley\",\"subscriber\":false}")
*//*
    }*/
}