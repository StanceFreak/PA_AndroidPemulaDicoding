package com.example.subimisidicoding.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.subimisidicoding.databinding.FragmentFavoriteBinding
import com.example.subimisidicoding.local.FilmFavEntity
import com.example.subimisidicoding.ui.adapter.AdapterFavorite
import com.example.subimisidicoding.viewmodel.FilmFavViewModel

class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding
    private lateinit var favAdapter: AdapterFavorite
    private lateinit var viewModel: FilmFavViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecycler()
    }

    private fun setupRecycler() {
        favAdapter = AdapterFavorite()

        binding.rvFavorite.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = favAdapter
            setHasFixedSize(true)
        }

        viewModel = ViewModelProviders.of(this).get(FilmFavViewModel::class.java)
        viewModel.getFavorite.observe(viewLifecycleOwner, Observer {
            favAdapter.setFavorite(it)
        })
//        if (viewModel.getFavorite.value != null) {
//            binding.layoutError.visibility = View.GONE
//            binding.rvFavorite.visibility = View.VISIBLE
//            viewModel.getFavorite.observe(viewLifecycleOwner, Observer {
//                favAdapter.setFavorite(it)
//            })
//        }
//        else {
//            binding.layoutError.visibility = View.VISIBLE
//            binding.rvFavorite.visibility = View.GONE
//        }
    }

}