package kr.hackersground.wsi.dodo.features.home.view

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.hackersground.wsi.dodo.R
import kr.hackersground.wsi.dodo.base.BaseFragment
import kr.hackersground.wsi.dodo.databinding.FragmentHomeBinding
import kr.hackersground.wsi.dodo.features.adapter.TalentAdapter
import kr.hackersground.wsi.dodo.features.home.vm.HomeViewModel
import kr.hackersground.wsi.dodo.util.repeatOnStarted
import kr.hackersground.wsi.domain.model.Talent

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {

    override val viewModel: HomeViewModel by viewModels()
    override val hasBottomNavigation: Boolean = true
    private lateinit var talentAdapter: TalentAdapter
    private var talentList: List<Talent> = emptyList()
    private var recommendedTalentList: List<Talent> = emptyList()

    override fun start(savedInstanceState: Bundle?) {
        talentAdapter = TalentAdapter()
        binding.rvTalent.adapter = talentAdapter
        binding.rvRecommendedTalent.adapter = talentAdapter
        ChangeTalentRecycleView()
        binding.tvNearTalent.text = "지금 지방에는 "+ talentList.size +"명의 인재가 있습니다!"
        repeatOnStarted {
            viewModel.eventFlow.collect { event -> handleEvent(event) }
        }
    }

    private fun ChangeTalentRecycleView() {
        for (i: Int in 1..10) {
            talentList += Talent(1,"test","des",123,123,"123")
        }
        for (i: Int in 1..10) {
            recommendedTalentList += Talent(1,"test","des",123,123,"123")
        }
        talentAdapter.submitList(talentList)
    }

    private fun handleEvent(event: HomeViewModel.Event) = when (event) {
        is HomeViewModel.Event.OnClickMap -> findNavController().navigate(R.id.action_main_home_to_main_map2)
    }
}