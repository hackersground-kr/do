package kr.hackersground.wsi.dodo.features.home.vm

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kr.hackersground.wsi.dodo.base.BaseViewModel
import kr.hackersground.wsi.dodo.util.MutableEventFlow
import kr.hackersground.wsi.dodo.util.asEventFlow

//import kr.hackersground.wsi.domain.usecase.home.HomeUseCases

@HiltViewModel
class HomeViewModel @Inject constructor(
//    private val homaUseCase: HomeUseCases = HomeUseCases()
) : BaseViewModel() {
    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()
    fun getAllTalents() {
        //TODO
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