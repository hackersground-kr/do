package kr.hackersground.wsi.dodo.features.home.view

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.hackersground.wsi.dodo.R
import kr.hackersground.wsi.dodo.base.BaseFragment
import kr.hackersground.wsi.dodo.databinding.FragmentHomeBinding
import kr.hackersground.wsi.dodo.features.home.vm.HomeViewModel

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {

    override val viewModel: HomeViewModel by viewModels()
    override val hasBottomNavigation: Boolean = true

    override fun start() {
        
    }
}