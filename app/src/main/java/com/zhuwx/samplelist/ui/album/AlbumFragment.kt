package com.zhuwx.samplelist.ui.album


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import com.zhuwx.samplelist.R
import com.zhuwx.samplelist.databinding.FragmentAlbumBinding
import com.zhuwx.samplelist.viewmodel.AlbumViewModelFactory

/**
 *  @author Wenxing Zhu
 *  Email : seanzhuwx@gmail.com
 *  Date : 08-Jul-2019
 *  Description :
 */
class AlbumFragment : Fragment() {

    private val args: AlbumFragmentArgs by navArgs()
    private lateinit var viewModel: AlbumViewModel
    private lateinit var binding: FragmentAlbumBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val databinding = DataBindingUtil.inflate<FragmentAlbumBinding>(inflater, R.layout.fragment_album, container, false)
        binding = databinding
        return databinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, AlbumViewModelFactory(args.userId)).get(AlbumViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        activity?.title = "Album ID: ${args.userId}"
        binding.lifecycleOwner = viewLifecycleOwner
        binding.status = viewModel.status

        viewModel.albums.observe(viewLifecycleOwner, Observer { albums ->
            if (binding.rvAlbums.adapter == null) {
                val rvAdapter = AlbumListAdapter(albums) {
                    // TODO: navigate to detail
                }
                binding.rvAlbums.adapter = rvAdapter
            } else {
                (binding.rvAlbums.adapter as AlbumListAdapter).setAlbumList(albums)
            }
        })
    }


}
