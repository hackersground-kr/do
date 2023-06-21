package kr.hackersground.wsi.dodo.features.map.view

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.hackersground.wsi.dodo.R
import kr.hackersground.wsi.dodo.base.BaseFragment
import kr.hackersground.wsi.dodo.databinding.FragmentHomeBinding
import kr.hackersground.wsi.dodo.databinding.FragmentMapBinding
import kr.hackersground.wsi.dodo.features.home.vm.HomeViewModel
import kr.hackersground.wsi.dodo.features.map.vm.MapViewModel

@AndroidEntryPoint
class MapFragment : BaseFragment<FragmentMapBinding, MapViewModel>(R.layout.fragment_map) {

    override val viewModel: MapViewModel by viewModels()
    override val hasBottomNavigation: Boolean = true

    override fun start() {
        
    }
}