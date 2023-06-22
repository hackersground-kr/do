package kr.hackersground.wsi.dodo.features.home.view

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.hackersground.wsi.dodo.R
import kr.hackersground.wsi.dodo.base.BaseFragment
import kr.hackersground.wsi.dodo.databinding.FragmentHomeBinding
import kr.hackersground.wsi.dodo.features.adapter.MemberAdapter
import kr.hackersground.wsi.dodo.features.home.vm.HomeViewModel
import kr.hackersground.wsi.dodo.util.repeatOnStarted

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {

    override val viewModel: HomeViewModel by viewModels()
    override val hasBottomNavigation: Boolean = true
    private lateinit var memberAdapter: MemberAdapter

    override fun start(savedInstanceState: Bundle?) {
        memberAdapter = MemberAdapter()
        binding.rvTalent.adapter = memberAdapter
        binding.rvRecommendedTalent.adapter = memberAdapter
        ChangeTalentRecycleView()
        binding.tvNearTalent.text = "지금 지방에는 "+ viewModel.memberList.value?.size +"명의 인재가 있습니다!"
        repeatOnStarted {
            viewModel.eventFlow.collect { event -> handleEvent(event) }
        }
    }

    private fun ChangeTalentRecycleView() {
        memberAdapter.submitList(viewModel.memberList.value)
    }

    private fun handleEvent(event: HomeViewModel.Event) = when (event) {
        is HomeViewModel.Event.OnClickMap -> findNavController().navigate(R.id.action_main_home_to_main_map2)
    }
}