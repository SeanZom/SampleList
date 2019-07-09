package com.zhuwx.samplelist.data.server

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.zhuwx.samplelist.data.DataSource
import com.zhuwx.samplelist.data.model.Album
import com.zhuwx.samplelist.data.model.User
import java.net.URL

/**
 *  @author Sean Zhu
 *  Email : seanzhuwx@gmail.com
 *  Date : 2019-07-08 - 17:13
 *  Description :
 */
object AppService: DataSource {
    private const val URL_USERS = "https://jsonplaceholder.typicode.com/users"
    private const val URL_ALBUMS = "https://jsonplaceholder.typicode.com/photos?albumId="

    private val gson = Gson()

    override fun getUsers(): List<User> {
        val jsonStr = URL(URL_USERS).readText()
        return gson.fromJson(jsonStr, Array<User>::class.java).toList()
    }

    override fun getAlbums(userId: Int): List<Album> = get<List<Album>>(URL_ALBUMS + userId)

    private fun <T> get(url: String): T {
        val jsonStr = URL(url).readText()
        val listType = object : TypeToken<T>() {}.type
        return gson.fromJson(jsonStr, listType)
    }

}