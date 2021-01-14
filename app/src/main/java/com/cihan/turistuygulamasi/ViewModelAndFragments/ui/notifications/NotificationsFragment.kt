package com.cihan.turistuygulamasi.ViewModelAndFragments.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cihan.turistuygulamasi.Adapter.advices_adapter
import com.cihan.turistuygulamasi.R
import com.cihan.turistuygulamasi.ViewModelAndFragments.yonlendirmeViewModel
import kotlinx.android.synthetic.main.fragment_notifications.*


class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    private var adviceRecycler = advices_adapter(arrayListOf())
    private val viewModel by activityViewModels<yonlendirmeViewModel>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notificationsViewModel = ViewModelProvider(this).get(NotificationsViewModel::class.java)



        adviceRwID.layoutManager = LinearLayoutManager(context)
        adviceRwID.adapter = adviceRecycler
        observeLiveData()
        dataShow()



    }
    fun observeLiveData(){
        notificationsViewModel.datalar.observe(viewLifecycleOwner, Observer {
            Advices -> Advices?.let {
            adviceRecycler.listeyiGuncelle(Advices)
            adviceRwID.visibility = View.VISIBLE
        }
            notificationsViewModel.progressBar.observe(viewLifecycleOwner, Observer {
                progress -> progress?.let {
                if (it){
                    progressBarAdviceID.visibility = View.GONE
                    adviceRwID.visibility = View.VISIBLE
                }else {
                    progressBarAdviceID.visibility = View.GONE

                }
            }
            })
        })

    }
    fun dataShow() {
        viewModel.someChangingVar.observe(viewLifecycleOwner, Observer { newValue->
            notificationsViewModel.adviceVerileriAl(requireContext().applicationContext,newValue+"Advice")
        })
    }

}