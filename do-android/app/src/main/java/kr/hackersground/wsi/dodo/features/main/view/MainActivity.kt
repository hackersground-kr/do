package kr.hackersground.wsi.dodo.features.main.view

import android.view.View
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
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
        AppCenter.start(
            application,
            "e59cdf02-8630-4ebc-8201-4fbb6789e5ba",
            Analytics::class.java,
            Crashes::class.java
        )
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