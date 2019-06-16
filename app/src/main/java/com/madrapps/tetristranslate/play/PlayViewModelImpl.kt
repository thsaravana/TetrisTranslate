package com.madrapps.tetristranslate.play

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PlayViewModelImpl : PlayViewModel, ViewModel() {

    private val _currentScore = MutableLiveData<Int>()

    override val currentScore: LiveData<Int> = _currentScore

    init {
        _currentScore.postValue(20)
    }
}

internal class PlayViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return PlayViewModelImpl() as T
    }
}