package com.zhuwx.samplelist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.zhuwx.samplelist.data.DataRepository
import com.zhuwx.samplelist.data.model.Album
import com.zhuwx.samplelist.data.model.User
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

/**
 *  @author Sean Zhu
 *  Email : seanzhuwx@gmail.com
 *  Date : 2019-07-11 - 14:26
 *  Description :
 */
@RunWith(MockitoJUnitRunner::class)
class DataRepositoryTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: DataRepository

    @Test
    fun testGetUsers() {
        val fakeUsers = MutableLiveData<List<User>>()
        `when`(repository.getUsers()).thenReturn(fakeUsers)
        assertThat(repository.getUsers().value, `is`(nullValue()))
        fakeUsers.value = fakeUserList()
        assertThat(repository.getUsers().value?.size, `is`(1))
        val user = repository.getUsers().value?.get(0)
        assertThat(user?.name, `is`("tester"))
    }

    @Test
    fun testGetAlbums() {
        val fakeAlbums = MutableLiveData<List<Album>>()
        `when`(repository.getAlbums(12)).thenReturn(fakeAlbums)
        assertThat(repository.getAlbums(12).value, `is`(nullValue()))
        fakeAlbums.value = fakeAlbumList(12)
        assertThat(repository.getAlbums(12).value!!.size, `is`(2))
    }


    private fun fakeUserList(): List<User> {
        val u1 = User(id = 12, name = "tester", email = "tester@t.com", phone = "12345")
        return listOf(u1)
    }

    private fun fakeAlbumList(albumId: Int): List<Album> {
        val b1 = Album(albumId = 12, id = 1, title = "b1", url = "b1url", thumbnailUrl = "tb1url")
        val b2 = Album(albumId = 12, id = 2, title = "b2", url = "b2url", thumbnailUrl = "tb2url")
        val b3 = Album(albumId = 10, id = 3, title = "b3", url = "b3url", thumbnailUrl = "tb3url")
        val b4 = Album(albumId = 9, id = 4, title = "b4", url = "b4url", thumbnailUrl = "tb4url")
        return listOf(b1, b2, b3, b4).filter { it.albumId == albumId }
    }
}