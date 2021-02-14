package com.cihan.turistuygulamasi.ViewModelAndFragments.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cihan.turistuygulamasi.Adapter.places_adapter
import com.cihan.turistuygulamasi.R
import com.cihan.turistuygulamasi.ViewModelAndFragments.yonlendirmeViewModel
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private val recyclerHomeAdapter = places_adapter(arrayListOf())
    private val viewModel by activityViewModels<yonlendirmeViewModel>()


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(context,"Click on Place For More Details", Toast.LENGTH_SHORT).show()



        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        recyclerViewHomeID.layoutManager = LinearLayoutManager(context)
        recyclerViewHomeID.adapter = recyclerHomeAdapter
        observeLiveData()
        dataShow()


    }

    override fun onStop() {
        super.onStop()
        recyclerHomeAdapter.verilistesi.clear()
    }
    fun observeLiveData (){
        homeViewModel.datalar.observe(viewLifecycleOwner, { places ->
            places?.let {
                recyclerViewHomeID.visibility = View.VISIBLE
                recyclerHomeAdapter.listeyiGuncelle(places)
            }
            homeViewModel.progressBar.observe(viewLifecycleOwner, { yukleniyor ->
                yukleniyor?.let {
                    if (it){
                        recyclerViewHomeID.visibility = View.GONE
                        progressBar.visibility = View.VISIBLE
                    }else{
                        progressBar.visibility = View.GONE
                    }
                }

            })

        })

    }

    fun dataShow() {
        viewModel.someChangingVar.observe(viewLifecycleOwner, { newValue->
            homeViewModel.verileriAl(requireContext().applicationContext,newValue+"Place")
        })
    }


}