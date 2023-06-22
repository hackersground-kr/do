package kr.hackersground.wsi.dodo.features.map.vm

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kr.hackersground.wsi.dodo.base.BaseViewModel
import kr.hackersground.wsi.dodo.features.map.data.MemberData
import kr.hackersground.wsi.dodo.features.map.state.GetAllMembersState
import kr.hackersground.wsi.domain.usecase.member.GetAllMembersUseCase

@HiltViewModel
class MapViewModel @Inject constructor(
    val getAllMembersUseCase: GetAllMembersUseCase,
) : BaseViewModel() {

    private val _getAllMembersState = MutableStateFlow(GetAllMembersState())
    val getAllMembersState: StateFlow<GetAllMembersState> = _getAllMembersState

    init {
        getAllMembers()
    }

    private fun getAllMembers() = viewModelScope.launch {
        _getAllMembersState.value = GetAllMembersState(isLoading = true)

        getAllMembersUseCase().onSuccess {
            _getAllMembersState.value = GetAllMembersState(members = it.map { member -> MemberData(
                name = member.name,
                latitude = member.latitude,
                longitude = member.longitude,
                pdfUrl = member.pdfUrl,
            ) })
        }.onFailure {
            _getAllMembersState.value = GetAllMembersState(error = it)
        }
    }
}
