package com.zhuwx.samplelist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zhuwx.samplelist.ui.album.AlbumViewModel

/**
 *  @author Sean Zhu
 *  Email : seanzhuwx@gmail.com
 *  Date : 2019-07-10 - 12:15
 *  Description :
 */
class AlbumViewModelFactory(
    private val albumId: Int
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AlbumViewModel(albumId) as T
    }
}