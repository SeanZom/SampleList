package com.zhuwx.samplelist.ui.info

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.zhuwx.samplelist.data.DataRepository
import com.zhuwx.samplelist.data.model.User


/**
 *  @author Sean Zhu
 *  Email : seanzhuwx@gmail.com
 *  Date : 2019-07-08 - 15:41
 *  Description :
 */
class UserInfoViewModel : ViewModel() {

    val users : LiveData<List<User>> = DataRepository.getUsers()

}