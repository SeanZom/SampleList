package com.zhuwx.samplelist.ui.info


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.zhuwx.samplelist.R
import com.zhuwx.samplelist.databinding.FragmentUserInfoBinding


/**
 *  @author Wenxing Zhu
 *  Email : seanzhuwx@gmail.com
 *  Date : 08-Jul-2019
 *  Description :
 */
class UserInfoFragment : Fragment() {
    private val userInfoViewModel: UserInfoViewModel by viewModels();

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val databinding = DataBindingUtil.inflate<FragmentUserInfoBinding>(inflater, R.layout.fragment_user_info, container, false)
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        userInfoViewModel.users.observe(viewLifecycleOwner, Observer { users ->

        })
    }


}
