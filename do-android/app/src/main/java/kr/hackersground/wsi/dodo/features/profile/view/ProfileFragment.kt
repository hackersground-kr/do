package kr.hackersground.wsi.dodo.features.profile.view

import android.os.Bundle
import android.util.Xml
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.naver.maps.geometry.LatLng
import dagger.hilt.android.AndroidEntryPoint
import kr.hackersground.wsi.dodo.R
import kr.hackersground.wsi.dodo.base.BaseFragment
import kr.hackersground.wsi.dodo.databinding.FragmentProfileBinding
import kr.hackersground.wsi.dodo.features.profile.vm.ProfileViewModel
import kr.hackersground.wsi.dodo.util.getMajor

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>(R.layout.fragment_profile) {

    override val viewModel: ProfileViewModel by viewModels()
    val args: ProfileFragmentArgs by navArgs()


    override fun start(savedInstanceState: Bundle?) {
        binding.icBack.setOnClickListener { findNavController().popBackStack() }
        binding.tvName.text = args.member.name
        binding.tvLevel.text = "Lv.${(1..10).random()}"
        binding.tvMajor.text = getMajor((1..10).random())

        val num = (1..75).random()
        Glide.with(requireContext())
            .load("https://randomuser.me/api/portraits/men/${num}.jpg")
            .circleCrop()
            .into(binding.ivProfile)

        val mUrl = "http://docs.google.com/gview?embedded=true&url=${args.member.pdfUrl}"
        binding.webviewPdf.apply {
            this.layoutParams = layoutParams
            webViewClient = WebViewClient()
            webChromeClient = WebChromeClient()
            with(settings) {
                setSupportZoom(true)
                javaScriptEnabled = true
                defaultTextEncodingName = Xml.Encoding.UTF_8.name
                loadWithOverviewMode = true
                useWideViewPort = true
                builtInZoomControls = true
            }
        }
        binding.webviewPdf.loadUrl(mUrl)
    }
}