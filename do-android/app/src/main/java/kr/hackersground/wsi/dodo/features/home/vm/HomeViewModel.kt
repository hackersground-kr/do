package kr.hackersground.wsi.dodo.features.home.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kr.hackersground.wsi.dodo.base.BaseViewModel
import kr.hackersground.wsi.dodo.util.MutableEventFlow
import kr.hackersground.wsi.dodo.util.asEventFlow
import kr.hackersground.wsi.domain.model.Member
import kr.hackersground.wsi.domain.usecase.member.GetAllMembersUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllMemberUseCase: GetAllMembersUseCase
) : BaseViewModel() {
    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()
    var memberList = MutableLiveData<List<Member>>()

    init {
        getAllMember()
    }

    fun getAllMember() {
        viewModelScope.launch {
            getAllMemberUseCase().onSuccess {
                memberList = MutableLiveData(it)
            }.onFailure {

            }
        }
    }

    private fun event(event: Event) {
        viewModelScope.launch {
            _eventFlow.emit(event)
        }
    }
    sealed class Event() {
        object OnClickMap : Event()
    }

    fun onClickMap() {
        event(Event.OnClickMap)
    }
}