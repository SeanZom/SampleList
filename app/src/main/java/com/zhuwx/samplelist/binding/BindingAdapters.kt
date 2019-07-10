package com.zhuwx.samplelist.binding

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.squareup.picasso.Picasso

/**
 *  @author Sean Zhu
 *  Email : seanzhuwx@gmail.com
 *  Date : 2019-07-09 - 17:48
 *  Description :
 */
object BindingAdapters {

    @JvmStatic
    @BindingAdapter("visibleGone")
    fun showHide(view: View, show: Boolean) {
        view.visibility = if (show) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter("imgUrl")
    fun bindImage(imageView: ImageView, url: String?) {
        val loadingDrawable = CircularProgressDrawable(imageView.context).apply {
            strokeWidth = 10f
            centerRadius = 50f
            start()
        }

        Picasso.get().load(url).placeholder(loadingDrawable).into(imageView)
    }
}