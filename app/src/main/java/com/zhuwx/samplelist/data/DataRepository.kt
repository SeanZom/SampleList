package com.zhuwx.samplelist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zhuwx.samplelist.data.model.Album
import com.zhuwx.samplelist.data.model.User
import com.zhuwx.samplelist.data.server.AppService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 *  @author Sean Zhu
 *  Email : seanzhuwx@gmail.com
 *  Date : 2019-07-08 - 18:55
 *  Description :
 */
object DataRepository {


    private val _usersCache = MutableLiveData<List<User>>()

    // Uses 'albumId' as keys
    private val _albumsCache = mutableMapOf<Int, List<Album>>()

    private val _currentAlbums = MutableLiveData<List<Album>>()


    fun getUsers(): LiveData<List<User>> {
        refreshUsers()
        return _usersCache
    }

    fun getAlbums(albumId: Int): LiveData<List<Album>> {
        _currentAlbums.value = _albumsCache[albumId] ?: emptyList()
        refreshAlbums(albumId)
        return _currentAlbums
    }

    fun getAlbum(id: Int): Album {
        return _currentAlbums.value!!.find { it.id == id }!!
    }

    private fun refreshUsers() {
        GlobalScope.launch(Dispatchers.Main) {
            val users = withContext(Dispatchers.IO) {
                AppService.getUsers()
            }
            _usersCache.value = users
        }
    }

    private fun refreshAlbums(albumId: Int) {
        GlobalScope.launch(Dispatchers.Main) {
            val albums = withContext(Dispatchers.IO) {
                AppService.getAlbums(albumId)
            }
            _albumsCache[albumId] = albums
            _currentAlbums.value = _albumsCache[albumId]
        }
    }
}