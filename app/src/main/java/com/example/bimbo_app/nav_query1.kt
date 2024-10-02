package com.example.bimbo_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bimbo_app.databinding.FragmentNavQuery1Binding
import com.github.kittinunf.fuel.Fuel
import com.google.gson.Gson

class nav_query1 : Fragment() {
    private var _binding: FragmentNavQuery1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNavQuery1Binding.inflate(inflater, container, false)
        return binding.root
        showLoading(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Fuel.get("https://663917474253a866a2504bf9.mockapi.io/EjemploApi/Users")
            .response { request, response, result ->
                val jsonBody = response.body().asString("application/json")
                val gson = Gson()
                query1List = gson.fromJson(jsonBody, Array<Query1>::class.java).toList()
                binding.txtTotalUsuarios.text = "Total de elementos: ${query1List.size}"
                binding.recycler.layoutManager = LinearLayoutManager(requireContext())
                binding.recycler.adapter = Query1Adapter(query1List)
                showLoading(false)
            }    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun showLoading(show: Boolean) {
        if (show) {
            binding.progressBar.visibility = View.VISIBLE
            binding.recycler.visibility = View.GONE
        } else {
            binding.progressBar.visibility = View.GONE
            binding.recycler.visibility = View.VISIBLE
        }
    }
}