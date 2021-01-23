package com.cihan.turistuygulamasi.ViewModelAndFragments.ui.dashboard

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

import com.cihan.turistuygulamasi.Adapter.food_adapter
import com.cihan.turistuygulamasi.R
import com.cihan.turistuygulamasi.ViewModelAndFragments.yonlendirmeViewModel
import kotlinx.android.synthetic.main.fragment_dashboard.*


class DashboardFragment : Fragment() {
    var o = 0
    private lateinit var dashboardViewModel: DashboardViewModel
    private var foodRecyclerAdapter = food_adapter(arrayListOf())
    private val viewModel by activityViewModels<yonlendirmeViewModel>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

            Toast.makeText(context,"Click on Food For More Details", Toast.LENGTH_SHORT).show()

        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)


        
        foodRWid.layoutManager = LinearLayoutManager(context)
        foodRWid.adapter = foodRecyclerAdapter
        observeLiveDataF()
        dataShow()




    }
    fun observeLiveDataF(){
        dashboardViewModel.datalarFood.observe(viewLifecycleOwner, Observer {
            foods ->
            foods?.let {
                foodRecyclerAdapter.listeyiGuncelle(foods)
                foodRWid.visibility = View.VISIBLE
            }
            dashboardViewModel.foodprogressBar.observe(viewLifecycleOwner, Observer {
                progresbar ->
                progresbar?.let {
                    if (it){
                    foodRWid.visibility = View.GONE
                    progressBarFoodID.visibility = View.VISIBLE}
                    else{
                        foodRWid.visibility = View.VISIBLE
                        progressBarFoodID.visibility = View.GONE
                    }
                }
            })
        })
    }
    fun dataShow() {
        viewModel.someChangingVar.observe(viewLifecycleOwner, Observer { newValue->
            dashboardViewModel.foodVerisiniAl(requireContext().applicationContext,newValue+"Food")
        })
    }





}