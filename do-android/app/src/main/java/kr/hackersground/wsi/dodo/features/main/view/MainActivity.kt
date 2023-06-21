package kr.hackersground.wsi.dodo.features.main.view

import android.view.View
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.hackersground.wsi.dodo.R
import kr.hackersground.wsi.dodo.base.BaseActivity
import kr.hackersground.wsi.dodo.databinding.ActivityMainBinding
import kr.hackersground.wsi.dodo.features.main.vm.MainViewModel

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {

    override val viewModel: MainViewModel by viewModels()
    private lateinit var navController: NavController

    override fun start() {
        setNavigation()
    }

    private fun setNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fcv_main) as NavHostFragment
        navController = navHostFragment.navController
        binding.bnvMain.setupWithNavController(navController)
    }

    fun setNavVisible(demand: Boolean) {
        binding.bnvMain.visibility = if (demand) View.VISIBLE else View.GONE
    }
}