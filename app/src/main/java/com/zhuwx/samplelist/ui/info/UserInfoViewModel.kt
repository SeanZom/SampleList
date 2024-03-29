package com.zhuwx.samplelist.ui.info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.zhuwx.samplelist.data.DataRepository
import com.zhuwx.samplelist.data.model.User
import com.zhuwx.samplelist.vo.Status


/**
 *  @author Sean Zhu
 *  Email : seanzhuwx@gmail.com
 *  Date : 2019-07-08 - 15:41
 *  Description :
 */
class UserInfoViewModel : ViewModel() {
    private val _status = MutableLiveData<Status>().apply { value = Status.LOADING }
    private val _users = DataRepository.getUsers()


    val status: LiveData<Status> = Transformations.map(_users) {
        _status.value = Status.DONE
        _status.value
    }

    val users : LiveData<List<User>> = _users


}