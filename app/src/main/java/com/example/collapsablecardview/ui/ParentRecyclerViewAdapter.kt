/*
 *  Copyright (C) 2023 Rajesh Hadiya
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.example.collapsablecardview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import com.example.collapsablecardview.database.entity.Image
import com.example.collapsablecardview.databinding.PumpItemEntryBinding

class ParentRecyclerViewAdapter(private val parentListItem: List<ParentItem>) : RecyclerView.Adapter<ParentRecyclerViewAdapter.PumpViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PumpViewHolder {
        /*val view = LayoutInflater.from(parent.context).inflate(R.layout.pump_item_entry, parent, false)
        return ProfileViewHolder(view)*/

        return PumpViewHolder(
            PumpItemEntryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: PumpViewHolder, position: Int) {
        val parentItem = parentListItem[position]
        holder.bind(parentItem, position)
    }
    override fun getItemCount(): Int = parentListItem.size


    inner class PumpViewHolder(/*itemView: View):RecyclerView.ViewHolder(itemView)*/
        private val binding: PumpItemEntryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        var constraintLayout = binding.constraintLayout

        fun bind(item: ParentItem, position: Int) {
            binding.apply {
                parentTitleTv.text = item.title
                //parentLogoIv.setImageResource(R.drawable.ic_user)
                childRecyclerView.setHasFixedSize(true)
                childRecyclerView.layoutManager = GridLayoutManager(this.root.context, 3)

                val adapter = ChildRecyclerViewAdapter(item.childList)
                childRecyclerView.adapter = adapter

                val isExpandable = item.isExpandable
                childRecyclerView.visibility = if(isExpandable) View.VISIBLE else View.GONE

                constraintLayout.setOnClickListener {

                    collapseOtherItems(position)

                    item.isExpandable = !item.isExpandable
                    //executePendingBindings()
                    notifyItemChanged(position)
                }
                //executePendingBindings()
            }
        }
    }

    private fun collapseOtherItems(position: Int) {
        val temp = parentListItem.indexOfFirst {
            it.isExpandable
        }

        if(temp >=0 && temp != position) {
            parentListItem[temp].isExpandable = false
            notifyItemChanged(temp)
        }
    }
}