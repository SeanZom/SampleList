package com.zhuwx.samplelist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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


    private val usersCache: MutableLiveData<List<User>> = MutableLiveData()


    fun getUsers(): LiveData<List<User>> {
        refreshUsers()
        return usersCache
    }

    private fun refreshUsers() {
        GlobalScope.launch(Dispatchers.Main) {
            val users = withContext(Dispatchers.IO) {
                AppService.getUsers()
            }
            usersCache.value = users
        }
    }

}