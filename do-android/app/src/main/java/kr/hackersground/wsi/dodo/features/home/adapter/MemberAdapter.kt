package kr.hackersground.wsi.dodo.features.home.adapter

import com.bumptech.glide.Glide
import kr.hackersground.wsi.dodo.R
import kr.hackersground.wsi.dodo.base.BaseListAdapter
import kr.hackersground.wsi.dodo.databinding.ItemMemberBinding
import kr.hackersground.wsi.dodo.features.home.adapter.callback.MemberDataDiffUtilCallback
import kr.hackersground.wsi.dodo.features.home.data.MemberData
import kr.hackersground.wsi.domain.model.Member

class MemberAdapter(val onClickItem: (member: Member) -> Unit) : BaseListAdapter<MemberData, ItemMemberBinding>(
    R.layout.item_member,
    MemberDataDiffUtilCallback
) {
    override fun action(item: MemberData, binding: ItemMemberBinding) {
        binding.item = item
        val randomNumber = (1..75).random()
        Glide.with(binding.root.context)
            .load("https://randomuser.me/api/portraits/men/${randomNumber}.jpg")
            .circleCrop()
            .into(binding.ivProfile)

        binding.root.setOnClickListener {
            onClickItem(Member(
                name = item.name,
                latitude = item.latitude,
                longitude = item.longitude,
                pdfUrl = item.pdfUrl,
            ))
        }
    }
}
