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
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.collapsablecardview.databinding.ItemProductBinding
import com.example.collapsablecardview.databinding.PumpItemEntryBinding

class ChildRecyclerViewAdapter(private val childList: List<ChildItem>) : RecyclerView.Adapter<ChildRecyclerViewAdapter.ChildProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildProductViewHolder {
        /*val view = LayoutInflater.from(parent.context).inflate(R.layout.pump_item_entry, parent, false)
        return ProfileViewHolder(view)*/

        return ChildProductViewHolder(
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ChildProductViewHolder, position: Int) {
        val childItem = childList[position]
        holder.bind(childItem)
    }

    override fun getItemCount(): Int = childList?.size?:0


    inner class ChildProductViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ChildItem) {
            binding.apply {
                childLogoIV.setImageResource(R.drawable.ic_user)
                childTitleTv.text = item.name
                /*parentTitleTv.text = item.title
                //parentLogoIv.setImageResource(R.drawable.ic_user)
                childRecyclerView.setHasFixedSize(true)
                childRecyclerView.layoutManager = GridLayoutManager(this.root.context, 3)
*/
                executePendingBindings()
            }
        }
    }
}