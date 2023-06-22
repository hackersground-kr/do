package kr.hackersground.wsi.dodo.features.write.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.hackersground.wsi.dodo.R
import kr.hackersground.wsi.dodo.base.BaseFragment
import kr.hackersground.wsi.dodo.databinding.FragmentWriteBinding
import kr.hackersground.wsi.dodo.features.write.vm.WriteViewModel

@AndroidEntryPoint
class WriteFragment : BaseFragment<FragmentWriteBinding, WriteViewModel>(R.layout.fragment_write) {

    override val viewModel: WriteViewModel by viewModels()

    override fun start(savedInstanceState: Bundle?) {
        binding.icBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnSend.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnPdf.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "application/pdf"
            startActivity(intent)
        }
    }
}