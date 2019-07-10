package com.zhuwx.samplelist.ui.info


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.zhuwx.samplelist.R
import com.zhuwx.samplelist.databinding.FragmentUserInfoBinding


/**
 *  @author Wenxing Zhu
 *  Email : seanzhuwx@gmail.com
 *  Date : 08-Jul-2019
 *  Description :
 */
class UserInfoFragment : Fragment() {
    private val userInfoViewModel: UserInfoViewModel by viewModels()

    private lateinit var binding: FragmentUserInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val databinding = DataBindingUtil.inflate<FragmentUserInfoBinding>(inflater, R.layout.fragment_user_info, container, false)
        binding = databinding
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Set title
        activity?.title = getString(R.string.title_user_info)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.status = userInfoViewModel.status

        userInfoViewModel.users.observe(viewLifecycleOwner, Observer { users ->
            if (binding.rvUsers.adapter == null) {
                val rvAdapter = UserInfoListAdapter(users) {
                    findNavController().navigate(UserInfoFragmentDirections.actionUserInfoFragmentToAlbumFragment(it.id))
                }
                binding.rvUsers.adapter = rvAdapter
            } else {
                (binding.rvUsers.adapter as UserInfoListAdapter).setUserList(users)
            }
        })
    }


}
