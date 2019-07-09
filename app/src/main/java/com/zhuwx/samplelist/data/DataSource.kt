package com.zhuwx.samplelist.data

import com.zhuwx.samplelist.data.model.Album
import com.zhuwx.samplelist.data.model.User

/**
 *  @author Sean Zhu
 *  Email : seanzhuwx@gmail.com
 *  Date : 2019-07-08 - 17:07
 *  Description :
 */
interface DataSource {

    fun getUsers(): List<User>?

    fun getAlbums(userId: Int): List<Album>?
}