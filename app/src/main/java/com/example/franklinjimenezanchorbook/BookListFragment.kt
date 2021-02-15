package com.example.franklinjimenezanchorbook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import com.example.franklinjimenezanchorbook.databinding.FragmentListingBinding

class ListingFragment : Fragment() {

    private val bookVM: BookViewModel by activityViewModels()
    private lateinit var adapter : BookAdapter
    private lateinit var binding : FragmentListingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListingBinding.inflate(inflater)

        binding.rvList.adapter = adapter
        binding.rvList.layoutManager = GridLayoutManager(context, 1)

        bookVM.booklist().observe(viewLifecycleOwner,{
        adapter.update(it)
        })
        adapter.selectedItem().observe(viewLifecycleOwner,{
bookVM.setSelected(it)
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container,DetailFragment())?.addToBackStack("detail")?.commit()
        })

        return binding.root
    }

}