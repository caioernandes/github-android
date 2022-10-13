package com.caioernandes.common.extensions

import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI

fun AppCompatActivity.setupNavigationGraph(
    @IdRes navHostFragmentId: Int,
    @NavigationRes graphResId: Int
) {
    val navHostFragment =
        supportFragmentManager.findFragmentById(navHostFragmentId) as NavHostFragment

    val navController = navHostFragment.navController
    navController.setGraph(graphResId)

    val appBarConfiguration = AppBarConfiguration(navController.graph)
    NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
}