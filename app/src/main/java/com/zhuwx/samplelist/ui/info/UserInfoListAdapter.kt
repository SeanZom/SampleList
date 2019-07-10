package com.zhuwx.samplelist.ui.info

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.zhuwx.samplelist.R
import com.zhuwx.samplelist.binding.BaseBindingViewHolder
import com.zhuwx.samplelist.data.model.User
import com.zhuwx.samplelist.databinding.UserItemBinding

/**
 *  @author Sean Zhu
 *  Email : seanzhuwx@gmail.com
 *  Date : 2019-07-09 - 15:50
 *  Description :
 */
class UserInfoListAdapter(users: List<User>, private val userClickCallback: ((User) -> Unit)?) : RecyclerView.Adapter<BaseBindingViewHolder<UserItemBinding>>() {

    private val _users = mutableListOf<User>().apply { addAll(users) }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseBindingViewHolder<UserItemBinding> {
        val binding = DataBindingUtil.inflate<UserItemBinding>(LayoutInflater.from(parent.context), R.layout.user_item, parent, false)
        binding.root.setOnClickListener {
            binding.user?.let {
                userClickCallback?.invoke(it)
            }
        }
        return BaseBindingViewHolder(binding)
    }

    override fun getItemCount(): Int = _users.size

    override fun onBindViewHolder(holder: BaseBindingViewHolder<UserItemBinding>, position: Int) {
        holder.binding.user = _users[position]
        holder.binding.executePendingBindings()
    }

    fun setUserList(newData: List<User>) {
        _users.clear()
        if (newData.isNotEmpty()) {
            _users.addAll(newData)
        }
        notifyDataSetChanged()
    }
}