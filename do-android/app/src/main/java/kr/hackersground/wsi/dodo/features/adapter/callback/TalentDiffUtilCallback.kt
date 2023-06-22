package kr.hackersground.wsi.dodo.features.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import kr.hackersground.wsi.domain.model.Talent

object TalentDiffUtilCallback : DiffUtil.ItemCallback<Talent>() {
    override fun areItemsTheSame(oldItem: Talent, newItem: Talent) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Talent, newItem: Talent) = oldItem == newItem
}
