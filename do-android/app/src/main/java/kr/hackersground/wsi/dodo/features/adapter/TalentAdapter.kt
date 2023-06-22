package kr.hackersground.wsi.dodo.features.adapter

import kr.hackersground.wsi.dodo.R
import kr.hackersground.wsi.dodo.base.BaseListAdapter
import kr.hackersground.wsi.dodo.databinding.ItemTalentBinding
import kr.hackersground.wsi.dodo.features.adapter.callback.TalentDiffUtilCallback
import kr.hackersground.wsi.domain.model.Talent

class TalentAdapter : BaseListAdapter<Talent, ItemTalentBinding>(
    R.layout.item_talent,
    TalentDiffUtilCallback
) {
    override fun action(item: Talent, binding: ItemTalentBinding) {
        binding.user = item
    }
}