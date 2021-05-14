package com.quan.datn.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.quan.datn.databinding.ItemHeaderBinding
import com.quan.datn.databinding.ItemTableRowOneBinding
import com.quan.datn.databinding.ItemTableRowTwoBinding


class HomeAdapter : RecyclerView.Adapter<HomeAdapter.Companion.ViewHolder> {

    var inter:IHomeAdapter? = null

    constructor(inter:IHomeAdapter){
        this.inter = inter
    }

    companion object {
        class ViewHolder : RecyclerView.ViewHolder {
            var itemHeaderBinding : ItemHeaderBinding ?= null

            constructor(binding: ItemHeaderBinding) : super(binding.root){
                itemHeaderBinding = binding
            }

            var itemTableRowOneBinding:ItemTableRowOneBinding ?= null

            constructor(binding: ItemTableRowOneBinding) : super(binding.root){
                itemTableRowOneBinding = binding
            }

            var itemTableRowTwoBinding:ItemTableRowTwoBinding ?= null

            constructor(binding: ItemTableRowTwoBinding) : super (binding.root){
                itemTableRowTwoBinding = binding
            }

        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding
        return when (viewType) {
            0 -> {
                binding = ItemHeaderBinding.inflate(inflater, parent, false)
                ViewHolder(binding)
            }
            else -> {
                if (viewType % 2 == 0){
                    binding = ItemTableRowTwoBinding.inflate(inflater, parent, false)
                    ViewHolder(binding)
                }else{
                    binding = ItemTableRowOneBinding.inflate(inflater, parent, false)
                    ViewHolder(binding)
                }
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder.itemViewType == 0){
            val binding = holder.itemHeaderBinding
            binding?.executePendingBindings()
        }else{
            if (holder.itemViewType % 2 == 0){
                val binding = holder.itemTableRowTwoBinding
                if (binding != null){
                    binding.benhAn = inter?.getModel()?.dsBenhAn?.value!![position - 1]
                    binding.onClickRow.setOnClickListener {
                        inter?.onClickItem(position - 1,binding.onClickRow)
                    }
                    binding.executePendingBindings()
                }
            }else{
                val binding = holder.itemTableRowOneBinding
                if (binding != null){
                    binding.benhAn = inter?.getModel()?.dsBenhAn?.value!![position - 1]
                    binding.onClickRow.setOnClickListener {
                        inter?.onClickItem(position - 1,binding.onClickRow)
                    }
                    binding.executePendingBindings()
                }
                binding?.executePendingBindings()
            }
        }
    }

    override fun getItemCount(): Int {
        return if (inter?.getModel()?.dsBenhAn?.value == null)
            1
        else
            inter?.getModel()?.dsBenhAn?.value!!.size + 1
    }

    interface IHomeAdapter {
        fun onClickItem(position: Int,view:View)
        fun getModel():HomeViewModel
    }

}