package kr.hackersground.wsi.dodo.features.home.view

import android.util.Log
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.hackersground.wsi.dodo.R
import kr.hackersground.wsi.dodo.base.BaseFragment
import kr.hackersground.wsi.dodo.databinding.FragmentHomeBinding
import kr.hackersground.wsi.dodo.features.adapter.TalentAdapter
import kr.hackersground.wsi.dodo.features.home.vm.HomeViewModel
import kr.hackersground.wsi.domain.model.Talent

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {

    override val viewModel: HomeViewModel by viewModels()
    override val hasBottomNavigation: Boolean = true
    private lateinit var talentAdapter: TalentAdapter
    private var talentList: List<Talent> = emptyList()
    override fun start() {
        talentAdapter = TalentAdapter()
        binding.rvTalent.adapter = talentAdapter
        ChangeTalentRecycleView()
        binding.tvNearTalent.text = "지금 지방에는 "+ talentList.size +"명의 인재가 있습니다!"
    }

    private fun ChangeTalentRecycleView() {
        for (i: Int in 1..10) {
            talentList += Talent(1,"test","des",123,123,"123")
        }
        talentAdapter.submitList(talentList)
    }

    fun onClickMap() {

    }
}