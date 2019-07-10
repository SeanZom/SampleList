package com.zhuwx.samplelist.ui.detail


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import com.zhuwx.samplelist.R
import com.zhuwx.samplelist.databinding.FragmentAlbumDetailBinding
import com.zhuwx.samplelist.viewmodel.AlbumDetailViewModelFactory

/**
 *  @author Wenxing Zhu
 *  Email : seanzhuwx@gmail.com
 *  Date : 08-Jul-2019
 *  Description :
 */
class AlbumDetailFragment : Fragment() {

    private val args: AlbumDetailFragmentArgs by navArgs()
    private lateinit var viewModel: AlbumDetailViewModel
    private lateinit var binding: FragmentAlbumDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val databinding = DataBindingUtil.inflate<FragmentAlbumDetailBinding>(inflater, R.layout.fragment_album_detail, container, false)
        binding = databinding
        return databinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, AlbumDetailViewModelFactory(args.albumId)).get(AlbumDetailViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as AppCompatActivity).supportActionBar?.subtitle = "Photo ID: ${args.albumId}"

        binding.album = viewModel.album
    }


}
