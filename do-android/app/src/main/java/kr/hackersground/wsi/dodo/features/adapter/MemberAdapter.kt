package kr.hackersground.wsi.dodo.features.adapter

import kr.hackersground.wsi.dodo.R
import kr.hackersground.wsi.dodo.base.BaseListAdapter
import kr.hackersground.wsi.dodo.databinding.ItemTalentBinding
import kr.hackersground.wsi.dodo.features.adapter.callback.MemberDiffUtilCallback
import kr.hackersground.wsi.domain.model.Member

class MemberAdapter : BaseListAdapter<Member, ItemTalentBinding>(
    R.layout.item_talent,
    MemberDiffUtilCallback
) {
    override fun action(item: Member, binding: ItemTalentBinding) {
        binding.user = item
    }
}