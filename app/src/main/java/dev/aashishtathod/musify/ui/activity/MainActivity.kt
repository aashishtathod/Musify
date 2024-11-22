package dev.aashishtathod.musify.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import dev.aashishtathod.musify.R
import dev.aashishtathod.musify.databinding.ActivityMainBinding
import dev.aashishtathod.musify.ui.musicList.MusicListFragment
import dev.aashishtathod.musify.ui.player.MusicPlayerFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, MusicListFragment.newInstance(), "MusicListFragment")
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.playerFragmentContainer, MusicPlayerFragment.newInstance(), "MusicPlayerFragment")
            .commit()
    }

}