package kr.hackersground.wsi.dodo.features.map.adapter.diffutil

import androidx.recyclerview.widget.DiffUtil
import kr.hackersground.wsi.dodo.features.map.data.MemberData

object MemberDataDiffUtilCallback : DiffUtil.ItemCallback<MemberData>() {
    override fun areItemsTheSame(oldItem: MemberData, newItem: MemberData) = oldItem == newItem
    override fun areContentsTheSame(oldItem: MemberData, newItem: MemberData) = oldItem == newItem
}
