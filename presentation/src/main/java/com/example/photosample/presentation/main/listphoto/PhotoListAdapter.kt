package com.example.photosample.presentation.main.listphoto

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.photosample.data.products.entity.PhotoResponse
import com.example.photosample.presentation.R
import com.example.photosample.presentation.databinding.ItemPhotoBinding

class PhotoListAdapter constructor(private val context: Context ) : PagingDataAdapter<PhotoResponse, PhotoListViewHolder>(diffCallBack) {

    private var onClickedListener: OnClickedListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoListViewHolder {
        val biding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoListViewHolder(biding)
    }

    override fun onBindViewHolder(holder: PhotoListViewHolder, position: Int) {
        Log.d("TAG", "onBindViewHolder: ${getItem(position)!!.id}")
        holder.binds(getItem(position)!!, context, onClickedListener!!)

    }

    fun setOnClickedListener(onClickedListener: OnClickedListener){
        this.onClickedListener = onClickedListener
    }

    companion object {
        private val diffCallBack: DiffUtil.ItemCallback<PhotoResponse> =
            object : DiffUtil.ItemCallback<PhotoResponse>() {
                override fun areContentsTheSame(
                    oldItem: PhotoResponse,
                    newItem: PhotoResponse
                ): Boolean {
                    return oldItem == newItem
                }

                override fun areItemsTheSame(
                    oldItem: PhotoResponse,
                    newItem: PhotoResponse
                ): Boolean {
                    return oldItem.id == newItem.id
                }
            }
    }
}

interface OnClickedListener{
    fun onClicked(id: String, url: String)
}
class PhotoListViewHolder(
    private val view: ItemPhotoBinding
) : RecyclerView.ViewHolder(view.root) {

    fun binds(data: PhotoResponse, context: Context, onClickedListener: OnClickedListener) {
        Log.d("TAG", "bindsItem: ${data.id}")
        view.photoId.text = data.id
        Glide.with(context)
            .load(data.url)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .placeholder(R.drawable.dummy)
            .override(600, 300)
            .centerCrop()
            .into(view.thumbnail)
        view.root.setOnClickListener {
            onClickedListener.onClicked(data.id, data.url)
        }
    }


}