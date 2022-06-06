package com.example.subimisidicoding.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.subimisidicoding.data.Film
import com.example.subimisidicoding.data.FilmData
import com.example.subimisidicoding.databinding.FragmentHomeBinding
import com.example.subimisidicoding.ui.adapter.AdapterHome

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeAdapter: AdapterHome
    private var data: ArrayList<Film> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState != null) {

        }

        setupRecycler()
    }

    private fun setupRecycler() {
        data.addAll(FilmData.listData)
        Log.d("test", data.toString())
        homeAdapter = AdapterHome(data)
        binding.rvHome.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter?.stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
            adapter = homeAdapter
            setHasFixedSize(true)
        }
    }

}