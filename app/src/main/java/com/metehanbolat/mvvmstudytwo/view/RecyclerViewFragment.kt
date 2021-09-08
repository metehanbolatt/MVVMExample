package com.metehanbolat.mvvmstudytwo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.metehanbolat.mvvmstudytwo.adapter.RecyclerCardAdapter
import com.metehanbolat.mvvmstudytwo.databinding.FragmentRecyclerViewBinding
import com.metehanbolat.mvvmstudytwo.model.Kayit
import com.metehanbolat.mvvmstudytwo.model.Kayitlar

class RecyclerViewFragment : Fragment() {

    private lateinit var binding : FragmentRecyclerViewBinding
    private lateinit var liste : Kayitlar
    private lateinit var title : String
    private lateinit var adapter : RecyclerCardAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)

        arguments?.let {
            liste = RecyclerViewFragmentArgs.fromBundle(it).kayitlar
            title = RecyclerViewFragmentArgs.fromBundle(it).title
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerCardView.layoutManager = StaggeredGridLayoutManager(2,GridLayoutManager.VERTICAL)
        adapter = RecyclerCardAdapter(liste.list as ArrayList<Kayit>)
        binding.recyclerCardView.adapter = adapter
        binding.recyclerBaslik.text = title

    }

}