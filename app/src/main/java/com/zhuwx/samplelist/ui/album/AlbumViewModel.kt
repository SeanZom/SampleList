package com.zhuwx.samplelist.ui.album

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.zhuwx.samplelist.data.DataRepository
import com.zhuwx.samplelist.data.model.Album
import com.zhuwx.samplelist.vo.Status

/**
 *  @author Sean Zhu
 *  Email : seanzhuwx@gmail.com
 *  Date : 2019-07-10 - 12:01
 *  Description :
 */
class AlbumViewModel(albumId: Int) : ViewModel() {
    private val _status = MutableLiveData<Status>().apply { value = Status.LOADING }

    private val _albums = DataRepository.getAlbums(albumId)

    val status: LiveData<Status> = Transformations.map(_albums) {
        _status.apply { value = Status.DONE }.value
    }

    val albums: LiveData<List<Album>> = _albums
}