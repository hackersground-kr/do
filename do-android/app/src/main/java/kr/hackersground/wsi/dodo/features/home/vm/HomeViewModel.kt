package kr.hackersground.wsi.dodo.features.home.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kr.hackersground.wsi.dodo.base.BaseViewModel
import kr.hackersground.wsi.dodo.features.home.data.MemberData
import kr.hackersground.wsi.dodo.features.home.state.GetAllMembersState
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

    private val _getAllMembersState = MutableStateFlow(GetAllMembersState())
    val getAllMembersState: StateFlow<GetAllMembersState> = _getAllMembersState

    init {
        getAllMember()
    }

    fun getAllMember() {
        viewModelScope.launch {
            _getAllMembersState.value = GetAllMembersState(isLoading = true)
            getAllMemberUseCase().onSuccess {
                _getAllMembersState.value = GetAllMembersState(members = it.map { member -> MemberData(
                    name = member.name,
                    latitude = member.latitude,
                    longitude = member.longitude,
                    pdfUrl = member.pdfUrl,
                    descriptor = ""
                ) })
            }.onFailure {
                _getAllMembersState.value = GetAllMembersState(error = it)
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