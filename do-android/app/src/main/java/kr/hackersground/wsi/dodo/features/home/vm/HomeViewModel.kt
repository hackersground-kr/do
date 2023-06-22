package kr.hackersground.wsi.dodo.features.home.vm

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kr.hackersground.wsi.dodo.base.BaseViewModel
import kr.hackersground.wsi.dodo.util.EventFlow

//import kr.hackersground.wsi.domain.usecase.home.HomeUseCases

@HiltViewModel
class HomeViewModel @Inject constructor(
//    private val homaUseCase: HomeUseCases = HomeUseCases()
) : BaseViewModel() {
    fun getAllTalents() {
        //TODO
    }

    fun onClickMap() {
        EventFlow
    }
}