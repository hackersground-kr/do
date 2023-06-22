package kr.hackersground.wsi.dodo.features.profile.view

import android.os.Bundle
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.hackersground.wsi.dodo.R
import kr.hackersground.wsi.dodo.base.BaseFragment
import kr.hackersground.wsi.dodo.databinding.FragmentProfileBinding
import kr.hackersground.wsi.dodo.features.profile.vm.ProfileViewModel

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>(R.layout.fragment_profile) {

    override val viewModel: ProfileViewModel by viewModels()

    override fun start(savedInstanceState: Bundle?) {

    }
}