package com.furkansenol.workwithroom.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.furkansenol.workwithroom.R
import com.google.android.material.appbar.MaterialToolbar


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //artık bu çalışmıyor
        //setupActionBarWithNavController(findNavController(R.id.fragmentContainerView))

        actionBarSettings()
    }

    private fun actionBarSettings() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        // Instantiate the navController using the NavHostFragment
        navController = navHostFragment.navController
        // Make sure actions in the ActionBar get propagated to the NavController
        setupActionBarWithNavController(navController)

        //action bar daki isimleri degistirmek icin "my_nav.xml" dosyasından label bilgisini değiştiriyorsun
    }

    //actionBar daki geri tuşu için
    override fun onSupportNavigateUp(): Boolean {
        val navController2 = findNavController(R.id.fragmentContainerView)
        return navController2.navigateUp() || super.onSupportNavigateUp()
    }
}