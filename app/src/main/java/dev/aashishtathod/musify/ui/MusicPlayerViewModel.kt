package dev.aashishtathod.musify.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.aashishtathod.musify.data.model.Song
import dev.aashishtathod.musify.domain.usecase.GetDownloadedMusicUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MusicPlayerViewModel @Inject constructor(
    private val getDownloadedMusicUseCase: GetDownloadedMusicUseCase
) : ViewModel (){

    private val _musicList = MutableLiveData<List<Song>>()
    val musicList: LiveData<List<Song>> = _musicList

    fun getDownloadedMusic() {
       viewModelScope.launch {
           getDownloadedMusicUseCase().collect {
               _musicList.postValue(it)
           }
       }
    }

}