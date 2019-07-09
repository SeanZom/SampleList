package com.zhuwx.samplelist.ui.detail


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zhuwx.samplelist.R

/**
 *  @author Wenxing Zhu
 *  Email : seanzhuwx@gmail.com
 *  Date : 08-Jul-2019
 *  Description :
 */
class AlbumDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_album_detail, container, false)
    }


}
