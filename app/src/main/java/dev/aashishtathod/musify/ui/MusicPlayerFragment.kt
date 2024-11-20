package dev.aashishtathod.musify.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import dev.aashishtathod.musify.databinding.FragmentMusicPlayerBinding

@AndroidEntryPoint
class MusicPlayerFragment : Fragment() {

    private lateinit var binding: FragmentMusicPlayerBinding
    private lateinit var viewModel: MusicPlayerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            /*  param1 = it.getString(ARG_PARAM1)
              param2 = it.getString(ARG_PARAM2)
              */
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMusicPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MusicPlayerViewModel::class.java]
        viewModel.getDownloadedMusic()

        viewModel.musicList.observe(viewLifecycleOwner) {
           println("Debug -> $it")
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(/*param1: String, param2: String*/) = MusicPlayerFragment().apply {
                arguments = Bundle().apply {
               /*     putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)*/
                }
            }
    }
}