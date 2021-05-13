package com.quan.datn.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.quan.datn.MainActivity
import com.quan.datn.databinding.FragmentHomeBinding
import com.quan.datn.ui.utils.DataManager
import okhttp3.internal.notifyAll

class HomeFragment : Fragment() {
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
//        binding.fixTableLayout.setAdapter(HomeAdapter(viewModel.dsBenhAn.value ?: arrayListOf() ))
        viewModel.dsBenhAn.observe(viewLifecycleOwner, Observer {
            binding.fixTableLayout.setAdapter(HomeAdapter(it))
        })

        return binding.root
    }

}