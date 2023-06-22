package kr.hackersground.wsi.dodo.features.home.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.hackersground.wsi.dodo.R
import kr.hackersground.wsi.dodo.base.BaseFragment
import kr.hackersground.wsi.dodo.databinding.FragmentHomeBinding
import kr.hackersground.wsi.dodo.features.adapter.MemberAdapter
import kr.hackersground.wsi.dodo.features.home.data.MemberData
import kr.hackersground.wsi.dodo.features.home.vm.HomeViewModel
import kr.hackersground.wsi.dodo.features.main.view.MainActivity
import kr.hackersground.wsi.dodo.util.repeatOnStarted
import kr.hackersground.wsi.domain.model.Member

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {

    override val viewModel: HomeViewModel by viewModels()
    override val hasBottomNavigation: Boolean = true
    private lateinit var memberAdapter: MemberAdapter
    private var members: List<MemberData> = emptyList()

    override fun start(savedInstanceState: Bundle?) {
        memberAdapter = MemberAdapter()
        viewModel.getAllMember()

        binding.rvTalent.adapter = memberAdapter
        binding.rvRecommendedTalent.adapter = memberAdapter

        collectGetAllMembersState()
        binding.tvNearTalent.text = "지금 지방에는 "+ members.size +"명의 인재가 있습니다!"

        repeatOnStarted {
            viewModel.eventFlow.collect { event -> handleEvent(event) }
        }
    }

    private fun collectGetAllMembersState() = lifecycleScope.launchWhenStarted {
        viewModel.getAllMembersState.collect { state ->
            if (state.members.isNotEmpty()) {
                members = state.members
                memberAdapter.submitList(members.map {Member(it.name, it.latitude, it.longitude, it.pdfUrl) })
            }
            if (state.error != null) {
                Toast.makeText(requireContext(), state.error.toString(), Toast.LENGTH_SHORT).show()
            }
            Log.d("HomeFragment", members.toString())
        }
    }

    private fun handleEvent(event: HomeViewModel.Event) = when (event) {
        is HomeViewModel.Event.OnClickMap -> (activity as? MainActivity)?.mainToMap()
    }
}