package kr.hackersground.wsi.dodo.features.map.view

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import dagger.hilt.android.AndroidEntryPoint
import kr.hackersground.wsi.dodo.R
import kr.hackersground.wsi.dodo.base.BaseFragment
import kr.hackersground.wsi.dodo.databinding.FragmentMapBinding
import kr.hackersground.wsi.dodo.features.map.data.MemberData
import kr.hackersground.wsi.dodo.features.map.vm.MapViewModel
import ted.gun0912.clustering.naver.TedNaverClustering

@AndroidEntryPoint
class MapFragment : BaseFragment<FragmentMapBinding, MapViewModel>(R.layout.fragment_map), OnMapReadyCallback {

    override val viewModel: MapViewModel by viewModels()
    override val hasBottomNavigation: Boolean = true

    private lateinit var naverMap: NaverMap

    override fun start(savedInstanceState: Bundle?) {
        binding.mapView.onCreate(savedInstanceState)
        binding.mapView.getMapAsync(this)
        viewModel.getAllMembers()

        collectGetAllMembersState()
    }

    private fun collectGetAllMembersState() = lifecycleScope.launchWhenStarted {
        viewModel.getAllMembersState.collect { state ->
            if (state.members.isNotEmpty()) {
                setMarker(state.members)
            }

            if (state.error != null) {
                Toast.makeText(requireContext(), state.error.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setMarker(members: List<MemberData>) {
        TedNaverClustering.with<MemberData>(requireContext(), naverMap)
            .items(members)
            .customCluster {
                TextView(requireContext()).apply {
                    setTextColor(Color.WHITE)
                    text = "${it.size}개"
                    setPadding(40, 40, 40, 40)
                    background = requireContext().getDrawable(R.drawable.drawable_marker)
                }
            }
            .markerClickListener { member ->
                val position = LatLng(member.latitude, member.longitude)
                Toast.makeText(
                    requireContext(),
                    "${position.latitude},${position.longitude} 클릭됨",
                    Toast.LENGTH_SHORT
                ).show()
            }
            .clusterClickListener { cluster ->
                val position = cluster.position
                Toast.makeText(
                    requireContext(),
                    "${cluster.size}개 클러스터 ${position.latitude},${position.longitude} 클릭됨",
                    Toast.LENGTH_SHORT
                ).show()
            }
            .make()
    }

    override fun onMapReady(map: NaverMap) {
        naverMap = map
        naverMap.maxZoom = 20.0
        naverMap.minZoom = 5.0

        with(naverMap.uiSettings) {
            isLocationButtonEnabled = false
            logoGravity = Gravity.END.or(Gravity.TOP)
            setLogoMargin(0, 0, 16, 0)
            isCompassEnabled = false
            isZoomControlEnabled = false
        }
    }

    override fun onStart() {
        super.onStart()
        binding.mapView.onStart()
        Log.d("MapTest", "START")
    }

    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
        Log.d("MapTest", "RESUME")
    }

    override fun onPause() {
        super.onPause()
        binding.mapView.onPause()
        Log.d("MapTest", "PAUSE")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.mapView.onSaveInstanceState(outState)
        Log.d("MapTest", "ON save...")
    }

    override fun onStop() {
        super.onStop()
        binding.mapView.onStop()
        Log.d("MapTest", "STOP")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.mapView.onDestroy()
        Log.d("MapTest", "DESTROY")
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView.onLowMemory()
        Log.d("MapTest", "LOW MEMORY")
    }
}