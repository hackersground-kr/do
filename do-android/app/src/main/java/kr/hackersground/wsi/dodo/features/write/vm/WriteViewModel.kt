package kr.hackersground.wsi.dodo.features.write.vm

import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kr.hackersground.wsi.dodo.base.BaseViewModel

@HiltViewModel
class WriteViewModel @Inject constructor() : BaseViewModel() {

    val name = MutableLiveData<String>()
    val address = MutableLiveData<String>()
    val major = MutableLiveData<String>()
}