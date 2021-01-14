package com.cihan.turistuygulamasi.View


import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.cihan.turistuygulamasi.R
import com.cihan.turistuygulamasi.ViewModelAndFragments.yonlendirmeViewModel

class yonlendirmeBottomBar : AppCompatActivity() {

    private val viewModel by viewModels<yonlendirmeViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val intent = intent
        var collectionPathName = intent.getStringExtra("province")

        collectionPathName?.let { viewModel.placeSearchFun(it) }






        setContentView(R.layout.activity_yonlendirme_bottom_bar)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)




    }




}