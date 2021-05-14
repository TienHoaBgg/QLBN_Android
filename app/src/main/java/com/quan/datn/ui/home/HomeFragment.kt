package com.quan.datn.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.quan.datn.MainActivity
import com.quan.datn.databinding.FragmentHomeBinding
import com.quan.datn.ui.utils.DataManager
import okhttp3.internal.notifyAll

class HomeFragment : Fragment(), HomeAdapter.IHomeAdapter {
    private lateinit var viewModel: HomeViewModel
    private lateinit var binding:FragmentHomeBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding = FragmentHomeBinding.inflate(inflater,container,false)

        DataManager.getInfoSessionLogin(this.requireContext())?.let {
            viewModel.getBenhAn(it.sdt)
        }

        viewModel.dsBenhAn.observe(viewLifecycleOwner, Observer {
            if (binding.listItem.adapter == null){
                binding.listItem.apply {
                    layoutManager = LinearLayoutManager(this@HomeFragment.requireContext())
                    adapter = HomeAdapter(this@HomeFragment)
                }
            }else{
                (binding.listItem.adapter as HomeAdapter).notifyDataSetChanged()
            }
        })

        return binding.root
    }

    override fun onClickItem(position: Int, view: View) {
        Toast.makeText(this.requireContext(),"Click $position",Toast.LENGTH_SHORT).show()
    }

    override fun getModel() = viewModel

}