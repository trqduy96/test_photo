package com.example.photosample.presentation.main.pagephoto

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.photosample.presentation.R
import com.example.photosample.presentation.databinding.FragmentPageBinding
import com.example.photosample.presentation.extension.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotoPageFragment : Fragment(R.layout.fragment_page) {

    private val mBinding by viewBinding(FragmentPageBinding::bind)

    private val args : PhotoPageFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = args.photoId
        val url = args.photoUrl

        Glide.with(requireContext())
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .placeholder(R.drawable.dummy)
            .into(mBinding.img)

        mBinding.photoId.text = id

    }
}