package dev.aashishtathod.musify.ui.musicList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dev.aashishtathod.musify.databinding.FragmentMusicListBinding
import dev.aashishtathod.musify.ui.activity.MainViewModel

class MusicListFragment : Fragment() {

    private lateinit var binding: FragmentMusicListBinding
    private lateinit var parentViewModel: MainViewModel
    private val songListAdapter by lazy { SongListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMusicListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
        observeData()
    }

    private fun setUp() {
        parentViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        binding.rvSongList.adapter = songListAdapter
    }

    private fun observeData() {
        parentViewModel.musicList.observe(viewLifecycleOwner) {
            songListAdapter.submitList(it)
        }
    }

    companion object {
        fun newInstance() =
            MusicListFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}