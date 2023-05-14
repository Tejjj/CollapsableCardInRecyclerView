package com.example.jsonrecyclerviewresponse

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dandan.jsonhandleview.library.JsonViewLayout
import com.example.jsonrecyclerviewresponse.databinding.ProfileItemBinding


class JsonResponseAdapter :
    ListAdapter<String, JsonResponseAdapter.ProfileViewHolder>(ProfileDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        return ProfileViewHolder(
            ProfileItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val jsonString = getItem(position)
        //holder.bind(image)
        try {
            holder.jsonView.bindJson(jsonString)
            holder.jsonView.expandAll()
        } catch (exception: Exception) {
            Log.d("Tejaswini_Json", " Binding exception occured :: $exception")
        }

    }


    class ProfileViewHolder(
        private val binding: ProfileItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        var jsonView: JsonViewLayout
                init {
                    jsonView = binding.jsonView
                }
        fun bind(jsonString: String) {
           /* binding.apply {
                profile = jsonString
                jsonView.bindJson(jsonString)
                jsonView.expandAll()

                // binding.profileImage.load(item.downloadUrl) {
                // bind the json string to a view.
                executePendingBindings()
            }*/

        }
    }
}


private class ProfileDiffCallback : DiffUtil.ItemCallback<String>() {

    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}