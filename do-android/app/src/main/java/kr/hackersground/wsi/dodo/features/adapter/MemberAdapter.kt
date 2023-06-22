package kr.hackersground.wsi.dodo.features.adapter

import kr.hackersground.wsi.dodo.R
import kr.hackersground.wsi.dodo.base.BaseListAdapter
import kr.hackersground.wsi.dodo.databinding.ItemMemberBinding
import kr.hackersground.wsi.dodo.features.adapter.callback.MemberDiffUtilCallback
import kr.hackersground.wsi.domain.model.Member

class MemberAdapter : BaseListAdapter<Member, ItemMemberBinding>(
    R.layout.item_member,
    MemberDiffUtilCallback
) {
    override fun action(item: Member, binding: ItemMemberBinding) {
        binding.user = item
    }
}