package com.example.photosample.presentation.main.listphoto

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.paging.PagingData
import com.example.photosample.data.products.entity.PhotoResponse
import com.example.photosample.domain.ext.observe
import com.example.photosample.presentation.R
import com.example.photosample.presentation.databinding.FragmentListBinding
import com.example.photosample.presentation.extension.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@Suppress("UNCHECKED_CAST")
@AndroidEntryPoint
class PhotoListFragment : Fragment(R.layout.fragment_list) {

    private val mBinding by viewBinding(FragmentListBinding::bind)

    private val mViewModel: PhotoListViewModel by viewModels()

    private val mAdapter by lazy {
        PhotoListAdapter(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        binds()
    }
    private fun initViews() {
        mBinding.rcView.adapter = mAdapter.withLoadStateFooter(PhotoLoadStateAdapter(mAdapter))
    }

    private fun binds() {
        mAdapter.setOnClickedListener(object : OnClickedListener{
            override fun onClicked(id: String, url: String) {
                navigateToDetails(id, url)
            }
        })
        mViewModel.search()
        observe(mViewModel.repositoryLiveData, ::submitData)
    }

    private fun submitData(repositoryLiveData: PagingData<PhotoResponse>) {
        mAdapter.submitData(lifecycle, repositoryLiveData)

    }

    private fun navigateToDetails(id: String, url: String) {
            val action = PhotoListFragmentDirections.actionPhotoListFragmentToPhotoPageFragment(
                id, url
            )
            findNavController().navigate(action)
    }



}