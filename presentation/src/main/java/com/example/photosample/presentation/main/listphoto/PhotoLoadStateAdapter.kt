package com.example.photosample.presentation.main.listphoto

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.photosample.presentation.databinding.ItemSearchFooterBinding

class PhotoLoadStateAdapter(
    private val adapter: PhotoListAdapter?
) : LoadStateAdapter<SearchLoadPageViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): SearchLoadPageViewHolder {
        val binding =
            ItemSearchFooterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchLoadPageViewHolder(binding, adapter)
    }

    override fun onBindViewHolder(holder: SearchLoadPageViewHolder, loadState: LoadState) {
        holder.binds(loadState)
    }
}

class SearchLoadPageViewHolder(
    private val view: ItemSearchFooterBinding,
    private val adapter: PhotoListAdapter?
) : RecyclerView.ViewHolder(view.root) {

    @SuppressLint("SetTextI18n")
    fun binds(loadState: LoadState) {
        view.progress.isVisible = loadState is LoadState.Loading
        view.tvError.isVisible = loadState is LoadState.Error
        if (loadState is LoadState.Error) {
            view.tvError.text = loadState.error.message + "\nClick to try again"
            view.tvError.setOnClickListener { adapter?.retry() }
        }
    }
}