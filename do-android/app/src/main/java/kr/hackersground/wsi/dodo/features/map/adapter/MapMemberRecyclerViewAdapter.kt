package kr.hackersground.wsi.dodo.features.map.adapter

import com.bumptech.glide.Glide
import kr.hackersground.wsi.dodo.R
import kr.hackersground.wsi.dodo.base.BaseListAdapter
import kr.hackersground.wsi.dodo.databinding.ItemMapMemberBinding
import kr.hackersground.wsi.dodo.features.map.adapter.diffutil.MemberDataDiffUtilCallback
import kr.hackersground.wsi.dodo.features.map.data.MemberData
import kr.hackersground.wsi.domain.model.Member

class MapMemberRecyclerViewAdapter(val onClickItem: (member: Member) -> Unit) : BaseListAdapter<MemberData, ItemMapMemberBinding>(
    R.layout.item_map_member,
    MemberDataDiffUtilCallback
) {
    override fun action(item: MemberData, binding: ItemMapMemberBinding) {
        val num = (1..75).random()
        binding.item = item
        Glide.with(binding.root.context)
            .load("https://randomuser.me/api/portraits/men/${num}.jpg")
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