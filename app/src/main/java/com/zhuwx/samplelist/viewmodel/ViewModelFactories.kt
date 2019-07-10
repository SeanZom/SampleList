package com.zhuwx.samplelist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zhuwx.samplelist.ui.album.AlbumsViewModel
import com.zhuwx.samplelist.ui.detail.AlbumDetailViewModel

/**
 *  @author Sean Zhu
 *  Email : seanzhuwx@gmail.com
 *  Date : 2019-07-10 - 12:15
 *  Description :
 *      This is the collection of the custom [ViewModel] factories
 */
class AlbumViewModelFactory(
    private val albumId: Int
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AlbumsViewModel(albumId) as T
    }
}

class AlbumDetailViewModelFactory(
    private val detailId: Int
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AlbumDetailViewModel(detailId) as T
    }
}