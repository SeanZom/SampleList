package com.zhuwx.samplelist.ui.detail

import androidx.lifecycle.ViewModel
import com.zhuwx.samplelist.data.DataRepository

/**
 *  @author Sean Zhu
 *  Email : seanzhuwx@gmail.com
 *  Date : 2019-07-10 - 17:55
 *  Description :
 */
class AlbumDetailViewModel(detailId: Int) : ViewModel() {

    val album = DataRepository.getAlbum(detailId)
}