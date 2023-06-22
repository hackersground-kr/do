package kr.hackersground.wsi.dodo.features.home.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import kr.hackersground.wsi.dodo.features.home.data.MemberData
import kr.hackersground.wsi.domain.model.Member

object MemberDataDiffUtilCallback : DiffUtil.ItemCallback<MemberData>() {
    override fun areItemsTheSame(oldItem: MemberData, newItem: MemberData) = oldItem.name == newItem.name
    override fun areContentsTheSame(oldItem: MemberData, newItem: MemberData) = oldItem == newItem
}
