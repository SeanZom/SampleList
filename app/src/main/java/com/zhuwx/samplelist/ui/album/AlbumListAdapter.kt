package com.zhuwx.samplelist.ui.album

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.zhuwx.samplelist.R
import com.zhuwx.samplelist.binding.BaseBindingViewHolder
import com.zhuwx.samplelist.data.model.Album
import com.zhuwx.samplelist.databinding.AlbumItemBinding
import kotlinx.android.synthetic.main.album_item.view.*

/**
 *  @author Sean Zhu
 *  Email : seanzhuwx@gmail.com
 *  Date : 2019-07-10 - 15:02
 *  Description :
 */
class AlbumListAdapter(albums: List<Album>, private val albumClickCallback: ((Album) -> Unit)?) : RecyclerView.Adapter<BaseBindingViewHolder<AlbumItemBinding>>() {

    private val _albums = mutableListOf<Album>().apply { addAll(albums) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseBindingViewHolder<AlbumItemBinding> {
        val binding = DataBindingUtil.inflate<AlbumItemBinding>(LayoutInflater.from(parent.context), R.layout.album_item, parent, false)
        binding.root.iv.setOnClickListener {
            binding.album?.let {
                albumClickCallback?.invoke(it)
            }
        }
        return BaseBindingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseBindingViewHolder<AlbumItemBinding>, position: Int) {
        holder.binding.album = _albums[position]
        holder.binding.executePendingBindings()
    }

    override fun getItemCount() = _albums.size

    fun setAlbumList(newData: List<Album>) {
        _albums.clear()
        if (newData.isNotEmpty()) {
            _albums.addAll(newData)
        }
        notifyDataSetChanged()
    }
}