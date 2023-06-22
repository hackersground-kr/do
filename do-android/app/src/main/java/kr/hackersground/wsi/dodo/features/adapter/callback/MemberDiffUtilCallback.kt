package kr.hackersground.wsi.dodo.features.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import kr.hackersground.wsi.domain.model.Member

object MemberDiffUtilCallback : DiffUtil.ItemCallback<Member>() {
    override fun areItemsTheSame(oldItem: Member, newItem: Member) = oldItem.name == newItem.name
    override fun areContentsTheSame(oldItem: Member, newItem: Member) = oldItem == newItem
}
