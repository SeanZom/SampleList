package com.zhuwx.samplelist.binding

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 *  @author Sean Zhu
 *  Email : seanzhuwx@gmail.com
 *  Date : 2019-07-10 - 15:05
 *  Description :
 */
class BaseBindingViewHolder<out T : ViewDataBinding>(val binding: T): RecyclerView.ViewHolder(binding.root)
